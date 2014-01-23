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
package com.leixl.easyframework.lucene;

import java.io.IOException;
import java.util.Date;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;

/**
 *  
 * @author leixl
 * @date   2014年1月22日 下午2:32:46
 * @version v1.0
 */
public interface LuceneEMovieDao {

	public Integer index(IndexWriter writer, Date startDate, Date endDate, Integer startId, Integer max)
			throws CorruptIndexException, IOException;
}
