package com.ejet.core.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ejet.comm.Page;
import com.ejet.comm.Param;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.google.gson.Gson;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.ejet.comm.exception.ExceptionCode.PARAM_MISSING;

/**
 * 基础controller
 *
 * @author Ejet
 *
 */
@SuppressWarnings("unchecked")
public abstract class ControllerBase {
	private Gson gson = new Gson();
	/**
	 * 最大分页条数200
	 */
	private final Integer MAX_PAGE_SIZE = 200;
    /**
     * 默认分页条数20
     */
	private final Integer DEFAULT_PAGE_SIZE = 20;

	//@Autowired
    //CoGlobal global;
    /**
     * 获取客户端IP地址
     *
     * @param request 请求的HttpServletRequest
     * @return ip地址信息
     */
	protected String getRemoteIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 监测是否绑定参数异常
     *
     * @param bindResult   校验结果
     * @throws CoBusinessException  错误信息
     */
	public void checkBindResult(BindingResult bindResult) throws CoBusinessException {
		if(bindResult.hasErrors()) {
			throw new CoBusinessException(PARAM_MISSING);
		}
	}

    /**
     * 入参转换为对象
     *
     * @param param
     * @param type
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public <T> T toBean(Object param, TypeReference<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        if(param==null) return null;

        T model = null;
        Object data = param;
        //包含分页信息对象
        if(param instanceof Param) {
            data = ((Param)param).getData();
            if(((Param)param).getPage()!=null) {//设置分页信息
                int pageNum = ((Param)param).getPage().getPageNum();
                int pageSize = ((Param)param).getPage().getPageSize();
                ((Param)param).getPage().setPageNum( pageNum<=0 ? 1 : pageNum );
                ((Param)param).getPage().setPageSize( pageSize<=0 ? DEFAULT_PAGE_SIZE : pageSize );
                ((Param)param).getPage().setPageSize( pageSize>MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize );
            }
        }
        if(data!=null) {
            model = JSON.parseObject(JSON.toJSONString(data), type);
        }
        //构造空对象，防止错误
        if(model==null) {
            model = getInstance(type.getType().getTypeName());
        }
        return model;
    }

    /**
     * 检查入参,主要是分页方法, 防止分页为空或者分页参数过大
     *
     * @param param
     */
    public void checkParam(Param param) throws CoBusinessException {
        if(param==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
        if(param.getPage()==null) {//设置分页信息
            param.setPage(new Page(1, DEFAULT_PAGE_SIZE));
        } else {
            int pageNum = param.getPage().getPageNum();
            int pageSize = param.getPage().getPageSize();
            param.getPage().setPageNum( pageNum<=0 ? 1 : pageNum );
            param.getPage().setPageSize( pageSize<=0 ? DEFAULT_PAGE_SIZE : pageSize );
            param.getPage().setPageSize( pageSize>MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize );
        }
    }


    /**
     * 根据类名，获取对象
     *
     * @param clazzName
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public <T> T getInstance(String clazzName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class clazz = Class.forName(clazzName);
        Class[] paramTypes = {};
        T inter = null;
        Constructor<T> constructor = clazz.getConstructor(paramTypes);
        inter = constructor.newInstance();
        return inter;
    }


}
