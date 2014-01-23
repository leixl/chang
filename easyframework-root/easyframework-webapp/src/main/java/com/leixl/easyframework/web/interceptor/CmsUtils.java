package com.leixl.easyframework.web.interceptor;

import javax.servlet.http.HttpServletRequest;

import com.leixl.easyframework.system.entity.EUser;

/**
 * 
 * 比如获得会员信息,获得后台站点信息
 */
public class CmsUtils {
	/**
	 * 用户KEY
	 */
	public static final String USER_KEY = "_user_key";


	/**
	 * 获得用户ID
	 * 
	 * @param request
	 * @return
	 */
	public static Long getUserId(HttpServletRequest request) {
		EUser user = getUser(request);
		if (user != null) {
			return user.getId();
		} else {
			return null;
		}
	}
	
	/**
	 * 获得用户
	 * 
	 * @param request
	 * @return
	 */
	public static EUser getUser(HttpServletRequest request) {
		return (EUser) request.getAttribute(USER_KEY);
	}


	/**
	 * 设置用户
	 * 
	 * @param request
	 * @param user
	 */
	public static void setUser(HttpServletRequest request, EUser user) {
		request.setAttribute(USER_KEY, user);
	}

	
}
