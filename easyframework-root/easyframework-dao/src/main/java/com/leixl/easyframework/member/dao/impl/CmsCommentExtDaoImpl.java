package com.leixl.easyframework.member.dao.impl;

import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.easyframework.core.pager.Pagination;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.member.dao.CmsCommentExtDao;
import com.leixl.easyframework.member.entity.CmsCommentExt;

@Repository
public class CmsCommentExtDaoImpl extends
		HibernateBaseDao<CmsCommentExt, Integer> implements CmsCommentExtDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}


	public int deleteByContentId(Integer movieId) {
		String hql = "delete from CmsCommentExt bean where bean.id in"
				+ " (select c.id from CmsComment c where c.movie.id=:movieId)";
		return getSession().createQuery(hql).setParameter("movieId",
				movieId).executeUpdate();
	}


}