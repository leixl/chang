package com.leixl.easyframework.action.lucene;

import static com.leixl.easyframework.common.Constants.UTF8;
import static com.leixl.easyframework.web.Constants.TPL_STYLE_LIST;
import static com.leixl.easyframework.web.Constants.TPL_SUFFIX;
import static com.leixl.easyframework.web.TplUtils.PARAM_STYLE_LIST;
import static com.leixl.easyframework.web.freemarker.DirectiveUtils.OUT_LIST;
import static com.leixl.easyframework.web.freemarker.DirectiveUtils.OUT_PAGINATION;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.queryParser.ParseException;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import com.leixl.easyframework.lucene.LuceneService;
import com.leixl.easyframework.web.Constants;
import com.leixl.easyframework.web.TplUtils;
import com.leixl.easyframework.web.freemarker.DirectiveUtils;
import com.leixl.easyframework.web.freemarker.DirectiveUtils.InvokeType;
import com.leixl.easyframework.web.freemarker.ParamsRequiredException;
import com.leixl.easyframework.web.springmvc.RealPathResolver;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class LucenePageDirective implements TemplateDirectiveModel {
	
	/**
	 * 输入参数，搜索关键字
	 */
	public static final String PARAM_QUERY = "q";
	
	/**
	 * 输入参数，开始日期
	 */
	public static final String PARAM_START_DATE = "startDate";
	/**
	 * 输入参数，结束日期
	 */
	public static final String PARAM_END_DATE = "endDate";
	
	protected String getQuery(Map<String, TemplateModel> params)
			throws TemplateException {
		return DirectiveUtils.getString(PARAM_QUERY, params);
	}
	
	protected Date getStartDate(Map<String, TemplateModel> params)
			throws TemplateException {
		return DirectiveUtils.getDate(PARAM_START_DATE, params);
	}

	protected Date getEndDate(Map<String, TemplateModel> params)
			throws TemplateException {
		return DirectiveUtils.getDate(PARAM_END_DATE, params);
	}
	
	@Autowired
	private LuceneService service;
	
	@Autowired
	private RealPathResolver realPathResolver;
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "lucene_page";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		int pageNo = TplUtils.getPageNo(env);
		int count = TplUtils.getCount(params);
		String query = getQuery(params);
		Date startDate = getStartDate(params);
		Date endDate = getEndDate(params);
		Pagination page;
		try {
			String path = realPathResolver.get(Constants.LUCENE_PATH);
			page = service.searchPage(path, query,startDate, endDate, pageNo, count);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

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

}
