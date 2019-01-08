package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiDao;
import com.khsh.datac.empi.model.PixEmpiModel;
import com.khsh.datac.empi.service.IPixEmpiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiService")
public class PixEmpiServiceImpl implements IPixEmpiService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiServiceImpl.class);

	@Autowired
	private PixEmpiDao mDao;

	@Override
	public int insertAutoKey(PixEmpiModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiModel  findByPK(PixEmpiModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiModel>  queryByCond(PixEmpiModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiModel> queryByPage(PixEmpiModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiModel> page = new PageBean<PixEmpiModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}
