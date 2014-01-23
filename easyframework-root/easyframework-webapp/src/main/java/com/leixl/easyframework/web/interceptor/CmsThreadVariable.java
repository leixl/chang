package com.leixl.easyframework.web.interceptor;

import com.leixl.easyframework.system.entity.EUser;

/**
 * 线程变量
 */
public class CmsThreadVariable {
	/**
	 * 当前用户线程变量
	 */
	private static ThreadLocal<EUser> EUserVariable = new ThreadLocal<EUser>();

	/**
	 * 获得当前用户
	 * 
	 * @return
	 */
	public static EUser getUser() {
		return EUserVariable.get();
	}

	/**
	 * 设置当前用户
	 * 
	 * @param user
	 */
	public static void setUser(EUser user) {
		EUserVariable.set(user);
	}

	/**
	 * 移除当前用户
	 */
	public static void removeUser() {
		EUserVariable.remove();
	}


}
