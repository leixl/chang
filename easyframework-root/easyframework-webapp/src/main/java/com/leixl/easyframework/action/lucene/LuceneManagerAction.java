/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月22日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.lucene;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.lucene.queryParser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.lucene.LuceneService;
import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.Constants;
import com.leixl.easyframework.web.ResponseUtils;
/**
 *  
 * @author leixl
 * @date   2014年1月22日 下午3:28:29
 * @version v1.0
 */
@Controller
public class LuceneManagerAction extends BaseAction{
	
	
	private static final Logger log = LoggerFactory
			.getLogger(LuceneManagerAction.class);
	
	@Autowired
	private LuceneService service;

	@RequestMapping(value = "/system/lucene/v_index.do")
	public String index(HttpServletRequest request, ModelMap model) {
		return "lucene/index";
	}

	@RequestMapping(value = "/system/lucene/o_create.do")
	public void create(Date startDate,
			Date endDate, Integer startId, Integer max,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws JSONException,IOException, ParseException{
		try {
			String realPath = request.getRealPath(Constants.LUCENE_PATH);
			Integer lastId = service.createIndex(realPath, startDate, endDate, startId, max);
			write(response,"success");
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			json.put("success", false);
			json.put("msg", e.getMessage());
			ResponseUtils.renderJson(response, json.toString());
			log.error("", e);
		} 
	}

}
