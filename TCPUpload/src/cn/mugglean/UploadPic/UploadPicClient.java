/**
 * �ϴ�ͼƬ�ͻ��ˣ���ȷĿ��
 * Դ�������ļ�
 * Ŀ�ģ�Socket��
 * ˼·��ע��ʹ���ֽ���
 * 
 */
package cn.mugglean.UploadPic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wangchengan
 *
 */
public class UploadPicClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ϴ�ͼƬ�ͻ��˿���.....");
		//1.����Socket
		Socket s=new Socket("192.168.1.119", 10003);
		//2.��ȷ����
		File file=new File("F:\\watermalen.jpg");
		FileInputStream fis=new FileInputStream(file);
		//3.��ȷ���
		OutputStream osSoc=s.getOutputStream();
		//4.Ƶ����д
		byte[] buf=new byte[1024];
		int len=0;
		while ((len=fis.read(buf))!=-1) {
			osSoc.write(buf,0,len);
		}
		//5.�������
		s.shutdownOutput();
		//6.��ȡ���������
		InputStream inSoc=s.getInputStream();
		byte[] bufIn=new byte[1024];
		int lenIn=inSoc.read(bufIn);
		String str=new String(bufIn, 0, lenIn);
		System.out.println(str);
	
	}

}
