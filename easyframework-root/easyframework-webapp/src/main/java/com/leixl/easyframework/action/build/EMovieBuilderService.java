package com.leixl.easyframework.action.build;

import java.io.IOException;
import java.util.Map;

import freemarker.template.TemplateException;

public interface EMovieBuilderService {
	

	public void index() throws IOException, TemplateException;

	public void index(String tpl, Map<String, Object> data)
			throws IOException, TemplateException;

}
