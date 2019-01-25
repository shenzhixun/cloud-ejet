package com.khsh.datac.patientview.base;

import lombok.Data;

@Data
public class BaseDictionaryDatas extends TableModel {

    private String dCode;

    private String dataKey;

    private String dataValue;

    private String dataNickValue;

    private String dataParentKey;

    private String note;

    private String spell;

    private String unit;

    private Boolean isDisable;

    private Boolean isVisible;

    private Integer dataOrder;

    private String foreignDataKey;

}
