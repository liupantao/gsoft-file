package com.gsoft.file.service.impl;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.gsoft.file.service.FileSecurityManager;
import com.gsoft.framework.core.Constants;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.util.DESUtils;
import com.gsoft.framework.util.StringUtils;

/**
 * 
 * @author LiuPeng
 * 
 */
@SuppressWarnings("restriction")
@Service("fileSecurityManager")
public class FileSecurityManagerImpl implements FileSecurityManager, InitializingBean {

	@Value("${file.keystore.file:}")
	private Resource keyStoreFile;

	@Value("${file.keystore.name:}")
	private String keyStoreName;

	@Value("${file.keystore.password:}")
	private String keyStorePassword;

	private String securityKey;

	@Override
	public String decryptToken(String authorization) {
		try {
			return DESUtils.decrypt(authorization, securityKey);
		} catch (Exception e) {
			throw new BusException(Constants.ACCESS_DENIED_CODE, "验证失败", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gsoft.framework.esb.service.EsbSecurityManager#encryptSecurityInfo
	 * (com.gsoft.framework.core.dataobj.Record)
	 */
	@Override
	public String encryptToken(String token) {
		String authorization = DESUtils.encrypt(securityKey, token);
		return authorization;
	}

	/**
	 * 安全密钥
	 * 
	 * @return
	 */
	private String initSecurityKey() {
		if (StringUtils.isNotEmpty(keyStoreName) && StringUtils.isNotEmpty(keyStorePassword) && keyStoreFile == null && keyStoreFile.exists()) {
			try {
				KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
				ks.load(keyStoreFile.getInputStream(), keyStorePassword.toCharArray());
				Certificate cert = ks.getCertificate(keyStoreName);
				BASE64Encoder encoder = new BASE64Encoder();
				if (cert == null) {
					throw new BusException("密钥配置错误，keyStoreName[" + this.keyStoreName + "]不匹配。");
				}
				return encoder.encode(cert.getPublicKey().getEncoded());
			} catch (KeyStoreException e) {

			} catch (NoSuchAlgorithmException e) {

			} catch (CertificateException e) {

			} catch (IOException e) {

			}
		}
		return "gileFile_securityKey";// 默认值
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 初始化securityKey
		securityKey = this.initSecurityKey();
	}

	@Override
	public String getSecurityKey() {
		return securityKey;
	}
}
