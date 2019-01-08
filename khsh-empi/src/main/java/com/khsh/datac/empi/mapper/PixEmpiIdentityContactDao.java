package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiIdentityContactModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PixEmpiIdentityContactDao {


	public void insertSingle(PixEmpiIdentityContactModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiIdentityContactModel obj) throws CoBusinessException;

	public void update(PixEmpiIdentityContactModel obj) throws CoBusinessException;

	public void delete(PixEmpiIdentityContactModel obj) throws CoBusinessException;

	public abstract PixEmpiIdentityContactModel  findByPK(PixEmpiIdentityContactModel obj) throws CoBusinessException;

	public abstract List<PixEmpiIdentityContactModel>  queryByCond(PixEmpiIdentityContactModel obj) throws CoBusinessException;

	public abstract List<PixEmpiIdentityContactModel>  queryByPage(PixEmpiIdentityContactModel obj) throws CoBusinessException;

	public abstract Integer  findMaxId(PixEmpiIdentityContactModel obj) throws CoBusinessException;


}
