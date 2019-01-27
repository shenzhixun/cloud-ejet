import com.ejet.comm.Page;
import com.ejet.comm.Param;
import com.google.gson.Gson;
import com.khsh.datac.patientview.vo.PatientVisitReqVO;
import com.khsh.datac.patientview.vo.PatientVisitVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: TestJson
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 17:12
 * Description:
 * History:
 * Version: 1.0
 */
public class TestJson {


    public static List<PatientVisitVO> queryPatientByPage() {
        List<PatientVisitVO> result = new ArrayList();
        PatientVisitVO vo = new PatientVisitVO();

        vo.setEmpi("42203707-3-c9004387d2614ae98c144c947c9f80f5100010");
        vo.setName("王曾英");
        vo.setAge(36);
        vo.setBirthday("1982/06/22");
        vo.setIdCard("422822198206224025");
        vo.setJobName("");
        vo.setNationName("汉族");
        vo.setMarriageStateName("其他");
        vo.setAddrDetail("花坪蔡家村8组");

        vo.setInHospitalId("18111844");
        vo.setBedId("37");
        vo.setInDeptName("妇产科");
        vo.setInHospitalDate("2018/07/19 15:49:43");
        vo.setVisitType("住院");
        vo.setVisitCorpName("建始县中医医院");
        vo.setDiagName("1.羊水过少2.孕39周+4待产");
        result.add(vo);
        return result;
    }


    public static List<PatientVisitVO> queryPatientVisitByPage() {
        List<PatientVisitVO> result = new ArrayList();
        PatientVisitVO vo = new PatientVisitVO();

        vo.setEmpi("42203707-3-c9004387d2614ae98c144c947c9f80f5100010");
        vo.setName("王曾英");
        vo.setAge(36);
        vo.setBirthday("1982/06/22");
        vo.setIdCard("422822198206224025");
        vo.setJobName("");
        vo.setNationName("汉族");
        vo.setMarriageStateName("其他");
        vo.setAddrDetail("花坪蔡家村8组");

        vo.setInHospitalId("18111844");
        vo.setBedId("37");
        vo.setInDeptName("妇产科");
        vo.setInHospitalDate("2018/07/19 15:49:43");
        vo.setVisitType("住院");
        vo.setVisitCorpName("建始县中医医院");
        vo.setDiagName("1.羊水过少2.孕39周+4待产");
        vo.setDiagBasis("入院情况及诊疗经过：患者王曾英，女，35岁。因“主诉”入院。入院症见：入院症见既往体健，否认高血压、冠心病、肺结核病毒性肝炎、血吸虫病、流行性出血热、痢疾、疟疾、伤寒、钩端螺旋体病等传染病史；否认手术外伤史；否认输血史。发育正常，营养好，表情自如，神志清楚，查体合作，体型正力型，步态正常，自动体位。唇红，黏膜无出血，伸舌居中，齿列正常，齿龈正常，扁桃体无红肿，咽不充血，声音正常。无鼻翼煽动，鼻腔内无分泌物，副鼻窦无压痛。双肺呼吸音正常，双肺未闻及干湿性啰音，语音传导正常，无胸膜摩擦音。心率75次/分，心律整齐，心音正常，无附加音，P2=A2，无心包摩擦音，各瓣膜听诊区未闻及病理性杂音。全腹柔软，无压痛，无反跳痛，肝肋下未触及，胆囊无压痛，Murphy征阴性，脾肋下未触及，肾区无叩痛，无腹部包块。四肢：肌张力正常，肌力正常，双下肢无明显水肿。神经系统：未见明显异常。舌象：舌红，苔薄白，脉弦。");
        result.add(vo);
        return result;
    }


    public static void main(String[] args) {

        Param<PatientVisitReqVO> param = new Param<>();
        PatientVisitReqVO req = new PatientVisitReqVO();
        req.setVisitTypes(Arrays.asList(new String[]{"1","2"})); // 1:门诊 2：住院 3:急诊
        req.setInHospitalEndTime("2018/01/19");
        req.setInHospitalEndTime("2018/07/19");
        req.setQueryKeywords("张三");
        // req.setName("张三");
        // req.setInHospitalId("18111844");//住院号，或者门诊号
        // req.setInDeptName("妇产科");
        Page page = new Page();
        param.setData(req);
        param.setPage(page);
        System.out.println(new Gson().toJson(param));


        System.out.println(new Gson().toJson(queryPatientByPage()));


    }



}
