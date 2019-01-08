package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiWeightConfigDao;
import com.khsh.datac.empi.model.PixEmpiWeightConfigModel;
import com.khsh.datac.empi.service.IPixEmpiWeightConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiWeightConfigService")
public class PixEmpiWeightConfigServiceImpl implements IPixEmpiWeightConfigService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiWeightConfigServiceImpl.class);

	@Autowired
	private PixEmpiWeightConfigDao mDao;

	@Override
	public int insertAutoKey(PixEmpiWeightConfigModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiWeightConfigModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiWeightConfigModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiWeightConfigModel  findByPK(PixEmpiWeightConfigModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiWeightConfigModel>  queryByCond(PixEmpiWeightConfigModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiWeightConfigModel> queryByPage(PixEmpiWeightConfigModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiWeightConfigModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiWeightConfigModel> page = new PageBean<PixEmpiWeightConfigModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiWeightConfigModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}
