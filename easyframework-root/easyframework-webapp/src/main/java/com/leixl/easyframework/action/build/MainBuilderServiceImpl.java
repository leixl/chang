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

import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPLDIR_INDEX;
import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPL_BASE;
import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPL_BASE_DIR;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.web.TplUtils;

import freemarker.template.TemplateException;

/**
 *  
 * @author leixl
 * @date   2014年3月1日 上午10:25:43
 * @version v1.0
 */
@Service
public class MainBuilderServiceImpl extends AbstractBuilder implements MainBuilderService{
	
	@Transactional(readOnly = true)
	public void index() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR, TPLDIR_INDEX,
				TPL_INDEX);
		build(tpl,getHomePath(TPLDIR_INDEX), data);
	}
	

	@Autowired
	private MessageSource tplMessageSource;
	

}
