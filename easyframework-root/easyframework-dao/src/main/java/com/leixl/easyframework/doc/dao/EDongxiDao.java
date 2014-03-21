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
package com.leixl.easyframework.doc.dao;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.doc.entity.EDongxi;

/**
 *  
 * @author leixl
 * @email  leixl0324@163.com
 * @date   2014年3月13日 下午12:41:13
 * @version v1.0
 */
public interface EDongxiDao {

	public Pagination getPage(String title, Boolean disabled, int pageNo,
			int pageSize);
	
	public EDongxi getById(Long id);

	public EDongxi save(EDongxi bean);
	
	public EDongxi updateByUpdater(Updater<EDongxi> updater);

	public EDongxi deleteById(Long id);
}
