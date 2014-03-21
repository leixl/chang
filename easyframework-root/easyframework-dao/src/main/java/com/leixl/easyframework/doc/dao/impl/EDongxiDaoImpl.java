/**
 * Project: easyframework-dao
 * 
 * File Created at 2014年3月13日
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.doc.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.easyframework.core.hibernate3.Finder;
import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.easyframework.core.pager.Pagination;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.doc.dao.EDongxiDao;
import com.leixl.easyframework.doc.entity.EDongxi;

/**
 * 
 * @author leixl
 * @email leixl0324@163.com
 * @date 2014年3月13日 下午12:39:13
 * @version v1.0
 */
@Repository
public class EDongxiDaoImpl extends HibernateBaseDao<EDongxi, Long> implements
		EDongxiDao {

	public Pagination getPage(String title, Boolean disabled, int pageNo,
			int pageSize) {
		Finder f = Finder.create("select bean from EDongxi bean");
		f.append(" where 1=1");
		if (!StringUtils.isBlank(title)) {
			f.append(" and bean.title like :title");
			f.setParam("title", "%" + title + "%");
		}
		if (disabled != null) {
			f.append(" and bean.disabled=:disabled");
			f.setParam("disabled", disabled);
		}
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
	
	public EDongxi getById(Long id) {
		EDongxi entity = get(id);
		return entity;
	}

	public EDongxi save(EDongxi bean) {
		getSession().save(bean);
		return bean;
	}

	public EDongxi deleteById(Long id) {
		EDongxi entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EDongxi> getEntityClass() {
		return EDongxi.class;
	}
}
