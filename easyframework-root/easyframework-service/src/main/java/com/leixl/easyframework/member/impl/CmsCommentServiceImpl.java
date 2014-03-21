package com.leixl.easyframework.member.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.doc.service.EMovieService;
import com.leixl.easyframework.member.CmsCommentExtService;
import com.leixl.easyframework.member.CmsCommentService;
import com.leixl.easyframework.member.dao.CmsCommentDao;
import com.leixl.easyframework.member.entity.CmsComment;
import com.leixl.easyframework.member.entity.CmsCommentExt;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.system.service.EUserService;

@Service
@Transactional
public class CmsCommentServiceImpl implements CmsCommentService {
	@Transactional(readOnly = true)
	public Pagination getPage(Integer movieId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int pageNo, int pageSize) {
		Pagination page = dao.getPage(movieId, greaterThen, checked,
				recommend, desc, pageNo, pageSize, false);
		return page;
	}

	@Transactional(readOnly = true)
	public Pagination getPageForTag(Integer movieId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int pageNo, int pageSize) {
		Pagination page = dao.getPage(movieId, greaterThen, checked,
				recommend, desc, pageNo, pageSize, true);
		return page;
	}
	public Pagination getPageForMember(Integer movieId,Integer toUserId,Integer fromUserId,
			Integer greaterThen, Boolean checked, Boolean recommend,
			boolean desc, int pageNo, int pageSize){
		Pagination page = dao.getPageForMember(movieId,toUserId,fromUserId, greaterThen, checked,
				recommend, desc, pageNo, pageSize, false);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<CmsComment> getListForDel(Integer userId,Integer commentUserId,String ip){
		return dao.getListForDel(userId,commentUserId,ip);
	}

	@Transactional(readOnly = true)
	public JSONArray getListForTag(Integer movieId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int count) {
		JSONArray result = new JSONArray();
		List<CmsComment> list =  dao.getList( movieId, greaterThen, checked, recommend,
				desc, count, true);
		if(list != null && list.size() > 0){
			JSONObject obj = null;
			for(CmsComment bean : list){
				obj = new JSONObject();
				EUser user = bean.getCommentUser();
				obj.put("username", user.getUsername());
				obj.put("commId", bean.getId());
				obj.put("content", bean.getCommentExt().getText());
				obj.put("commTime", bean.getCreateTime());
				result.add(obj);
			}
		}
		 return result;
	}

	@Transactional(readOnly = true)
	public CmsComment findById(Integer id) {
		CmsComment entity = dao.findById(id);
		return entity;
	}

	public CmsComment comment(String text, String ip, Integer movieId,
			Long userId, boolean checked, boolean recommend) {
		CmsComment comment = new CmsComment();
		comment.setMovie(movieService.getById(movieId));
		if (userId != null) {
			comment.setCommentUser(userService.findById(userId));
		}
		comment.setChecked(checked);
		comment.setRecommend(recommend);
		comment.init();
		dao.save(comment);
		cmsCommentExtMng.save(ip, text, comment);
		return comment;
	}
	
	
	

	public CmsComment update(CmsComment bean, CmsCommentExt ext) {
		Updater<CmsComment> updater = new Updater<CmsComment>(bean);
		bean = dao.updateByUpdater(updater);
		cmsCommentExtMng.update(ext);
		return bean;
	}

	public int deleteByContentId(Integer contentId) {
		cmsCommentExtMng.deleteByContentId(contentId);
		return dao.deleteByContentId(contentId);
	}

	public CmsComment deleteById(Integer id) {
		CmsComment bean = dao.deleteById(id);
		return bean;
	}

	public CmsComment[] deleteByIds(Integer[] ids) {
		CmsComment[] beans = new CmsComment[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	public void ups(Integer id) {
		CmsComment comment = findById(id);
		comment.setUps((short) (comment.getUps() + 1));
	}

	public void downs(Integer id) {
		CmsComment comment = findById(id);
		comment.setDowns((short) (comment.getDowns() + 1));
	}

	@Autowired
	private EUserService userService;
	@Autowired
	private EMovieService movieService;
	@Autowired
	private CmsCommentExtService cmsCommentExtMng;
	@Autowired
	private CmsCommentDao dao;
	

}