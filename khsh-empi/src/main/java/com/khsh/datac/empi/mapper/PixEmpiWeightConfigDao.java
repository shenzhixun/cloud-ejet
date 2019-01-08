package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiWeightConfigModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PixEmpiWeightConfigDao {


	public void insertSingle(PixEmpiWeightConfigModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiWeightConfigModel obj) throws CoBusinessException;

	public void update(PixEmpiWeightConfigModel obj) throws CoBusinessException;

	public void delete(PixEmpiWeightConfigModel obj) throws CoBusinessException;

	public abstract PixEmpiWeightConfigModel  findByPK(PixEmpiWeightConfigModel obj) throws CoBusinessException;

	public abstract List<PixEmpiWeightConfigModel>  queryByCond(PixEmpiWeightConfigModel obj) throws CoBusinessException;

	public abstract List<PixEmpiWeightConfigModel>  queryByPage(PixEmpiWeightConfigModel obj) throws CoBusinessException;

	public abstract Integer  findMaxId(PixEmpiWeightConfigModel obj) throws CoBusinessException;


}
