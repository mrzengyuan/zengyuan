package net.zy.util;

/**
 * 
 * <p>function:�ַ����ĳ��ô�����</p>
 * @author Administrator
 * @version 1.0
 * @date 2017-8-18 ����9:32:11
 */
public class MyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addZero(200,8));
	}
	/**
	 * <p>The integer is converted to a fixed number of binary output, not enough bits to add zero</p>
	 * <p>����������ת���ɹ̶�λ���Ķ������������λ����</p>
	 * @param number Numbers to convert ����
	 * @param digit fix number of bit �̶�λ��
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
