/**
 * 代码声明
 */
package com.gsoft.framework.upload.dao;

import com.gsoft.framework.jpa.dao.JpaDao;
import com.gsoft.framework.upload.entity.FileUploadInfo;

public interface FileUploadInfoDao extends JpaDao<FileUploadInfo, String> {
	
}