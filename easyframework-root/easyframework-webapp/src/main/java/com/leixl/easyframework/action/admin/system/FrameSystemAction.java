/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-11-30
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.admin.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author leixl
 * @date   2013-11-30 下午7:16:32
 * @version v1.0
 */
@Controller
public class FrameSystemAction {

	@RequestMapping("/system/main.do")
	public String systemMain() {
		return "frame/system_main";
	}
	
	@RequestMapping("/system/left.do")
	public String systemLeft() {
		return "frame/system_left";
	}
	
	@RequestMapping("/system/right.do")
	public String systemRight() {
		return "frame/system_right";
	}
	
}
