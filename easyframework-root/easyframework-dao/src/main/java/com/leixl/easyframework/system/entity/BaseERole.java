package com.leixl.easyframework.system.entity;

import java.io.Serializable;

public abstract class BaseERole implements Serializable {

	// constructors
	public BaseERole() {
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private String roleName;
	private Integer priority;
	private Boolean supered;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Boolean getSupered() {
		return supered;
	}

	public void setSupered(Boolean supered) {
		this.supered = supered;
	}
	
	

}
