package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.khsh.datac.empi.comm.CardTypeEnum;
import com.khsh.datac.empi.mapper.EmpiDao;
import com.khsh.datac.empi.service.IEmpiService;
import com.khsh.datac.empi.vo.EmpiVO;
import com.khsh.datac.empi.vo.PixEmpiIdentityVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("empiService")
public class EmpiServiceImpl implements IEmpiService {

	private final Logger log = LoggerFactory.getLogger(EmpiServiceImpl.class);

    @Autowired
    private EmpiDao mDao;

    /**
     * 校验必填信息
     * @param model
     * @throws CoBusinessException
     */
    public void checkRegInfo(EmpiVO model) throws CoBusinessException {
        if(StringUtils.isBlank(model.getName())) {//姓名为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "姓名为空");
        }
        if(StringUtils.isBlank(model.getBirthday())) {//出生年月不能为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "出生年月不能为空");
        }
    }

    public PixEmpiIdentityVO wrap(CardTypeEnum type, String number) {
        PixEmpiIdentityVO item = new PixEmpiIdentityVO();
        item.setIdType(type.ordinal());
        item.setIdCode(type.getName());
        item.setIdName(type.getDesc());
        item.setIdNo(number);
        return item;
    }

    /**
     * 根据唯一标识获取
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO queryIdentity(EmpiVO model) throws CoBusinessException {
        //根据 身份证、医保卡、就诊卡、护照等唯一标识信息查询
        List<PixEmpiIdentityVO> identityList = new ArrayList<>();
        if(!StringUtils.isBlank(model.getIdCard())) {
            //校验身份是否合法

            identityList.add(wrap(CardTypeEnum.ID_CARD, model.getIdCard()));
        }
        if(!StringUtils.isBlank(model.getYibaoCard())) {
            identityList.add(wrap(CardTypeEnum.YIBAO_CARD, model.getYibaoCard()));
        }
        if(!StringUtils.isBlank(model.getJiuzhenCard())) {
            identityList.add(wrap(CardTypeEnum.JIUZHEN_CARD, model.getJiuzhenCard()));
        }
        if(!StringUtils.isBlank(model.getHuzhaoCard())) {
            identityList.add(wrap(CardTypeEnum.HUZHAO_CARD, model.getHuzhaoCard()));
        }
        model.setIdentityList(identityList);

        List<PixEmpiIdentityVO> result = mDao.queryIdentity(identityList);

        return null;
    }



	//获取empi信息
    @Override
    public EmpiVO getEmpi(EmpiVO model) throws CoBusinessException {

        checkRegInfo(model);

        queryIdentity(model);


        return null;
    }



}
