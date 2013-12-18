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
package com.leixl.easyframework.action.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author leixl
 * @date   2013-11-30 下午7:16:32
 * @version v1.0
 */
@Controller
public class FrameMemberAction {

	@RequestMapping("/member/main.do")
	public String memberMain() {
		return "frame/member_main";
	}
	
	@RequestMapping("/member/left.do")
	public String memberLeft() {
		return "frame/member_left";
	}
	
	@RequestMapping("/member/right.do")
	public String memberRight() {
		return "frame/member_right";
	}
	
}
