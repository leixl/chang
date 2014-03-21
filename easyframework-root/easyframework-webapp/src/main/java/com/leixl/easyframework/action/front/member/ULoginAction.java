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

import static com.leixl.easyframework.common.Constants.MESSAGE;
import static com.leixl.easyframework.common.Constants.RETURN_URL;
import static com.leixl.easyframework.core.AuthenticationService.AUTH_KEY;
import static com.leixl.easyframework.web.TplUtils.MODULE_NAME_MEMBER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leixl.easyframework.common.exception.BadCredentialsException;
import com.leixl.easyframework.common.exception.DisabledException;
import com.leixl.easyframework.common.exception.UsernameNotFoundException;
import com.leixl.easyframework.core.AuthenticationService;
import com.leixl.easyframework.core.SessionProvider;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.system.service.EUserService;
import com.leixl.easyframework.web.RequestUtils;
import com.leixl.easyframework.web.ResponseUtils;
import com.leixl.easyframework.web.ResultJson;
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
	@Autowired
	private SessionProvider session;
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private EUserService service;

	@RequestMapping(value = "/tologin.htm", method = RequestMethod.GET)
	public String input(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return TplUtils.getTplPath(request,
				MODULE_NAME_MEMBER, TPL_MEMBER_LOGIN);
	}
	
	@RequestMapping(value = "/login.htm")
	public void submit(String email, String password, String captcha, String message,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		JSONObject resultJson = new JSONObject();
		try{
			String ip = RequestUtils.getIpAddr(request);
			authenticationService.login(email, password, ip,false,
					request, response);
			resultJson.put(ResultJson.RETURN_CODE, ResultJson.CMS_EMAIL_OK_SERVER_CODE);
		} catch (UsernameNotFoundException e) {
			resultJson.put(ResultJson.RETURN_CODE, ResultJson.CMS_YHM_CODE);
			resultJson.put(ResultJson.RETURN_MSG, ResultJson.CMS_YHM_MSG);
		} catch (BadCredentialsException e) {
			resultJson.put(ResultJson.RETURN_CODE, ResultJson.CMS_MM_CODE);
			resultJson.put(ResultJson.RETURN_MSG, ResultJson.CMS_MM_MSG);
		} catch (DisabledException e) {
		}
		ResponseUtils.renderJson(response, resultJson.toString());
	}
	
	/**
	 * 会员是否登录
	 * @param request
	 * @param response
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/isLogin.htm")
	public void isLogin(HttpServletRequest request,
	                      HttpServletResponse response) throws JSONException{
	    JSONObject resultJson = new JSONObject();
	    resultJson.put("success",false);
	    Long userId = authenticationService.retrieveUserIdFromSession(request);
	    EUser user = null;
        if (userId != null) {
        	if (userId != null) {
    			user = service.findById(userId);
    			resultJson.put("success",true);
                resultJson.put("username", user.getEmail());
    		}           
        }
        ResponseUtils.renderJson(response, resultJson.toString());
	}
	
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout.htm")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		Long userId = (Long) session.getAttribute(request, AUTH_KEY);
		if (userId != null) {
			session.logout(request, response);
		}
		String returnUrl = RequestUtils.getQueryParam(request, RETURN_URL);
		String view = getView(returnUrl);
		if (view != null) {
			return view;
		} else {
			return "redirect:tologin.htm";
		}
	}
	
	/**
	 * 获得地址
	 * 
	 * @param processUrl
	 * @param returnUrl
	 * @param authId
	 * @param defaultUrl
	 * @return
	 */
	private String getView(String returnUrl) {
		if (!StringUtils.isBlank(returnUrl)) {
			StringBuilder sb = new StringBuilder("redirect:");
			sb.append(returnUrl);
			return sb.toString();
		} else {
			return null;
		}
	}
}
