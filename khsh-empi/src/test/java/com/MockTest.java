package com;


import com.google.gson.Gson;
import com.khsh.datac.empi.vo.EmpiVO;

import java.lang.reflect.InvocationTargetException;

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

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        EmpiVO result = MockUtils.getMockJson(EmpiVO.class);
        System.out.println("==== model ====" + gson.toJson(result));
    }



}
