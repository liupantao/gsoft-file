package com.gsoft.file.service;

public interface FileSecurityManager {
	/**
	 * 加密token
	 * @param token
	 * @return
	 */
	public String encryptToken(String token);
	
	/**
	 * 解密token
	 * @param authorization
	 * @return
	 */
	public String decryptToken(String authorization);

	public String getSecurityKey();
	
}
