package com;


import com.ejet.comm.utils.time.TimeUtils;
import com.google.gson.Gson;
import com.khsh.datac.empi.comm.CardTypeEnum;
import com.khsh.datac.empi.vo.EmpiVO;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: MockTest
 * Author:   Ejet
 * CreateDate:     2018/10/8 14:37
 * Description:
 * History:
 * Version: 1.0
 */
public class MockTest {

    private static Gson gson = new Gson();

    public static void mock() throws Exception {
        EmpiVO result = MockUtils.getMockJson(EmpiVO.class);
        System.out.println("==== model ====" + gson.toJson(result));
    }


    // public static void testJson() {
    //     JsonObject json = new JsonObject();
    //
    //     json.addProperty("regCorpId", get(Fields.In, "42203707-3").getString(r));
    //     json.addProperty("regCorpName", get(Fields.In, "建始县中医医院").getString(r));
    //
    //     json.addProperty("patientId", get(Fields.In, "PATIENT_ID").getString(r));
    //     json.addProperty("inpatientId", get(Fields.In, "INPATIENT_ID").getString(r));
    //     json.addProperty("zyh", get(Fields.In, "zyh").getString(r));
    //     json.addProperty("name", get(Fields.In, "NAME").getString(r));
    //     json.addProperty("birthday", get(Fields.In, "csrq").getString(r));
    //     json.addProperty("sex", get(Fields.In, "SEXDM").getString(r));
    //     json.addProperty("sexName", get(Fields.In, "SEX").getString(r));
    //     json.addProperty("idCard", get(Fields.In, "sfz").getString(r));
    //     json.addProperty("marriageState", get(Fields.In, "HYZKDM").getString(r));
    //     json.addProperty("marriageStateName", get(Fields.In, "HYZK").getString(r));
    //     json.addProperty("country", get(Fields.In, "GJDM").getString(r));
    //     json.addProperty("countryName", get(Fields.In, "GJ").getString(r));
    //     json.addProperty("nation", get(Fields.In, "MZDM").getString(r));
    //     json.addProperty("nationName", get(Fields.In, "MZ").getString(r));
    //     json.addProperty("job", get(Fields.In, "ZY").getString(r));
    //     json.addProperty("birthAddress", get(Fields.In, "CSDZ").getString(r)); //出生地址
    //     json.addProperty("addrDetail", get(Fields.In, "JTDZ").getString(r)); //家庭地址
    //     json.addProperty("birthAddress", get(Fields.In, "JTDH").getString(r)); //家庭电话
    //     json.addProperty("birthAddress", get(Fields.In, "JTLXR").getString(r));//家庭联系人
    //     json.addProperty("birthAddress", get(Fields.In, "BRLXFS").getString(r));//病人联系方式
    //     json.addProperty("birthAddress", get(Fields.In, "GZDW").getString(r)); //工作单位
    //     json.addProperty("birthAddress", get(Fields.In, "GZDWDZ").getString(r));//工作单位地址
    //     json.addProperty("birthAddress", get(Fields.In, "RYRQ").getString(r));//入院日期
    //     json.addProperty("birthAddress", get(Fields.In, "cwh").getString(r));//床位号
    //     json.addProperty("birthAddress", get(Fields.In, "RYRQ").getString(r));//入院科室
    //
    //     json.addProperty("relPhone", get(Fields.In, "JTDZ").getString(r));
    //
    //
    //
    //     System.out.println(json.toString());
    // }

    public static void main(String[] args) throws Exception {
        //mock();

        CardTypeEnum type = CardTypeEnum.ID_CARD;

        // System.out.println(type.ordinal());
        // System.out.println(type.getName());
        // System.out.println(type.getDesc());

        String idCard = "522728198811083626";
        //String idCard = "430426198303216696";
        //System.out.println(IDCardUtils.validateIDCard(idCard, "/"));
        //String time = "2018/11/14 23:02:00.000000000";
        String time = "1990/07/20 18:21:30.000000000";
        //Date birth = TimeUtils.formatDate3("yyyy/MM/dd HH:mm:ss.000000000", "yyyy/MM/dd HH:mm:ss", time);
        //int age = IDCardUtils.getAgeByBirth(birth);
        System.out.println(TimeUtils.formatDate3("yyyy/MM/dd HH:mm:ss.000000000", "yyyy/MM/dd HH:mm:ss", time));
        System.out.println(TimeUtils.formatDate3("yyyy/MM/dd HH:mm:ss.000000000", "yyyy/MM/dd HH:mm:ss", "1990/07/20 18:21:30.00"));

        //System.out.println(IDCardUtils.validateIDCard(idCard, "-")[0] + "|" + IDCardUtils.validateIDCard(idCard,"-")[1]);

        //mock();

        //testJson();




    }



}
