package com.afan.common.Exception;

import com.afan.common.model.response.ResultCode;

/**
 * @ClassName: ExceptionCast
 * @Description: 异常抛出类
 * @Author：afan
 * @Date : 2019/7/25 10:58
 */
public class ExceptionCast {

	public static void cast(ResultCode resultCode){
		throw new CustomerException(resultCode);
	}
}
