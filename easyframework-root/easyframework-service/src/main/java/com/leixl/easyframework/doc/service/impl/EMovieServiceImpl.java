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

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.doc.dao.EMovieDao;
import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.doc.entity.EMovieTag;
import com.leixl.easyframework.doc.service.EMovieService;
import com.leixl.easyframework.doc.service.EMovieTagService;

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
	@Autowired
	private EMovieTagService tagService;

	public Pagination getPage(String name,Boolean disabled,int pageNo, int pageSize) {
		Pagination page = dao.getPage(name,disabled,pageNo, pageSize);
		return page;
	}
	
	public List<EMovie> getList(){
		return dao.getList();
	}
	
	public Pagination getPageForTag(int pageNo, int pageSize) {
		Pagination page = dao.getPageForTag(pageNo, pageSize);
		return page;
	}
	
	public Pagination getPageByTagIdsForTag(Integer[] tagIds,Boolean recommend,
			int orderBy, int pageNo, int pageSize){
		Pagination page = dao.getPageByTagIdsForTag(tagIds, recommend,orderBy,pageNo,pageSize);
		return page;
	}
	
	public List<EMovie> getListForTag(Boolean recommend,int orderBy,Integer first, Integer count) {
		return dao.getListForTag(recommend,orderBy,first,count);
	}
	
	public EMovie getById(Integer id){
		return dao.getById(id);
	}

	public EMovie save(EMovie bean,String[] tagArr){
		bean.init();
		dao.save(bean);
		List<EMovieTag> tags = tagService.saveTags(tagArr);
		bean.setTags(tags);
	    return bean;
	}
	
	public EMovie update(EMovie bean,String[] tagArr){
		Updater<EMovie> updater = new Updater<EMovie>(bean);
		bean = dao.updateByUpdater(updater);
		// 更新标签
		tagService.updateTags(bean.getTags(), tagArr);
		return bean;
	}

	public EMovie deleteById(Integer id) {
		EMovie entity = dao.getById(id);
		if (entity != null) {
			dao.delete(entity);
		}
		return entity;
	}
	
}
