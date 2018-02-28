package com.cxs.framework.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;



public class HttpUtils {

	private static final int TIMEOUT_IN_MILLIONS =600000;

    private final static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public interface CallBack{
        void onRequestComplete(String result);
    }
 

    /**
     * 异步的Get请求
     * 
     * @param urlStr
     * @param callBack
     */
    public static void doGetAsyn(final String urlStr, final CallBack callBack) {
        new Thread()  {
            public void run() {
                try {
                    String result = doGet(urlStr);
                    if (callBack != null) {
                        callBack.onRequestComplete(result);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
 
            };
        }.start();
    }
  
    /**
     * 异步的Post请求
     * @param urlStr
     * @param params
     * @param callBack
     * @throws Exception
     */
    public static void doPostAsyn(final String urlStr, final String params,final CallBack callBack) throws Exception {
        new Thread() {
            public void run() {
                try {
                    String result = doPost(urlStr, params);
                    if (callBack != null){
                        callBack.onRequestComplete(result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
 
            };
        }.start();
 
    }

 
    /**
     * Get请求，获得返回数据
     * 
     * @param urlStr
     * @return
     * @throws Exception
     */
    public static String doGet(String urlStr) {
        URL url = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            if (conn.getResponseCode() == 200){
                is = conn.getInputStream();
                baos = new ByteArrayOutputStream();
                int len = -1;
                byte[] buf = new byte[128];
 
                while ((len = is.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                baos.flush();
                logger.info("HttpUtils doGet 接口响应《"+baos.toString()+"》");
                return baos.toString();
            } else {
                throw new RuntimeException(" responseCode is not 200 ... ");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        } finally {
            try
            {
                if (is != null)
                    is.close();
            } catch (IOException e)
            {
            }
            try
            {
                if (baos != null)
                    baos.close();
            } catch (IOException e)
            {
            }
            conn.disconnect();
        }
         
        return null ;
 
    }
 
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url 发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     * @throws Exception
     */
    private static String doPost(String url, String param) 
    {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
 
            if (param != null && !param.trim().equals("")) {
                // 获取URLConnection对象对应的输出流
                out = new PrintWriter(conn.getOutputStream());
                // 发送请求参数
                out.print(param);
                // flush输出流的缓冲
                out.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        // 使用finally块来关闭输出流、输入流
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
   
    

	/**
	 * Build queryString of the url  
	 * 用于get请求
	 */
    private static String pingGet(String url, Map<String, String> queryParas) {
		if (queryParas == null || queryParas.isEmpty())
			return url;
		StringBuilder sb = new StringBuilder(url);
		boolean isFirst;
		if (url.indexOf("?") == -1) {
			isFirst = true;
			sb.append("?");
		} else {
			isFirst = false;
		}
		for (Entry<String, String> entry : queryParas.entrySet()) {
			if (isFirst)
				isFirst = false;
			else
				sb.append("&");

			String key = entry.getKey();
			String value = entry.getValue();
			if (value != null && value != "")
				try {
					value = URLEncoder.encode(value, "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			sb.append(key).append("=").append(value);
		}
		return sb.toString();
	}
	
	public static String pingPost(Map<String, String> queryParas) {
		if(queryParas ==null ){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		String str="";
		for (Entry<String, String> entry : queryParas.entrySet()) {
			sb.append("&");
			String key = entry.getKey();
			String value = entry.getValue();
			if (value != null && value != "")
				try {
					value = URLEncoder.encode(value, "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			sb.append(key).append("=").append(value);
			str=sb.toString().substring(1);
		}
		return str;
	}
	
	public static String get(String url,Map<String,String> map){
		return doGet(pingGet(url,map));
	}
    
    /*public static String post(String url,Map<String,String> map){
    	return doPost(url,HttpUtils.pingPost(map));
    }*/
	
	public static String post(String url,Map<String,String> map){
    	return AESUtil.decrypt(doPost(url,HttpUtils.pingPost(map)));
    }
    
    public static String decryptPost(String url,Map<String,String> map){
    	return AESUtil.decrypt(doPost(url,HttpUtils.pingPost(map)));
    }
    
    public static void main(String[] args) {
//    	System.out.println(HttpUtils.doGet("http://localhost:8090/webapi/query/querylistD07R?fundcode=1111"));
//    	System.out.println(HttpUtils.doPost("http://localhost:8090/webapi/query/querylistD07R","fundcode=1111&startdate=20150101"));
//    	Map<String,String> map=new HashMap<String,String>();
//    	map.put("uid", "1000000016");
//    	map.put("id", "10114");
//    	System.out.println(HttpUtils.doGet(pingGet("https://api.qixun.tv/v1/live/detail",map)));
//    	System.out.println(HttpUtils.doPost("http://localhost:8090/webapi/query/querylistD07R",HttpUtils.pingPost(map)));
        String json = HttpUtils.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxce35c15ef8875327&secret=58c7d7e18091f1457ebd46231ad9046e");
        System.out.println(json);
    }
}
