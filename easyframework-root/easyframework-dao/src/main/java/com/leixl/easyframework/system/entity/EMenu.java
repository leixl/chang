/**
 * Project: sycms-dal
 * 
 * File Created at 2011-9-28
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * 6677bank Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with 6677bank.com.
 */
package com.leixl.easyframework.system.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.easyframework.core.hibernate3.HibernateTree;
import org.easyframework.core.hibernate3.PriorityInterface;

/**
 *
 * @author leixl
 * @version CmsMenu.java 2011-9-28 上午09:04:58
 *
 */
public class EMenu extends BaseEMenu implements HibernateTree<Integer>,PriorityInterface{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7653233596666533400L;

	/**
	 * 获得节点列表。从父节点到自身。
	 * 
	 * @return
	 */
	public List<EMenu> getNodeList() {
		LinkedList<EMenu> list = new LinkedList<EMenu>();
		EMenu node = this;
		while (node != null) {
			list.addFirst(node);
			node = node.getParent();
		}
		return list;
	}

	/**
	 * 获得节点列表ID。从父节点到自身。
	 * 
	 * @return
	 */
	public Integer[] getNodeIds() {
		List<EMenu> menus = getNodeList();
		Integer[] ids = new Integer[menus.size()];
		int i = 0;
		for (EMenu c : menus) {
			ids[i++] = c.getId();
		}
		return ids;
	}

	/**
	 * 获得深度
	 * 
	 * @return 第一层为0，第二层为1，以此类推。
	 */
	public int getDeep() {
		int deep = 0;
		EMenu parent = getParent();
		while (parent != null) {
			deep++;
			parent = parent.getParent();
		}
		return deep;
	}



	public static List<EMenu> getListForSelect(List<EMenu> topList) {
		
		List<EMenu> list = new ArrayList<EMenu>();
		for (EMenu c : topList) {
			addChildToList(list, c);
		}
		return list;
	}

	/**
	 * 递归将子菜单加入列表。条件：有内容的菜单。
	 * 
	 * @param list
	 *            菜单容器
	 * @param EMenu
	 *            待添加的菜单，且递归添加子菜单
	 * @param rights
	 *            有权限的菜单，为null不控制权限。
	 */
	private static void addChildToList(List<EMenu> list, EMenu menu) {
		
		list.add(menu);
		Set<EMenu> child = menu.getChild();
		for (EMenu c : child) {
				addChildToList(list, c);
		}
	}
	
	
	public void init() {
		if (getPriority() == null) {
			setPriority(10);
		}
		if (getDisplay() == null) {
			setDisplay(true);
		}
	}

	
	/**
	 * @see HibernateTree#getLftName()
	 */
	public String getLftName() {
		return DEF_LEFT_NAME;
	}

	/**
	 * @see HibernateTree#getParentName()
	 */
	public String getParentName() {
		return DEF_PARENT_NAME;
	}

	/**
	 * @see HibernateTree#getRgtName()
	 */
	public String getRgtName() {
		return DEF_RIGHT_NAME;
	}

	public static Integer[] fetchIds(Collection<EMenu> menus) {
		if (menus == null) {
			return null;
		}
		Integer[] ids = new Integer[menus.size()];
		int i = 0;
		for (EMenu c : menus) {
			ids[i++] = c.getId();
		}
		return ids;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public EMenu() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public EMenu(java.lang.Integer id) {
		super(id);
	}

	

	/* (non-Javadoc)
	 * @see com.jeecms.common.hibernate3.HibernateTree#getTreeCondition()
	 */
	@Override
	public String getTreeCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
