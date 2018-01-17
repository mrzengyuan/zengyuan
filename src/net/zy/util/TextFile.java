package net.zy.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * <p>function:Static functions for reading and writing text files as
	a single string, and treating a file as an ArrayList.</p>
 * @author Administrator
 * @version 1.0
 * @date 2017-7-14 ����11:11:06
 */
public class TextFile extends ArrayList<String>{

	/**
	 * function��read a file as a single String
	 * @param fileName String
	 * @return sb StringBuilder
	 */
	
	  public static String read(String fileName) {
	    StringBuilder sb = new StringBuilder();
	    try {
	      BufferedReader in= new BufferedReader(new FileReader(
	        new File(fileName).getAbsoluteFile()));
	      try {
	        String s;
	        while((s = in.readLine()) != null) {
	          sb.append(s);
	          sb.append("\n");
	        }
	      } finally {
	        in.close();
	      }
	    } catch(IOException e) {
	      throw new RuntimeException(e);
	    }
	    return sb.toString();
	  }

	  /**
	   * <p>Write a single file in one method call</p>
	   * @param fileName
	   * @param text
	   */
	  public static void write(String fileName, String text) {
	    try {
	      PrintWriter out = new PrintWriter(
	        new File(fileName).getAbsoluteFile());
	      try {
	        out.print(text);
	      } finally {
	        out.close();
	      }
	    } catch(IOException e) {
	      throw new RuntimeException(e);
	    }
	  }
	  /**
	   * <p>read and write</p>
	   * @param fileReadName
	   * @param fileWriteName
	   */
	  public static void readeAndWrite(String fileReadName,String fileWriteName){
		  
		  try {
			BufferedReader in=new BufferedReader(new FileReader(fileReadName));
			PrintWriter out=new PrintWriter(new FileWriter(fileWriteName));
			String text;
			try {
				while((text=in.readLine())!=null){
					out.println(text);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				out.close();
				in.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  /**
	   * function Read a file, split by any regular expression
	   * @param fileName String
	   * @param splitter Regex
	   * @return List<String>
	   * summary ��ȡ�ļ����ݹ���List���ϣ��Զ�ȡ���ݽ��в�����������ļ���
	   */
	  public TextFile(String fileName, String splitter) {
	    super(Arrays.asList(read(fileName).split(splitter)));
	    // Regular expression split() often leaves an empty
	    // String at the first position:
	    if(get(0).equals("")) remove(0);
	  }
	  public void write(String fileName) {
		    try {
		      PrintWriter out = new PrintWriter(
		        new File(fileName).getAbsoluteFile());
		      try {
		        for(String item : this)
		          out.println(item);
		      } finally {
		        out.close();
		      }
		    } catch(IOException e) {
		      throw new RuntimeException(e);
		    }
		  }
	  public static void main(String[] args) {
		//read("");
	}
}
