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
package com.leixl.easyframework.system.entity;


/**
 *  用户
 * @author leixl
 * @date   2013-11-30 下午4:20:54
 * @version v1.0
 */
public class EUser extends BaseEUser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2406372032917959393L;

	public void init(){
		if(getLoginCount()==null){
			setLoginCount(0);
		}
		if(getErrorCount()==null){
			setErrorCount(0);
		}
	}
}
