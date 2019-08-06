package com.khsh.datac.empi.api;

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

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;

/**
 *
 * 获取EMPI信息，外部接口调用
 *
 */

@RestController
@RequestMapping(value="/api")
public class EmpiApiController extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(EmpiController.class);
    @Autowired
    private EmpiServiceImpl mService;

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
     * 获取empi号码（根据patientId）
     */
    @ResponseBody
    @RequestMapping(value="/get-empi-by-patientid")
    public Result getEmpiByPatientId(@RequestBody(required=true) EmpiVO param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            EmpiVO result = mService.queryEmpiByPatientInfo(param);
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




}
