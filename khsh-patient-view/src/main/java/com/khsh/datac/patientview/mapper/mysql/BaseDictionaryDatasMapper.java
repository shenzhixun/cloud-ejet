package com.khsh.datac.patientview.mapper.mysql;

import com.khsh.datac.patientview.base.BaseDictionaryDatas;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseDictionaryDatasMapper {
    /**
     * 保存数据
     * @param baseDictionaryDatas
     * @return
     */
    int insert(BaseDictionaryDatas baseDictionaryDatas);

    /**
     * 保存数据
     * @param baseDictionaryDatas
     * @return
     */
    int insertSelective(BaseDictionaryDatas baseDictionaryDatas);

    /**
     * 查询数据
     * @param uuid
     * @return
     */
    BaseDictionaryDatas selectByPrimaryKey(Long uuid);

    /**
     * 查询所有数据
     * @return
     */
    List<BaseDictionaryDatas> selectAll(@Param("code") String code, RowBounds rowBounds);

    /**
     * 查询指定数据集合
     * @param corpId
     * @param dCode
     * @return
     */
    List<BaseDictionaryDatas> selectByCode(@Param("corpId") Integer corpId, @Param("dCode") String dCode);

    /**
     * 查询指定数据集合
     * @param corpId
     * @param dCode
     * @param keys
     * @return
     */
    List<BaseDictionaryDatas> selectByKeys(@Param("corpId") Integer corpId, @Param("dCode") String dCode, @Param("keys") String... keys);

    /**
     * 查询多个字典表结果集
     * @param corpId
     * @param dCodes
     * @return
     */
    List<BaseDictionaryDatas> selectByCodes(@Param("corpId") Integer corpId, @Param("dCodes") String... dCodes);

    /**
     * 查询所有数据（记录数）
     * @return
     */
    Integer selectAllCount(@Param("code") String code);

    /**
     * 删除数据
     * @param uuid
     * @return
     */
    int deleteByPrimaryKey(Long uuid);

    /**
     * 根据ID列表删除数据
     * @param uuids
     * @return
     */
    int deleteByPrimaryKeys(@Param("uuids") List<Long> uuids);

    /**
     * 有选择性地修改数据，传来的对象不一定所有属性都要有值
     * @param dictionaryDatas
     * @return
     */
    int updateByPrimaryKeySelective(BaseDictionaryDatas dictionaryDatas);

    /**
     * 根据主键修改数据，要求传来的对象所有属性都要有值
     * @param uuid
     * @return
     */
    BaseDictionaryDatas updateByPrimaryKey(Long uuid);
}

