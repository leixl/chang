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
package com.leixl.easyframework.doc.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.easyframework.core.hibernate3.Finder;
import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.easyframework.core.pager.Pagination;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.doc.dao.EMovieDao;
import com.leixl.easyframework.doc.entity.EMovie;

/**
 * 
 * @author leixl
 * @date 2013-12-23 上午10:19:15
 * @version v1.0
 */
@Repository
public class EMovieDaoImpl extends HibernateBaseDao<EMovie, Integer> implements
		EMovieDao {

	public Pagination getPage(String name, Boolean disabled, int pageNo,
			int pageSize) {
		Finder f = Finder.create("select bean from EMovie bean");

		f.append(" where 1=1");
		if (!StringUtils.isBlank(name)) {
			f.append(" and bean.name like :name");
			f.setParam("name", "%" + name + "%");
		}
		if (disabled != null) {
			f.append(" and bean.disabled=:disabled");
			f.setParam("disabled", disabled);
		}
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public List<EMovie> getList() {
		Finder f = Finder.create("select bean from EMovie bean");
		f.append(" order by bean.id desc");
		return find(f);
	}
	
	public Pagination getPageForTag(int pageNo, int pageSize){
		Finder f = Finder.create("select bean from EMovie bean");
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
	
	public Pagination getPageByTagIdsForTag(Integer[] tagIds,Boolean recommend,
			int orderBy, int pageNo, int pageSize) {
		Finder f = byTagIds(tagIds, recommend,orderBy);
		f.setCacheable(true);
		return find(f, pageNo, pageSize);
	}


	@SuppressWarnings("unchecked")
	public List<EMovie> getListForTag(Boolean recommend,int orderBy,Integer first, Integer count) {
		Finder f = Finder.create("select bean from EMovie bean");
		f.append(" where 1=1");
		if (recommend != null) {
			f.append(" and bean.recommend=:recommend");
			f.setParam("recommend", recommend);
		}
		if (first != null) {
			f.setFirstResult(first);
		}
		if (count != null) {
			f.setMaxResults(count);
		}
		f.setCacheable(true);
		appendOrder(f,orderBy);
		return find(f);
	}

	public EMovie getById(Integer id) {
		EMovie entity = get(id);
		return entity;
	}

	public EMovie save(EMovie bean) {
		getSession().save(bean);
		return bean;
	}

	public EMovie deleteById(Integer id) {
		EMovie entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	private Finder byTagIds(Integer[] tagIds,Boolean recommend, int orderBy) {
		Finder f = Finder.create();
		int len = tagIds.length;
		if (len == 1) {
			f.append("select bean from EMovie bean join bean.tags tag");
			f.append(" where tag.id=:tagId").setParam("tagId", tagIds[0]);
		} else {
			f.append("select distinct bean from Content bean");
			f.append(" join bean.tags tag");
			f.append(" where tag.id in(:tagIds)");
			f.setParamList("tagIds", tagIds);
		}
		
		if (recommend != null) {
			f.append(" and bean.recommend=:recommend");
			f.setParam("recommend", recommend);
		}
		appendOrder(f, orderBy);
		return f;
	}
	
	private void appendOrder(Finder f, int orderBy) {
		switch (orderBy) {
		case 1:
			// ID升序
			f.append(" order by bean.id asc");
			break;
		case 2:
			// 发布时间降序
			f.append(" order by bean.createDate desc");
			break;
		case 3:
			// 发布时间升序
			f.append(" order by bean.createDate asc");
			break;
		default:
			// 默认： ID降序
			f.append(" order by bean.id desc");
		}
	}
	

	@Override
	protected Class<EMovie> getEntityClass() {
		return EMovie.class;
	}

}
