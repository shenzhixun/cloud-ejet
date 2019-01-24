package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiHisRModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PixEmpiHisRDao {


	public void insertSingle(PixEmpiHisRModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiHisRModel obj) throws CoBusinessException;

	public void update(PixEmpiHisRModel obj) throws CoBusinessException;

	public void delete(PixEmpiHisRModel obj) throws CoBusinessException;

	public abstract PixEmpiHisRModel  findByPK(PixEmpiHisRModel obj) throws CoBusinessException;

	public abstract List<PixEmpiHisRModel>  queryByCond(PixEmpiHisRModel obj) throws CoBusinessException;

	public abstract List<PixEmpiHisRModel>  queryByPage(PixEmpiHisRModel obj) throws CoBusinessException;

	public abstract Integer  findMaxId(PixEmpiHisRModel obj) throws CoBusinessException;


}
