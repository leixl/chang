/**
 * Project: easyframework-service
 * 
 * File Created at 2013-12-11
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.system.dao.ERoleDao;
import com.leixl.easyframework.system.entity.ERole;
import com.leixl.easyframework.system.service.ERoleService;

/**
 *  
 * @author leixl
 * @date   2013-12-11 下午4:55:05
 * @version v1.0
 */
@Service
@Transactional
public class ERoleServiceImpl implements ERoleService{

	@Autowired
	private ERoleDao dao;
	
	public List<ERole> getList(){
	   return dao.getList();	
	}
}
