package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiLogDao;
import com.khsh.datac.empi.model.PixEmpiLogModel;
import com.khsh.datac.empi.service.IPixEmpiLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiLogService")
public class PixEmpiLogServiceImpl implements IPixEmpiLogService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiLogServiceImpl.class);

	@Autowired
	private PixEmpiLogDao mDao;

	@Override
	public int insertAutoKey(PixEmpiLogModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiLogModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiLogModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiLogModel  findByPK(PixEmpiLogModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiLogModel>  queryByCond(PixEmpiLogModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiLogModel> queryByPage(PixEmpiLogModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiLogModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiLogModel> page = new PageBean<PixEmpiLogModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiLogModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}
