/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月17日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.tpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.web.BaseAction;

/**
 *  
 * @author leixl
 * @date   2014年1月17日 下午11:41:38
 * @version v1.0
 */
@Controller
public class EMovieTplAction extends BaseAction{

	@RequestMapping("/doc/movie/v_tpls.do")
	public String toTplList(ModelMap model){
		
		File file = new File("/WEB-INF/t/cms/www/chang/movie/");
		File[] child = file.listFiles();
		List list = null;
		if (child != null) {
			list = new ArrayList(child.length);
		} else {
			list = new ArrayList(0);
		}
		model.addAttribute("list", list);
		return "doc/movie/tpls";
	}
}
