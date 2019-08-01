package com.khsh.datac.empi.service;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiRModel;

import java.util.List;

public interface IPixEmpiRService {

	public int insertAutoKey(PixEmpiRModel model) throws CoBusinessException;

	public void update(PixEmpiRModel model) throws CoBusinessException;

	public void delete(PixEmpiRModel model) throws CoBusinessException; 

	public PixEmpiRModel findByPK(PixEmpiRModel model) throws CoBusinessException; 

	public List<PixEmpiRModel>  queryByCond(PixEmpiRModel model) throws CoBusinessException;


}