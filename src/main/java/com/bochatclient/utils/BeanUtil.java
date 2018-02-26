package com.bochatclient.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.json.JSONObject;

import com.bochatclient.enter.UserEnterBean;

public class BeanUtil {

	/**
	 * javaBean转换成json字符串，只针对简单类型
	 * @param object
	 * @return
	 */
	public static String beanToJson(Object object){
		
		Field[] supfields = null;
		if(!object.getClass().getSuperclass().equals(Object.class)){
			supfields = object.getClass().getSuperclass().getDeclaredFields();
		}
		
		Field[] fields = object.getClass().getDeclaredFields();
		int supfieldLength = 0;
		if(supfields!=null){
			supfieldLength = supfields.length;
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		
		for(int i=0,size=fields.length,consize=(size+supfieldLength) ;i<consize;i++){
			
			Field field = null;
			if(i<size){
				field = fields[i];
			}else{
				field = supfields[i-size];
			}
			field.setAccessible(true);//允许访问私有成员
			
			String fieldName = field.getName();
			String typeName = field.getType().getSimpleName();
			
			if(fieldName.equals("serialVersionUID")){//序列号id不需要格式化
				continue;
			}
			
			// 将属性的首字母大写
            String name = fieldName;
            name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                    .toUpperCase());
            try{
	            Method m = object.getClass().getMethod("get" + name);
	            Object value = m.invoke(object);
	            switch (typeName) {
				case "String":
					sb.append("\""+fieldName+"\":");
					sb.append("\""+value.toString()+"\"");
					if(i<consize-1){
						sb.append(",");
					}
					break;
				default:
					sb.append("\""+fieldName+"\":");
					sb.append(value.toString());
					if(i<consize-1){
						sb.append(",");
					}
					break;
	            }
            }catch(Exception e){
            	e.printStackTrace();
            }
		}
		sb.append("}");
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(new JSONObject(beanToJson(new UserEnterBean("1", "2", "3", "4"))));
	}
}
