package com.leixl.easyframework.member;

import java.util.List;

import net.sf.json.JSONArray;

import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.member.entity.CmsComment;
import com.leixl.easyframework.member.entity.CmsCommentExt;

public interface CmsCommentService {
	public Pagination getPage(Integer movieId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int pageNo, int pageSize);

	public Pagination getPageForTag(Integer movieId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int pageNo, int pageSize);
	
	/**
	 * 
	 * @param siteId
	 * @param contentId
	 * @param toUserId 写评论的用户
	 * @param fromUserId 投稿的信息接收到的相关评论
	 * @param greaterThen
	 * @param checked
	 * @param recommend
	 * @param desc
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPageForMember(Integer movieId,Integer toUserId,Integer fromUserId,
			Integer greaterThen, Boolean checked, Boolean recommend,
			boolean desc, int pageNo, int pageSize);
	/**
	 * 
	 * @param siteId
	 * @param userId 发表信息用户id
	 * @param commentUserId 评论用户id
	 * @param ip  评论来访ip
	 * @return
	 */
	public List<CmsComment> getListForDel(Integer userId,Integer commentUserId,String ip);

	public JSONArray getListForTag(Integer movieId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int count);

	public CmsComment findById(Integer id);

	public CmsComment comment(String text, String ip, Integer movieId,
			Long userId, boolean checked, boolean recommend);

	public CmsComment update(CmsComment bean, CmsCommentExt ext);

	public int deleteByContentId(Integer contentId);

	public CmsComment deleteById(Integer id);

	public CmsComment[] deleteByIds(Integer[] ids);

	public void ups(Integer id);

	public void downs(Integer id);
}