package net.zy.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 * <p>function: json工具类</p>
 * @author zengyuan
 * @version 1.0
 * @date 2017-12-11 下午4:01:35
 * @jar json-lib-2.3-jdk15.jar
	commons-beanutils-1.7.0.jar
	commons-lang-2.3.jar
	commons-logging-1.0.4.jar
	commons-collections-3.1.jar
	ezmorph-1.0.3.jar
 */
public class JSONUtil {
	/**
	 * <p>function: 将对象转换成json对象输出</p>
	 * @param Object
	 * @return String
	 */
	public static String toJSONObject(Object src){
		return JSONObject.fromObject(src).toString();
	}
	/**
	 * <p>function: 将list集合转换成json对象输出</p>
	 * @param List
	 * @return String
	 */
	public static String toJSONArray(List l){
		return JSONArray.fromObject(l).toString();
	}
	
public static void main(String[] args) {
	 Map map = new HashMap();  
     map.put("key","json");  
     map.put("test", "test");  
     
     Map map1 = new HashMap(); 
     map1.put("key","json");  
     map1.put("test", "test"); 
     Map map2 = new HashMap(); 
     map2.put("key","json");  
     map2.put("test", "test"); 
     map.put("root", map1);
     map.put("root", map2);
     JSONObject json4 = JSONObject.fromObject(map);//转化map对象  
     System.out.println(json4); 
	
}
	
}
