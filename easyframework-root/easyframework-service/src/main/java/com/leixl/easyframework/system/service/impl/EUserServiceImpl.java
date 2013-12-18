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
package com.leixl.easyframework.system.service.impl;

import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.system.dao.EUserDao;
import com.leixl.easyframework.system.service.EUserService;

/**
 * 用户管理
 * 
 * @author leixl
 * @date 2013-12-2 下午2:16:36
 * @version v1.0
 */
@Service
@Transactional
public class EUserServiceImpl implements EUserService {
 
	@Autowired
	private EUserDao dao;

	public Pagination getPage(String username, String email, Integer groupId,
			Boolean disabled, Boolean admin, int pageNo, int pageSize) {

		Pagination page = dao.getPage(username, email, groupId, disabled,
				admin, pageNo, pageSize);
		return page;
	}
}
