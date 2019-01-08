package com.khsh.datac.empi.service;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.model.PixEmpiIdentityContactModel;

import java.util.List;
public interface IPixEmpiIdentityContactService {


	public int insertAutoKey(PixEmpiIdentityContactModel model) throws CoBusinessException;

	public void update(PixEmpiIdentityContactModel model) throws CoBusinessException;

	public void delete(PixEmpiIdentityContactModel model) throws CoBusinessException;

	public PixEmpiIdentityContactModel findByPK(PixEmpiIdentityContactModel model) throws CoBusinessException;

	public List<PixEmpiIdentityContactModel>  queryByCond(PixEmpiIdentityContactModel model) throws CoBusinessException;


}
