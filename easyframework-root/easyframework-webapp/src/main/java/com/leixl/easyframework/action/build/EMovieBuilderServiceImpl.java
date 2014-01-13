package com.leixl.easyframework.action.build;

import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPLDIR_INDEX;
import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPL_BASE;
import static com.leixl.easyframework.action.build.ConstantsOfBuilder.TPL_BASE_DIR;
import static com.leixl.easyframework.common.Constants.UTF8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.leixl.easyframework.doc.dao.EMovieDao;
import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.web.TplUtils;
import com.leixl.easyframework.web.URLHelper;
import com.leixl.easyframework.web.URLHelper.PageInfo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EMovieBuilderServiceImpl extends AbstractEMovieBuilder implements EMovieBuilderService {
	private Logger log = LoggerFactory.getLogger(EMovieBuilderServiceImpl.class);

	@Autowired
	private EMovieDao dao;
	
	@Transactional(readOnly = true)
	public void index() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR, TPLDIR_INDEX,
				TPL_INDEX);
		build(tpl,getIndexPath(TPLDIR_INDEX), data);
	}
	
	@Transactional(readOnly = true)
	public void list() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR, null,
				TPL_MOVIE_LIST);
		
		List<EMovie> movies = dao.getList();
		PageInfo info;
		int pageSize = 4;
		int totalPage = movies.size() / pageSize + 1;
		for(int i = 1 ; i <= totalPage ; i ++){
//			info = URLHelper.getPageInfo(getListPath(i).substring(getListPath(i)
//					.lastIndexOf("/")), null);
			TplUtils.frontPageData(i,  data);//将pageNo放入环境标量中。
			build(tpl, getListPath(i),data);
		}
	}
	
	@Transactional(readOnly = true)
	public void tag() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, LOCATION, null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + TPL_BASE_DIR, null,
				TPL_MOVIE_TAG);
		build(tpl, getTagPath("tag"),data);
	} 
	
	

	@Transactional(readOnly = true)
	public void build(String tpl,String filePath, Map<String, Object> data)
			throws IOException, TemplateException {
		long time = System.currentTimeMillis();
		File f = new File(filePath);
		File parent = f.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		Writer out = null;
		try {
			// FileWriter不能指定编码确实是个问题，只能用这个代替了。
			out = new OutputStreamWriter(new FileOutputStream(f), UTF8);
			Template template = conf.getTemplate(tpl);
			template.process(data, out);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		time = System.currentTimeMillis() - time;
		log.info("create index page, in {} ms", time);
	}



	@Autowired
	private MessageSource tplMessageSource;
	
	
	@Autowired
	private FreeMarkerConfigurer freemarkerConfig;

	private Configuration conf;

	@Autowired
	public void setFreeMarkerConfigurer() {
		this.conf = freemarkerConfig.getConfiguration();
	}

}
