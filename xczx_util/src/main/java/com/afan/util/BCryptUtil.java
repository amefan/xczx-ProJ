package com.afan.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: BCryptUtil
 * @Description: 密码加密工具类
 * @Author：afan
 * @Date : 2019/7/11 13:38
 */
public class BCryptUtil {

	public static String encode(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPass = passwordEncoder.encode(password);
		return hashPass;
	}
	
	public static boolean match(String password,String hashPass){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean flag = passwordEncoder.matches(password, hashPass);
		return flag;
	}

}
