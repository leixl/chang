package com.leixl.easyframework.system.dao.impl;

import java.util.List;

import org.easyframework.core.hibernate3.Finder;
import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.system.dao.ERoleDao;
import com.leixl.easyframework.system.entity.ERole;


@Repository
public class ERoleDaoImpl extends HibernateBaseDao<ERole,Integer> implements ERoleDao{

	
	@SuppressWarnings("unchecked")
	public List<ERole> getList(){
		Finder f = Finder.create("select bean from ERole bean");
		return find(f);
	}
	
	
}
