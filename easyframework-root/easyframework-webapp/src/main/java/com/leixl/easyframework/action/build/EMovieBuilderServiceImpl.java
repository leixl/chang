package com.leixl.easyframework.action.build;

import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPLDIR_INDEX;
import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPL_BASE;
import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPL_BASE_DIR;
import static org.easyframework.core.pager.SimplePage.DEF_COUNT;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.common.DateFormatUtils;
import com.leixl.easyframework.doc.dao.EMovieDao;
import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.web.TplUtils;
import com.leixl.easyframework.web.URLHelper.PageInfo;

import freemarker.template.TemplateException;

@Service
public class EMovieBuilderServiceImpl extends AbstractBuilder implements EMovieBuilderService {
	private Logger log = LoggerFactory.getLogger(EMovieBuilderServiceImpl.class);

	@Autowired
	private EMovieDao dao;
	
	@Transactional(readOnly = true)
	public void index() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR+"/"+LOCATION, TPLDIR_INDEX,
				TPL_INDEX);
		build(tpl,getIndexPath(TPLDIR_INDEX), data);
	}
	
	@Transactional(readOnly = true)
	public void pager() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR+"/"+LOCATION, null,
				TPL_MOVIE_LIST);
		
		List<EMovie> movies = dao.getList();
		PageInfo info;
		int pageSize = DEF_COUNT;
		int totalPage = movies.size() / pageSize + 1;
		for(int i = 1 ; i <= totalPage ; i ++){
//			info = URLHelper.getPageInfo(getListPath(i).substring(getListPath(i)
//					.lastIndexOf("/")), null);
			TplUtils.frontPageData(i,  data);//将pageNo放入环境标量中。
			build(tpl, getPagerPath(i),data);
		}
	}
	
	@Transactional(readOnly = true)
	public void detail() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR+"/"+LOCATION, null,
				TPL_MOVIE_DETAIL);
		List<EMovie> movies = dao.getList();
		if(movies != null && movies.size() >0){
			for(EMovie bean : movies){
				TplUtils.frontData(data, LOCATION, null);
				data.put("movie", bean);//将每个影片实体放入缓存中
				build(tpl, getDetailPath(DateFormatUtils.format(bean.getCreateDate(),"yyyyMMdd"),bean.getId()),data);
			}
		}
		
	}
	
	@Transactional(readOnly = true)
	public void tag() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR+"/"+LOCATION, null,
				TPL_MOVIE_TAG);
		build(tpl, getTagPath("tag"),data);
	} 
	
	

	@Autowired
	private MessageSource tplMessageSource;
	

}
