/**
 * TCP����ˣ����տͻ������ݲ����з�������Ӧ��
 */
package cn.mugglean.TCPConnect;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wangchengan
 *
 */
public class TCPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("������������");
		//1.����Socket���񣬱����ṩҪ�����Ķ˿�
		ServerSocket ss=new ServerSocket(10003);
		//2.��ȡ�ͻ��˶���
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+".....������");
		//3.��ȡ�ͻ��˵�Socket�Ķ�ȡ��
		InputStream inSoc=s.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=inSoc.read(buf);
		String str=new String(buf, 0, buf.length);
		
		//4.��ȡ�ͻ��˵�����������ͻ��˷�������
		OutputStream outSoc=s.getOutputStream();
		outSoc.write("�������յ��ͻ��˵���Ӧ��������Ϣ���ͻ���".getBytes());
		//5.�ر���Դ
		s.close();
		ss.close();
	}

}
