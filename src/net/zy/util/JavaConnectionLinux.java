package net.zy.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.StringUtils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
/**
 * 
 * <p>function:java remote connection linux server execution script command</p>
 * <p>java远程连接linux服务器执行脚本命令</p>
 * @author Administrator
 * @version 1.0
 * @date 2017-9-5 上午10:38:26
 */
public class JavaConnectionLinux {
	/**
	 * 
	 * @param host:ip地址
	 * @param port：端口号
	 * @param username：用户名
	 * @param password：密码
	 * @param cmd：执行的命令
	 * @return String
	 * jar包:ganymed-ssh2-build210.jar commons-lang3-3.2.jar(StringUtils)
	 */
	public static String exec(String host,int port,String username, String password, String cmd) {
		
		String DEFAULTCHART = "UTF-8";
		Connection conn = null;
		Session session = null;
		String result = "";
		try {
			conn = new Connection(host, port);
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username,password);
			if (isAuthenticated == false) {
				throw new IOException("Authentication failed.");
			}
			session = conn.openSession();
			session.execCommand(cmd);// 执行命令
			result = processStdout(session.getStdout(), DEFAULTCHART);
		
			// 如果为得到标准输出为空，说明脚本执行出错了
			if (StringUtils.isBlank(result)) {
			
				result += processStdout(session.getStderr(), DEFAULTCHART);
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} finally {
			// 连接的Session和Connection对象都需要关闭
			if (session != null) {
				session.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return result;
	}
	/** 
	    * Resolve the result set returned by the script
	    * 解析脚本返回的结果集 
	    * @param in 标准输入流对象 
	    * @param charset 编码 
	    * @since V0.1 
	    * @return String
	    */  
	private static String processStdout(InputStream in, String charset) {
		InputStream stdout = new StreamGobbler(in);
		StringBuffer buffer = new StringBuffer(); 
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset));
			String line = null;
			
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\n");
				
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		//String cmd="ll /> /opt/tomcat7/1.txt";
		//String cmd="cat /opt/tomcat7/2.txt";
		//String cmd="ps -ef | grep java | grep -v grep";//排除带有grep的命令行
		String cmd="sh /opt/zengyuan/test/hello.sh";
		String exec=exec("218.29.0.22",22,"root","HTTfk@HNR$968",cmd);
		System.out.println("返回结果："+exec);
		
	}
}
