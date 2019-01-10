package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiLogModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PixEmpiLogDao {


	public void insertSingle(PixEmpiLogModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiLogModel obj) throws CoBusinessException;

	public void update(PixEmpiLogModel obj) throws CoBusinessException;

	public void delete(PixEmpiLogModel obj) throws CoBusinessException;

	public abstract PixEmpiLogModel  findByPK(PixEmpiLogModel obj) throws CoBusinessException;

	public abstract List<PixEmpiLogModel>  queryByCond(PixEmpiLogModel obj) throws CoBusinessException;

	public abstract List<PixEmpiLogModel>  queryByPage(PixEmpiLogModel obj) throws CoBusinessException;

	public abstract Integer  findMaxId(PixEmpiLogModel obj) throws CoBusinessException;


}
