package com.khsh.datac.empi.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiRegisterModel;
@Mapper
public interface PixEmpiRegisterDao { 


	public void insertSingle(PixEmpiRegisterModel obj) throws CoBusinessException; 

	public int insertAutoKey(PixEmpiRegisterModel obj) throws CoBusinessException; 

	public void update(PixEmpiRegisterModel obj) throws CoBusinessException; 

	public void delete(PixEmpiRegisterModel obj) throws CoBusinessException; 

	public abstract PixEmpiRegisterModel  findByPK(PixEmpiRegisterModel obj) throws CoBusinessException; 

	public abstract List<PixEmpiRegisterModel>  queryByCond(PixEmpiRegisterModel obj) throws CoBusinessException; 

	public abstract List<PixEmpiRegisterModel>  queryByPage(PixEmpiRegisterModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(PixEmpiRegisterModel obj) throws CoBusinessException; 


}