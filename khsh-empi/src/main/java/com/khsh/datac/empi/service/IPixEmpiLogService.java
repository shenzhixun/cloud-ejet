package com.khsh.datac.empi.service;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiLogModel;

import java.util.List;
public interface IPixEmpiLogService {


	public int insertAutoKey(PixEmpiLogModel model) throws CoBusinessException;

	public void update(PixEmpiLogModel model) throws CoBusinessException;

	public void delete(PixEmpiLogModel model) throws CoBusinessException;

	public PixEmpiLogModel findByPK(PixEmpiLogModel model) throws CoBusinessException;

	public List<PixEmpiLogModel>  queryByCond(PixEmpiLogModel model) throws CoBusinessException;


}
