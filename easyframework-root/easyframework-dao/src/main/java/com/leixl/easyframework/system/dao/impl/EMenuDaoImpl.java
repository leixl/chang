/**
 * Project: easyframework-dao
 * 
 * File Created at 2013-12-11
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

import org.easyframework.core.hibernate3.Finder;
import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.system.dao.EMenuDao;
import com.leixl.easyframework.system.entity.EMenu;

/**
 *  
 * @author leixl
 * @date   2013-12-11 下午10:19:24
 * @version v1.0
 */
@Repository
public class EMenuDaoImpl  extends HibernateBaseDao<EMenu,Integer> implements EMenuDao{

	@SuppressWarnings("unchecked")
	public List<EMenu> getTopList(boolean displayOnly, boolean cacheable) {
		Finder f = getTopFinder(displayOnly, cacheable);
		return find(f);
	}
	
	@SuppressWarnings("unchecked")
	public List<EMenu> getChildList(Integer parentId,boolean displayOnly, boolean cacheable) {
		Finder f = getChildFinder(parentId, displayOnly,
				cacheable);
		return find(f);
	}
	
	private Finder getTopFinder(boolean displayOnly, boolean cacheable) {
		Finder f = Finder.create("from EMenu bean");
		f.append(" where bean.parent.id is null");
		if (displayOnly) {
			f.append(" and bean.display=true");
		}
		f.append(" order by bean.priority asc,bean.id asc");
		f.setCacheable(cacheable);
		return f;
	}
	
	private Finder getChildFinder(Integer parentId, boolean displayOnly, boolean cacheable) {
		Finder f = Finder.create("from EMenu bean");
		f.append(" where bean.parent.id=:parentId");
		f.setParam("parentId", parentId);
		if (displayOnly) {
			f.append(" and bean.display=true");
		}
		f.append(" order by bean.priority asc,bean.id asc");
		return f;
	}
	
	public EMenu getById(Integer id) {
		EMenu entity = get(id);
		return entity;
	}
	
	
	public EMenu save(EMenu bean) {
		getSession().save(bean);
		return bean;
	}

	public EMenu deleteById(Integer id) {
		EMenu entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EMenu> getEntityClass() {
		return EMenu.class;
	}
}
