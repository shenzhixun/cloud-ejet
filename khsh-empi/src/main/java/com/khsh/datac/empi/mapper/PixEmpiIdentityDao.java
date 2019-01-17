package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiIdentityModel;
import com.khsh.datac.empi.vo.EmpiVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PixEmpiIdentityDao {


	public void insertSingle(PixEmpiIdentityModel obj) throws CoBusinessException;

	public int insertAutoKey(PixEmpiIdentityModel obj) throws CoBusinessException;

	public void update(PixEmpiIdentityModel obj) throws CoBusinessException;

	public void delete(PixEmpiIdentityModel obj) throws CoBusinessException;

	public abstract PixEmpiIdentityModel  findByPK(PixEmpiIdentityModel obj) throws CoBusinessException;

	public abstract List<PixEmpiIdentityModel>  queryByCond(PixEmpiIdentityModel obj) throws CoBusinessException;

	public abstract List<PixEmpiIdentityModel>  queryByPage(PixEmpiIdentityModel obj) throws CoBusinessException;

	public abstract Integer findMaxId(PixEmpiIdentityModel obj) throws CoBusinessException;

    public abstract void insertBatch(EmpiVO vo) throws CoBusinessException;

}
