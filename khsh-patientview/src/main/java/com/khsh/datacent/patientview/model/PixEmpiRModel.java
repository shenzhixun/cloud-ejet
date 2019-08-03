package com.khsh.datacent.patientview.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiRModel extends CoBaseVO {
    /**    */
    private Long id;
    /**  患者empi  */
    private String empi;
    /**  关联患者empi  */
    private String relEmpi;
    /**  关联关系 1： 被关联 2：  */
    private String relFlag;
    /**  备注  */
    private String remark;
    /**  创建人  */
    private String createBy;
    /**  创建时间  */
    private String createTime;
    /**  修改时间  */
    private String updateTime;
    /**  扩展  */
    private String ext;


}
