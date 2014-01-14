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
package com.leixl.easyframework.doc.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.doc.dao.EMovieTagDao;
import com.leixl.easyframework.doc.entity.EMovieTag;
import com.leixl.easyframework.doc.service.EMovieTagService;

/**
 *  
 * @author leixl
 * @date   2014年1月8日 下午4:04:07
 * @version v1.0
 */
@Service
@Transactional
public class EMovieTagServiceImpl implements EMovieTagService{

	@Autowired
	private EMovieTagDao dao;

	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	public List<EMovieTag> getListForTag(Integer typeId){
		return dao.getList(typeId);
	}
	
	public List<EMovieTag> getList(){
		return dao.getList(null);
	}
	
	public EMovieTag getById(Integer id){
		return dao.getById(id);
	}
	
	public EMovieTag getByName(String name){
		return dao.getByName(name, false);
	}

	public EMovieTag save(EMovieTag bean){
        if(bean.getTypeId() == null){
        	bean.setTypeId(1);//默认为类型
        }
        if(bean.getCount() == null){
        	bean.setCount(1);
        }
	    return dao.save(bean);
	}
	
	public EMovieTag update(EMovieTag bean){
		Updater<EMovieTag> updater = new Updater<EMovieTag>(bean);
		return dao.updateByUpdater(updater);
	}
	
	/**
	 * @see ContentTagMng#saveTags(String[])
	 */
	public List<EMovieTag> saveTags(String[] tagArr) {
		if (tagArr == null || tagArr.length <= 0) {
			return null;
		}
		List<EMovieTag> list = new ArrayList<EMovieTag>();
		// 用于检查重复
		Set<String> tagSet = new HashSet<String>();
		EMovieTag tag;
		for (String name : tagArr) {
			// 检测重复
			for (String t : tagSet) {
				if (t.equalsIgnoreCase(name)) {
					continue;
				}
			}
			tagSet.add(name);
			tag = saveTag(name);
			list.add(tag);
		}
		return list;
	}

	/**
	 * @see ContentTagMng#saveTag(String)
	 */
	public EMovieTag saveTag(String name) {
		EMovieTag tag = getByName(name);
		if (tag != null) {
			tag.setCount(tag.getCount() + 1);
		} else {
			tag = new EMovieTag();
			tag.setName(name);
			tag = save(tag);
		}
		return tag;
	}

	public List<EMovieTag> updateTags(List<EMovieTag> tags, String[] tagArr) {
		if (tagArr == null) {
			tagArr = new String[0];
		}
		List<EMovieTag> list = new ArrayList<EMovieTag>();
		EMovieTag bean;
		for (String t : tagArr) {
			bean = null;
			for (EMovieTag tag : tags) {
				if (t.equalsIgnoreCase(tag.getName())) {
					bean = tag;
					break;
				}
			}
			if (bean == null) {
				bean = saveTag(t);
			}
			list.add(bean);
		}
		Set<EMovieTag> toBeRemove = new HashSet<EMovieTag>();
		boolean contains;
		for (EMovieTag tag : tags) {
			contains = false;
			for (String t : tagArr) {
				if (t.equalsIgnoreCase(tag.getName())) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				toBeRemove.add(tag);
			}
		}
		tags.clear();
		tags.addAll(list);
		removeTags(toBeRemove);
		return tags;
	}

	public void removeTags(Collection<EMovieTag> tags) {
		Set<EMovieTag> toRemove = new HashSet<EMovieTag>();
		for (EMovieTag tag : tags) {
			tag.setCount(tag.getCount() - 1);
			if (tag.getCount() <= 0) {
				toRemove.add(tag);
			}
		}
		for (EMovieTag tag : toRemove) {
			//由于事务真正删除关联的sql语句还没有执行，这个时候jc_contenttag里至少还有一条数据。
			if (dao.countRef(tag.getId()) <= 1) {
				dao.deleteById(tag.getId());
			} else {
				// 还有引用，不应该出现的情况，此时无法删除。
			}
		}
	}
}
