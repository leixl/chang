package com.leixl.easyframework.directive;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.leixl.easyframework.doc.service.EMovieService;
import com.leixl.easyframework.web.TplUtils;
import com.leixl.easyframework.web.freemarker.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 内容标签基类
 */
public abstract class AbstractEMovieDirective implements
		TemplateDirectiveModel {
	/**
	 * 输入参数，TAG ID。允许多个TAG ID，用","分开。和tagNames之间二选一，ID优先级更高。
	 */
	public static final String PARAM_TAG_ID = "tagId";
	/**
	 * 输入参数，类型ID。可选。允许多个类型ID,用","分开。
	 */
	public static final String PARAM_TYPE_ID = "typeId";
	/**
	 * 输入参数，推荐。0：所有；1：推荐；2：不推荐。默认所有。
	 */
	public static final String PARAM_RECOMMEND = "recommend";
	/**
	 * 输入参数，标题。可以为null。
	 */
	public static final String PARAM_TITLE = "title";
	/**
	 * 输入参数，排序方式。
	 */
	public static final String PARAM_ORDER_BY = "orderBy";

	


	protected Boolean getRecommend(Map<String, TemplateModel> params)
			throws TemplateException {
		String recommend = DirectiveUtils.getString(PARAM_RECOMMEND, params);
		if ("1".equals(recommend)) {
			return true;
		} else if ("2".equals(recommend)) {
			return false;
		} else {
			return null;
		}
	}

	protected String getTitle(Map<String, TemplateModel> params)
			throws TemplateException {
		return DirectiveUtils.getString(PARAM_TITLE, params);
	}

	protected int getOrderBy(Map<String, TemplateModel> params)
			throws TemplateException {
		Integer orderBy = DirectiveUtils.getInt(PARAM_ORDER_BY, params);
		if (orderBy == null) {
			return 0;
		} else {
			return orderBy;
		}
	}

	protected Object getData(Map<String, TemplateModel> params, Environment env)
			throws TemplateException {
		int orderBy = getOrderBy(params);
		Boolean recommend = getRecommend(params);
		int count = TplUtils.getCount(params);
		if(isPage()){
			int pageNo = TplUtils.getPageNo(env);
			System.out.println("当前页："+pageNo +"\t 每页显示条数：" + count);
			return service.getPageForTag(pageNo, count);
		}else{
			int first = TplUtils.getFirst(params);
			return service.getListForTag(recommend, orderBy, first, count);
		}
		
	}

	abstract protected boolean isPage();
	
	@Autowired
	private EMovieService service;
}
