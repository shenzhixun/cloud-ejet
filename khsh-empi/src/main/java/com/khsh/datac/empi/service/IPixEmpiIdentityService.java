package com.khsh.datac.empi.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiIdentityModel;
public interface IPixEmpiIdentityService { 


	public int insertAutoKey(PixEmpiIdentityModel model) throws CoBusinessException; 

	public void update(PixEmpiIdentityModel model) throws CoBusinessException;

	public void delete(PixEmpiIdentityModel model) throws CoBusinessException; 

	public PixEmpiIdentityModel findByPK(PixEmpiIdentityModel model) throws CoBusinessException; 

	public List<PixEmpiIdentityModel>  queryByCond(PixEmpiIdentityModel model) throws CoBusinessException;


}