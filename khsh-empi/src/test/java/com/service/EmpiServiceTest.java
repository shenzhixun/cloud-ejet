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

    private void setHasIdentityCard(EmpiVO model) {
        if(model==null) {
            model = new EmpiVO();
        }
        // model.setName("陈仕见");
        // model.setSex(Constant.SEX_FEMAIL);
        // model.setBirthday("1974/07/20 18:21:30.000000000");
        // model.setPatientId("b6c98001-828d-43e4-beb8-a923012f502f");
        // model.setInpatientId("7e842cec-b5d6-484e-9251-a923012f502f");
        // model.setRegCorpId("HB_JSZYY");
        // model.setRegSysId("HIS");
        // model.setIdCard("433426194101012233");
        // model.setYibaoCard("1234");
        // model.setJiuzhenCard("");

        model.setName("陈天双");
        model.setSex(Constant.SEX_FEMAIL);
        model.setBirthday("1974/07/20 18:21:30.000000000");
        model.setPatientId("b6c98001-828d-43e4-beb8-a923012f502f");
        model.setInpatientId("7e842cec-b5d6-484e-9251-a923012f502f");
        model.setRegCorpId("HB_JSZYY");
        model.setRegSysId("HIS");

        model.setIdCard("422822194907210517");
        model.setJiuzhenCard("1234");


    }


    private void setHasIdentityCardExt(EmpiVO model) {
        if(model==null) {
            model = new EmpiVO();
        }
        model.setName("陈仕见");
        model.setSex(Constant.SEX_MAIL);
        model.setBirthday("1974/07/20 18:21:30.000000000");
        model.setPatientId("b6c98001-828d-43e4-beb8-a923012f502f");
        model.setInpatientId("7e842cec-b5d6-484e-9251-a923012f502f");
        model.setRegCorpId("HB_JSZYY");
        model.setRegSysId("HIS");

        model.setHuzhaoCard("099999");
        model.setJiashiCard("9999999");


        model.setSex(1);
        model.setAddrDetail("深圳市xxxx");
        model.setNation("中国");
        model.setMarriageState("未婚");
        model.setRelation("");
        model.setRelPhone("13900099");
        model.setPhone("1398989898");
        model.setRelName("家庭x");


    }



    @Test
    public void generateEmpi(){
        try {
            EmpiVO query = new EmpiVO();
            //setHasIdentityCard(query);
            setHasIdentityCardExt(query);

            EmpiVO result = mService.generateEmpi(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
