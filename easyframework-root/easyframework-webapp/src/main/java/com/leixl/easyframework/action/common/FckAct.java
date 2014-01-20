package com.leixl.easyframework.action.common;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.leixl.easyframework.web.image.ImageScale;
import com.leixl.easyframework.web.upload.Command;
import com.leixl.easyframework.web.upload.UploadResponse;
import com.leixl.easyframework.web.upload.UploadUtils;

/**
 * FCK服务器端接口
 * 
 * 为了更好、更灵活的处理fck上传，重新实现FCK服务器端接口。
 * 
 */
@Controller
public class FckAct implements ServletContextAware{

	private static final Logger log = LoggerFactory.getLogger(FckAct.class);
	
	public static final int CUT_FILE_WIDTH=580;
	public static final int CUT_FILE_HEIGHT=580;

	// TODO 浏览服务器文件未实现
	// @RequestMapping(value = "/fck/connector.do")
	// public String connector() {
	// return null;
	// }

	@RequestMapping(value = "/fck/upload.do", method = RequestMethod.POST)
	public void upload(
			@RequestParam(value = "Command", required = false) String commandStr,
			@RequestParam(value = "Type", required = false) String typeStr,
			@RequestParam(value = "CurrentFolder", required = false) String currentFolderStr,
			@RequestParam(value = "mark", required = false) Boolean mark,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.debug("Entering Dispatcher#doPost");
		responseInit(response);
		if (StringUtils.isEmpty(commandStr) && StringUtils.isEmpty(currentFolderStr)) {
			commandStr = "QuickUpload";
			currentFolderStr = "/";
			if (StringUtils.isEmpty(typeStr)) {
				typeStr = "File";
			}
		}
		if (currentFolderStr != null && !currentFolderStr.startsWith("/")) {
			currentFolderStr = "/".concat(currentFolderStr);
		}
		log.debug("Parameter Command: {}", commandStr);
		log.debug("Parameter Type: {}", typeStr);
		log.debug("Parameter CurrentFolder: {}", currentFolderStr);
		UploadResponse ur = validateUpload(request, commandStr, typeStr,
				currentFolderStr);
		if (ur == null) {
			ur = doUpload(request, typeStr, currentFolderStr);
		}
		PrintWriter out = response.getWriter();
		out.print(ur);
		out.flush();
		out.close();
	}

	private UploadResponse doUpload(HttpServletRequest request, String typeStr,
			String currentFolderStr) throws Exception {
		try {
		    int cutWidth = CUT_FILE_WIDTH;
		    int cutHeight = CUT_FILE_HEIGHT;
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// We upload just one file at the same time
			MultipartFile uplFile = multipartRequest.getFileMap().entrySet()
					.iterator().next().getValue();
			// Some browsers transfer the entire source path not just the
			// filename
			String filename = FilenameUtils.getName(uplFile
					.getOriginalFilename());
			log.debug("Parameter NewFile: {}", filename);
			String ext = FilenameUtils.getExtension(filename);
			
			String fileUrl;
			fileUrl = storeByExt("/u", ext, uplFile);
			// 加上部署路径
			fileUrl = request.getContextPath() + fileUrl;
			File cutFile = retrieve(fileUrl);
			
			BufferedImage bi = ImageIO.read(cutFile);
			System.out.println("Width=" + bi.getWidth());
			System.out.println("Height=" + bi.getHeight());
			//自动裁剪
			
			if(bi.getWidth() < cutWidth){
				cutWidth = bi.getWidth();
			}
			if(bi.getHeight() < cutHeight){
				cutHeight = bi.getHeight();
			}
			imageScale.resizeFix(cutFile, cutFile, cutWidth, cutHeight);
			
			return UploadResponse.getOK(request, fileUrl);
		} catch (IOException e) {
			return UploadResponse.getFileUploadWriteError(request);
		}
	}
	
	private UploadResponse validateUpload(HttpServletRequest request,
			String commandStr, String typeStr, String currentFolderStr) {
		// TODO 是否允许上传
		if (!Command.isValidForPost(commandStr)) {
			return UploadResponse.getInvalidCommandError(request);
		}
		
		if (!UploadUtils.isValidPath(currentFolderStr)) {
			return UploadResponse.getInvalidCurrentFolderError(request);
		}
		return null;
	}

	private void responseInit(HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
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
	
	private File retrieve(String name) {
		return new File(ctx.getRealPath(name));
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
	
	@Autowired
	private ImageScale imageScale;

}
