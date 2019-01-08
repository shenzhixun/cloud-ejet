package com.khsh.datac.empi.service;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiRegisterExtModel;

import java.util.List;
public interface IPixEmpiRegisterExtService {


	public int insertAutoKey(PixEmpiRegisterExtModel model) throws CoBusinessException;

	public void update(PixEmpiRegisterExtModel model) throws CoBusinessException;

	public void delete(PixEmpiRegisterExtModel model) throws CoBusinessException;

	public PixEmpiRegisterExtModel findByPK(PixEmpiRegisterExtModel model) throws CoBusinessException;

	public List<PixEmpiRegisterExtModel>  queryByCond(PixEmpiRegisterExtModel model) throws CoBusinessException;


}
