package com.afan.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CookieUtil
 * @Description: cookie工具类
 * @Author：afan
 * @Date : 2019/7/11 17:55
 */
public class CookieUtil {

		/*
		 * @Description: 添加cookie
		 * @author: afan
		 * @param: [
		 *            domian: 设置跨域共享
		 *            path: 设置统一服务器下应用共享
		 *            name: cookie名字
		 *            value: 值
		 *            maxAge: 生命周期，以秒为单位
		 *            httpOnly : 具有 HttpOnly 特性不能通过客户端脚本访问，则为 true；否则为 false。默认值为 false
		 *           ]
		 * @return: void
		 */
		public static void addCookie(HttpServletResponse response,String domian,String path,String
									 name,String value,int maxAge,boolean httpOnly){
			Cookie cookie = new Cookie(name, value);
			cookie.setDomain(domian);
			cookie.setMaxAge(maxAge);
			cookie.setPath(path);
			cookie.setHttpOnly(httpOnly);
			response.addCookie(cookie);
		}

		/**
		 * @Description: 根据cookie名字读取cookie
		 * @author: afan
		 * @param: [request, cookieName]
		 * @return: java.util.Map<java.lang.String,java.lang.String>
		 */
		public static Map<String,String> readCookies(HttpServletRequest request,String ...
				cookieNames){
			HashMap<String, String> cookieMap = new HashMap<>();
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					String cookieValue = cookie.getValue();
					for (int i = 0; i < cookieNames.length; i++) {
						if(cookieNames[i].equals(cookieName)){
							cookieMap.put(cookieName,cookieValue);
						}
					}
				}
			}
			return cookieMap;
		}

}
