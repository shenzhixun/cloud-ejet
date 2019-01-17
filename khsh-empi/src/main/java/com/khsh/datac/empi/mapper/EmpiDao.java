package com.khsh.datac.empi.mapper;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.empi.vo.EmpiVO;
import com.khsh.datac.empi.vo.PixEmpiIdentityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpiDao {


	public abstract List<PixEmpiIdentityVO> queryIdentity(List<PixEmpiIdentityVO> list) throws CoBusinessException;

	//唯一性标识empi信息的接口
	public abstract EmpiVO queryEmpiByCard(EmpiVO query) throws CoBusinessException;

	public abstract EmpiVO queryEmpiByCardExt(EmpiVO query) throws CoBusinessException;

    public abstract EmpiVO queryEmpiByPatientId(EmpiVO query) throws CoBusinessException;

    public abstract EmpiVO queryEmpiByInpatientId(EmpiVO query) throws CoBusinessException;

	//根据身份证查询
	public abstract EmpiVO queryEmpiByIdCard(EmpiVO query) throws CoBusinessException;

	//根据医保卡查询
	public abstract EmpiVO queryEmpiByYibaoCard(EmpiVO query) throws CoBusinessException;
	//根据就诊卡查询
	public abstract EmpiVO queryEmpiByJiuzhenCard(EmpiVO query) throws CoBusinessException;
	// 其他唯一标识卡
    public abstract EmpiVO queryEmpiByExtCard(EmpiVO query) throws CoBusinessException;

    //更新empi信息
    public abstract EmpiVO updateEmpi(EmpiVO query) throws CoBusinessException;


}
