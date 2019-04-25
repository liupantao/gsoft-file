package com.gsoft.framework.upload.service;

import java.io.File;

import com.gsoft.file.entity.FileStore;
import com.gsoft.framework.upload.entity.FileUploadInfo;

/**
 * 
 * @author LiuPeng
 * 
 */
public interface FileUploadInfoWebManager {

	/**
	 * 存储上传信息
	 * 
	 * @param fileName
	 * @param in
	 * @return
	 */
	public FileUploadInfo saveFileUploadInfo(String channel, FileStore fileStore);

	/**
	 * 根据通道和id获取文件信息
	 * 
	 * @param channel
	 * @param id
	 * @return
	 */
	public FileUploadInfo getFileUploadInfo(String channel, String id);

	/**
	 * 根据路径下载文件
	 * 
	 * @param filePath
	 * @return
	 */
	public File getFileByPath(String filePath);

}
