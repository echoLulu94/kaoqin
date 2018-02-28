package com.cxs.framework.utils;

import java.util.*;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
/* 
 * 利用HttpClient进行post请求的工具类 
 */  
public class HttpClientUtil {
	  
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
    public static String doPost(String url,Map<String,String> map){
    	return doPost(url, map, "UTF-8");
    }


    public static String doPost(String url,Map<String,String> map,String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Entry<String,String> elem = iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public static String doPost(String url,Map<String,String> map,Map<String,String> headMap,String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            if(null!=headMap&&!headMap.isEmpty()){
                for(Entry<String,String> entry : headMap.entrySet()){
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Entry<String,String> elem = iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 发送get请求
     * @param url       链接地址
     * @return
     */
    public static String doGet(String url){
        return doGet(url,null);
    }

    /**
     * 发送get请求
     * @param url       链接地址
     * @param charset   字符编码，若为null则默认utf-8
     * @return
     */
    public static String doGet(String url,String charset){
        if(null == charset){
            charset = "utf-8";
        }
        HttpClient httpClient = null;
        HttpGet httpGet= null;
        String result = null;

        try {
            httpClient = new SSLClient();
            httpGet = new HttpGet(url);

            Long startTime = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpGet);
            if(response != null){
                logger.info("接口:["+url+"]请求响应时间:["+((System.currentTimeMillis()-startTime)/1000)+"]秒");
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                    logger.info("["+url+"]接口返回报文长度：["+result.length()+"]");
                    logger.info("["+url+"]接口返回：["+result+"]");
                }
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args){
        Map<String,String> paramMap = new HashMap<>();
        Map<String,String> headMap = new HashMap<>();

//      注：用户名和密码之间用空格冒号分割
        String gbhApiUAP = "SHANGHAIFENG :IKONIC2017";

        headMap.put("Authorization","Basic "+Base64.getBase64(gbhApiUAP));
        System.out.println(HttpClientUtil.doPost("https://api.orderlink.it/v1/user/token",paramMap,headMap,"UTF-8"));

        String token ="3bb9ff645d600821c0e8651b00a490458f8f5b3d3def5032ab2cc6079ce2ea5a9cf045ede5f30bb4e2637a9b0ca75903da6bd3b3259c62fbb4a6d3a56364c89de2eb96be5193d638cdafce1f5f58a19fe2fb87a22c8ead2f2849e5e44ed2f705";
        String limit = "3";
        String page = "1";
        System.out.println(HttpClientUtil.doGet("https://api.orderlink.it/v1/products?access_token="+token+"&limit="+limit+"&page="+page));
    }
}  