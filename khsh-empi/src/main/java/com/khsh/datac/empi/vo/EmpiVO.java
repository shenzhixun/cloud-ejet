package com.khsh.datac.empi.vo;

import com.khsh.datac.empi.model.PixEmpiModel;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: EmpiVO
 * Author:   ShenYijie
 * CreateDate:     2019-01-08 16:18
 * Description: empi对象信息
 * History:
 * Version: 1.0
 */
public class EmpiVO extends PixEmpiModel {
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 社保卡
     */
    private String shebaoCard;
    /**
     * 医保卡
     */
    private String yibaoCard;
    /**
     * 军官证号
     */
    private String junguanCard;

    /**
     * 就诊卡（院内）
     */
    private String jiuzhenCard;

    /**
     * 护照
     */
    private String huzhaoCard;
    /**
     * 驾驶证
     */
    private String jiashiCard;

    /**
     * 患者姓名
     */
    private String name;
    /**
     * 患者性别
     */
    private String sex;
    /**
     * 患者出生日期
     */
    private String birthday;
    /**
     * 患者联系方式
     */
    private String phone;
    /**
     * 患者国别
     */
    private String country;
    /**
     * 患者民族
     */
    private String nation;
    /**  文化程度  */
    private String eduDegree;
    /**  职业  */
    private String job;
    /**  邮箱  */
    private String email;
    /**  婚姻状况  */
    private String marriageState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEduDegree() {
        return eduDegree;
    }

    public void setEduDegree(String eduDegree) {
        this.eduDegree = eduDegree;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarriageState() {
        return marriageState;
    }

    public void setMarriageState(String marriageState) {
        this.marriageState = marriageState;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getShebaoCard() {
        return shebaoCard;
    }

    public void setShebaoCard(String shebaoCard) {
        this.shebaoCard = shebaoCard;
    }

    public String getYibaoCard() {
        return yibaoCard;
    }

    public void setYibaoCard(String yibaoCard) {
        this.yibaoCard = yibaoCard;
    }

    public String getJunguanCard() {
        return junguanCard;
    }

    public void setJunguanCard(String junguanCard) {
        this.junguanCard = junguanCard;
    }

    public String getJiuzhenCard() {
        return jiuzhenCard;
    }

    public void setJiuzhenCard(String jiuzhenCard) {
        this.jiuzhenCard = jiuzhenCard;
    }

    public String getHuzhaoCard() {
        return huzhaoCard;
    }

    public void setHuzhaoCard(String huzhaoCard) {
        this.huzhaoCard = huzhaoCard;
    }

    public String getJiashiCard() {
        return jiashiCard;
    }

    public void setJiashiCard(String jiashiCard) {
        this.jiashiCard = jiashiCard;
    }
}
