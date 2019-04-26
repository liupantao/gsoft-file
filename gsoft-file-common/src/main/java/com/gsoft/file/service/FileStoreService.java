package com.gsoft.file.service;

import java.io.File;
import java.io.InputStream;

import com.gsoft.file.DownloadCallback;
import com.gsoft.file.entity.FileStore;

/**
 * 
 * @author LiuPeng
 * 
 */
public interface FileStoreService {

	/** 
	 * 存储文件
	 * @param file
	 * @return 
	 */
	public FileStore storeFile(File file);

	/** 
	 * 存储文件
	 * @param fileName
	 * @param in
	 * @return 
	 */
	public FileStore storeFile(String fileName, InputStream in);

	/** 
	 * 获取文件
	 * @param filePath
	 * @return 
	 */
	public File getFile(String filePath);
	
	/** 
	 * 获取文件
	 * @param filePath
	 * @param callback
	 * @return 
	 */
	public <T> T getFile(String filePath, DownloadCallback<T> callback);
	
	/** 
	 * 删除文件
	 * @param filePath 
	 */
	public void deleteFile(String filePath);

}