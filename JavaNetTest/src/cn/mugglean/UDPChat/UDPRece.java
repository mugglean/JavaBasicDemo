/**
 * UDP接收端，负责接收，只要将收到的字符串打印出来就行了
 */
package cn.mugglean.UDPChat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Wangchengan
 *
 */
public class UDPRece implements Runnable {
	//1.创建一个Socket服务，明确一个端口
	private DatagramSocket ds;
	public UDPRece(DatagramSocket ds) {
		super();
		this.ds = ds;
	}
	@Override
	public void run() {
		while(true) {
		//2.创建数据包对象以接收数据
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		try {
			ds.receive(dp);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//3.使用数据包对象的方法获取数据
		String ip=dp.getAddress().getHostAddress();
		int port=dp.getPort();
		String str=new String(dp.getData(), 0, dp.getLength());
		
		System.out.println(ip+":"+str);
		//5.加上判断标记，如果发送端发送了over，则提示发出信息
		if ("over".equals(str)) {
			System.out.println(ip+"....离开聊天室");
		}
		//4.关闭资源，因为此时是聊天室要一直接收所以不用关闭
		}
	}

}
