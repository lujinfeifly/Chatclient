package com.bochatclient.cache;

import java.util.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: 管理缓存</p>
 * @author renms 2015-08-10
 */
public class CacheManager {
    private static Map<String,Cache> cacheMap = new HashMap<String,Cache>();

    private CacheManager() {
    }
    
    /**
     * 保存缓存信息，缓存永远有效
     * @param key 缓存key
     * @param obj 缓存对象
     */
    public static void putCacheInfo(String key,Object obj){
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setTimeOut(0);//超时时间设置为0，表示永远不超时
        cache.setValue(obj);
        cache.setExpired(false);
        cacheMap.put(key,cache);
    }
    
    /**
     * 保存缓存信息
     * @param key 缓存key
     * @param obj 缓存对象
     * @param dt 缓存有效期 　过期时间
     */
    public static void putCacheInfo(String key,Object obj,long dt){
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setTimeOut(System.currentTimeMillis()+dt);
        cache.setValue(obj);
        cache.setExpired(false);
        cacheMap.put(key,cache);
    }
    
    //获取缓存信息
    public static Cache getCacheInfo(String key) {

        if (hasCache(key)) {
            Cache cache = getCache(key);
            if (cacheExpired(cache)) { //调用判断是否终止方法
                cache.setExpired(true);
            }
            return cache;
        }else
            return null;
    }
    
    //得到缓存。同步静态方法
    private synchronized static Cache getCache(String key) {
        return (Cache) cacheMap.get(key);
    }

    //判断是否存在一个缓存
    private synchronized static boolean hasCache(String key) {
        return cacheMap.containsKey(key);
    }

    //清除所有缓存
    public synchronized static void clearAll() {
        cacheMap.clear();
    }

    //清除某一类特定缓存,通过遍历HASHMAP下的所有对象，来判断它的KEY与传入的TYPE是否匹配
    public synchronized static void clearAll(String type) {
        ArrayList<String> arr = new ArrayList<String>();
        try {
	        for(String key:cacheMap.keySet()){
	        	if (key.startsWith(type)) { //如果匹配则删除掉
	                arr.add(key);
	            }
	        }
	        
	        for (int k = 0; k < arr.size(); k++) {
	            clearOnly(arr.get(k));
	        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //清除指定的缓存
    public synchronized static void clearOnly(String key) {
        cacheMap.remove(key);
    }

    //判断缓存是否终止
    public static boolean cacheExpired(Cache cache) {
        if (null == cache) { //传入的缓存不存在
            return false;
        }
        long nowDt = System.currentTimeMillis(); //系统当前的毫秒数
        long cacheDt = cache.getTimeOut(); //缓存内的过期毫秒数
        if (cacheDt <= 0||cacheDt>nowDt) { //过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE
            return false;
        } else { //大于过期时间 即过期
            return true;
        }
    }

    //获取缓存对象中的所有键值名称
    public static ArrayList<String> getCacheAllkey() {
    	ArrayList<String> arr = new ArrayList<String>();
        try {
	        for(String key:cacheMap.keySet()){
                arr.add(key);
	        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
}