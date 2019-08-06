package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiRModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PixEmpiRDao { 

	public void insertSingle(PixEmpiRModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiRModel obj) throws CoBusinessException; 

	public void update(PixEmpiRModel obj) throws CoBusinessException; 

	public void delete(PixEmpiRModel obj) throws CoBusinessException; 

	public abstract PixEmpiRModel findByPK(PixEmpiRModel obj) throws CoBusinessException;

	public abstract List<PixEmpiRModel> queryByCond(PixEmpiRModel obj) throws CoBusinessException;

	public abstract List<PixEmpiRModel> queryByPage(PixEmpiRModel obj) throws CoBusinessException;

	public abstract Integer findMaxId(PixEmpiRModel obj) throws CoBusinessException;

	public abstract List<PixEmpiRModel> queryEmpiRelation(PixEmpiRModel obj) throws CoBusinessException;

}