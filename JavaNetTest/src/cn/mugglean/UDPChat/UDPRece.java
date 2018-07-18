/**
 * UDP���նˣ�������գ�ֻҪ���յ����ַ�����ӡ����������
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
	//1.����һ��Socket������ȷһ���˿�
	private DatagramSocket ds;
	public UDPRece(DatagramSocket ds) {
		super();
		this.ds = ds;
	}
	@Override
	public void run() {
		while(true) {
		//2.�������ݰ������Խ�������
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		try {
			ds.receive(dp);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//3.ʹ�����ݰ�����ķ�����ȡ����
		String ip=dp.getAddress().getHostAddress();
		int port=dp.getPort();
		String str=new String(dp.getData(), 0, dp.getLength());
		
		System.out.println(ip+":"+str);
		//5.�����жϱ�ǣ�������Ͷ˷�����over������ʾ������Ϣ
		if ("over".equals(str)) {
			System.out.println(ip+"....�뿪������");
		}
		//4.�ر���Դ����Ϊ��ʱ��������Ҫһֱ�������Բ��ùر�
		}
	}

}
