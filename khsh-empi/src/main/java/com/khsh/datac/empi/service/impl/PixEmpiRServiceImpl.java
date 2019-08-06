package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.comm.Constant;
import com.khsh.datac.empi.mapper.PixEmpiRDao;
import com.khsh.datac.empi.model.PixEmpiRModel;
import com.khsh.datac.empi.service.IPixEmpiRService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiRService")
public class PixEmpiRServiceImpl implements IPixEmpiRService {
	private final Logger log = LoggerFactory.getLogger(PixEmpiRServiceImpl.class);
	@Autowired
	private PixEmpiRDao mDao;

	@Override
	public int insertAutoKey(PixEmpiRModel model) throws CoBusinessException {
		return mDao.insertAutoKey(model);
	}

	@Override
	public void update(PixEmpiRModel model) throws CoBusinessException {
		if (model.getId() == null) {
			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
		}
		mDao.update(model);
	}

	@Override
	public void delete(PixEmpiRModel model) throws CoBusinessException {
		mDao.delete(model);
	}

	public PixEmpiRModel findByPK(PixEmpiRModel model) throws CoBusinessException {
		return mDao.findByPK(model);
	}

	@Override
	public List<PixEmpiRModel> queryByCond(PixEmpiRModel model) throws CoBusinessException {
		return mDao.queryByCond(model);
	}

	public PageBean<PixEmpiRModel> queryByPage(PixEmpiRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiRModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiRModel> page = new PageBean<PixEmpiRModel>(list);
		return page;
	}

	public int insertSingle(PixEmpiRModel model) throws CoBusinessException {
		// 获取最大id。保证连续性
		Integer maxId = mDao.findMaxId(null);
		maxId = maxId == null ? 1 : maxId + 1;
		model.setId(Long.valueOf(maxId));
		mDao.insertSingle(model);
		return maxId;
	}


	/**
	 * 查询是否存在，不存在则插入
	 * @throws CoBusinessException
	 */
	public void queryAndInsert(List<PixEmpiRModel> list) throws CoBusinessException {

		if(list!=null && list.size()>0) {
			for (PixEmpiRModel item : list) {
				try {
					List<PixEmpiRModel> result = mDao.queryEmpiRelation(item);
					if (result==null || result.size()==0) {
						item.setRelFlag(Constant.REL_FLAG_MAIN);
						insertAutoKey(item);
					}
				}catch (CoBusinessException e) {
					log.error("", e);
				}
			}
		}
	}



}