package com.gsoft.file.util;

import java.io.File;
import java.util.UUID;

import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.FileUtils;

public class FilePathUtils {

	public static File getDatePath(File path) {
		File subpath = new File(path,DateUtils.getToday("yyyyMMdd"));
		if (!subpath.exists()) {
			subpath.mkdirs();
		}
		return subpath;
	}

	public static String getRandomFileName(String fileName) {
		String extension = FileUtils.getFileExtension(fileName);
		String uuid = UUID.randomUUID().toString();
		return uuid + extension;
	}
	
	public static void main(String[] args) {
	}
}
