package com.ejet.core.configurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ejet.core.base.InterceptorBase;
import com.ejet.core.context.CoApplicationContext;
import com.ejet.core.filter.CoCorsFilter;
import com.ejet.core.filter.CoSessionFilter;
import com.ejet.core.filter.CoSessionManager;
import com.ejet.core.global.CoConstant;
import com.ejet.core.global.CoGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 过滤器、拦截器相关配置
 * 过滤器：spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
 *
 * @author Ejet
 *
 */
@Configuration
public class CoWebMvcConfigurerImpl  implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(CoWebMvcConfigurerImpl.class);
	@Autowired
    CoGlobal coGlobal;
	/**
	 * 拦截器链条配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        logger.info("##########  add Interceptors num: {} ", CoApplicationContext.getInstance().getInterceptors().size());
        for(InterceptorBase interceptor : CoApplicationContext.getInstance().getInterceptors()) {
            if(interceptor!=null) { //多个拦截器添加
                logger.info("##########  add Interceptor: {} ##########", interceptor.getName());
                registry.addInterceptor(interceptor).addPathPatterns("/**")
 			            .excludePathPatterns(interceptor.excludePathPatterns());
            }
        }
	}

    /**
     * json消息转换器
     * @param converters
     */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
	}

	/**
	 * session过滤器
	 *
	 * @return
	 */
    @Bean
    public FilterRegistrationBean<CoSessionFilter> sessionFilterRegistration() {
        FilterRegistrationBean<CoSessionFilter> registration = new FilterRegistrationBean<CoSessionFilter>();
        registration.setFilter(new CoSessionFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter(CoSessionManager.OPEN_SESSION_AUTH, coGlobal.isOpenSessionAuth() ? "true" : "false");//是否开启session过滤
        registration.setOrder(CoConstant.FILTER_ORDER_SESSION); //spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
        registration.setName(CoConstant.FILTER_NAME_SESSION);
        return registration;
    }

	 /**
     * 跨域过滤器配置
     * @return
     */
    @Bean
    public FilterRegistrationBean<CoCorsFilter> crosFilterRegistration() {
        FilterRegistrationBean<CoCorsFilter> registration = new FilterRegistrationBean<CoCorsFilter>();
        registration.setFilter(new CoCorsFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(CoConstant.FILTER_ORDER_CROS); //spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
        registration.setName(CoConstant.FILTER_NAME_CROS);
        return registration;
    }


}
