package com.khsh.datac.empi.vo;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: EmpiMergeVO
 * Author:   ShenYijie
 * CreateDate:     2019-02-18 17:32
 * Description: 合并empi
 * History:
 * Version: 1.0
 */
@Data
public class EmpiMergeVO extends CoBaseVO {

    /**
     * 待合并的信息
     */
    private List<EmpiVO> mergeList = new ArrayList<>();


}
