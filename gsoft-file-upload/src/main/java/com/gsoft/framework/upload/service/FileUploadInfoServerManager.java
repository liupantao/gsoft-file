/**
 * 
 */
package com.gsoft.framework.upload.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import com.gsoft.file.entity.FileStore;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.upload.entity.FileUploadInfo;

/**
 * 文件上传信息
 * 
 * @author LiuPeng
 * 
 */
public interface FileUploadInfoServerManager {

	/**
	 * 根据ID获取FileUploadInfo
	 * @param id
	 * @return
	 */
	public FileUploadInfo getFileUploadInfo(String id);
	/**
	 * 存储上传信息
	 * 
	 * @param fileName
	 * @param in
	 * @return
	 */
	public FileUploadInfo saveFileUploadInfo(FileStore fileStore,String userId);

	/**
	 * 更新FileUploadInfo
	 * 
	 * @param FileUploadInfo
	 */
	public FileUploadInfo updateFileUploadInfo(FileUploadInfo FileUploadInfo);

	/**
	 * 分页查询
	 * 
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 */
	public PagerRecords getPagerFileUploadInfo(Pager pager, Collection<Condition> conditions, Collection<Order> orders);

	/**
	 * 根据id获取文件
	 * 
	 * @param id
	 * @return
	 */
	public File getFile(String id);

	/**
	 * 根据路径获取文件
	 * @param filePath
	 * @return
	 */
	public File getFileByPath(String filePath);
	/**
	 * 存储上传信息并保存文件
	 * 
	 * @param fileName
	 * @param in
	 * @param group
	 * @return
	 */
	public FileUploadInfo storeFile(String fileName,String fileGroup,  InputStream in);

	/**
	 * 删除上传信息并删除文件
	 * 
	 * @param id
	 */
	public void removeFileUploadInfoAndFile(String id);

}
