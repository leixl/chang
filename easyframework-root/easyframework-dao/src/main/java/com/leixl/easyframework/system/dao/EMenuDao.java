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
package com.leixl.easyframework.system.dao;

import java.util.List;

import org.easyframework.core.hibernate3.Updater;

import com.leixl.easyframework.system.entity.EMenu;

/**
 * 
 * @author leixl
 * @date 2013-12-11 下午10:26:58
 * @version v1.0
 */
public interface EMenuDao {

	public List<EMenu> getTopList(boolean displayOnly, boolean cacheable);

	public List<EMenu> getChildList(Integer parentId, boolean displayOnly,
			boolean cacheable);

	public EMenu getById(Integer id);

	public EMenu save(EMenu bean);
	
	public EMenu updateByUpdater(Updater<EMenu> updater);

	public EMenu deleteById(Integer id);

}
