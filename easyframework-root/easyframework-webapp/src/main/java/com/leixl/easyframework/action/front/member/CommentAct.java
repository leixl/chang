package com.leixl.easyframework.action.front.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.core.SessionProvider;
import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.doc.service.EMovieService;
import com.leixl.easyframework.member.CmsCommentService;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.web.RequestUtils;
import com.leixl.easyframework.web.ResponseUtils;
import com.leixl.easyframework.web.interceptor.CmsUtils;
import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
public class CommentAct {
	private static final Logger log = LoggerFactory.getLogger(CommentAct.class);

	public static final String COMMENT_PAGE = "tpl.commentPage";
	public static final String COMMENT_LIST = "tpl.commentList";

	@RequestMapping(value = "/comment_list.htm")
	public void list(Integer movieId, Integer greatTo,
			Integer recommend, Integer checked,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		JSONArray json = commentService.getListForTag(movieId,
				greatTo, true, false, true, 10);
		ResponseUtils.renderJson(response, json.toString());
	}

	@RequestMapping(value = "/comment.htm")
	public void ajaxCommet(Integer movieId, String content,
			HttpServletRequest request, HttpServletResponse response) throws JSONException {
		EUser user = CmsUtils.getUser(request);
		JSONObject json = new JSONObject();
		boolean checked = false;
		Long userId = null;
		if (user != null) {
			userId = user.getId();
		}
		commentService.comment(content, RequestUtils.getIpAddr(request),
				movieId,userId, checked, false);
		json.put("success", true);
		ResponseUtils.renderJson(response, json.toString());
	}

	@RequestMapping(value = "/comment_up.jspx")
	public void up(Integer movieId, HttpServletRequest request,
			HttpServletResponse response) {
		if (exist(movieId)) {
			commentService.ups(movieId);
			ResponseUtils.renderJson(response, "true");
		} else {
			ResponseUtils.renderJson(response, "false");
		}
	}

	@RequestMapping(value = "/comment_down.jspx")
	public void down(Integer movieId, HttpServletRequest request,
			HttpServletResponse response) {
		if (exist(movieId)) {
			commentService.downs(movieId);
			ResponseUtils.renderJson(response, "true");
		} else {
			ResponseUtils.renderJson(response, "false");
		}
	}

	private boolean exist(Integer id) {
		if (id == null) {
			return false;
		}
		EMovie movie = movieService.getById(id);
		return movie != null;
	}

	@Autowired
	private CmsCommentService commentService;
	@Autowired
	private EMovieService movieService;
	@Autowired
	private SessionProvider session;
	@Autowired
	private ImageCaptchaService imageCaptchaService;
}
