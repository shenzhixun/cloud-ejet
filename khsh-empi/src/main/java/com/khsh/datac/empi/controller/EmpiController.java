package com.khsh.datac.empi.controller;

import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
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








}
