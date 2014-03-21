package com.leixl.easyframework.web.interceptor;


import static com.leixl.easyframework.common.Constants.RETURN_URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.leixl.easyframework.core.AuthenticationService;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.system.service.EUserService;

/**
 * CMS上下文信息拦截器
 * 
 * 包括登录信息、权限信息、站点信息
 */
public class FrontContextInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log = LoggerFactory
			.getLogger(FrontContextInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String ctx = request.getContextPath() ;
		request.setAttribute("base", ctx);
		
		// 获得用户
		EUser user = null;
		// 正常状态
		Long userId = authService.retrieveUserIdFromSession(request);;
		if (userId != null) {
			user = userService.findById(userId);
		}
		
		String uri = request.getRequestURI();
		// 不在验证的范围内
		if (exclude(uri)) {
			return true;
		}
		// 用户为null跳转到登陆页面
		if (user == null) {
			response.sendRedirect(getLoginUrl(request));
			return false;
		}
		CmsUtils.setUser(request, user);
		log.info(request.getContextPath());
		return true;
	}

	private String getLoginUrl(HttpServletRequest request) {
		StringBuilder buff = new StringBuilder();
		if (loginUrl.startsWith("/")) {
			String ctx = request.getContextPath();
			if (!StringUtils.isBlank(ctx)) {
				buff.append(ctx);
			}
		}
		buff.append(loginUrl).append("?");
		buff.append(RETURN_URL).append("=").append(returnUrl);
		return buff.toString();
	}
	
	private boolean exclude(String uri) {
		if (excludeUrls != null) {
			for (String exc : excludeUrls) {
				if (exc.equals(uri)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	private String loginUrl;
	private String returnUrl;
	private String[] excludeUrls;

	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private EUserService userService;
	
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
	public void setExcludeUrls(String[] excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
}