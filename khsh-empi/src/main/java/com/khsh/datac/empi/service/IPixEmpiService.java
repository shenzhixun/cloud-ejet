package com.khsh.datac.empi.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiModel;
public interface IPixEmpiService { 


	public int insertAutoKey(PixEmpiModel model) throws CoBusinessException; 

	public void update(PixEmpiModel model) throws CoBusinessException;

	public void delete(PixEmpiModel model) throws CoBusinessException; 

	public PixEmpiModel findByPK(PixEmpiModel model) throws CoBusinessException; 

	public List<PixEmpiModel>  queryByCond(PixEmpiModel model) throws CoBusinessException;


}