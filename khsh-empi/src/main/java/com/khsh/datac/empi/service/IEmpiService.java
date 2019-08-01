package com.khsh.datac.empi.service;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.vo.EmpiVO;

public interface IEmpiService {

	public EmpiVO generateEmpi(EmpiVO model) throws CoBusinessException;

}
