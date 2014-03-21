package com.leixl.easyframework.member;

import com.leixl.easyframework.member.entity.CmsComment;
import com.leixl.easyframework.member.entity.CmsCommentExt;

public interface CmsCommentExtService {
	public CmsCommentExt save(String ip, String text, CmsComment comment);

	public CmsCommentExt update(CmsCommentExt bean);

	public int deleteByContentId(Integer movieId);
}