package net.zy.util;

import java.security.MessageDigest;

/**
 * 
 * <p>function:MD5¼ÓÃÜ</p>
 * @author Administrator
 * @version 1.0
 * @date 2017-9-27 ÉÏÎç9:09:53
 */
public class Md5Util {

	/**
	 * 
	 * @param ss ÊäÈëµÄ×Ö·û´®
	 * @return MD5Âë
	 */
	public final static String md5(String ss) {

		String s = ss == null ? "" : ss;

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			//System.out.println(Arrays.toString(md));
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// MD5_Test aa = new MD5_Test();
		String mi = Md5Util.md5("@CRM.123456");//202cb962ac59075b964b07152d234b70
		System.out.print(mi);
	}
}
