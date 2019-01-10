package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.vo.EmpiVO;
import com.khsh.datac.empi.vo.PixEmpiIdentityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpiDao {

	public abstract EmpiVO queryEmpi(EmpiVO obj) throws CoBusinessException;

	public abstract List<PixEmpiIdentityVO> queryIdentity(List<PixEmpiIdentityVO> list) throws CoBusinessException;

}
