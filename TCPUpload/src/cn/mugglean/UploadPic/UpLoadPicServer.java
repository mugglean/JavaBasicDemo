/**
 * ʹ�ö��̼߳������ͻ���һֱ���У�������һֱ����
 */
package cn.mugglean.UploadPic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangchengan
 *
 */
public class UpLoadPicServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("������������...");
		ServerSocket ss=new ServerSocket(10003);
		while(true) {
		Socket s=ss.accept();
		new Thread(new UpLoadPic(s)).start();
		}
	}

}
