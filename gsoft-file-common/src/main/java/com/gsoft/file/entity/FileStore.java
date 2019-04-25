package com.gsoft.file.entity;

import com.gsoft.framework.core.dataobj.Domain;

/**
 * 
 * @author LiuPeng
 *
 */
public class FileStore implements Domain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6926111000135770841L;

	private String fileName;
	
	private String fileSize;
	
	private String filePath;
	
	private String createTime;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
