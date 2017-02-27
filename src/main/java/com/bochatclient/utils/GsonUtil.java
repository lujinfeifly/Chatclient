package com.bochatclient.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {
	private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private GsonUtil() {
    }

    /**
     * 转成json
     * 
     * @param object
     * @return
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 转成bean
     * 
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

   /**
     * 转成list
     * 泛型在编译期类型被擦除导致报错
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list
     * 解决泛型问题
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public <T> List<T> jsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }


    /**
     * 转成list中有map的
     * 
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     * 
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
    
    public static void main(String[] args) {
//    	String jsonStr = "{\'retcode\':\'000000\',\'retmsg\':\'OK\',\'escapeflag\':\'1\',\'msg\':\'1\',\'v\':0}";
    	
    	String jsonStr = "{'retcode':'000000','retmsg':'OK','rettime':'14:54','escapeflag':'0','v':'0','msg':[{'ct':[{'e':3,'c':0,'d':1,'b':0,'a':2},{'h':[{'o':0,'h':0,'a2':0,'a8':0,'bb':'285461808','p':'dxjtest285461808','j':null,'x':1,'a1':null,'g':'','l':false,'b1':null,'b3':null,'y':285461808,'m':0,'c3':0},{'o':0,'h':0,'a2':0,'a8':0,'bb':'846659298','p':'dxjtest846659298','j':null,'x':1,'a1':null,'g':'','l':false,'b1':null,'b3':null,'y':846659298,'m':0,'c3':0}],'g':[{'o':16,'h':0,'a2':10000000000000,'a8':50,'bb':'672030622','p':'672030622@许愿树','j':'http://image.cdn.tllm.cxg.changyou.com/show/20151026/images/head/anchorDefault.jpg','x':1,'a1':'1,3','g':'{\'b7\':\'\',\'b9\':0}','l':false,'b1':'许愿树','b3':0,'y':-1,'m':0,'c3':0}],'f':[{'o':16,'h':0,'a2':10000000000000,'a8':50,'bb':'672030622','p':'672030622@许愿树','j':'http://image.cdn.tllm.cxg.changyou.com/show/20151026/images/head/anchorDefault.jpg','x':1,'a1':'1,3','g':'{\'b7\':\'\',\'b9\':0}','l':false,'b1':'许愿树','b3':0,'y':-1,'m':0,'c3':0}]}],'a':'SendMsg','c':'6','d':'14:54','b':'0'}]}";
    	
//    	Map<String,Object> map = GsonToMaps(jsonStr);
    	
//    	for(String key:map.keySet()){
//    		System.out.println(key+"----"+map.get(key).toString());
//    	}
    	
    	
	}
    
}
