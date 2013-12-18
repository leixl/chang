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
package com.leixl.easyframework.system.service;

import java.util.List;

import com.leixl.easyframework.system.entity.EMenu;

/**
 * 
 * @author leixl
 * @date 2013-12-11 下午10:31:59
 * @version v1.0
 */
public interface EMenuService {

	public List<EMenu> getTopList();

	public List<EMenu> getChildList(Integer parentId);

	public EMenu getById(Integer id);

	public EMenu save(EMenu bean);
	
	public EMenu update(EMenu bean,Integer parentId) ;
	
	public EMenu[] deleteByIds(Integer[] ids);
}
