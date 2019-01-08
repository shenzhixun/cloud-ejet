package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiRegisterExtDao;
import com.khsh.datac.empi.model.PixEmpiRegisterExtModel;
import com.khsh.datac.empi.service.IPixEmpiRegisterExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiRegisterExtService")
public class PixEmpiRegisterExtServiceImpl implements IPixEmpiRegisterExtService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiRegisterExtServiceImpl.class);

	@Autowired
	private PixEmpiRegisterExtDao mDao;

	@Override
	public int insertAutoKey(PixEmpiRegisterExtModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiRegisterExtModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiRegisterExtModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiRegisterExtModel  findByPK(PixEmpiRegisterExtModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiRegisterExtModel>  queryByCond(PixEmpiRegisterExtModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiRegisterExtModel> queryByPage(PixEmpiRegisterExtModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiRegisterExtModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiRegisterExtModel> page = new PageBean<PixEmpiRegisterExtModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiRegisterExtModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}
