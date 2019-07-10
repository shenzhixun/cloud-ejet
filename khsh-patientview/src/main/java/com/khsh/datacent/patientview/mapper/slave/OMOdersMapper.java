package com.khsh.datacent.patientview.mapper.slave;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datacent.patientview.vo.OMOrdersDetailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: OMOdersMapper
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 17:10
 * Description:     医嘱信息
 * History:
 * Version: 1.0
 */
@Mapper
public interface OMOdersMapper {

    public List<OMOrdersDetailVO> queryPatientOmOrdersByPage(OMOrdersDetailVO req) throws CoBusinessException;

}
