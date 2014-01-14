/**
 * Project: easyframework-dao
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
package com.leixl.easyframework.doc.entity;

import java.io.Serializable;

/**
 * 
 * @author leixl
 * @date 2014年1月8日 下午4:02:39
 * @version v1.0
 */
public class BaseEMovieTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8662950089403597024L;

	// constructors
	public BaseEMovieTag() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEMovieTag(Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;
	// primary key
	private Integer id;
	private String name;
	private Integer typeId;
	private Integer count;

	/**
	 * @return the id
	 */
	
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	
    
	
	
}
