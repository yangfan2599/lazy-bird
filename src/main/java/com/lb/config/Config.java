package com.lb.config;

import java.util.HashMap;
import java.util.Map;

import com.lb.tool.Tools;

public class Config {

	private static String SUBMIT_FORM_NAME = "upfile";
	private static String UPLOAD_ACTION_NAME = "upload";
	private static String SAVE_FILE_PATH = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
	
	/**
	 * ActionName上传的action名称 
	 * FieldName提交的表单名称
	 * MaxSize上传大小限制，单位B
	 * AllowFiles上传格式显示
	 * CompressEnable是否压缩,默认是true
	 * CompressBorder图片压缩最长边限制
	 * InsertAlign插入的图片浮动方式
	 * UrlPrefix图片访问路径前缀 
	 * PathFormat上传保存路径,可以自定义保存路径和文件名格式
	 */
	public static String initConfig(){
		Map<String,Object> CONFIG_DATA = new HashMap<String,Object>();
		/* --------------上传图片配置项---------------- */
		CONFIG_DATA.put("imageActionName", UPLOAD_ACTION_NAME);
		CONFIG_DATA.put("imageFieldName", SUBMIT_FORM_NAME);
		CONFIG_DATA.put("imageMaxSize", 2*1024*1000);
		CONFIG_DATA.put("imageAllowFiles", getAllowImages());
		CONFIG_DATA.put("imageCompressEnable", true);
		CONFIG_DATA.put("imageCompressBorder", 1600);
		CONFIG_DATA.put("imageInsertAlign", "none");
		CONFIG_DATA.put("imageUrlPrefix", "");
		CONFIG_DATA.put("imagePathFormat", SAVE_FILE_PATH);
		/* --------------涂鸦图片上传配置项---------------- */
		CONFIG_DATA.put("scrawlActionName", "uploadscrawl");
		CONFIG_DATA.put("scrawlFieldName", SUBMIT_FORM_NAME);
		CONFIG_DATA.put("scrawlPathFormat", SAVE_FILE_PATH);
		CONFIG_DATA.put("scrawlMaxSize", 2*1024*1000);
		CONFIG_DATA.put("scrawlUrlPrefix", "");
		CONFIG_DATA.put("scrawlInsertAlign", "none");
		/*-------------- 截图工具上传 ---------------- */
		CONFIG_DATA.put("snapscreenActionName", UPLOAD_ACTION_NAME);
		CONFIG_DATA.put("snapscreenPathFormat", SAVE_FILE_PATH);
		CONFIG_DATA.put("snapscreenUrlPrefix", "");
		CONFIG_DATA.put("snapscreenInsertAlign", "none");
		/*-------------- 抓取远程图片配置 ----------------*/
		CONFIG_DATA.put("catcherLocalDomain", getServers());
		CONFIG_DATA.put("catcherActionName", "catchimage");
		CONFIG_DATA.put("catcherFieldName", "source");
		CONFIG_DATA.put("catcherPathFormat", SAVE_FILE_PATH);
		CONFIG_DATA.put("catcherUrlPrefix", "");
		CONFIG_DATA.put("catcherMaxSize", 2*1024*1000);
		CONFIG_DATA.put("catcherAllowFiles", getAllowImages());
		/*-------------- 上传视频配置 ----------------*/
		CONFIG_DATA.put("videoActionName", "uploadvideo");
		CONFIG_DATA.put("videoFieldName", SUBMIT_FORM_NAME);
		CONFIG_DATA.put("videoPathFormat", "/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}");
		CONFIG_DATA.put("videoUrlPrefix", "");
		CONFIG_DATA.put("videoMaxSize", 100*1024*1000);
		CONFIG_DATA.put("videoAllowFiles", getAllowVedios());
		/*-------------- 上传文件配置 ----------------*/
		CONFIG_DATA.put("fileActionName", UPLOAD_ACTION_NAME);
		CONFIG_DATA.put("fileFieldName", SUBMIT_FORM_NAME);
		CONFIG_DATA.put("filePathFormat", "/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}");
		CONFIG_DATA.put("fileUrlPrefix", "");
		CONFIG_DATA.put("fileMaxSize", 50*1024*1000);
		CONFIG_DATA.put("fileAllowFiles", getAllowFiles());
		/*-------------- 列出指定目录下的图片 ----------------*/
		CONFIG_DATA.put("imageManagerActionName", "listimage");
		CONFIG_DATA.put("imageManagerListPath", "/ueditor/jsp/upload/image/");
		CONFIG_DATA.put("imageManagerListSize", 20);
		CONFIG_DATA.put("imageManagerUrlPrefix", "");
		CONFIG_DATA.put("imageManagerInsertAlign", "none");
		CONFIG_DATA.put("imageManagerAllowFiles", getAllowImages());
		/*-------------- 列出指定目录下的文件 ----------------*/
		CONFIG_DATA.put("fileManagerActionName", "listfile");
		CONFIG_DATA.put("fileManagerListPath", "/ueditor/jsp/upload/file/");
		CONFIG_DATA.put("fileManagerUrlPrefix", "");
		CONFIG_DATA.put("fileManagerListSize", "20");
		CONFIG_DATA.put("fileManagerAllowFiles", getAllowFiles());
		return Tools.writeAsString(CONFIG_DATA);
	}
	
	private static String[] getAllowImages(){
		String [] arr = {".png", ".jpg", ".jpeg", ".gif", ".bmp"};
		return arr;
	}
	
	private static String[] getServers(){
		String [] arr = {"127.0.0.1", "localhost", "img.baidu.com"};
		return arr;
	}
	
	private static String[] getAllowVedios(){
		String [] arr = {".flv", ".swf", ".mkv", ".avi", 
				         ".rm", ".rmvb", ".mpeg", ".mpg",
		                 ".ogg", ".ogv", ".mov", ".wmv", 
		                 ".mp4", ".webm", ".mp3", ".wav",
		                 ".mid"};
		return arr;
	}
	
	private static String[] getAllowFiles(){
		String [] arr = {".png", ".jpg", ".jpeg", ".gif", ".bmp",
		        ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
		        ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
		        ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
		        ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"};
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(initConfig());
	}
}
