package com.service;

import com.ejet.core.CommWebApplication;
import com.ejet.core.db.CommWebDBApplication;
import com.khsh.datac.empi.EMPIApplication;
import com.khsh.datac.empi.comm.Constant;
import com.khsh.datac.empi.service.impl.EmpiServiceImpl;
import com.khsh.datac.empi.vo.EmpiVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: EmpiServiceTest
 * Author:   ShenYijie
 * CreateDate:   2019-01-09 21:47
 * Description: empi测试
 * History:
 * Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {EMPIApplication.class, CommWebApplication.class, CommWebDBApplication.class})
public class EmpiServiceTest {

    @Autowired
    private EmpiServiceImpl mService;
    // private EmpiVO query;

    private void set(EmpiVO model) {
        if(model==null) {
            model = new EmpiVO();
        }
        model.setName("黄开英");
        model.setSex(Constant.SEX_FEMAIL);
        model.setBirthday("1941-01-01");
        model.setPatientId("e11f64e8-3f90-4727-9fb3-a997009bd80c");

        model.setIdCard("433426194101012233");
        model.setYibaoCard("1234");
        model.setJiuzhenCard("");


    }


    @Test
    public void getEmpi(){
        try {
            EmpiVO query = new EmpiVO();
            set(query);

            mService.getEmpi(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
