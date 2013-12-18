/**
 * Project: easyframework-dao
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
package com.leixl.easyframework.system.entity;

import java.io.Serializable;

/**
 *  
 * @author leixl
 * @date   2013-11-30 下午4:22:52
 * @version v1.0
 */
public abstract class BaseEUser implements Serializable{

	
	
	
	// constructors
	public BaseEUser () {
		initialize();
	}
	
	protected void initialize () {}
	
	private int hashCode = Integer.MIN_VALUE;
	
	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String username;
	private java.lang.String email;
	private java.lang.String password;
	private java.util.Date registerTime;
	private java.lang.String registerIp;
	private java.util.Date lastLoginTime;
	private java.lang.String lastLoginIp;
	private java.lang.Integer loginCount;
	private java.lang.Integer rank;
	private java.lang.Long uploadTotal;
	private java.lang.Integer uploadSize;
	private java.sql.Date uploadDate;
	private java.lang.Boolean admin;
	private java.lang.Boolean viewonlyAdmin;
	private java.lang.Boolean selfAdmin;
	private java.lang.Boolean disabled;
	private java.lang.String resetKey;
	private java.lang.String resetPwd;
	private java.util.Date errorTime;
	private java.lang.Integer errorCount;
	private java.lang.String errorIp;
	private java.lang.Boolean activation;
	private java.lang.String activationCode;
	
	/**
	 * @return the id
	 */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public java.lang.String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public java.lang.String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	/**
	 * @return the registerTime
	 */
	public java.util.Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * @param registerTime the registerTime to set
	 */
	public void setRegisterTime(java.util.Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * @return the registerIp
	 */
	public java.lang.String getRegisterIp() {
		return registerIp;
	}

	/**
	 * @param registerIp the registerIp to set
	 */
	public void setRegisterIp(java.lang.String registerIp) {
		this.registerIp = registerIp;
	}

	/**
	 * @return the lastLoginTime
	 */
	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the lastLoginIp
	 */
	public java.lang.String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(java.lang.String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * @return the loginCount
	 */
	public java.lang.Integer getLoginCount() {
		return loginCount;
	}

	/**
	 * @param loginCount the loginCount to set
	 */
	public void setLoginCount(java.lang.Integer loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * @return the rank
	 */
	public java.lang.Integer getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(java.lang.Integer rank) {
		this.rank = rank;
	}

	/**
	 * @return the uploadTotal
	 */
	public java.lang.Long getUploadTotal() {
		return uploadTotal;
	}

	/**
	 * @param uploadTotal the uploadTotal to set
	 */
	public void setUploadTotal(java.lang.Long uploadTotal) {
		this.uploadTotal = uploadTotal;
	}

	/**
	 * @return the uploadSize
	 */
	public java.lang.Integer getUploadSize() {
		return uploadSize;
	}

	/**
	 * @param uploadSize the uploadSize to set
	 */
	public void setUploadSize(java.lang.Integer uploadSize) {
		this.uploadSize = uploadSize;
	}

	/**
	 * @return the uploadDate
	 */
	public java.sql.Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(java.sql.Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @return the admin
	 */
	public java.lang.Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(java.lang.Boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the viewonlyAdmin
	 */
	public java.lang.Boolean getViewonlyAdmin() {
		return viewonlyAdmin;
	}

	/**
	 * @param viewonlyAdmin the viewonlyAdmin to set
	 */
	public void setViewonlyAdmin(java.lang.Boolean viewonlyAdmin) {
		this.viewonlyAdmin = viewonlyAdmin;
	}

	/**
	 * @return the selfAdmin
	 */
	public java.lang.Boolean getSelfAdmin() {
		return selfAdmin;
	}

	/**
	 * @param selfAdmin the selfAdmin to set
	 */
	public void setSelfAdmin(java.lang.Boolean selfAdmin) {
		this.selfAdmin = selfAdmin;
	}

	/**
	 * @return the disabled
	 */
	public java.lang.Boolean getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(java.lang.Boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the resetKey
	 */
	public java.lang.String getResetKey() {
		return resetKey;
	}

	/**
	 * @param resetKey the resetKey to set
	 */
	public void setResetKey(java.lang.String resetKey) {
		this.resetKey = resetKey;
	}

	/**
	 * @return the resetPwd
	 */
	public java.lang.String getResetPwd() {
		return resetPwd;
	}

	/**
	 * @param resetPwd the resetPwd to set
	 */
	public void setResetPwd(java.lang.String resetPwd) {
		this.resetPwd = resetPwd;
	}

	/**
	 * @return the errorTime
	 */
	public java.util.Date getErrorTime() {
		return errorTime;
	}

	/**
	 * @param errorTime the errorTime to set
	 */
	public void setErrorTime(java.util.Date errorTime) {
		this.errorTime = errorTime;
	}

	/**
	 * @return the errorCount
	 */
	public java.lang.Integer getErrorCount() {
		return errorCount;
	}

	/**
	 * @param errorCount the errorCount to set
	 */
	public void setErrorCount(java.lang.Integer errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * @return the errorIp
	 */
	public java.lang.String getErrorIp() {
		return errorIp;
	}

	/**
	 * @param errorIp the errorIp to set
	 */
	public void setErrorIp(java.lang.String errorIp) {
		this.errorIp = errorIp;
	}

	/**
	 * @return the activation
	 */
	public java.lang.Boolean getActivation() {
		return activation;
	}

	/**
	 * @param activation the activation to set
	 */
	public void setActivation(java.lang.Boolean activation) {
		this.activation = activation;
	}

	/**
	 * @return the activationCode
	 */
	public java.lang.String getActivationCode() {
		return activationCode;
	}

	/**
	 * @param activationCode the activationCode to set
	 */
	public void setActivationCode(java.lang.String activationCode) {
		this.activationCode = activationCode;
	}
	
	
	
}
