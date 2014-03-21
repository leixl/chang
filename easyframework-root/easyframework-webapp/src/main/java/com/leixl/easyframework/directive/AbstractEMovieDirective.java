package com.leixl.easyframework.directive;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.leixl.easyframework.doc.entity.EMovieTag;
import com.leixl.easyframework.doc.service.EMovieService;
import com.leixl.easyframework.doc.service.EMovieTagService;
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
	 * 输入参数，TAG NAME。允许多个TAG NAME，用","分开。
	 */
	public static final String PARAM_TAG_NAME = "tagName";
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

	
	protected Integer[] getTagIds(Map<String, TemplateModel> params)
			throws TemplateException {
		Integer[] ids = DirectiveUtils.getIntArray(PARAM_TAG_ID, params);
		if (ids != null && ids.length > 0) {
			return ids;
		} else {
			String nameStr = DirectiveUtils.getString(PARAM_TAG_NAME, params);
			if (StringUtils.isBlank(nameStr)) {
				return null;
			}
			String[] names = StringUtils.split(nameStr, ',');
			Set<Integer> set = new HashSet<Integer>();
			EMovieTag tag;
			for (String name : names) {
				tag = tagService.findByNameForTag(name);
				if (tag != null) {
					set.add(tag.getId());
				}
			}
			if (set.size() > 0) {
				return set.toArray(new Integer[set.size()]);
			} else {
				return null;
			}
		}
	}

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
		
		Integer[] tagIds = getTagIds(params);
		if (tagIds != null) {
				int pageNo = TplUtils.getPageNo(env);
				return service.getPageByTagIdsForTag(tagIds,recommend,
						orderBy, pageNo, count);
		}
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
	
	@Autowired
	private EMovieTagService tagService;
}
