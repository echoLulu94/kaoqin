package com.cxs.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(EnumUtil.class);

    // 计算文件的 MD5 值
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest =MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String [] args){
        for(int i=0;i<10;i++){
            Long startTime = System.currentTimeMillis();
            File file = new File("/Users/apple/myproject/document/crm/龙树资本组织架构编码的副本.txt");
            logger.info(getFileMD5(file));
            logger.info("耗时:"+(System.currentTimeMillis()-startTime)+"毫秒");
        }
    }
}
