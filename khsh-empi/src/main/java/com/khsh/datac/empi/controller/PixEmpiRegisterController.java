package com.khsh.datac.empi.controller;

import com.ejet.comm.Param;
import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.core.base.ControllerBase;
import com.ejet.core.comm.PageBean;
import com.khsh.datac.empi.model.PixEmpiRegisterModel;
import com.khsh.datac.empi.service.impl.PixEmpiRegisterServiceImpl;
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
@RequestMapping(value="/pix-empi-register")
public class PixEmpiRegisterController extends ControllerBase {

	private final Logger log = LoggerFactory.getLogger(PixEmpiRegisterController.class);
	@Autowired
	private PixEmpiRegisterServiceImpl mService;


	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)PixEmpiRegisterModel model) {
		Result rs = new Result();
		try {
			List<PixEmpiRegisterModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/find-by-pk")
	public Result findByPK(@RequestBody(required=true)PixEmpiRegisterModel model) {
		Result rs = new Result();
		try {
			PixEmpiRegisterModel result = mService.findByPK(model);
			rs = new Result(result);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)PixEmpiRegisterModel model) {
		Result rs = new Result();
		try{
			mService.delete(model);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/add")
	public Result add(@RequestBody(required=true)PixEmpiRegisterModel model) {
		Result rs = new Result();
		try{
			mService.insertSingle(model);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/update")
	public Result update(@RequestBody(required=true)PixEmpiRegisterModel model) {
		Result rs = new Result();
		try{
			mService.update(model);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/query-by-page")
	public Result queryByPage(@RequestBody(required=true)Param<PixEmpiRegisterModel> param, BindingResult bindResult) {
		Result rs = new Result();
		try{
			checkBindResult(bindResult);
			checkParam(param);
			PixEmpiRegisterModel model = param.getData();
			PageBean<PixEmpiRegisterModel> pageBean = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
			rs = new Result(pageBean.getPage(), pageBean.getResult());
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
