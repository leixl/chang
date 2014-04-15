/**
 * Project: easyframework-dao
 * 
 * File Created at 2013-11-30
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.system.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.easyframework.core.hibernate3.Finder;
import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.easyframework.core.pager.Pagination;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.system.dao.EUserDao;
import com.leixl.easyframework.system.entity.EUser;


@Repository
public class EUserDaoImpl extends HibernateBaseDao<EUser,Long> implements EUserDao{

	
	
	public Pagination getPage(String username, String email,
			Integer groupId, Boolean disabled, Boolean admin,
			int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from EUser bean");
		
		f.append(" where 1=1");
		if (!StringUtils.isBlank(username)) {
			f.append(" and bean.username like :username");
			f.setParam("username", "%" + username + "%");
		}
		if (!StringUtils.isBlank(email)) {
			f.append(" and bean.email like :email");
			f.setParam("email", "%" + email + "%");
		}
		if (groupId != null) {
			f.append(" and bean.group.id=:groupId");
			f.setParam("groupId", groupId);
		}
		if (disabled != null) {
			f.append(" and bean.disabled=:disabled");
			f.setParam("disabled", disabled);
		}
		if (admin != null) {
			f.append(" and bean.admin=:admin");
			f.setParam("admin", admin);
		}
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
	

	public EUser findByUsername(String username) {
		return findUniqueByProperty("username", username);
	}
	
	public EUser findByEmail(String email) {
		return findUniqueByProperty("email", email);
	}


	public int countByUsername(String username) {
		String hql = "select count(*) from EUser bean where bean.username=:username";
		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		return ((Number) query.iterate().next()).intValue();
	}
	public int countMemberByUsername(String username) {
		String hql = "select count(*) from EUser bean where bean.username=:username and bean.admin=false";
		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		return ((Number) query.iterate().next()).intValue();
	}

	public int countByEmail(String email) {
		String hql = "select count(*) from EUser bean where bean.email=:email";
		Query query = getSession().createQuery(hql);
		query.setParameter("email", email);
		return ((Number) query.iterate().next()).intValue();
	}

	public EUser save(EUser bean) {
		getSession().save(bean);
		return bean;
	}
	
}
