package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.service.IEmpiService;
import com.khsh.datac.empi.vo.EmpiVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("empiService")
public class EmpiServiceImpl implements IEmpiService {

	private final Logger log = LoggerFactory.getLogger(EmpiServiceImpl.class);


	//获取empi信息
    @Override
    public EmpiVO getEmpi(EmpiVO model) throws CoBusinessException {
        //根据 医保卡、社保卡、身份证等唯一标识信息






        return null;
    }



}
