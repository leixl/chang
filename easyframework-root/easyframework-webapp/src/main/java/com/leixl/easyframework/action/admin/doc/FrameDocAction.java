/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-12-15
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.admin.doc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author leixl
 * @date   2013-12-15 下午6:42:40
 * @version v1.0
 */
@Controller
public class FrameDocAction {

	@RequestMapping("/doc/main.do")
	public String docMain() {
		return "frame/doc_main";
	}
	
	@RequestMapping("/doc/left.do")
	public String docLeft() {
		return "frame/doc_left";
	}
	
	@RequestMapping("/doc/right.do")
	public String docRight() {
		return "frame/doc_right";
	}
}
