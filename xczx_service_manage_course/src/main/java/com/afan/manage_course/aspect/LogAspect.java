package com.afan.manage_course.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: LogAspect
 * @Description: 日志统一打印
 * @Author：afan
 * @Date : 2019/7/25 17:35
 */
@Component
@Aspect
public class LogAspect {
	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	private final static String TENANT_KEY = "tenantId";



	@Pointcut("execution (* com.afan.manage_course.service..*.*(..))")
	public void apiLogAop() {
	}

	@Around("apiLogAop()")
	public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
		logger.info("日志统一打印 ===== {}.{}() start =====,参数:\n{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), argsToString(point.getArgs()));
		long startTime = System.currentTimeMillis();
		//DateTime endTime = null;
		//Interval interval = null;
		Object response = null;

//        if (RequestContextHolder.getRequestAttributes() != null) {
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            appRuntimeEnv.ensureTenantId(getParam(request, TENANT_KEY));
//        }

		try {
			//执行该方法
			response = point.proceed();
		} catch (Exception e) {
			logger.error("catch exception：{}\r\nexception",e.getMessage(),e);
//			endTime = new DateTime();
//			interval = new Interval(startTime, endTime);
			logger.info("日志统一打印 ===== {}.{}() end =====,响应时间:{}毫秒,响应内容:\n{}", point.getSignature
					().getDeclaringTypeName(), point.getSignature().getName(), System
					.currentTimeMillis()-startTime);
			throw e;
		}
		//endTime = new DateTime();
		//interval = new Interval(startTime, endTime);
		logger.info("日志统一打印 ===== {}.{}() end =====,响应时间:{}毫秒,响应内容:\n{}", point.getSignature()
				.getDeclaringTypeName(), point.getSignature().getName(), System.currentTimeMillis
				()-startTime, argsToString
				(response));
		return response;
	}

	private String argsToString(Object object) {
		try {
			return  new JSONObject().toJSONString(object);
		} catch (Exception e) {
			logger.error("", e);
		}
		return String.valueOf(object);
	}

	/**
	 * 在切点之后织入
	 * @throws Throwable
	 */
	@After("apiLogAop()")
	public void doAfter() throws Throwable {
		logger.info("=========================================== End ===========================================");
		// 每个请求之间空一行
		logger.info("");
	}

	/**
	 * 获取业务参数
	 *
	 * @param request
	 * @param param
	 * @throws Exception
	 */
	private String getParam(HttpServletRequest request, String param) throws Exception {
		String[] reqParam = request.getParameterValues(param);
		return (reqParam == null || reqParam.length < 1 ? null : reqParam[0]);
	}
}
