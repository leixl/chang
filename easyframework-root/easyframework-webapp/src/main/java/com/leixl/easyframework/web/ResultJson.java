/**
 * Project: cms-common
 * 
 * File Created at 2012-10-31
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * 6677bank Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with 6677bank.com.
 */
package com.leixl.easyframework.web;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;


/**
 * TODO :  
 * @author leixl
 * @email  leixl0324@163.com
 * @date   2012-10-31 上午09:54:23
 * @version v1.0
 */
public abstract class ResultJson {
    
    /** 返回关键字-代码 */
    public static final String RETURN_CODE                     =   "code";
    
    /** 返回关键字-消息 */
    public static final String RETURN_MSG                      =   "msg";
    
    public static final String CMS_SUCCESS_CODE = "007"; //操作成功
    
    public static final String CMS_SUCCESS_MSG = "操作成功";
    
    public static final String CMS_ERROR_CODE = "009";  //操作失败
    
    public static final String CMS_ERROR_MSG = "操作失败";
    
    public static final String CMS_YZM_CODE = "5"; //验证码错误
    
    public static final String CMS_YZM_MSG = "验证码错误";
    
    public static final String CMS_YHM_CODE = "502"; //用户名输入错误
    
    public static final String CMS_YHM_MSG = "用户不存在";
    
    public static final String CMS_MM_CODE = "503";//密码输入错误
    
    public static final String CMS_MM_MSG = "密码输入错误";
    
    public static final String CMS_ACTIVE_CODE = "505";//密码输入错误
    
    public static final String CMS_ACTIVE_MSG = "用户未激活";
    
    public static final String CMS_YHM_EXIST_CODE = "504";//邮箱已存在
    
    public static final String CMS_YHM_EXIST_MSG = "邮箱已存在";
    
    public static final String CMS_YHM_NOT_EXIST_MSG = "邮箱可以使用";
    
    public static final String CMS_EMAIL_OK_SERVER_CODE = "0"; // 邮件服务器OK
    
    public static final String CMS_EMAIL_BAD_SERVER_CODE = "4"; // 邮件服务器没有设置好

    public static final String CMS_EMAIL_BAD_SERVER_MSG = "邮件服务器没有设置好";
    
    public static final String CMS_EMAIL_NO_TPL_CODE = "5"; // 邮件模板没有设置好
    
    public static final String CMS_EMAIL_NO_TPL_MSG = "邮件模板没有设置好";
    
    public static final String CMS_EMAIL_SEND_EXCEPTION_CODE = "100";// 发送邮件异常
    
    public static final String CMS_EMAIL_SEND_EXCEPTION_MSG = "发送邮件异常";
    /**
     * 添加返回代码-成功
     * @param result
     */
    public static JSONObject returnSuccess(){
        JSONObject resultJson = new JSONObject();
        try {
            resultJson.put(RETURN_CODE, CMS_SUCCESS_CODE);
            resultJson.put(RETURN_MSG, CMS_SUCCESS_MSG);         
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultJson;
    }
    
    /**
     * 添加返回代码-失败
     * @param result
     */
    public static JSONObject returnError(){
        JSONObject resultJson = new JSONObject();
        try {
            resultJson.put(RETURN_CODE, CMS_ERROR_CODE);
            resultJson.put(RETURN_MSG, CMS_ERROR_MSG);         
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultJson;
    }
    
    /**
     * 添加返回代码-失败
     * @param result
     */
    public static JSONObject returnError(String msg){
        JSONObject resultJson = new JSONObject();
        try {
            resultJson.put(RETURN_CODE, CMS_ERROR_CODE);
            resultJson.put(RETURN_MSG, msg);         
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultJson;
    }
}
