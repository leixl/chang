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
package com.leixl.easyframework.doc.service;

import java.util.Collection;
import java.util.List;

import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.doc.entity.EMovieTag;

/**
 *  
 * @author leixl
 * @date   2014年1月8日 下午4:04:16
 * @version v1.0
 */
public interface EMovieTagService {

	public Pagination getPage(int pageNo, int pageSize);
	
	public List<EMovieTag> getListForTag(Integer typeId);
	
	public List<EMovieTag> getList();
	
	public EMovieTag getById(Integer id);
	
	public EMovieTag save(EMovieTag bean);
	
	public EMovieTag update(EMovieTag bean);
	
	public List<EMovieTag> saveTags(String[] tagArr);
	
	public List<EMovieTag> updateTags(List<EMovieTag> tags, String[] tagArr);
	
	public EMovieTag saveTag(String name);
	
	public void removeTags(Collection<EMovieTag> tags);
}
