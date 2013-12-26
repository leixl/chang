package com.leixl.easyframework.action.build;

import static com.leixl.easyframework.web.Constants.TPL_BASE;
import static com.leixl.easyframework.common.Constants.UTF8;
import static com.leixl.easyframework.web.Constants.TPLDIR_INDEX;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.leixl.easyframework.common.Constants;
import com.leixl.easyframework.web.TplUtils;
import com.leixl.easyframework.web.springmvc.RealPathResolver;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EMoviePageBuilderServiceImpl implements EMoviePageBuilderService {
	private Logger log = LoggerFactory.getLogger(EMoviePageBuilderServiceImpl.class);

	/**
	 * 首页模板名称
	 */
	public static final String TPL_INDEX = "tpl.index";
	
	@Transactional(readOnly = true)
	public void index() throws IOException, TemplateException {
		Map<String, Object> data = new HashMap<String, Object>();
		TplUtils.frontData(data, "movie", null);
		String tpl = TplUtils.getTplPath(tplMessageSource, "zh_CN", TPL_BASE + "/www", TPLDIR_INDEX,
				TPL_INDEX);
		index(tpl, data);
	}

	@Transactional(readOnly = true)
	public void index(String tpl, Map<String, Object> data)
			throws IOException, TemplateException {
		long time = System.currentTimeMillis();
		File f = new File(getIndexPath());
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

	@Transactional(readOnly = true)
	public boolean deleteIndex() {
		File f = new File(getIndexPath());
		return f.delete();
	}

	private String getIndexPath() {
		StringBuilder pathBuff = new StringBuilder();
		pathBuff.append("/").append(Constants.INDEX).append(
				".html");
		return realPathResolver.get(pathBuff.toString());
	}

	@Autowired
	private MessageSource tplMessageSource;
	@Autowired
	private RealPathResolver realPathResolver;
	
	@Autowired
	private FreeMarkerConfigurer freemarkerConfig;

	private Configuration conf;

	@Autowired
	public void setFreeMarkerConfigurer() {
		this.conf = freemarkerConfig.getConfiguration();
	}

}
