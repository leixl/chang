/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月13日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.directive;

import static com.leixl.easyframework.common.Constants.UTF8;
import static com.leixl.easyframework.web.Constants.TPL_STYLE_LIST;
import static com.leixl.easyframework.web.Constants.TPL_SUFFIX;
import static com.leixl.easyframework.web.TplUtils.PARAM_STYLE_LIST;
import static com.leixl.easyframework.web.freemarker.DirectiveUtils.OUT_LIST;
import static com.leixl.easyframework.web.freemarker.DirectiveUtils.OUT_PAGINATION;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.web.TplUtils;
import com.leixl.easyframework.web.freemarker.DirectiveUtils;
import com.leixl.easyframework.web.freemarker.DirectiveUtils.InvokeType;
import com.leixl.easyframework.web.freemarker.ParamsRequiredException;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 *  
 * @author leixl
 * @date   2014年1月13日 下午1:37:28
 * @version v1.0
 */
public class EMoviePageDirective extends AbstractEMovieDirective{

	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "movie_page";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Pagination page = (Pagination) super.getData(params, env);
		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(OUT_PAGINATION, DEFAULT_WRAPPER.wrap(page));
		paramWrap.put(OUT_LIST, DEFAULT_WRAPPER.wrap(page.getList()));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(TPL_STYLE_LIST + listStyle + TPL_SUFFIX, UTF8, true);
			TplUtils.includePagination(params, env);
		} else if (InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			TplUtils.includeTpl(TPL_STYLE_LIST, env);
			TplUtils.includePagination(params, env);
		} else if (InvokeType.custom == type) {
//			TplUtils.includeTpl(TPL_NAME,params, env);
		} else if (InvokeType.body == type) {
			body.render(env.getOut());
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}

	
	@Override
	protected boolean isPage() {
		return true;
	}
}
