package com.cxs.framework.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Description: IO工具类
 * @ClassName: IOUtils 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年5月13日 上午8:40:10 
 *
 */
public abstract class IOUtil {
	  
	private static final Logger logger = LoggerFactory.getLogger(IOUtil.class);
	
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    /**
     * 关闭IO
     * @param closeable 自动关闭
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
        	logger.error("关闭失败！", ioe);
        }
    }

    /**
     * InputStream转字符串，字符串默认UTF-8编码
     *
     * @param input 源<code>InputStream</code>
     * @return 转化成的字符串
     */
    public static String toString(InputStream input) throws IOException {
        return toString(input, Charsets.UTF_8);
    }

    /**
     * InputStream转字符串
     *
     * @param input 源<code>InputStream</code>
     * @param charset  转成字符串的编码<code>Charset</code>
     * @return 转化成的字符串
     */
    public static String toString(InputStream input, Charset charset) throws IOException {
        InputStreamReader in = new InputStreamReader(input, charset);
        StringBuffer out = new StringBuffer();
        char[] c = new char[DEFAULT_BUFFER_SIZE];
        for (int n; (n = in.read(c)) != -1;) {
            out.append(new String(c, 0, n));
        }
        IOUtil.closeQuietly(in);
        IOUtil.closeQuietly(input);
        return out.toString();
    }

    /**
     * InputStream转File
     * @param input  源<code>InputStream</code>
     * @param file 目标文件
     */
    public static void toFile(InputStream input, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        while ((bytesRead = input.read(buffer, 0, DEFAULT_BUFFER_SIZE)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        IOUtil.closeQuietly(os);
        IOUtil.closeQuietly(input);
    }
}
