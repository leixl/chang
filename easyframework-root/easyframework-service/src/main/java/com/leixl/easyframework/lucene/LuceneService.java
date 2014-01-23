package com.leixl.easyframework.lucene;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.store.Directory;
import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.doc.entity.EMovie;

public interface LuceneService {
	
	public Integer createIndex(String realPath,Date startDate, Date endDate, Integer startId, Integer max)
			throws IOException, ParseException;

	public Integer createIndex(Date startDate, Date endDate, Integer startId, Integer max,
			Directory dir) throws IOException, ParseException;

	public void createIndex(EMovie bean, Directory dir) throws IOException;

	public void createIndex(String realPath,EMovie bean) throws IOException;

	public void deleteIndex(String realPath,Integer contentId) throws IOException,
			ParseException;

	public void deleteIndex(Integer contentId, Directory dir)
			throws IOException, ParseException;

	public void updateIndex(String realPath,EMovie bean) throws IOException, ParseException;

	public void updateIndex(EMovie bean, Directory dir) throws IOException,
			ParseException;

	public Pagination searchPage(String path, String queryString,Date startDate, Date endDate,
			int pageNo, int pageSize) throws CorruptIndexException,
			IOException, ParseException;

	public Pagination searchPage(Directory dir, String queryString, Date startDate, Date endDate,
			int pageNo, int pageSize) throws CorruptIndexException,
			IOException, ParseException;

	public List<EMovie> searchList(String path, String queryString, Date startDate, Date endDate,
			int pageNo, int pageSize) throws CorruptIndexException,
			IOException, ParseException;

	public List<EMovie> searchList(Directory dir, String queryString,Date startDate, Date endDate,
			int first, int max) throws CorruptIndexException, IOException,
			ParseException;

}
