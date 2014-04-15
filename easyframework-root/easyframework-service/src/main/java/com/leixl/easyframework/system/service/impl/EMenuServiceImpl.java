/**
 * Project: easyframework-service
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
package com.leixl.easyframework.system.service.impl;

import java.util.Date;
import java.util.List;

import org.easyframework.core.hibernate3.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.system.dao.EMenuDao;
import com.leixl.easyframework.system.entity.EMenu;
import com.leixl.easyframework.system.service.EMenuService;

/**
 * 
 * @author leixl
 * @date 2013-12-11 下午10:31:50
 * @version v1.0
 */
@Service
@Transactional
public class EMenuServiceImpl implements EMenuService {

	@Autowired
	private EMenuDao dao;

	public List<EMenu> getTopList() {
		return dao.getTopList(true, false);
	}

	public List<EMenu> getChildList(Integer parentId) {
		return dao.getChildList(parentId, true, false);
	}

	public EMenu getById(Integer id) {
		EMenu entity = dao.getById(id);
		return entity;
	}

	public EMenu save(EMenu bean) {
		// 关联parentId
		if (bean.getParentId() != null) {
			bean.setParent(dao.getById(bean.getParentId()));
		}
		Date currDate = new Date();
		bean.setCreateDate(currDate);
		bean.setUpdateDate(currDate);
		bean.init();
		dao.save(bean);
		return bean;
	}

	public EMenu update(EMenu bean, Integer parentId) {
		// 更新父级菜单
		EMenu parent;
		if (parentId != null) {
			parent = getById(parentId);
		} else {
			parent = null;
		}
		bean.setParent(parent);
		Updater<EMenu> updater = new Updater<EMenu>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public EMenu[] deleteByIds(Integer[] ids) {
		EMenu[] beans = new EMenu[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			EMenu bean = dao.getById(ids[i]);
			beans[i] = bean;
		}
		return beans;
	}
}
