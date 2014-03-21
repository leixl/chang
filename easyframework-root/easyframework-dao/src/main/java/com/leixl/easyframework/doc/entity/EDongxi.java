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
package com.leixl.easyframework.doc.entity;

import java.util.Date;

/**
 *  
 * @author leixl
 * @email  leixl0324@163.com
 * @date   2014年3月13日 上午11:22:56
 * @version v1.0
 */
public class EDongxi extends BaseEDongxi{

	public void init(){
		Date currDate = new Date();
		if(getDisabled() == null){
			setDisabled(false);
		}
		if(getRecommend() == null){
			setRecommend(false);
		}
		if(getCreateDate() == null){
			setCreateDate(currDate);
		}
		if(getUpdateDate() == null){
			setUpdateDate(currDate);
		}
	}
}
