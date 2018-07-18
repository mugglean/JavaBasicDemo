/**
 * TCP客户端
 * 需求：发送数据给服务端，并接受服务端的数据
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
		System.out.println("客户端启动");
		//1.建立Socket客户端服务，因为Socket为面向有连接，所以创建时必须明确端口和地址
		Socket s=new Socket("192.168.1.119",10003);
		//2.获取Socket IO中的输出流就能进行写操作了
		OutputStream outSoc=s.getOutputStream();
		outSoc.write("tcp客户端发起连接".getBytes());
		//3.获取Socket IO中的输入流就能进行读操作了
		InputStream inSoc=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=inSoc.read(buf);
		String str=new String(buf, 0, len);
		System.out.println(str);
		//4.关闭资源
		s.close();
	}

}
