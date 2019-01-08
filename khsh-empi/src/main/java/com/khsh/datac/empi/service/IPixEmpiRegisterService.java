package com.khsh.datac.empi.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiRegisterModel;
public interface IPixEmpiRegisterService { 


	public int insertAutoKey(PixEmpiRegisterModel model) throws CoBusinessException; 

	public void update(PixEmpiRegisterModel model) throws CoBusinessException;

	public void delete(PixEmpiRegisterModel model) throws CoBusinessException; 

	public PixEmpiRegisterModel findByPK(PixEmpiRegisterModel model) throws CoBusinessException; 

	public List<PixEmpiRegisterModel>  queryByCond(PixEmpiRegisterModel model) throws CoBusinessException;


}