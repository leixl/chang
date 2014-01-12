package com.leixl.easyframework.action.common;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.leixl.easyframework.web.upload.UploadUtils;


@Controller
public class ImageUploadAct implements ServletContextAware{
	private static final Logger log = LoggerFactory
			.getLogger(ImageUploadAct.class);
	/**
	 * 结果页
	 */
	private static final String RESULT_PAGE = "/common/iframe_upload";
	/**
	 * 错误信息参数
	 */
	public static final String ERROR = "error";

	@RequestMapping("/common/o_upload_image.do")
	public String execute(
			String filename,
			Integer uploadNum,
			@RequestParam(value = "uploadFile", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) {
		String origName = file.getOriginalFilename();
		String ext = FilenameUtils.getExtension(origName).toLowerCase(
				Locale.ENGLISH);
		try{
			String fileUrl;
			String ctx = request.getContextPath();
			if (!StringUtils.isBlank(filename)) {
				filename = filename.substring(ctx.length());
				fileUrl = storeByFilename(filename, file);
			} else {
				fileUrl = storeByExt("/u", ext, file);
				// 加上部署路径
				fileUrl = ctx + fileUrl;
			}
			model.addAttribute("uploadPath", fileUrl);
			model.addAttribute("uploadNum", uploadNum);
		}catch (Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			log.error("upload file error!", e);
		}
		
		return RESULT_PAGE;
	}
	
	private String storeByExt(String path, String ext, MultipartFile file)
			throws IOException {
		String filename = UploadUtils.generateFilename(path, ext);
		File dest = new File(getRealPath(filename));
		dest = UploadUtils.getUniqueFile(dest);
		store(file, dest);
		return filename;
	}
	
	private String storeByFilename(String filename, MultipartFile file)
			throws IOException {
		File dest = new File(getRealPath(filename));
		store(file, dest);
		return filename;
	}
	
	private void store(MultipartFile file, File dest) throws IOException {
		try {
			UploadUtils.checkDirAndCreate(dest.getParentFile());
			file.transferTo(dest);
		} catch (IOException e) {
			log.error("Transfer file error when upload file", e);
			throw e;
		}
	}

	private void store(File file, File dest) throws IOException {
		try {
			UploadUtils.checkDirAndCreate(dest.getParentFile());
			FileUtils.copyFile(file, dest);
		} catch (IOException e) {
			log.error("Transfer file error when upload file", e);
			throw e;
		}
	}
	
	private String getRealPath(String name){
		String realpath=ctx.getRealPath(name);
		if(realpath==null){
			realpath=ctx.getRealPath("/")+name;
		}
		return realpath;
	}

	private ServletContext ctx;

	public void setServletContext(ServletContext servletContext) {
		this.ctx = servletContext;
	}

	
}