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

import java.util.List;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.system.entity.EUser;

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
	
	public EUser findById(Long id);
	
	public EUser findByUsername(String username);
	
	public List<EUser> findByEmail(String email);
	
	public int countByUsername(String username);
	
	public int countMemberByUsername(String username);
	
	public int countByEmail(String email);
	
	public EUser save(EUser bean);
	
	public EUser deleteById(Long id);
	
	public EUser updateByUpdater(Updater<EUser> updater);
}
