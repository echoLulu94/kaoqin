package com.cxs.framework.utils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @Description: http工具类
 * @ClassName: com.cxs.wechat.core.utils.HttpClient
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年6月2日
 */
public class HttpClient {

	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String CHARSET = "UTF-8";

	/**
	 * https 域名校验
	 */
	private class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	/**
	 * https 证书管理
	 */
	private class TrustAnyTrustManager implements X509TrustManager {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}
	}

	private static final SSLSocketFactory sslSocketFactory = initSSLSocketFactory();
	private static final TrustAnyHostnameVerifier trustAnyHostnameVerifier = new HttpClient().new TrustAnyHostnameVerifier();

	private static SSLSocketFactory initSSLSocketFactory() {
		try {
			TrustManager[] tm = { new HttpClient().new TrustAnyTrustManager() };
			SSLContext sslContext = SSLContext.getInstance("TLS", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			return sslContext.getSocketFactory();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static HttpURLConnection getHttpConnection(String url, String method, Map<String, String> headers) throws IOException, NoSuchAlgorithmException,
			NoSuchProviderException, KeyManagementException {
		URL _url = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
		if (conn instanceof HttpsURLConnection) {
			((HttpsURLConnection) conn).setSSLSocketFactory(sslSocketFactory);
			((HttpsURLConnection) conn).setHostnameVerifier(trustAnyHostnameVerifier);
		}

		conn.setRequestMethod(method);
		conn.setDoOutput(true);
		conn.setDoInput(true);

		conn.setConnectTimeout(600000);
		conn.setReadTimeout(600000);

		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36");

		if (headers != null && !headers.isEmpty())
			for (Entry<String, String> entry : headers.entrySet())
				conn.setRequestProperty(entry.getKey(), entry.getValue());

		return conn;
	}

	/**
	 * Send GET request
	 */
	public static String get(String url, Map<String, Object> queryParas, Map<String, String> headers) {
		HttpURLConnection conn = null;
		try {
			conn = getHttpConnection(buildUrlWithQueryString(url, queryParas), GET, headers);
			conn.connect();
			return readResponseString(conn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static String get(String url, Map<String, Object> queryParas) {
		return get(url, queryParas, null);
	}

	public static String get(String url) {
		return get(url, null, null);
	}

	/**
	 * Send POST request
	 */
	public static String post(String url, Map<String, Object> queryParas, String data, Map<String, String> headers) {
		HttpURLConnection conn = null;
		try {
			conn = getHttpConnection(buildUrlWithQueryString(url, queryParas), POST, headers);
			conn.connect();

			OutputStream out = conn.getOutputStream();
			if(StringUtil.isNotEmpty(data)){
				out.write(data.getBytes(CHARSET));
			}
			out.flush();
			out.close();

			return readResponseString(conn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static String post(String url, Map<String, Object> queryParas, String data) {
		return post(url, queryParas, data, null);
	}

	public static String post(String url, String data, Map<String, String> headers) {
		return post(url, null, data, headers);
	}

	public static String post(String url, String data) {
		return post(url, null, data, null);
	}

	private static String readResponseString(HttpURLConnection conn) {
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		try {
			inputStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, CHARSET));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Build queryString of the url
	 */
	private static String buildUrlWithQueryString(String url, Map<String, Object> queryParas) {
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

		for (Entry<String, Object> entry : queryParas.entrySet()) {
			if (isFirst)
				isFirst = false;
			else
				sb.append("&");

			String key = entry.getKey();
			String value = String.valueOf(entry.getValue());
			if (value != null && value != "")
				try {
					value = URLEncoder.encode(value, CHARSET);
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			sb.append(key).append("=").append(value);
		}
		return sb.toString();
	}
	
	/**
	 * 读取请求中的数据
	 * 
	 * request.getParameter()、 request.getInputStream()、
	 * request.getReader()这三种方法是有冲突的，因为流只能被读一次。
	 * 比如：
	 * 		当form表单内容采用 enctype=application/x-www-form-urlencoded编码时，
	 * 先通过调用request.getParameter() 方法得到参数后，再调用request.getInputStream()
	 * 或request.getReader()已经得不到流中的内容，因为在调用 request.getParameter()时，
	 * 系统可能对表单中提交的数据以流的形式读了一次,反之亦然。
	 * 当form表单内容采用enctype=multipart/form-data编码时，
	 * 即使先调用request.getParameter()也得不到数据，
	 * 所以这时调用request.getParameter()方法对 request.getInputStream()
	 * 或request.getReader()没有冲突，即使已经调用了 request.getParameter()方法，
	 * 也可以通过调用request.getInputStream()或request.getReader()得到表单中的数据,
	 * 而request.getInputStream()和request.getReader()在同一个响应中是不能混合使用的,
	 * 如果混合使用就会抛异常。
	 * @param bufferedReader 请求数据
	 * @return
	 */
	public static String readIncommingRequestData(BufferedReader bufferedReader) {
		try {
			StringBuilder result = new StringBuilder();
			for (String line = null; (line = bufferedReader.readLine()) != null;) {
				result.append(line).append("\n");
			}
			return result.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}


	public static void main(String[] args) {
//    	System.out.println(HttpUtils.doGet("http://localhost:8090/webapi/query/querylistD07R?fundcode=1111"));
//    	System.out.println(HttpUtils.doPost("http://localhost:8090/webapi/query/querylistD07R","fundcode=1111&startdate=20150101"));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("uid", "1000000016");
		map.put("id", "10114");
		System.out.println(HttpUtils.doGet(HttpClient.post("https://api.qixun.tv/v1/live/detail",map,null,null)));
//    	System.out.println(HttpUtils.doPost("http://localhost:8090/webapi/query/querylistD07R",HttpUtils.pingPost(map)));
	}
}