/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年3月1日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.build;

import java.io.IOException;

import freemarker.template.TemplateException;

/**
 *  
 * @author leixl
 * @date   2014年3月1日 上午10:25:31
 * @version v1.0
 */
public interface MainBuilderService {

	public void index() throws IOException, TemplateException;
	
}
