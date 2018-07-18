/**
 * TCP�ͻ���
 * ���󣺷������ݸ�����ˣ������ܷ���˵�����
 */
package cn.mugglean.TCPConnect;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Wangchengan
 *
 */
public class TCPClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ�������");
		//1.����Socket�ͻ��˷�����ΪSocketΪ���������ӣ����Դ���ʱ������ȷ�˿ں͵�ַ
		Socket s=new Socket("192.168.1.119",10003);
		//2.��ȡSocket IO�е���������ܽ���д������
		OutputStream outSoc=s.getOutputStream();
		outSoc.write("tcp�ͻ��˷�������".getBytes());
		//3.��ȡSocket IO�е����������ܽ��ж�������
		InputStream inSoc=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=inSoc.read(buf);
		String str=new String(buf, 0, len);
		System.out.println(str);
		//4.�ر���Դ
		s.close();
	}

}
