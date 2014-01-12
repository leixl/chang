/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月12日
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
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.web.TplUtils;
import com.leixl.easyframework.web.freemarker.DirectiveUtils;
import com.leixl.easyframework.web.freemarker.ParamsRequiredException;
import com.leixl.easyframework.web.freemarker.DirectiveUtils.InvokeType;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 *  
 * @author leixl
 * @date   2014年1月12日 上午10:42:51
 * @version v1.0
 */
public class EMovieTagDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
	}
}
