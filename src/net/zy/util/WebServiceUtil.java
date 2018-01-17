package net.zy.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 
 * <p>function:Java calls the webservice interface remotely and returns information
 * java远程调用webservice接口并返回信息</p>
 * @author Administrator
 * @version 1.0
 * @date 2017-8-18 下午2:39:12
 */
public class WebServiceUtil {

	/**
	 * <p>Java calls the webservice interface remotely and returns information
	 * java远程调用webservice接口并返回信息</p>
	 * @param url Request interface url 请求接口url
	 * @param soap Request message 请求报文
	 * @return String
	 */
	public static String getMessage(String url,String soap){
		String result="";
		try {
			URL u=new URL(url);
			HttpURLConnection http = (HttpURLConnection) u.openConnection();
			http.setDoOutput(true);
	        http.setDoInput(true);
	        http.setRequestMethod("POST");
	        http.setUseCaches(false);
	        http.setRequestProperty("Content-Type", "text/xml;charset=utf-8");	        
	        http.connect();
	        
	        OutputStream out = http.getOutputStream();
	        out.write(soap.getBytes("utf-8"));	     
	        out.flush();
	        out.close();
	        
	        int l_resCode = http.getResponseCode();
	 		BufferedReader in = null;
	 		if (l_resCode == 200) {
	 			in = new BufferedReader(new InputStreamReader(
	 					http.getInputStream()));
	 		} else {
	 			in = new BufferedReader(new InputStreamReader(
	 					http.getErrorStream()));
	 		}
             String line;           
             while ((line = in.readLine()) != null) {
             result+=line;
             }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
}
