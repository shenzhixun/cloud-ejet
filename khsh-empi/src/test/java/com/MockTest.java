package com;


import com.google.gson.Gson;
import com.khsh.datac.empi.comm.CardTypeEnum;
import com.khsh.datac.empi.utils.IDCardUtils;
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

    public static void main(String[] args) throws Exception {
        //mock();

        CardTypeEnum type = CardTypeEnum.ID_CARD;

        System.out.println(type.ordinal());
        System.out.println(type.getName());
        System.out.println(type.getDesc());


        String idCard = "522728198811083626";
        //String idCard = "430426198303216696";
        System.out.println(IDCardUtils.validateIDCard(idCard));
        System.out.println(IDCardUtils.validateIDCard(idCard)[0] + "|" + IDCardUtils.validateIDCard(idCard)[1]);



    }



}
