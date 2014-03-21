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
import static com.leixl.easyframework.common.Constants.MESSAGE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leixl.easyframework.core.SessionProvider;
import com.leixl.easyframework.system.service.EUserService;
import com.leixl.easyframework.web.RequestUtils;
import com.leixl.easyframework.web.ResponseUtils;
import com.leixl.easyframework.web.ResultJson;
import com.leixl.easyframework.web.TplUtils;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 *  会员注册
 * @author leixl
 * @date   2014年1月29日 下午3:23:31
 * @version v1.0
 */
@Controller
public class RegistAction {
	
	public static final String TPL_MEMBER_REGITST = "tpl.member.regist";

	@Autowired
	private ImageCaptchaService imageCaptchaService;
	@Autowired
	private SessionProvider session;
	@Autowired
	private EUserService service;
	
	

	@RequestMapping(value = "/toregist.htm", method = RequestMethod.GET)
	public String toRegist(HttpServletRequest request) {
		return TplUtils.getTplPath(request,
				MODULE_NAME_MEMBER, TPL_MEMBER_REGITST);
	}
	
	
	@RequestMapping(value="/regist.htm")
	public void regist(HttpServletRequest request,
			HttpServletResponse response,String email,String password,
			String nickName,String captcha){
		JSONObject resultJson = new JSONObject();
		String ip = RequestUtils.getIpAddr(request);
		service.registMember(email, password, nickName, ip,request,response);
		resultJson.put(ResultJson.RETURN_CODE, ResultJson.CMS_EMAIL_OK_SERVER_CODE);
		ResponseUtils.renderJson(response, resultJson.toString());
	}
	
	 /**
     * 验证用户名是否已被注册
     * @param request
     * @param response
     * @throws JSONException
     */
    @RequestMapping(value = "/email_unique.htm")
    public void usernameUnique(HttpServletRequest request, HttpServletResponse response)
            throws JSONException {
        String email = RequestUtils.getQueryParam(request, "email");
        if (service.emailExist(email)) {          
            ResponseUtils.renderJson(response, "false");
        }
        ResponseUtils.renderJson(response, "true");
    }
	
}
