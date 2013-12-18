/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-12-11
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.system.entity.EMenu;
import com.leixl.easyframework.system.service.EMenuService;
import com.leixl.easyframework.web.AbstractWebErrors;
import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.WebErrors;

/**
 *  
 * @author leixl
 * @date   2013-12-11 下午10:34:44
 * @version v1.0
 */
@Controller
public class EMenuAction extends BaseAction{

	@Autowired
	private EMenuService service;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/system/menu/v_list.do")
	public String list(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<EMenu> topList = service.getTopList();
		List<EMenu> menuList = EMenu.getListForSelect(topList);
		
		model.addAttribute("menuList", menuList);
		return "system/menu/list";
	}
	
	@RequestMapping(value = "/system/menu/v_add.do")
	public String add(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<EMenu> topList = service.getTopList();
		List<EMenu> menuList = EMenu.getListForSelect(topList);
		model.addAttribute("menuList", menuList);
		
		return "system/menu/add";
	}
	
	@RequestMapping(value = "/system/menu/o_save.do")
	public String save(EMenu bean , HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		service.save(bean);
		write(response,"success");
		return null;
	}
	
	@RequestMapping(value = "/system/menu/v_edit.do")
	public String edit(Integer id ,HttpServletRequest request,
	                   HttpServletResponse response, ModelMap model){
		WebErrors errors = validateEdit(id, request);
        if (errors.hasErrors()) {
        	write(response,"errorParam");
            return null;
        }
	    List<EMenu> topList = service.getTopList();
        List<EMenu> menuList = EMenu.getListForSelect(topList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("menu", service.getById(id));
	    return "system/menu/edit";
	}

	@RequestMapping(value = "/system/menu/o_update.do")
	public String update(EMenu bean,Integer parentId, HttpServletRequest request,
	                     HttpServletResponse response, ModelMap model){
	    WebErrors errors = validateUpdate(bean.getId(), request);
        if (errors.hasErrors()) {
        	write(response,"errorParam");
            return null;
        }
        service.update(bean,parentId);
        write(response,"success");
		return null;
	}
	
	 @RequestMapping("/system/menu/o_delete.do")
	    public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request,HttpServletResponse response, ModelMap model) {
	        WebErrors errors = validateDelete(ids, request);
	        if (errors.hasErrors()) {
	            return errors.showErrorPage(model);
	        }
	        EMenu[] beans = service.deleteByIds(ids);
	        return "redirect:v_list.do";
	}
	
	private WebErrors validateEdit(Integer id, HttpServletRequest request) {
        WebErrors errors = WebErrors.create(request);
        if (vldExist(id, errors)) {
            return errors;
        }
        return errors;
    }
	
	private WebErrors validateUpdate(Integer id, HttpServletRequest request) {
        WebErrors errors = WebErrors.create(request);
        if (vldExist(id, errors)) {
            return errors;
        }
        return errors;
    }
	
	 private WebErrors validateDelete(Integer[] ids, HttpServletRequest request) {
	        WebErrors errors = WebErrors.create(request);
	        errors.ifEmpty(ids, "ids");
	        for (Integer id : ids) {
	            vldExist(id, errors);
	        }
	        return errors;
	    }

	private boolean vldExist(Integer id, WebErrors errors) {
        if (errors.ifNull(id, "id")) {
            return true;
        }
        EMenu entity = service.getById(id);
        if (errors.ifNotExist(entity, EMenu.class, id)) {
            return true;
        }
        return false;
    }
}
