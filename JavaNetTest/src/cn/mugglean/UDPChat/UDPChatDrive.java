/**
 * 聊天室开启，这里使用了多线程的方法，发送端和接收端一起运行
 */
package cn.mugglean.UDPChat;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * @author Wangchengan
 *
 */
public class UDPChatDrive {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//先创建Socket服务
		DatagramSocket send=new DatagramSocket(8888);
		DatagramSocket rec=new DatagramSocket(10000);
		
		new Thread(new UDPSend(send)).start();
		new Thread(new UDPRece(rec)).start();
	}

}
