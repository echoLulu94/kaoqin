package com.cxs.extension.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @Description: 文件上传工具类
 * @ClassName: com.cxs.extension.core.utils.UploadUtil
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年6月6日
 */
public class UploadUtil {
	//private static final Logger logger = LogManager.getLogger(UploadUtil.class)
  private static final Logger logger = LoggerFactory.getLogger(UploadUtil.class);

	/**
	 * 保存上传文件
	 * @param file 上传的文件
	 * @param filePath 文件存放的路径
	 * @param fileName 文件名称
	 * @return 是否保存成功
	 */
	public static Boolean upload(MultipartFile file, String filePath,String fileName) {
		logger.info("filePath:"+filePath);
		Boolean flag = false;
		File imgFile = new File(filePath);
//		判断文件夹是否存在，不存在创建
		if (!imgFile.exists()) {
			logger.info("filePath:["+filePath+"]不存在，创建文件夹！");
			try {
				imgFile.mkdirs();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		// 转存文件
		try {
			File localFile = new File(filePath+fileName);
	        byte[] bytes = file.getBytes();
	        BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(localFile));
	        buffStream.write(bytes);
	        buffStream.close();
			flag=true;
		} catch (IllegalStateException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return flag;
	}
}

