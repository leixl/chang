/**
 * Project: easyframework-service
 * 
 * File Created at 2013-12-23
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.doc.service.impl;

import java.util.List;

import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.doc.dao.EMovieDao;
import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.doc.service.EMovieService;

/**
 *  
 * @author leixl
 * @date   2013-12-23 上午10:27:25
 * @version v1.0
 */
@Service
@Transactional
public class EMovieServiceImpl implements EMovieService{

	@Autowired
	private EMovieDao dao;

	public Pagination getPage(String name,Boolean disabled,int pageNo, int pageSize) {
		Pagination page = dao.getPage(name,disabled,pageNo, pageSize);
		return page;
	}
	
	public List<EMovie> getList(){
		return dao.getList();
	}
	
	public EMovie getById(Integer id){
		return dao.getById(id);
	}

	public EMovie save(EMovie bean){
		bean.init();
	    return dao.save(bean);
	}
	
//	public EMovie updateByUpdater(Updater<EMovie> updater){
//		
//	}
//
//	public EMovie deleteById(Integer id){
//		
//	}
}
