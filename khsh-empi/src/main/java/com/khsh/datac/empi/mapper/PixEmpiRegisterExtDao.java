package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiRegisterExtModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PixEmpiRegisterExtDao {


	public void insertSingle(PixEmpiRegisterExtModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiRegisterExtModel obj) throws CoBusinessException;

	public void update(PixEmpiRegisterExtModel obj) throws CoBusinessException;

	public void delete(PixEmpiRegisterExtModel obj) throws CoBusinessException;

	public abstract PixEmpiRegisterExtModel  findByPK(PixEmpiRegisterExtModel obj) throws CoBusinessException;

	public abstract List<PixEmpiRegisterExtModel>  queryByCond(PixEmpiRegisterExtModel obj) throws CoBusinessException;

	public abstract List<PixEmpiRegisterExtModel>  queryByPage(PixEmpiRegisterExtModel obj) throws CoBusinessException;

	public abstract Integer  findMaxId(PixEmpiRegisterExtModel obj) throws CoBusinessException;


}
