package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiRModel extends CoBaseVO {
    /**    */
    private java.lang.Long id;
    /**  患者empi  */
    private java.lang.String empi;
    /**  关联患者empi  */
    private java.lang.String relEmpi;
    /**  关联关系 1： 被关联 2：  */
    private java.lang.String relFlag;
    /**  备注  */
    private java.lang.String remark;
    /**  创建人  */
    private java.lang.String createBy;
    /**  创建时间  */
    private java.lang.String createTime;
    /**  修改时间  */
    private java.lang.String updateTime;
    /**  扩展  */
    private java.lang.String ext;


}
