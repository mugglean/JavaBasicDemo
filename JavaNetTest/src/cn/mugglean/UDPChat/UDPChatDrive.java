/**
 * �����ҿ���������ʹ���˶��̵߳ķ��������Ͷ˺ͽ��ն�һ������
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
		//�ȴ���Socket����
		DatagramSocket send=new DatagramSocket(8888);
		DatagramSocket rec=new DatagramSocket(10000);
		
		new Thread(new UDPSend(send)).start();
		new Thread(new UDPRece(rec)).start();
	}

}
