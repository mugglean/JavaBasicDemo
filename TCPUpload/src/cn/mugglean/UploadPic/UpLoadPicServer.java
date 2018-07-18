/**
 * 使用多线程技术，客户端一直运行，服武器一直运行
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
		System.out.println("服务器端运行...");
		ServerSocket ss=new ServerSocket(10003);
		while(true) {
		Socket s=ss.accept();
		new Thread(new UpLoadPic(s)).start();
		}
	}

}
