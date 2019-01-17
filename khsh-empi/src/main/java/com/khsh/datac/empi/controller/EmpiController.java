package com.khsh.datac.empi.controller;

import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.ejet.core.base.ControllerBase;
import com.khsh.datac.empi.service.impl.EmpiServiceImpl;
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

    /**
     * 获取empi号码
     */
    @ResponseBody
    @RequestMapping(value="/get-empi")
    public Result getEmpi(@RequestBody(required=true) EmpiVO param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            EmpiVO result = mService.getEmpi(param);
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
     * 获取empi号码（根据patientId）
     */
    @ResponseBody
    @RequestMapping(value="/get-empi-by-patientid")
    public Result getEmpiByPatientId(@RequestBody(required=true) EmpiVO param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            EmpiVO result = mService.getEmpiByPatientId(param);
            if(result==null || StringUtils.isBlank(result.getEmpi())) {
                throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "查询EMPI信息为空!");
            }
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
            List<EmpiVO> result = mService.getEmpiSimilar(param);
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
     * 获取根据patient更新empi等注册信息（根据patientId）
     */
    @ResponseBody
    @RequestMapping(value="/update-empi")
    public Result updateEmpiByPatientInfo(@RequestBody(required=true) EmpiVO param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            EmpiVO result = mService.updateEmpiByPatientInfo(param);
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



}
