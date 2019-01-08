package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiIdentityContactDao;
import com.khsh.datac.empi.model.PixEmpiIdentityContactModel;
import com.khsh.datac.empi.service.IPixEmpiIdentityContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiIdentityContactService")
public class PixEmpiIdentityContactServiceImpl implements IPixEmpiIdentityContactService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiIdentityContactServiceImpl.class);

	@Autowired
	private PixEmpiIdentityContactDao mDao;

	@Override
	public int insertAutoKey(PixEmpiIdentityContactModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiIdentityContactModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiIdentityContactModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiIdentityContactModel  findByPK(PixEmpiIdentityContactModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiIdentityContactModel>  queryByCond(PixEmpiIdentityContactModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiIdentityContactModel> queryByPage(PixEmpiIdentityContactModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiIdentityContactModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiIdentityContactModel> page = new PageBean<PixEmpiIdentityContactModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiIdentityContactModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}
