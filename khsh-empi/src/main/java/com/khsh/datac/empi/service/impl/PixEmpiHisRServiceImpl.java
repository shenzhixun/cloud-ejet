package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.collect.BeanUtils;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiHisRDao;
import com.khsh.datac.empi.model.PixEmpiHisRModel;
import com.khsh.datac.empi.service.IPixEmpiHisRService;
import com.khsh.datac.empi.vo.EmpiVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.khsh.datac.empi.utils.ValidateUtils.checkPatientHisRInfo;

@Service("pixEmpiHisRService")
public class PixEmpiHisRServiceImpl implements IPixEmpiHisRService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiHisRServiceImpl.class);

	@Autowired
	private PixEmpiHisRDao mDao;

	@Override
	public int insertAutoKey(PixEmpiHisRModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiHisRModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiHisRModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiHisRModel findByPK(PixEmpiHisRModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiHisRModel> queryByCond(PixEmpiHisRModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiHisRModel> queryByPage(PixEmpiHisRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiHisRModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiHisRModel> page = new PageBean<PixEmpiHisRModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiHisRModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId.longValue());
 		mDao.insertSingle(model);
 		return maxId;
 	}


	/**
	 * 查询患者是否存在，并根据结果进行插入
	 *
	 * @param model
	 * @throws CoBusinessException
	 */
 	public void queryAndInsert(EmpiVO model) throws CoBusinessException {
 		//校验
		checkPatientHisRInfo(model);
		PixEmpiHisRModel query = new PixEmpiHisRModel();
		query.setPatientId(model.getPatientId());
		query.setInpatientId(model.getInpatientId());
		List<PixEmpiHisRModel> result = mDao.queryByCond(query);
		if(result==null || result.size()==0) { //无记录，则需要插入
			BeanUtils.copyProperties(model, query);
			mDao.insertAutoKey(query);
		}
	}


}
