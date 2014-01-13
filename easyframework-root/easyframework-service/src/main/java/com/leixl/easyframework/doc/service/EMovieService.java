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
package com.leixl.easyframework.doc.service;

import java.util.List;

import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.doc.entity.EMovie;

/**
 *  
 * @author leixl
 * @date   2013-12-23 上午10:26:48
 * @version v1.0
 */
public interface EMovieService {

	public Pagination getPage(String name,Boolean disabled,int pageNo, int pageSize);
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPageForTag(int pageNo, int pageSize) ;
	
	public List<EMovie> getList();
	
	public EMovie getById(Integer id);
	
	public EMovie save(EMovie bean);
	
	public EMovie update(EMovie bean);
}
