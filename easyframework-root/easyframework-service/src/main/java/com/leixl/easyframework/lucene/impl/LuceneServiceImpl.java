package com.leixl.easyframework.lucene.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.doc.service.EMovieService;
import com.leixl.easyframework.lucene.LuceneContent;
import com.leixl.easyframework.lucene.LuceneEMovieDao;
import com.leixl.easyframework.lucene.LuceneService;

@Service
@Transactional
public class LuceneServiceImpl implements LuceneService {
	
	@Autowired
	private LuceneEMovieDao dao;
	
	@Autowired
	private EMovieService service;
	
	
	@Transactional(readOnly = true)
	public Integer createIndex(String realPath,
			Date startDate, Date endDate, Integer startId, Integer max)
			throws IOException, ParseException {
		Directory dir = new SimpleFSDirectory(new File(realPath));
		return createIndex(startDate, endDate, startId, max,
				dir);
	}

	@Transactional(readOnly = true)
	public Integer createIndex(Date startDate, Date endDate, Integer startId, Integer max,
			Directory dir) throws IOException, ParseException {
		boolean exist = IndexReader.indexExists(dir);
		IndexWriter writer = new IndexWriter(dir, new StandardAnalyzer(
				Version.LUCENE_30), !exist, IndexWriter.MaxFieldLength.LIMITED);
		try {
			if (exist) {
				LuceneContent.delete(startDate, endDate,
						writer);
			}
			Integer lastId = dao.index(writer,startDate, endDate, startId, max);
			writer.optimize();
			return lastId;
		} finally {
			writer.close();
		}
	}

	@Transactional(readOnly = true)
	public void createIndex(String realPath,EMovie bean) throws IOException {
		Directory dir = new SimpleFSDirectory(new File(realPath));
		createIndex(bean, dir);
	}

	@Transactional(readOnly = true)
	public void createIndex(EMovie bean, Directory dir) throws IOException {
		boolean exist = IndexReader.indexExists(dir);
		IndexWriter writer = new IndexWriter(dir, new StandardAnalyzer(
				Version.LUCENE_30), !exist, IndexWriter.MaxFieldLength.LIMITED);
		try {
			writer.addDocument(LuceneContent.createDocument(bean));
		} finally {
			writer.close();
		}
	}

	@Transactional(readOnly = true)
	public void deleteIndex(String realPath,Integer contentId) throws IOException,
			ParseException {
		Directory dir = new SimpleFSDirectory(new File(realPath));
		deleteIndex(contentId, dir);
	}

	@Transactional(readOnly = true)
	public void deleteIndex(Integer contentId, Directory dir)
			throws IOException, ParseException {
		boolean exist = IndexReader.indexExists(dir);
		if (exist) {
			IndexWriter writer = new IndexWriter(dir, new StandardAnalyzer(
					Version.LUCENE_30), false,
					IndexWriter.MaxFieldLength.LIMITED);
			try {
				LuceneContent.delete(contentId, writer);
			} finally {
				writer.close();
			}
		}
	}

	public void updateIndex(String realPath,EMovie bean) throws IOException, ParseException {
		Directory dir = new SimpleFSDirectory(new File(realPath));
		updateIndex(bean, dir);
	}

	public void updateIndex(EMovie bean, Directory dir) throws IOException,
			ParseException {
		boolean exist = IndexReader.indexExists(dir);
		IndexWriter writer = new IndexWriter(dir, new StandardAnalyzer(
				Version.LUCENE_30), !exist, IndexWriter.MaxFieldLength.LIMITED);
		try {
			if (exist) {
				LuceneContent.delete(bean.getId(), writer);
			}
			writer.addDocument(LuceneContent.createDocument(bean));
		} finally {
			writer.close();
		}
	}

	@Transactional(readOnly = true)
	public Pagination searchPage(String path, String queryString,Date startDate, Date endDate,
			int pageNo, int pageSize) throws CorruptIndexException,
			IOException, ParseException {
		Directory dir = new SimpleFSDirectory(new File(path));
		return searchPage(dir, queryString, startDate,
				endDate, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Pagination searchPage(Directory dir, String queryString,Date startDate, Date endDate,
			int pageNo, int pageSize) throws CorruptIndexException,
			IOException, ParseException {
		Searcher searcher = new IndexSearcher(dir);
		try {
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
			Query query = LuceneContent.createQuery(queryString,startDate, endDate, analyzer);
			TopDocs docs = searcher.search(query, pageNo * pageSize);
			Pagination p = LuceneContent.getResultPage(searcher, docs, pageNo,
					pageSize);
			List<?> ids = p.getList();
			List<EMovie> movies = new ArrayList<EMovie>(ids.size());
			for (Object id : ids) {
				movies.add(service.getById((Integer) id));
			}
			p.setList(movies);
			return p;
		} finally {
			searcher.close();
		}
	}

	@Transactional(readOnly = true)
	public List<EMovie> searchList(String path, String queryString, Date startDate, Date endDate,
			int first, int max) throws CorruptIndexException, IOException,
			ParseException {
		Directory dir = new SimpleFSDirectory(new File(path));
		return searchList(dir, queryString, startDate,
				endDate, first, max);
	}

	@Transactional(readOnly = true)
	public List<EMovie> searchList(Directory dir, String queryString,Date startDate, Date endDate,
			int first, int max) throws CorruptIndexException, IOException,
			ParseException {
		Searcher searcher = new IndexSearcher(dir);
		try {
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
			Query query = LuceneContent.createQuery(queryString,startDate, endDate, analyzer);
			if (first < 0) {
				first = 0;
			}
			if (max < 0) {
				max = 0;
			}
			TopDocs docs = searcher.search(query, first + max);
			List<Integer> ids = LuceneContent.getResultList(searcher, docs,
					first, max);
			List<EMovie> movies = new ArrayList<EMovie>(ids.size());
			for (Object id : ids) {
				movies.add(service.getById((Integer) id));
			}
			return movies;
		} finally {
			searcher.close();
		}
	}

	
}
