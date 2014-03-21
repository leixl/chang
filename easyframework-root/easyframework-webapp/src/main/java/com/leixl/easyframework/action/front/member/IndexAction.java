/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年3月11日
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.front.member;

import static com.leixl.easyframework.web.TplUtils.MODULE_NAME_MEMBER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.TplUtils;

/**
 *  
 * @author leixl
 * @email  leixl0324@163.com
 * @date   2014年3月11日 上午10:11:48
 * @version v1.0
 */
@Controller
public class IndexAction extends BaseAction{

	
	public static final String TPL_MEMBER_INDEX = "tpl.member.index";
	
	@RequestMapping(value = "/index.htm")
	public String index(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return TplUtils.getTplPath(request,
				MODULE_NAME_MEMBER, TPL_MEMBER_INDEX);
	}
	
}
