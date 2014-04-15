package com.leixl.easyframework.member.dao;

import org.easyframework.core.hibernate3.Updater;
import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.member.entity.CmsCommentExt;

public interface CmsCommentExtDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsCommentExt getById(Integer id);

	public CmsCommentExt save(CmsCommentExt bean);

	public CmsCommentExt updateByUpdater(Updater<CmsCommentExt> updater);

	public int deleteByContentId(Integer contentId);

	public CmsCommentExt delete(CmsCommentExt bean);
}