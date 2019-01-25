package com.khsh.datac.patientview.service.impl;

import com.chz.apps.common.j2cache.J2CacheUtil;
import com.chz.apps.common.tools.Constant;
import com.chz.apps.common.utils.ListUtils;
import com.chz.apps.common.vo.DicDataVo;
import com.chz.apps.common.vo.DicVo;
import com.chz.apps.web.bean.ReqBean;
import com.chz.apps.web.bean.RespBean;
import com.chz.component.basic.model.TableModelTools;
import com.khsh.datac.patientview.base.BaseDictionaryDatas;
import com.khsh.datac.patientview.model.Dictionary;
import com.khsh.datac.patientview.cache.RedisServiceHelper;
import com.khsh.datac.patientview.constant.DicConstant;
import com.khsh.datac.patientview.mapper.mysql.BaseDictionaryDatasMapper;
import com.khsh.datac.patientview.mapper.mysql.DictionaryMapper;
import com.khsh.datac.patientview.service.IBaseDictionaryDatasService;
import com.khsh.datac.patientview.vo.BaseDictionaryDatasVo;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BaseDictionaryDatasService implements IBaseDictionaryDatasService {

    @Autowired
    private RedisServiceHelper redisServiceHelper;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private BaseDictionaryDatasMapper baseDictionaryDatasMapper;

//    @Autowired
//    private ITableBaseService tableBaseService;

    @Override
    public RespBean<BaseDictionaryDatasVo> insert(BaseDictionaryDatasVo vo) {
        if(StringUtils.isBlank(vo.getCode()))
            return RespBean.error("子系统编码不能为空");

        BaseDictionaryDatas baseDictionaryDatas = vo2ModelForInsert(vo);
        TableModelTools.initSysFields(baseDictionaryDatas);//处理公共参数
        if(baseDictionaryDatasMapper.insertSelective(baseDictionaryDatas) > 0){
            vo.setUuid(baseDictionaryDatas.getUuid());
            return RespBean.success(vo,"新增成功");
        }
        return RespBean.error("新增失败");
    }

    @Override
    public RespBean<BaseDictionaryDatasVo> update(BaseDictionaryDatasVo vo) {
        if(vo.getUuid() == null)
            return RespBean.error("未找到需要更新的数据");

        BaseDictionaryDatas baseDictionaryDatas = vo2ModelForUpdate(vo);
        TableModelTools.initUpdateSysField(baseDictionaryDatas);
        baseDictionaryDatas.setUuid(vo.getUuid());
        if(baseDictionaryDatasMapper.updateByPrimaryKeySelective(baseDictionaryDatas) > 0)
            return RespBean.success(vo,"更新成功");

        return RespBean.error("更新失败");
    }

    @Override
    public RespBean del(List<Long> uuids) {
        if(ListUtils.isListNull(uuids))
            return RespBean.error("没有找到需要删除的数据");

//        if(tableBaseService.logicDelByUuids(UserInfoConstant.TABLE_BASE_DICTIONARY_DATAS,uuids.toArray(new Long[0])) > 0)
//            return RespBean.successMsg("删除成功");

        return RespBean.error("删除失败");
    }

    @Override
    public RespBean<List<BaseDictionaryDatasVo>> findAll(ReqBean<BaseDictionaryDatasVo> reqBean) {
        String code = MapUtils.getString(reqBean.getCustomDatas(),"code");
        if("".equals(code))
            code = null;

        reqBean.getPage().setTotalCount(baseDictionaryDatasMapper.selectAllCount(code));//查询总记录数
        List<BaseDictionaryDatas> baseDictionaryData = baseDictionaryDatasMapper.selectAll(code,new RowBounds(reqBean.getPage().getOffset(),reqBean.getPage().getPageSize()));//查询数据
        List<BaseDictionaryDatasVo> vos = models2Vos(baseDictionaryData);//转换格式
        return RespBean.buildPage(vos,reqBean.getPage());
    }

    @Override
    public List<DicVo> findAllDics(List<String> dCodeList) {
        List<DicVo> result = new ArrayList<>();
        List<String> needSearchCodes = null;
        if(ListUtils.isListNotNull(dCodeList)){
            //直接查询缓存
            for (String code:dCodeList) {
                CacheObject object = J2CacheUtil.getChannel().get(J2CacheUtil.CAFFEINE_REGION_DICS, DicConstant.getDicCacheKey(code));
                if(object == null || object.getValue() == null){
                    if(needSearchCodes == null)
                        needSearchCodes = new ArrayList<>();

                    needSearchCodes.add(code);
                    continue;
                }
                result.add((DicVo) object.getValue());
            }

            if(ListUtils.isListNull(needSearchCodes))
                return result;
        }

        //查询所有字典数据
        List<Dictionary> dictionaries = dictionaryMapper.selectByCodes(Constant.CORP_ID_VAL,needSearchCodes != null ? needSearchCodes.toArray(new String[0]) : null);
        if(ListUtils.isListNull(dictionaries))
            return new ArrayList<>();

        List<BaseDictionaryDatas> datas = baseDictionaryDatasMapper.selectByCodes(Constant.CORP_ID_VAL, ListUtils.isListNotNull(dCodeList) ? dCodeList.toArray(new String[0]) : null);
        if(ListUtils.isListNull(datas))
            return new ArrayList<>();

        Map<String,List<DicDataVo>> dataMap = new HashMap<>();
        String lastDic = "";
        for (BaseDictionaryDatas data: datas){
            if(StringUtils.isBlank(lastDic) || !lastDic.equals(data.getDCode()))
                lastDic = data.getDCode();

            if(dataMap.get(data.getDCode()) == null)
                dataMap.put(data.getDCode(),new ArrayList<>());

            DicDataVo dataVo=new DicDataVo();
            dataVo.setCode(data.getDCode());
            dataVo.setDataKey(data.getDataKey());
            dataVo.setDataValue(data.getDataValue());
            dataVo.setDataNickValue(data.getDataNickValue());
            dataVo.setDataParentKey(data.getDataParentKey());
            dataVo.setNote(data.getNote());
            dataVo.setSpell(data.getSpell());
            dataVo.setUnit(data.getUnit());
            dataVo.setIsDisable(data.getIsDisable());
            dataVo.setIsVisible(data.getIsVisible());
            dataVo.setDataOrder(data.getDataOrder());
            dataVo.setForeignDataKey(data.getForeignDataKey());
            dataVo.setUuid(data.getUuid());
            dataMap.get(data.getDCode()).add(dataVo);
        }
        datas = null;//置空，便于内存回收
        System.gc();


        for (Dictionary dictionary:dictionaries) {
            DicVo dicVo=new DicVo();
            dicVo.setCode(dictionary.getDCode());
            dicVo.setName(dictionary.getDName());
            dicVo.setShowNick(dictionary.getDShowNick());
            dicVo.setCorpId(dictionary.getCorpId());
            dicVo.setDatas(dataMap.get(dictionary.getDCode()));
            result.add(dicVo);
        }

        cacheLocal(ListUtils.isListNotNull(result) ? result.toArray(new DicVo[0]) : null);
        return result;
    }

    /**
     * 按照Map格式缓存字典表数据，方便后续取值
     * @param dics
     */
    public void cacheLocal(DicVo... dics){
        if(dics == null || dics.length == 0)
            return;

        for (DicVo dicVo : dics) {
            if(ListUtils.isListNull(dicVo.getDatas())){
//                J2CacheUtil.getChannel().set(J2CacheUtil.CAFFEINE_REGION_DICS, DicConstant.getDicCacheKey(dicVo.getCode()),null,true);//添加到缓存
                redisServiceHelper.put(DicConstant.getDicCacheKey(dicVo.getCode()),null);
                continue;
            }else {
//                J2CacheUtil.getChannel().set(J2CacheUtil.CAFFEINE_REGION_DICS, DicConstant.getDicCacheKey(dicVo.getCode()), dicVo, true);//添加到缓存
                redisServiceHelper.put(DicConstant.getDicCacheKey(dicVo.getCode()), dicVo);
            }

            Map<String, DicDataVo> dataMap = new HashMap<>();
            for (DicDataVo dicData : dicVo.getDatas()) {
                dataMap.put(dicData.getDataKey(),dicData);
            }
//            J2CacheUtil.getChannel().set(J2CacheUtil.CAFFEINE_REGION_DICS,DicConstant.getDicMapCacheKey(dicVo.getCode()),dataMap,true);//添加到缓存
            redisServiceHelper.put(DicConstant.getDicMapCacheKey(dicVo.getCode()),dataMap);
        }
    }

    public BaseDictionaryDatas vo2ModelForInsert(BaseDictionaryDatasVo baseDictionaryDatasVo){
        BaseDictionaryDatas baseDictionaryDatas = new BaseDictionaryDatas();
        baseDictionaryDatas.setDCode(baseDictionaryDatasVo.getCode());
        baseDictionaryDatas.setUuid(baseDictionaryDatasVo.getUuid());
        baseDictionaryDatas.setDataKey(baseDictionaryDatasVo.getDataKey());
        baseDictionaryDatas.setDataValue(baseDictionaryDatasVo.getDataValue());
        baseDictionaryDatas.setDataNickValue(baseDictionaryDatasVo.getDataNickValue());
        baseDictionaryDatas.setDataParentKey(baseDictionaryDatasVo.getDataParentKey());
        baseDictionaryDatas.setNote(baseDictionaryDatasVo.getNote());
        baseDictionaryDatas.setSpell(baseDictionaryDatasVo.getSpell());
        baseDictionaryDatas.setUnit(baseDictionaryDatasVo.getUnit());
        baseDictionaryDatas.setIsDisable(baseDictionaryDatasVo.getIsDisable()?true :false);
        baseDictionaryDatas.setIsVisible(baseDictionaryDatasVo.getIsVisible()?true :false);
        baseDictionaryDatas.setDataOrder(baseDictionaryDatasVo.getDataOrder());
        baseDictionaryDatas.setForeignDataKey(baseDictionaryDatasVo.getForeignDataKey());
        return baseDictionaryDatas;
    }

    public BaseDictionaryDatas vo2ModelForUpdate(BaseDictionaryDatasVo baseDictionaryDatasVo){
        BaseDictionaryDatas baseDictionaryDatas = new BaseDictionaryDatas();
        if(baseDictionaryDatasVo.getDataValue()!=null)
            baseDictionaryDatas.setDataValue(baseDictionaryDatasVo.getDataValue());
        if(baseDictionaryDatasVo.getDataNickValue()!=null)
            baseDictionaryDatas.setDataNickValue(baseDictionaryDatasVo.getDataNickValue());
        if(baseDictionaryDatasVo.getDataParentKey()!=null)
            baseDictionaryDatas.setDataParentKey(baseDictionaryDatasVo.getDataParentKey());
        if(baseDictionaryDatasVo.getNote()!=null)
            baseDictionaryDatas.setNote(baseDictionaryDatasVo.getNote());
        if(baseDictionaryDatasVo.getSpell()!=null)
            baseDictionaryDatas.setSpell(baseDictionaryDatasVo.getSpell());
        if(baseDictionaryDatasVo.getUnit()!=null)
            baseDictionaryDatas.setUnit(baseDictionaryDatasVo.getUnit());
        if(baseDictionaryDatasVo.getIsDisable()!=null)
            baseDictionaryDatas.setIsDisable(baseDictionaryDatasVo.getIsDisable()?true :false);
        if(baseDictionaryDatasVo.getIsVisible()!=null)
            baseDictionaryDatas.setIsVisible(baseDictionaryDatasVo.getIsVisible()?true:false);
        if(baseDictionaryDatasVo.getDataOrder()!=null)
            baseDictionaryDatas.setDataOrder(baseDictionaryDatasVo.getDataOrder());
        if(baseDictionaryDatasVo.getForeignDataKey()!=null)
            baseDictionaryDatas.setForeignDataKey(baseDictionaryDatasVo.getForeignDataKey());

        return baseDictionaryDatas;
    }

    public BaseDictionaryDatasVo model2Vo(BaseDictionaryDatas baseDictionaryDatas){
        BaseDictionaryDatasVo baseDictionaryDatasVo = new BaseDictionaryDatasVo();
        baseDictionaryDatasVo.setCode(baseDictionaryDatas.getDCode());
        baseDictionaryDatasVo.setUuid(baseDictionaryDatas.getUuid());
        baseDictionaryDatasVo.setDataKey(baseDictionaryDatas.getDataKey());
        baseDictionaryDatasVo.setDataValue(baseDictionaryDatas.getDataValue());
        baseDictionaryDatasVo.setDataNickValue(baseDictionaryDatas.getDataNickValue());
        baseDictionaryDatasVo.setDataParentKey(baseDictionaryDatas.getDataParentKey());
        baseDictionaryDatasVo.setNote(baseDictionaryDatas.getNote());
        baseDictionaryDatasVo.setSpell(baseDictionaryDatas.getSpell());
        baseDictionaryDatasVo.setUnit(baseDictionaryDatas.getUnit());
        baseDictionaryDatasVo.setIsDisable(baseDictionaryDatas.getIsDisable());
        baseDictionaryDatasVo.setIsVisible(baseDictionaryDatas.getIsVisible());
        baseDictionaryDatasVo.setDataOrder(baseDictionaryDatas.getDataOrder());
        baseDictionaryDatasVo.setForeignDataKey(baseDictionaryDatas.getForeignDataKey());
        return baseDictionaryDatasVo;
    }

    public List<BaseDictionaryDatasVo> models2Vos(List<BaseDictionaryDatas> datas){
        if(ListUtils.isListNull(datas))
            return new ArrayList<>();

        List<BaseDictionaryDatasVo> vos = new ArrayList<>();
        for (BaseDictionaryDatas data:datas)
            vos.add(model2Vo(data));

        return vos;
    }

    @Override
    public RespBean<Map<String,String>> findById(Integer corpId, String dCode, String... dataKey) {
        if(dataKey.length == 0 || StringUtils.isBlank(dCode))
            return RespBean.error();

        List<BaseDictionaryDatas> datas = baseDictionaryDatasMapper.selectByKeys(corpId,dCode,dataKey);
        if(ListUtils.isListNull(datas))
            return RespBean.error();

        Map<String,String> result = new LinkedHashMap<>();
        for (BaseDictionaryDatas data:datas) {
            result.put(data.getDataKey(),data.getDataValue());//此处应该根据主表code，识别是否要使用昵称字段
        }

        return RespBean.success(result);
    }

    @Override
    public List<DicVo> findByCodes(Integer corpId, List<DicVo> vos) {
        if(ListUtils.isListNull(vos))
            return new ArrayList<>();

        List<String> dCodes = new ArrayList<>();
        Map<String, DicVo> voMap = new LinkedHashMap<>();
        for (DicVo vo : vos) {
            if(dCodes.contains(vo.getCode()))
                continue;

            vo.setDatas(new ArrayList<>());//初始化，防止空指针异常
            dCodes.add(vo.getCode());
            voMap.put(vo.getCode(),vo);
        }

        List<BaseDictionaryDatas> models = baseDictionaryDatasMapper.selectByCodes(corpId,vos.toArray(new String[0]));
        if(ListUtils.isListNull(models))
            return new ArrayList<>();

        for (BaseDictionaryDatas data:models)
            voMap.get(data.getDCode()).getDatas().add(this.model2Vo(data));

        List<DicVo> result = new ArrayList<>();
        for (Map.Entry<String, DicVo> row:voMap.entrySet())
            result.add(row.getValue());

        return result;
    }
}
