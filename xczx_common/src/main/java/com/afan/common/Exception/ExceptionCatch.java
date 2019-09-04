package com.afan.common.Exception;

import com.afan.common.model.response.Response;
import com.afan.common.model.response.ResponseResult;
import com.afan.common.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ExceptionCatch
 * @Description: 异常捕获类
 * @Author：afan
 * @Date : 2019/7/25 15:33
 */
@ControllerAdvice
public class ExceptionCatch {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

	@ExceptionHandler(CustomerException.class)
	@ResponseBody
	public ResponseResult customerException(CustomerException e){
		//LOGGER.error("catch exception：{}\r\nexception",e.getMessage(),e);
		ResultCode resultCode = e.getResultCode();
		return new ResponseResult(resultCode);
	}

}
