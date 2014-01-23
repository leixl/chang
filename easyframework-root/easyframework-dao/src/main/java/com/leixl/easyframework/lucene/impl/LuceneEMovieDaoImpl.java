/**
 * Project: easyframework-dao
 * 
 * File Created at 2014年1月22日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.lucene.impl;

import java.io.IOException;
import java.util.Date;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.easyframework.core.hibernate3.Finder;
import org.easyframework.core.hibernate3.HibernateBaseDao;
import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.lucene.LuceneContent;
import com.leixl.easyframework.lucene.LuceneEMovieDao;

/**
 *  
 * @author leixl
 * @date   2014年1月22日 下午2:33:06
 * @version v1.0
 */
@Repository
public class LuceneEMovieDaoImpl extends HibernateBaseDao<EMovie, Integer> implements LuceneEMovieDao{

	public Integer index(IndexWriter writer, Date startDate, Date endDate, Integer startId, Integer max)
			throws CorruptIndexException, IOException {
		Finder f = Finder.create("select bean from EMovie bean");
		
		f.append(" where 1=1");
		if (startId != null) {
			f.append(" and bean.id > :startId");
			f.setParam("startId", startId);
		}
		if (startDate != null) {
			f.append(" and bean.createDate >= :startDate");
			f.setParam("startDate", startDate);
		}
		if (endDate != null) {
			f.append(" and bean.createDate <= :endDate");
			f.setParam("endDate", endDate);
		}
		f.append(" order by bean.id asc");
		if (max != null) {
			f.setMaxResults(max);
		}
		Session session = getSession();
		ScrollableResults movies = f.createQuery(getSession()).setCacheMode(
				CacheMode.IGNORE).scroll(ScrollMode.FORWARD_ONLY);
		int count = 0;
		EMovie movie = null;
		while (movies.next()) {
			movie = (EMovie) movies.get(0);
			writer.addDocument(LuceneContent.createDocument(movie));
			if (++count % 20 == 0) {
				session.clear();
			}
		}
		if (count < max || movie == null) {
			// 实际数量小于指定数量，代表生成结束。如果没有任何数据，也代表生成结束。
			return null;
		} else {
			// 返回最后一个ID
			return movie.getId();
		}

	}

	
	@Override
	protected Class<EMovie> getEntityClass() {
		return EMovie.class;
	}
}
