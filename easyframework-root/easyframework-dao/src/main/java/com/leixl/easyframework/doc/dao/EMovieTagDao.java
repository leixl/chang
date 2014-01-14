/**
 * Project: easyframework-dao
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
package com.leixl.easyframework.doc.dao;

import java.util.List;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.doc.entity.EMovieTag;

/**
 *  
 * @author leixl
 * @date   2014年1月8日 下午4:03:45
 * @version v1.0
 */
public interface EMovieTagDao {

	public Pagination getPage(int pageNo,
			int pageSize);
	
	public List<EMovieTag> getList(Integer typeId) ;
	
	public EMovieTag getByName(String name, boolean cacheable) ;
	
	public EMovieTag getById(Integer id);
	
	public EMovieTag save(EMovieTag bean);
	
	public EMovieTag updateByUpdater(Updater<EMovieTag> updater);
	
	public EMovieTag deleteById(Integer id);
	
	public int deleteRef(Integer id);
	
	public int countRef(Integer id);
	
	
}
