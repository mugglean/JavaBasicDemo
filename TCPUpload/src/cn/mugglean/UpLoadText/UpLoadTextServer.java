/**
 * ʹ��TCP�ϴ��ı��ķ�������,��ȡ�ɹ��󣬷������ϴ��ɹ������ͻ���
 * Դ��Socket��
 * Ŀ�ģ��ļ������
 * Bug:��socketд���ļ���ʱ��ҲҪ���ϻ��к��Զ�ˢ��
 */
package cn.mugglean.UpLoadText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangchengan
 *
 */
public class UpLoadTextServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("�ϴ��ı���������������");
		//1.����Socket
		ServerSocket ss=new ServerSocket(10003);
		//2.��ȡ�ͻ��˶���
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"�ɹ�����....");
		//3.ȷ��Դ��ת���ֽ������ϻ�����
		BufferedReader bufr=new BufferedReader(new InputStreamReader(s.getInputStream()));
		//4.ȷ�������
		File file=new File("2.txt");
		BufferedWriter bufw=new BufferedWriter(new FileWriter(file));
		//5.Ƶ����д
		String line=null;
		while((line=bufr.readLine())!=null) {
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		//6.���ͻ��˷�����Ϣ
		OutputStream outSoc=s.getOutputStream();
		outSoc.write("�ϴ��ɹ�".getBytes());
		//7.�ر���Դ
		bufw.close();
		bufr.close();
		s.close();
	}

}
