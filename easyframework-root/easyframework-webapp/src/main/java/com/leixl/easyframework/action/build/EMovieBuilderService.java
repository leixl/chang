package com.leixl.easyframework.action.build;

import java.io.IOException;

import freemarker.template.TemplateException;

public interface EMovieBuilderService {
	

	public void index() throws IOException, TemplateException;
	
	public void pager() throws IOException, TemplateException;
	
	public void detail() throws IOException, TemplateException;

	public void tag() throws IOException, TemplateException;
}
