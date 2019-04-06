package com.test;

import com.ejet.Application;
import com.ejet.mapper.slave.SlaverPatientMapper;
import com.ejet.model.PatientVisitModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MultiDatasourceTest {
    @Autowired
    private com.ejet.mapper.master.PatientMapper masterDao;
    @Autowired
    private SlaverPatientMapper slaverDao;
    /**
     * 查询用户
     * @throws Exception
     */
    @Test
    public void testQueryUser() throws Exception {
        PatientVisitModel query = new PatientVisitModel();
        query.setEmpi("42203707-3-c9004387d2614ae98c144c947c9f80f5100010");
        PatientVisitModel masterUser = masterDao.queryPatientByPage(query );
        System.out.println("masterUser==>"+masterUser.getName());

        PatientVisitModel slaverUser = slaverDao.queryPatientByPage(query);
        System.out.println("slaverUser==>"+slaverUser.getName());
    }
}