/**
 * Project: cms-web
 * 
 * File Created at 2012-10-31
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * 6677bank Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with 6677bank.com.
 */
package com.leixl.easyframework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONObject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.leixl.easyframework.core.SessionProvider;
import com.leixl.easyframework.web.RequestUtils;
import com.leixl.easyframework.web.ResponseUtils;
import com.leixl.easyframework.web.ResultJson;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 校验验证码
 * 
 * @author leixl
 * @email leixl0324@163.com
 * @date 2012-10-31 上午08:39:51
 * @version v1.0
 */
public class VcaptchaFilter implements Filter {

    protected final Logger      logger = LoggerFactory.getLogger(VcaptchaFilter.class);
    
    private static final String INCLUDE_URIS = "includeURIs";

    private ImageCaptchaService captchaService;
	private SessionProvider session;
    
    private String[] includeURIs;
    
    private JSONObject resultJson;

    public void init(FilterConfig config) throws ServletException {
        WebApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(config
                .getServletContext());
        captchaService = (ImageCaptchaService) BeanFactoryUtils.beanOfTypeIncludingAncestors(
                appCtx, ImageCaptchaService.class);
        session = (SessionProvider) BeanFactoryUtils.beanOfTypeIncludingAncestors(appCtx,
                SessionProvider.class);
        
        initIncludeURIs(config);
        initResultJson();
    }

    // 初始化 includeURIs
    private void initIncludeURIs(FilterConfig config) {
        String includeVal = config.getInitParameter(INCLUDE_URIS);
        if (StringUtils.isNotBlank(includeVal)) {
            includeURIs = includeVal.split(",");
        }
    }
    
    // 初始化 resultJson
    private void initResultJson() {
        resultJson = new JSONObject();
        resultJson.put(ResultJson.RETURN_CODE, ResultJson.CMS_YZM_CODE);
        resultJson.put(ResultJson.RETURN_MSG, ResultJson.CMS_YZM_MSG);
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        String requestURI = request.getRequestURI();

        if (ArrayUtils.contains(includeURIs, requestURI)) {
            if (!doValidate(request, response)) {
                ResponseUtils.renderJson(response, resultJson);
                return;
            }
        }
        chain.doFilter(req, resp);
    }
    
    // 校验验证码
    private boolean doValidate(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = session.getSessionId(request, response);
        String captcha = RequestUtils.getQueryParam(request, "captcha");
        
        try {
            return captchaService.validateResponseForID(sessionId, captcha);
        }
        catch (CaptchaServiceException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
    
    public void destroy() {

    }

}
