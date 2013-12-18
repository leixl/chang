/**
 * Project: easyframework-dao
 * 
 * File Created at 2013-11-30
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.system.dao;

import org.easyframework.core.pager.Pagination;

/**
 *  
 * @author leixl
 * @date   2013-11-30 下午4:14:37
 * @version v1.0
 */
public interface EUserDao {

	public Pagination getPage(String username, String email,
			Integer groupId, Boolean disabled, Boolean admin,
			int pageNo, int pageSize) ;
}
