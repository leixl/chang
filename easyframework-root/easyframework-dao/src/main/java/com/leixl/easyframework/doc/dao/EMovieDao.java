/**
 * Project: easyframework-dao
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
package com.leixl.easyframework.doc.dao;

import java.util.List;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.doc.entity.EMovie;

/**
 *  
 * @author leixl
 * @date   2013-12-23 上午10:18:53
 * @version v1.0
 */
public interface EMovieDao {

	public Pagination getPage(String name,Boolean disabled,
			int pageNo, int pageSize);
	
	public List<EMovie> getList();
	
	public Pagination getPageForTag(int pageNo, int pageSize);
	
	/**
	 * 按标签查询分页
	 * @param tagIds
	 * @param recommend
	 * @param orderBy
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPageByTagIdsForTag(Integer[] tagIds,Boolean recommend,
			int orderBy, int pageNo, int pageSize);
	
	public List<EMovie> getListForTag(Boolean recommend,int orderBy,Integer first, Integer count) ;
	
	public EMovie getById(Integer id);

	public EMovie save(EMovie bean);
	
	public EMovie updateByUpdater(Updater<EMovie> updater);

	public EMovie delete(EMovie bean);
}
