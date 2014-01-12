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
package com.leixl.easyframework.doc.dao.impl;

import java.util.List;

import org.easyframework.core.hibernate3.Finder;
import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.easyframework.core.pager.Pagination;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.doc.dao.EMovieTagDao;
import com.leixl.easyframework.doc.entity.EMovieTag;

/**
 *  
 * @author leixl
 * @date   2014年1月8日 下午4:03:35
 * @version v1.0
 */
@Repository
public class EMovieTagDaoImpl extends HibernateBaseDao<EMovieTag, Integer> implements EMovieTagDao{

	public Pagination getPage(int pageNo,
			int pageSize) {
		Finder f = Finder.create("select bean from EMovieTag bean");
		f.append(" where 1=1");
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<EMovieTag> getList() {
		Finder f = Finder.create("select bean from EMovieTag bean");
		f.append(" order by bean.id desc");
		return find(f);
	}

	public EMovieTag getById(Integer id) {
		EMovieTag entity = get(id);
		return entity;
	}

	public EMovieTag save(EMovieTag bean) {
		getSession().save(bean);
		return bean;
	}

	public EMovieTag deleteById(Integer id) {
		EMovieTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<EMovieTag> getEntityClass() {
		return EMovieTag.class;
	}
}
