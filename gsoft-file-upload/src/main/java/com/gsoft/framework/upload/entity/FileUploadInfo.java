/**
 * 
 */
package com.gsoft.framework.upload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.gsoft.file.entity.FileStore;
import com.gsoft.framework.core.dataobj.Domain;

@Entity
@Table(name = "YOUI_UPLOAD_INFO")
public class FileUploadInfo implements Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8275829299008837305L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "UPLOAD_INFO_ID")
	@Length(max = 32)
	private String id;// UUID

	@Column(name = "UPLOAD_INFO_PATH")
	private String filePath;// 文件相对路径

	@Column(name = "UPLOAD_INFO_NAME")
	private String fileName;// 上传文件名称

	@Column(name = "FILE_SIZE")
	private String fileSize;
	
	@Column(name = "CREATE_TIME")
	private String createTime;// 时间戳

	@Column(name = "FILE_GROUP")
	private String fileGroup;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "UPLOAD_INFO_STATUS")
	private String status;// 文件使用状态

	public FileUploadInfo() {
	}
	
	public FileUploadInfo(FileStore fileStore) {
		this.fileName = fileStore.getFileName();
		this.filePath = fileStore.getFilePath();
		this.fileSize = fileStore.getFileSize();
		this.createTime = fileStore.getCreateTime();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFileGroup() {
		return fileGroup;
	}

	public void setFileGroup(String fileGroup) {
		this.fileGroup = fileGroup;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
