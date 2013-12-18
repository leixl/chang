/**
 * Project: easyframework-service
 * 
 * File Created at 2013-12-2
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.system.service;

import org.easyframework.core.pager.Pagination;

/**
 *  
 * @author leixl
 * @date   2013-12-2 下午2:16:14
 * @version v1.0
 */
public interface EUserService {
 
	/**
	 * 用户列表
	 * @param username
	 * @param email
	 * @param groupId
	 * @param disabled
	 * @param admin
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPage(String username, String email, Integer groupId,
			Boolean disabled, Boolean admin, int pageNo, int pageSize);
}
