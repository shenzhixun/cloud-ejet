package com.khsh.datac.empi.comm;

/**
 * 卡类型
 */
public enum CardTypeEnum {
    NONE("NONE","NONE无识别信息"),
    ID_CARD("ID_CARD","身份证"),
    YIBAO_CARD("YIBAO_CARD","医保卡"),
    JIUZHEN_CARD("JIUZHEN_CARD", "就诊卡"),
    HUZHAO_CARD("HUZHAO_CARD", "护照"),

    JIASHI_CARD("JIASHI_CARD", "驾驶证"),
    JUNGUAN_CARD("JUNGUAN_CARD", "军官证"),
    SHEBAO_CARD("SHEBAO_CARD", "社保卡");

    private String name;
    private String desc;

    private CardTypeEnum(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public static CardTypeEnum getTypeByname(String name) {
        if(name == null || "".equals(name.trim())){
            return null;
        }
        for (CardTypeEnum c : CardTypeEnum.values()) {
            if(c.getName().toLowerCase().equals(name.trim().toLowerCase())){
                return c;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }



}
