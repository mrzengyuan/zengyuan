package net.zy.util;

/**
 * 
 * <p>function:字符串的常用处理方法</p>
 * @author Administrator
 * @version 1.0
 * @date 2017-8-18 上午9:32:11
 */
public class MyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addZero(200,8));
	}
	/**
	 * <p>The integer is converted to a fixed number of binary output, not enough bits to add zero</p>
	 * <p>将整形数字转换成固定位数的二进制输出，高位补零</p>
	 * @param number Numbers to convert 数字
	 * @param digit fix number of bit 固定位数
	 * @return String
	 */
	public static String addZero(int number,int digit){
		StringBuilder s=new StringBuilder();
		String binaryNumber=Integer.toBinaryString(number);
		for(int i=0;i<digit;i++){
			s.append(0);
		}
		return s.substring(0,digit-binaryNumber.length())+binaryNumber;
	}
}
