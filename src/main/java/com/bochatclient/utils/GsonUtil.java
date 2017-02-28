package com.bochatclient.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.UserMsgBean;
import com.bochatclient.bean.UserMsgBeanCT;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.StringMap;
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
        }
        t = gson.fromJson(gsonString, cls);
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
//    	String jsonStr = '{\'retcode\':\'000000\',\'retmsg\':\'OK\',\'escapeflag\':\'1\',\'msg\':\'1\',\'v\':0}';
    	
    	
    	
    	String jsonStr = "{'retcode':'000000','retmsg':'OK','rettime':'17:59','escapeflag':'0','v':'0','msg':[{'a':'SendMsg','b':'0','ct':'111111','c':'2','d':'17:59','e':{'q':'null','i':0,'o':0,'h':0,'a':'0','a2':301000000000,'a8':0,'bb':'85168','p':'边好9527@龙腾天下','a9':0,'w':1,'u':1,'j':'52','x':1,'a1':'','k':'114.247.160.239','r':'0','g':'{\'b7\':\'\',\'b9\':0}','s':null,'f':'0','a5':0,'a4':'23470201128EB61D','c':'','l':false,'b1':'龙腾天下','z':33,'e':750,'t':3,'d':null,'b3':0,'b2':0,'v':1,'y':89795,'m':0,'a3':0,'b4':'','c3':'0','aa':'85168','a7':'边好9527@龙腾天下'},'f':null}],'isFirst':0}";
    	
//    	jsonStr="{'retcode':'000000','retmsg':'OK','rettime':'17:59','escapeflag':'0','v':'0','msg':[{'a':'SendMsg','b':'0','ct':'111111','c':'2','d':'17:59','f':null}],'isFirst':0}";
//    	
//    	jsonStr="{'retcode':'000000','retmsg':'OK','rettime':'17:59','escapeflag':'0','v':'0','msg':[{'a':'SendMsg','b':'0','ct':'111111','c':'2','d':'17:59','e':{'q':'null','i':0,'o':0,'h':0,'a':'0','a2':301000000000,'a8':0,'bb':'85168','p':'边好9527@龙腾天下','a9':0,'w':1,'u':1,'j':'52','x':1,'a1':'','k':'114.247.160.239','r':'0','g':'123','s':null,'f':'0','a5':0,'a4':'23470201128EB61D','c':'','l':false,'b1':'龙腾天下','z':33,'e':750,'t':3,'d':null,'b3':0,'b2':0,'v':1,'y':89795,'m':0,'a3':0,'b4':'','c3':'0','aa':'85168','a7':'边好9527@龙腾天下'},'f':null}],'isFirst':0}";
    	
    	BaseBean<StringMap<StringMap<String>>> bb = GsonUtil.GsonToBean(jsonStr, BaseBean.class);
		int retCode = Integer.parseInt(bb.getRetcode());
		
		System.out.println("gift:"+retCode);
    	
		StringMap<StringMap<String>> sm = bb.getMsg().get(0);
		
		System.out.println(sm.get("e").get("p")+"--"+sm.get("ct"));
		
//    	Map<String,Object> map = GsonToMaps(jsonStr);
    	
//    	for(String key:map.keySet()){
//    		System.out.println(key+'----'+map.get(key).toString());
//    	}
    	
    	
	}
    
}
