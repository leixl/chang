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
	

	@Override
	protected Class<EMovie> getEntityClass() {
		return EMovie.class;
	}

}
