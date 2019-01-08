package com.khsh.datac.empi.service;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiWeightConfigModel;

import java.util.List;
public interface IPixEmpiWeightConfigService {


	public int insertAutoKey(PixEmpiWeightConfigModel model) throws CoBusinessException;

	public void update(PixEmpiWeightConfigModel model) throws CoBusinessException;

	public void delete(PixEmpiWeightConfigModel model) throws CoBusinessException;

	public PixEmpiWeightConfigModel findByPK(PixEmpiWeightConfigModel model) throws CoBusinessException;

	public List<PixEmpiWeightConfigModel>  queryByCond(PixEmpiWeightConfigModel model) throws CoBusinessException;


}
