package com.khsh.datac.patientview.aspect;

import com.chz.apps.common.tools.Constant;
import com.chz.apps.common.utils.ReflectUtil;
import com.chz.apps.common.vo.BaseVo;
import com.chz.apps.common.vo.DicData;
import com.chz.apps.common.vo.DicDataVo;
import com.chz.apps.web.bean.RespBean;
import com.google.gson.reflect.TypeToken;
import com.khsh.datac.patientview.cache.RedisServiceHelper;
import com.khsh.datac.patientview.constant.DicConstant;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class DictionaryProxyAspect {

    private static Logger logger = LoggerFactory.getLogger(DictionaryProxyAspect.class);

    private static final String DIC_MAP_KEY_SEP = "!@#";

    @Autowired
    private RedisServiceHelper redisServiceHelper;

    @Around("@annotation(com.chz.apps.common.vo.DictionaryProxy)")
    public Object dictionaryConvert(ProceedingJoinPoint point){
        Object result = null;
        try {
            result = point.proceed();
            if(result != null && result instanceof RespBean && ((RespBean)result).checkSuccess() && ((RespBean)result).getData() != null){
                boolean isList = false;

                //支持集合和非集合
                if(((RespBean)result).getData() instanceof List)
                    if(((List) ((RespBean)result).getData()).size() > 0)
                        isList = true;
                    else
                        return  result;
                else
                    isList = false;

                Map<String,DicData> dicMap = new HashMap<>();
                String dicLabelsFieldName = "dicLabels";
                if(!isList){
                    RespBean<Object> resp = (RespBean)result;

                    findRespDicMap("",dicMap,resp.getData().getClass());
                    fillDicData(resp.getData(),dicLabelsFieldName,"",dicMap);
                }else{
                    RespBean<List<Object>> resp = (RespBean)result;
                    findRespDicMap("",dicMap,resp.getData().get(0).getClass());
                    for (Object vo:resp.getData()) {
                        fillDicData(vo,dicLabelsFieldName,"",dicMap);
                    }
                }

            }
        }catch (Throwable e){
            e.printStackTrace();
        }
        return result;
    }

    public Object getFieldByObject(Object obj,String fieldName) throws Exception{
        Class clazz = obj.getClass();
//        Field field = clazz.getDeclaredField(fieldName);
//        if(field == null)
//            return null;

        //获取驼峰get方法
        String getMethod = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
        return clazz.getMethod(getMethod).invoke(obj);
    }

    /**
     * 校验是否继承自BaseVO
     * @param field
     * @return
     */
    public boolean valExtendBaseVO(Field field){
        try {
            if(field.getType().newInstance() instanceof BaseVo){
                return true;
            }
        }catch (Exception e){

        }

        return false;
    }

    /**
     * 填充数据字段数据
     * @param vo
     * @param parentKey     属性
     * @param labelsFieldName
     * @param dicMap
     * @throws Exception
     */
    public void fillDicData(Object vo, String labelsFieldName, String parentKey, Map<String,DicData> dicMap){
        try {
            for (Map.Entry<String,DicData> dic:dicMap.entrySet()) {
                fillDicFieldValueByKey(dic.getValue(),vo,labelsFieldName,dic.getKey());
            }
        }catch (Exception e){
            logger.warn("字典表格式转换失败",e);
        }
    }

    /**
     * 获取对象属性中所有的字典表信息
     * @param parentKey
     * @param result
     * @param clazz
     * @return
     */
    public Map<String,DicData> findRespDicMap(String parentKey, Map<String,DicData> result, Class clazz){
        String prevKey = parentKey;
        if(StringUtils.isBlank(prevKey))
            prevKey = "";
        else
            prevKey += DIC_MAP_KEY_SEP;

        if(result == null)
            result = new HashMap<>();

        Field[] fields = ReflectUtil.getFields(clazz);
        for (Field field:fields) {
            DicData dicData = field.getAnnotation(DicData.class);
            if(dicData != null)
                result.put(prevKey + field.getName(),dicData);

            if(field.getType().equals(List.class)){
                System.out.println("集合处理");
            }else if(valExtendBaseVO(field))
                findRespDicMap(prevKey + field.getName(),result,field.getType());
        }
        return result;
    }

    /**
     * 找到key对应的字段值（如果为空，说明不需要处理）
     * @param dic
     * @param vo
     * @param fieldPathKey
     * @return
     */
    public void fillDicFieldValueByKey(DicData dic, Object vo, String labelFieldName, String fieldPathKey){
        if(dic == null)
            return;

        Object parentObject = vo;
        Object fieldValue = null;
        String[] keyArry = fieldPathKey.split(DIC_MAP_KEY_SEP);

        int index = 0;
        while(index < keyArry.length){
            Object val = ReflectUtil.getFieldValue(parentObject, keyArry[index]);
            if (val == null)
                break;

            if(index == keyArry.length - 1){
                fieldValue = val;
            }else{
                //继续往下找
                if (val instanceof List) {
                    //todo:待完善
                }else{
                    parentObject = val;
                }
            }
            index++;
        }

        if(fieldValue == null || (fieldValue instanceof String && StringUtils.isBlank(fieldValue.toString())))
            return;

        Map<String,Object> dicLabels = getLabelMap(parentObject,labelFieldName);

        if(fieldValue instanceof List){

        }else{
            DicDataVo dataVo = getDataByKey(Constant.CORP_ID_VAL,dic.value(),fieldValue.toString());
            if(dataVo != null)
                dicLabels.put(keyArry[keyArry.length-1]+"_label", dataVo.getDataValue());
            else
                logger.warn("数据字典["+dic.value()+"].["+fieldValue+"]没有找到字典值");//说明有数据没有字典表对应关系
        }
    }

    /**
     * 获取数据值
     * @param corpId
     * @param dCode
     * @param dataKey
     * @return
     */
    public DicDataVo getDataByKey(Integer corpId, String dCode, String dataKey){
        Map<String,DicDataVo> dicDataMap = getDicVoMap(dCode);
        if(dicDataMap == null)
            return null;

        return dicDataMap.get(dataKey);
    }

    /**
     * 获取字典表数据（Map格式）
     * @param dicCode
     * @return
     */
    public Map<String,DicDataVo> getDicVoMap(String dicCode){
//        CacheObject cacheObject = J2CacheUtil.getChannel().get(J2CacheUtil.CAFFEINE_REGION_DICS, DicConstant.getDicMapCacheKey(dicCode),true);
//        return cacheObject == null || cacheObject.getValue() == null ? null : (Map) cacheObject.getValue();

        Map<String,DicDataVo> cacheObject = redisServiceHelper.get(DicConstant.getDicMapCacheKey(dicCode),(new TypeToken<HashMap<String, DicDataVo>>(){}).getType());
        return cacheObject;
    }

    public Map<String,Object> getLabelMap(Object vo,String labelFieldName){
        Object labelMap = ReflectUtil.getFieldValue(vo,labelFieldName);
        if(labelMap == null)
            return new HashMap<>();

        return (Map)labelMap;
    }

}
