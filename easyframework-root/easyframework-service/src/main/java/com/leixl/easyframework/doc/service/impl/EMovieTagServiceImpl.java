/**
 * Project: easyframework-service
 * 
 * File Created at 2014年1月8日
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

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.doc.dao.EMovieTagDao;
import com.leixl.easyframework.doc.entity.EMovieTag;
import com.leixl.easyframework.doc.service.EMovieTagService;

/**
 *  
 * @author leixl
 * @date   2014年1月8日 下午4:04:07
 * @version v1.0
 */
@Service
@Transactional
public class EMovieTagServiceImpl implements EMovieTagService{

	@Autowired
	private EMovieTagDao dao;

	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	public List<EMovieTag> getList(){
		return dao.getList();
	}
	
	public EMovieTag getById(Integer id){
		return dao.getById(id);
	}

	public EMovieTag save(EMovieTag bean){
	    return dao.save(bean);
	}
	
	public EMovieTag update(EMovieTag bean){
		Updater<EMovieTag> updater = new Updater<EMovieTag>(bean);
		return dao.updateByUpdater(updater);
	}
}
