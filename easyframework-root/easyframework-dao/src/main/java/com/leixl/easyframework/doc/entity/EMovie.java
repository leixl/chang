/**
 * Project: easyframework-dao
 * 
 * File Created at 2013-12-20
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

import java.util.Date;
import java.util.List;


/**
 *  电影
 * @author leixl
 * @date   2013-12-20 下午5:28:59
 * @version v1.0
 */
public class EMovie extends BaseEMovie{

	/**
	 * 
	 */
	private static final long serialVersionUID = -900493996828320445L;

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
	
	public String getTagStr() {
		List<EMovieTag> tags = getTags();
		if (tags != null && tags.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (EMovieTag tag : tags) {
				sb.append(tag.getName()).append(',');
			}
			return sb.substring(0, sb.length() - 1);
		} else {
			return null;
		}
	}
}
