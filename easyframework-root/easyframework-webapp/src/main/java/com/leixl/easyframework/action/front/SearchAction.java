/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月22日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.front;

import static com.leixl.easyframework.web.TplUtils.MODULE_NAME_MOVIE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.RequestUtils;
import com.leixl.easyframework.web.TplUtils;



/**
 *  
 * @author leixl
 * @date   2014年1月22日 下午4:39:07
 * @version v1.0
 */
@Controller
public class SearchAction extends BaseAction{

	
	public static final String SEARCH_INPUT = "tpl.searchInput";
	public static final String SEARCH_RESULT = "tpl.searchResult";
	/**
	 * 列表模板名称
	 */
	public static final String TPL_TAGMOVIE_LIST = "tpl.movie.tag_list";
	
	@RequestMapping(value = "/search*.htm", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		// 将request中所有参数保存至model中。
		model.putAll(RequestUtils.getQueryParams(request));
		TplUtils.frontData(request, model);
		TplUtils.frontPageData(request, model);
		String q = RequestUtils.getQueryParam(request, "q");
		String parseQ=parseKeywords(q);
		model.addAttribute("input",q);
		model.addAttribute("q",parseQ);
		if (StringUtils.isBlank(q)) {
			return TplUtils.getTplPath(request,
					MODULE_NAME_MOVIE, SEARCH_INPUT);
		} else {
			return TplUtils.getTplPath(request,
					MODULE_NAME_MOVIE, SEARCH_RESULT);
		}
	}
	
	@RequestMapping(value = "/getPageByTagIds.htm", method = RequestMethod.GET)
	public String getPageByTagIds(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		// 将request中所有参数保存至model中。
		model.putAll(RequestUtils.getQueryParams(request));
		TplUtils.frontData(request, model);
		TplUtils.frontPageData(request, model);
		String tagId = RequestUtils.getQueryParam(request, "tagId");
		model.addAttribute("tagId",tagId);
			return TplUtils.getTplPath(request,
					MODULE_NAME_MOVIE, TPL_TAGMOVIE_LIST);
	}
}
