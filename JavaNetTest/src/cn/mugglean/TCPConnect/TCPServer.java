/**
 * TCP服务端，接收客户端数据并进行反馈，即应答
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
		System.out.println("服务器端启动");
		//1.创建Socket服务，必须提供要监听的端口
		ServerSocket ss=new ServerSocket(10003);
		//2.获取客户端对象
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+".....已连接");
		//3.获取客户端的Socket的读取流
		InputStream inSoc=s.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=inSoc.read(buf);
		String str=new String(buf, 0, buf.length);
		
		//4.获取客户端的输出流，给客户端反馈数据
		OutputStream outSoc=s.getOutputStream();
		outSoc.write("服务器收到客户端的响应，返回信息给客户端".getBytes());
		//5.关闭资源
		s.close();
		ss.close();
	}

}
