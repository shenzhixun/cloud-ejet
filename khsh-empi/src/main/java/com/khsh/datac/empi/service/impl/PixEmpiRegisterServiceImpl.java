package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiRegisterDao;
import com.khsh.datac.empi.model.PixEmpiRegisterModel;
import com.khsh.datac.empi.service.IPixEmpiRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiRegisterService")
public class PixEmpiRegisterServiceImpl implements IPixEmpiRegisterService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiRegisterServiceImpl.class);

	@Autowired
	private PixEmpiRegisterDao mDao;

	@Override
	public int insertAutoKey(PixEmpiRegisterModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiRegisterModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiRegisterModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiRegisterModel  findByPK(PixEmpiRegisterModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiRegisterModel>  queryByCond(PixEmpiRegisterModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiRegisterModel> queryByPage(PixEmpiRegisterModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiRegisterModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiRegisterModel> page = new PageBean<PixEmpiRegisterModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiRegisterModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(Integer.valueOf(maxId));
 		mDao.insertSingle(model);
 		return maxId;
 	}


}
