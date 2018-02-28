package com.cxs.extension.core.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;
		
	
/**
 * redis封装类
 */
public class RedisUtil {

    /**非spring管理的bean需要用这种方式获取spring容器中的bean*/
    private static JedisPool jedisPool;

    private static RedisUtil redisUtil;

    public static RedisUtil getInstance(){
    	if(null==redisUtil) {
    		redisUtil = new RedisUtil();
        	jedisPool = (JedisPool)SpringContextUtil.getBean(JedisPool.class);
    	}
        return redisUtil;
    }

    /**
     * 缓存字符串
     * @param key 键
     * @param value 值
     * @return
     */
    public String setStr(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key,value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取缓存中的字符串
     * @param key 键
     * @return
     */
    public String getStr(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 缓存Map
     * @param key 键
     * @param value 值
     * @return
     */
    public String setMap(String key, Map<String,String> value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hmset(key,value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取缓存中的Map
     * @param key 键
     * @return
     */
    public Map<String,String> getMap(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hgetAll(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
