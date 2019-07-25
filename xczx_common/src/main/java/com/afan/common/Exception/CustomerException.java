package com.afan.common.Exception;

import com.afan.common.model.response.ResultCode;

/**
 * @ClassName: CustomerException
 * @Description: 自定义异常类
 * @Author：afan
 * @Date : 2019/7/25 10:34
 */
public class CustomerException extends RuntimeException {

	private ResultCode resultCode;

	public CustomerException(ResultCode resultCode){
		super("错误代码:"+resultCode.code()+"错误信息:"+resultCode.message());
		this.resultCode = resultCode;
	}


	public ResultCode getResultCode() {
		return this.resultCode;
	}
}
