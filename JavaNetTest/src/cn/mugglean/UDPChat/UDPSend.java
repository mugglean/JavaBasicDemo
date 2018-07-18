/**
 * UDP聊天室发送端
 * 思路：
 * 源：键盘输入流
 * 目的：Socket流
 * 
 */
package cn.mugglean.UDPChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Wangchengan
 *
 */
public class UDPSend implements Runnable {
	//2.明确目的，Socket流对象，先建立Socket服务
	private DatagramSocket ds;
	public UDPSend(DatagramSocket ds) {
		super();
		this.ds = ds;
	}
	@Override
	public void run() {
		//1.键盘输入流中来的
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		//3.读取数据并将数据发送出去
		String line=null;
		try {
			while ((line=in.readLine())!=null) {
				//3.1将数据封装到数据包
				byte[] buf=line.getBytes();
				DatagramPacket dp=new DatagramPacket(buf, buf.length, 
						InetAddress.getByName("192.168.1.119"),10000);
				ds.send(dp);
				//3.2最后加上结束标记,如果是over结束，则退出循环关闭发送流
				if ("over".equals(line)) {
					break;
				}
			}
			ds.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
