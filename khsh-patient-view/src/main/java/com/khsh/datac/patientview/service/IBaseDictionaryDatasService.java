package com.khsh.datac.patientview.service;

import com.chz.apps.common.vo.DicVo;
import com.chz.apps.web.bean.ReqBean;
import com.chz.apps.web.bean.RespBean;
import com.khsh.datac.patientview.vo.BaseDictionaryDatasVo;

import java.util.List;
import java.util.Map;

public interface IBaseDictionaryDatasService {

    RespBean<BaseDictionaryDatasVo> insert(BaseDictionaryDatasVo vo);

    RespBean<BaseDictionaryDatasVo> update(BaseDictionaryDatasVo vo);

    RespBean del(List<Long> uuids);

    RespBean<List<BaseDictionaryDatasVo>> findAll(ReqBean<BaseDictionaryDatasVo> vo);

    /**
     * 批量查询字典表数据
     * @param dCodeList
     * @return
     */
    List<DicVo> findAllDics(List<String> dCodeList);

    /**
     * 获取字典数据
     * @param vos
     * @return
     */
    List<DicVo> findByCodes(Integer corpId, List<DicVo> vos);

    RespBean<Map<String,String>> findById(Integer corpId, String dCode, String... dataKey);

}
