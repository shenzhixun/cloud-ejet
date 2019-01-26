// package com.khsh.datac.patientview.mapper.mysql;
//
// import com.khsh.datac.patientview.model.Dictionary;
// import org.apache.ibatis.annotations.Param;
// import org.apache.ibatis.session.RowBounds;
//
// import java.util.List;
//
// public interface DictionaryMapper {
//
//     int deleteByPrimaryKey(Long uuid);
//
//     int deleteByPrimaryKeys(@Param("uuids") List<Long> uuids);
//
//     int insert(Dictionary record);
//
//     int insertSelective(Dictionary record);
//
//     Dictionary selectByPrimaryKey(Long uuid);
//
//     Dictionary selectByCode(@Param("corpId") Integer corpId, @Param("dCode") String code);
//
//     List<Dictionary> selectBySystem(@Param("corpId") Integer corpId, @Param("sCode") String sCode);
//
//     List<Dictionary> selectByCodes(@Param("corpId") Integer corpId, @Param("codes") String... codes);
//
//     /**
//      * 查询所有数据
//      * @return
//      */
//     List<Dictionary> selectAll(RowBounds rowBounds);
//
//     /**
//      * 查询所有数据（记录数）
//      * @return
//      */
//     Integer selectAllCount();
//
//     int updateByPrimaryKeySelective(Dictionary record);
//
//     int updateByPrimaryKey(Dictionary record);
//
// }
