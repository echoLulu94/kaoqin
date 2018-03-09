package com.cxs.framework.utils.ath;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.cxs.framework.utils.CharacterUtil;
import com.cxs.framework.utils.MessageDigestUtil;
import com.cxs.framework.utils.StringUtil;

import javax.servlet.http.Cookie;

/**
 * 普通账户登录令牌
 * 
 * 
 */
public final class Token {
	/**
	 * 一周免登录
	 */
	public static final int LOGIN_MAX_AGE = 365*24*3600;

	/**
	 * 账户tokenName
	 */
	private String tokenName;

	/**
	 * 自动过期时间（单位：秒）
	 */
	private int maxAge = -1;

	/**
	 * 创建时间
	 */
	private long time;

	/**
	 * 校验码
	 */
	private String hash;

	/**
	 * 登录名
	 */
	//private String phone;

	/**
	 * 微信unionid
	 */
	private String unionid;

	/**
	 * 学号id
	 */
	private String id;

	public Token() {
	}

	public Token(String tokenString) {
		byte[] bytes = CharacterUtil.hexString2Bytes(tokenString);
		// 内容均为ASCII字符，不必使用UTF8
		String jsonString = new String(bytes);
		JSONObject json = JSONObject.parseObject(jsonString);
		
		try {
			this.tokenName = json.getString("tokenName");
			this.maxAge = json.getIntValue("maxAge");
			this.time = json.getLongValue("time");
			this.hash = json.getString("hash");
			//this.phone = json.getString("phone");
			this.unionid = json.getString("unionid");
			this.id = json.getString("id");
		} catch (JSONException e) {
		}
	}

	public Token(JSONObject json) {
		this.tokenName = json.getString("tokenName");
		this.maxAge = json.getIntValue("maxAge");
		this.time = json.getLongValue("time");
		this.hash = json.getString("hash");
		//this.phone = json.getString("phone");
		this.unionid = json.getString("unionid");
		this.id = json.getString("id");
	}

	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		try {
			json.put("tokenName", tokenName);
			json.put("maxAge", maxAge);
			json.put("time", time);
			json.put("hash", hash);
			//json.put("phone", phone);
			json.put("unionid", unionid);
			json.put("id", id);
		} catch (JSONException e) {
		}
		return json;
	}

	public String toTokenString() {
		// 由于该字符串用于保存于Cookie中，不可出现各类特殊字符，因此需要编码保存
		JSONObject json = this.toJSONObject();
		// 内容均为ASCII字符，不必使用UTF8
		return CharacterUtil.bytes2HexString(json.toString().getBytes());
	}
	
	/**
	 * 创建token
	 * @param tokenName 令牌名
	 * @param id 登录名
	 * @param salt 秘钥
	 * @param maxAge 过期时间
	 * @return
	 */
	public static Token buildToken(String tokenName, String id, String salt, int maxAge) {
		long now = System.currentTimeMillis();
		Token token = new Token();
		token.setTokenName(tokenName);
		token.setMaxAge(maxAge);
		token.setTime(now);
		token.setId(id);
		if(StringUtil.isNotEmpty(salt)){
			String hash = Token.generateHash(token.getMaxAge(), now, salt);
			token.setHash(hash);
			return token;
		}
		return null;
	}

	/**
	 * 创建token,默认永不过期
	 * @param tokenName 令牌名
	 * @param phone 登录名
	 * @param salt 秘钥
	 * @return
	 */
	public static Token buildToken(String tokenName, String phone, String salt) {
		return buildToken(tokenName,phone,salt,-1);
	}

	/**
	 * 根据最大存活时间（单位秒）、创建时间、加密参数生成唯一hash密文
	 * 
	 * @param maxAge
	 * @param time
	 * @param salt
	 * @return
	 */
	public static String generateHash(int maxAge, long time, String salt) {
		StringBuilder source = new StringBuilder("");
		source.append(maxAge).append(";").append(time);
		return MessageDigestUtil.hmacsha256(source.toString(), salt, "utf-8");
	}
	
	/**
	 * 从Cookie列表中获取Token
	 * @param cookieName
	 * @param cookies
	 * @return
	 */
	public static Token readTokenFromCookie(String cookieName, Cookie[] cookies) {
		String tokenString = null;
		if (cookies != null) {
			int length = cookies.length;
			for (int i = 0; i < length; i++) {
				Cookie cookie = cookies[i];
				String name = cookie.getName();
				if (cookieName.equals(name)) {
					tokenString = cookie.getValue();
					break;
				}
			}
		}
		int length = (tokenString != null) ? tokenString.length() : -1;
		if (length > 0) {
			try {
				return new Token(tokenString);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

	
	/**
	 *
	 * @param cookieName cookie名称
	 * @param cookieValue cookie值
	 * @param maxAge 超时时间
	 * @return
	 */
	public static Cookie buildCookie(String cookieName, String cookieValue, int maxAge) {
		Cookie cookie = new Cookie(cookieName,cookieValue);
		cookie.setSecure(false);// share on http and https
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		return cookie;
	}

	/**
	 * 验证token是否有效
	 * @param token
	 * @param salt
	 * @return
	 */
	public static boolean isTokenLegal(Token token, String salt) {
		int maxAge = token.getMaxAge();
		long time = token.getTime();
		String hash = token.getHash();
		boolean legal = false;
		legal = Token.generateHash(maxAge, time, salt).equals(hash);
		return legal;
	}

	public String getTokenName() {
		return tokenName;
	}

	public final int getMaxAge() {
		return maxAge;
	}

	public final long getTime() {
		return time;
	}

	public final String getHash() {
		return hash;
	}

	public final void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	public final void setTime(long time) {
		this.time = time;
	}

	public final void setHash(String hash) {
		this.hash = hash;
	}

	
/*
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
*/

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
