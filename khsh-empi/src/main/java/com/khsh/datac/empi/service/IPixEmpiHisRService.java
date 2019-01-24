package com.khsh.datac.empi.service;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiHisRModel;

import java.util.List;
public interface IPixEmpiHisRService {


	public int insertAutoKey(PixEmpiHisRModel model) throws CoBusinessException;

	public void update(PixEmpiHisRModel model) throws CoBusinessException;

	public void delete(PixEmpiHisRModel model) throws CoBusinessException;

	public PixEmpiHisRModel findByPK(PixEmpiHisRModel model) throws CoBusinessException;

	public List<PixEmpiHisRModel>  queryByCond(PixEmpiHisRModel model) throws CoBusinessException;


}
