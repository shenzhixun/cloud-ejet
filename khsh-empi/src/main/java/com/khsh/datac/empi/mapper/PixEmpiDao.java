package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PixEmpiDao {


	public void insertSingle(PixEmpiModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiModel obj) throws CoBusinessException;

	public void update(PixEmpiModel obj) throws CoBusinessException;

	public void delete(PixEmpiModel obj) throws CoBusinessException;

	public abstract PixEmpiModel  findByPK(PixEmpiModel obj) throws CoBusinessException;

	public abstract List<PixEmpiModel>  queryByCond(PixEmpiModel obj) throws CoBusinessException;

	public abstract List<PixEmpiModel>  queryByPage(PixEmpiModel obj) throws CoBusinessException;

	public abstract Integer  findMaxId(PixEmpiModel obj) throws CoBusinessException;


}
