package com.khsh.datac.empi.api;

import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.core.base.ControllerBase;
import com.khsh.datac.empi.service.impl.EmpiExtServiceImpl;
import com.khsh.datac.empi.service.impl.EmpiServiceImpl;
import com.khsh.datac.empi.vo.EmpiMergeVO;
import com.khsh.datac.empi.vo.EmpiVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;

@RestController
@RequestMapping(value="/empi")
public class EmpiController extends ControllerBase {

	private final Logger log = LoggerFactory.getLogger(EmpiController.class);
	@Autowired
	private EmpiServiceImpl mService;
    @Autowired
    private EmpiExtServiceImpl extService;
    /**
     * 生成EMPI，根据获取的HIS门诊、住院记录
     */
    @ResponseBody
    @RequestMapping(value="/gen-empi")
    public Result generateEmpi(@RequestBody(required=true) EmpiVO param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            EmpiVO result = mService.generateEmpi(param);
            rs = new Result(result);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }

    /**
     * 获取empi号码(相似的信息)
     */
    @ResponseBody
    @RequestMapping(value="/get-empi-similar")
    public Result getSimilarEmpi(@RequestBody(required=true) EmpiVO param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            List<EmpiVO> result = extService.getEmpiSimilar(param);
            rs = new Result(result);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }
//    /**
//     * 合并empi
//     */
//    @ResponseBody
//    @RequestMapping(value="/merge-empi")
//    public Result mergeEmpi(@RequestBody(required=true) EmpiMergeVO param, BindingResult bindResult) {
//        Result rs = new Result();
//        try{
//            checkBindResult(bindResult);
//            extService.mergeEmpi(param);
//        }catch (CoBusinessException e) {
//            log.error("", e);
//            rs = new Result(e.getCode(), e);
//        }catch (Exception e) {
//            log.error("", e);
//            rs = new Result(SYS_ERROR, e);
//        }
//        return rs;
//    }


    /**
     * 拆分empi
     */
    @ResponseBody
    @RequestMapping(value="/divide-empi")
    public Result divideEmpi(@RequestBody(required=true) EmpiMergeVO param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            extService.divideEmpi(param);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }


//
//    /**
//     * 获取根据patient更新empi等注册信息（根据patientId）
//     */
//    @ResponseBody
//    @RequestMapping(value="/update-empi")
//    public Result updateEmpiByPatientInfo(@RequestBody(required=true) EmpiVO param, BindingResult bindResult) {
//        Result rs = new Result();
//        try{
//            checkBindResult(bindResult);
//            EmpiVO result = mService.updateEmpiByPatientInfo(param);
//            rs = new Result(result);
//        }catch (CoBusinessException e) {
//            log.error("", e);
//            rs = new Result(e.getCode(), e);
//        }catch (Exception e) {
//            log.error("", e);
//            rs = new Result(SYS_ERROR, e);
//        }
//        return rs;
//    }


}
