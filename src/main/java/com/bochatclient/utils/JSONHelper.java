package com.bochatclient.utils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: JSONHelper.java
 * @Description: 工具类-json对象转换成javaBean
 * @author renms
 * @date 2017年4月7日 下午2:58:27 
 * @version 1.0
 */
public class JSONHelper {
	
	public static <T> T jsonToObject(String jsonStr,Class<T> t) {
		JSONObject job = new JSONObject(jsonStr);
		return jsonToObject(job, t);
	}
	
	public static <T> T jsonToObject(JSONObject json,Class<T> t) {
		try{
			T tobj=t.newInstance();
			Field[] fields = t.getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				Field field = fields[i];
				field.setAccessible(true);//允许访问私有成员
				
				Mapping mapField = field.getAnnotation(Mapping.class);
				if(mapField==null)
					continue;
				String key = mapField.value();
				String typeName = field.getType().getSimpleName();
				
				// 将属性的首字母大写
	            String name = field.getName();;
	            name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
	                    .toUpperCase());
				try{
					Method m = null;
					switch (typeName) {
					case "int":
						m=tobj.getClass().getMethod("set" + name,int.class);
						m.invoke(tobj,json.optInt(key));
//				        field.set(tobj, json.optInt(key));//为字段赋值
						break;
					case "String":
						m=tobj.getClass().getMethod("set" + name,String.class);
						m.invoke(tobj,json.optString(key));
//				        field.set(tobj, json.optString(key));//为字段赋值
						break;
					case "boolean":
						m=tobj.getClass().getMethod("set" + name,boolean.class);
						m.invoke(tobj,json.optBoolean(key));
//				        field.set(tobj, json.optBoolean(key));//为字段赋值
						break;
					case "long":
						m=tobj.getClass().getMethod("set" + name,long.class);
						m.invoke(tobj,json.optLong(key));
//				        field.set(tobj, json.optLong(key));//为字段赋值
						break;
					case"double":
						m=tobj.getClass().getMethod("set" + name,double.class);
						m.invoke(tobj,json.optDouble(key));
//				        field.set(tobj, json.optDouble(key));//为字段赋值
						break;
					default:
						//判断type是否是简单类型
						String type = mapField.type();
						if(type.equals("object")){
							Class childClass = Class.forName(field.getType().getName());
							Object obj = json.get(key);
							JSONObject cjob = null;
							if(obj!=null&&!"".equals(obj)&&!"null".equals(obj.toString())){
								cjob = new JSONObject(obj.toString());
								m=tobj.getClass().getMethod("set" + name,childClass);
								m.invoke(tobj,jsonToObject(cjob, childClass));
//								field.set(tobj, jsonToObject(cjob, childClass));//为字段赋值
							}
						}else if(type.equals("list")){
							String childClassName = mapField.name();
							Class childClass = Class.forName(childClassName);
							Object obj = json.opt(key);
							JSONArray cjob = null;
							if(obj!=null&&!"".equals(obj)&&null!=obj){
								cjob = new JSONArray(obj.toString());
								List list = new ArrayList();
								for(int j=0;j<cjob.length();j++){
									list.add(jsonToObject(cjob.get(j).toString(), childClass));
								}
								m=tobj.getClass().getMethod("set" + name,List.class);
								m.invoke(tobj,list);
//								field.set(tobj, list);//为字段赋值
							}
						}
						break;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return tobj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
//	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		System.out.println(jsonToObject("{}", ChatUserSimpleBean.class).toString());
//	}
	
    /**
     * 将json字符串转换为List集合
     *
     * @param jsonArrStr
     * @return
     */
    public static List<Map<String, Object>> jsonObjList(String jsonArrStr) {
        List<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
        JSONArray jsonArr = null;
        try {
            jsonArr = new JSONArray(jsonArrStr);
            jsonList = (List<Map<String, Object>>)JSONHelper.jsonToList(jsonArr);
        } catch (JSONException e) {
            System.out.println("Json字符串转换异常！");
            e.printStackTrace();
        }
        return jsonList;
    }
    /**
     * 将json对象的键值存放在集合，映射table的column
     *
     * @param map
     * @return
     */
    public static List<String> jsonMapKeysList(Map<?, ?> map) {
        List<String> jsonjsonList = new ArrayList<String>();
        String columnStr = "column";
        for (int i = 0; i < map.keySet().size(); i++) {
            jsonjsonList.add(columnStr + (i + 1));
        }
        System.out.println(jsonjsonList.size());
        return jsonjsonList;
    }
    /**
     * 将传递近来的json数组转换为List集合
     *
     * @param jsonArr
     * @return
     * @throws JSONException
     */
    private static List<?> jsonToList(JSONArray jsonArr)
            throws JSONException {
        List<Object> jsonToMapList = new ArrayList<Object>();
        for (int i = 0; i < jsonArr.length(); i++) {
            Object object = jsonArr.get(i);
            if (object instanceof JSONArray) {
                jsonToMapList.add(JSONHelper.jsonToList((JSONArray) object));
            } else if (object instanceof JSONObject) {
                jsonToMapList.add(JSONHelper.jsonToMap((JSONObject) object));
            } else {
                jsonToMapList.add(object);
            }
        }
        return jsonToMapList;
    }
    /**
     * 将传递近来的json对象转换为Map集合
     *
     * @param jsonObj
     * @return
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> jsonToMap(JSONObject jsonObj)
            throws JSONException {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        Iterator<String> jsonKeys = jsonObj.keys();
        while (jsonKeys.hasNext()) {
            String jsonKey = jsonKeys.next();
            Object jsonValObj = jsonObj.get(jsonKey);
            if (jsonValObj instanceof JSONArray) {
                jsonMap.put(jsonKey, JSONHelper.jsonToList((JSONArray) jsonValObj));
            } else if (jsonValObj instanceof JSONObject) {
                jsonMap.put(jsonKey, JSONHelper.jsonToMap((JSONObject) jsonValObj));
            } else {
                jsonMap.put(jsonKey, jsonValObj);
            }
        }
        return jsonMap;
    }
}