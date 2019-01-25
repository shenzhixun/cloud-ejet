package com.khsh.datac.patientview.base;

import java.io.Serializable;
import java.util.Date;

public class TableModel implements Serializable {
    private Long uuid = null;
    private Date dateFrom = null;
    private Date dateTo = null;
    private Integer creator = null;
    private Integer whoModified = null;
    private Date timeCreated = null;
    private Date timeModified = null;
    private Integer corpId = null;

    public TableModel() {
    }

    public Long getUuid() {
        return this.uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Date getDateFrom() {
        return this.dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return this.dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getCreator() {
        return this.creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getWhoModified() {
        return this.whoModified;
    }

    public void setWhoModified(Integer whoModified) {
        this.whoModified = whoModified;
    }

    public Date getTimeCreated() {
        return this.timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeModified() {
        return this.timeModified;
    }

    public void setTimeModified(Date timeModified) {
        this.timeModified = timeModified;
    }

    public Integer getCorpId() {
        return this.corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }
}
