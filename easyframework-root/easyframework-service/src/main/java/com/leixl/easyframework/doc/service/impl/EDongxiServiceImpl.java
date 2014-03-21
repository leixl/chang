/**
 * Project: easyframework-service
 * 
 * File Created at 2014年3月13日
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.doc.service.impl;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.doc.dao.EDongxiDao;
import com.leixl.easyframework.doc.entity.EDongxi;
import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.doc.service.EDongxiService;

/**
 *  
 * @author leixl
 * @email  leixl0324@163.com
 * @date   2014年3月13日 下午12:44:55
 * @version v1.0
 */
@Service
@Transactional
public class EDongxiServiceImpl implements EDongxiService{

	@Autowired
	private EDongxiDao dao;
	
	public Pagination getPage(String title,Boolean disabled,int pageNo, int pageSize) {
		Pagination page = dao.getPage(title,disabled,pageNo, pageSize);
		return page;
	}
	
	
	public EDongxi getById(Long id){
		return dao.getById(id);
	}

	public EDongxi save(EDongxi bean){
		bean.init();
		dao.save(bean);
	    return bean;
	}
	
	public EDongxi update(EDongxi bean){
		Updater<EDongxi> updater = new Updater<EDongxi>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}
}
