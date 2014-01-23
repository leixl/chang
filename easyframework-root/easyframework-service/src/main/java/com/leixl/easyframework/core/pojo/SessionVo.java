/**
 * Project: easyframework-service
 * 
 * File Created at 2014年1月23日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.core.pojo;

import java.io.Serializable;

/**
 *  
 * @author leixl
 * @date   2014年1月23日 下午5:01:05
 * @version v1.0
 */
public class SessionVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5333343430364920639L;

	private Long userId;
	
	private String username;
	
	private String userPic;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userPic
	 */
	public String getUserPic() {
		return userPic;
	}

	/**
	 * @param userPic the userPic to set
	 */
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	
	
	
}
