/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月29日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
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

import com.leixl.easyframework.web.TplUtils;

/**
 *  会员登录
 * @author leixl
 * @date   2014年1月29日 下午3:23:44
 * @version v1.0
 */
@Controller
public class ULoginAction {

	public static final String TPL_MEMBER_LOGIN = "tpl.member.login";
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String input(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return TplUtils.getTplPath(request,
				MODULE_NAME_MEMBER, TPL_MEMBER_LOGIN);
	}
}
