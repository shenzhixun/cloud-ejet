package com.ejet.comm.base;

import java.util.List;

public interface CoBaseMapper<T extends CoBaseVO> {

    List<T> selectAll();
    List<T> selectAllByPage();
    T selectByPrimaryKey(String id);


    int insert(T record);
    int insertSelective(T record);


    int deleteByPrimaryKey(String id);


    int updateByPrimaryKey(T record);
    int updateByPrimaryKeySelective(T record);


}
