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

import java.io.Serializable;

/**
 * TODO Comment of BaseCmsMenu
 *
 * @author leixl
 * @version BaseCmsMenu.java 2011-9-28 上午09:05:11
 *
 */
public class BaseEMenu implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 7477261536952699767L;
   

	// constructors
	public BaseEMenu () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEMenu (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.Integer parentId;
	private java.lang.String actionUrl;
	private java.lang.Integer lft;
	private java.lang.Integer rgt;
	private java.lang.Integer priority;
	private java.util.Date createDate;
	private java.util.Date updateDate;
	private java.lang.String permPrefix;
	private java.lang.Boolean isLeaf;
	private java.lang.Boolean display;

	// many to one
	private EMenu parent;

	// collections
	private java.util.Set<EMenu> child;
	/**
	 * @return the hashCode
	 */
	public int getHashCode() {
		return hashCode;
	}

	/**
	 * @param hashCode the hashCode to set
	 */
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	/**
	 * @return the id
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * @return the parentId
	 */
	public java.lang.Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}

    
	
	/**
     * @return the actionUrl
     */
    public java.lang.String getActionUrl() {
        return actionUrl;
    }

    /**
     * @param actionUrl the actionUrl to set
     */
    public void setActionUrl(java.lang.String actionUrl) {
        this.actionUrl = actionUrl;
    }

    /**
	 * @return the lft
	 */
	public java.lang.Integer getLft() {
		return lft;
	}

	/**
	 * @param lft the lft to set
	 */
	public void setLft(java.lang.Integer lft) {
		this.lft = lft;
	}

	/**
	 * @return the rgt
	 */
	public java.lang.Integer getRgt() {
		return rgt;
	}

	/**
	 * @param rgt the rgt to set
	 */
	public void setRgt(java.lang.Integer rgt) {
		this.rgt = rgt;
	}

	/**
	 * @return the priority
	 */
	public java.lang.Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(java.lang.Integer priority) {
		this.priority = priority;
	}

	
	
	/**
     * @return the createDate
     */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the updateDate
     */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    

    /**
     * @return the permPrefix
     */
    public java.lang.String getPermPrefix() {
        return permPrefix;
    }

    /**
     * @param permPrefix the permPrefix to set
     */
    public void setPermPrefix(java.lang.String permPrefix) {
        this.permPrefix = permPrefix;
    }

    /**
	 * @return the isLeaf
	 */
	public java.lang.Boolean getIsLeaf() {
		return isLeaf;
	}

	/**
	 * @param isLeaf the isLeaf to set
	 */
	public void setIsLeaf(java.lang.Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	/**
	 * @return the display
	 */
	public java.lang.Boolean getDisplay() {
		return display;
	}

	/**
	 * @param display the display to set
	 */
	public void setDisplay(java.lang.Boolean display) {
		this.display = display;
	}
	
	

	/**
	 * @return the parent
	 */
	public EMenu getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(EMenu parent) {
		this.parent = parent;
	}

	/**
	 * @return the child
	 */
	public java.util.Set<EMenu> getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(java.util.Set<EMenu> child) {
		this.child = child;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EMenu)) return false;
		else {
			EMenu menu = (EMenu) obj;
			if (null == this.getId() || null == menu.getId()) return false;
			else return (this.getId().equals(menu.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}
