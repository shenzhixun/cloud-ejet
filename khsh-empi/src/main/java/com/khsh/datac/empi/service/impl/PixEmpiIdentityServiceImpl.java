package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.empi.mapper.PixEmpiIdentityDao;
import com.khsh.datac.empi.model.PixEmpiIdentityModel;
import com.khsh.datac.empi.service.IPixEmpiIdentityService;
import com.khsh.datac.empi.vo.EmpiVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pixEmpiIdentityService")
public class PixEmpiIdentityServiceImpl implements IPixEmpiIdentityService {


	private final Logger log = LoggerFactory.getLogger(PixEmpiIdentityServiceImpl.class);

	@Autowired
	private PixEmpiIdentityDao mDao;

	@Override
	public int insertAutoKey(PixEmpiIdentityModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}

	@Override
	public void update(PixEmpiIdentityModel model) throws CoBusinessException {
 		if(model.getId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}

	@Override
	public void delete(PixEmpiIdentityModel model) throws CoBusinessException {
 		mDao.delete(model);
 	}

	public PixEmpiIdentityModel  findByPK(PixEmpiIdentityModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<PixEmpiIdentityModel>  queryByCond(PixEmpiIdentityModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<PixEmpiIdentityModel> queryByPage(PixEmpiIdentityModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<PixEmpiIdentityModel> list = mDao.queryByPage(model);
		PageBean<PixEmpiIdentityModel> page = new PageBean<PixEmpiIdentityModel>(list);
 		return page;
 	}

	public int insertSingle(PixEmpiIdentityModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}

 	public void insertBatch(EmpiVO vo) throws CoBusinessException {
	    if(vo.getIdentityList()!=null && vo.getIdentityList().size()>0) {
            mDao.insertBatch(vo);
        }
    }

}
