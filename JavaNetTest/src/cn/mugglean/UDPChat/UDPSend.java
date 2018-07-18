/**
 * UDP�����ҷ��Ͷ�
 * ˼·��
 * Դ������������
 * Ŀ�ģ�Socket��
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
	//2.��ȷĿ�ģ�Socket�������Ƚ���Socket����
	private DatagramSocket ds;
	public UDPSend(DatagramSocket ds) {
		super();
		this.ds = ds;
	}
	@Override
	public void run() {
		//1.����������������
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		//3.��ȡ���ݲ������ݷ��ͳ�ȥ
		String line=null;
		try {
			while ((line=in.readLine())!=null) {
				//3.1�����ݷ�װ�����ݰ�
				byte[] buf=line.getBytes();
				DatagramPacket dp=new DatagramPacket(buf, buf.length, 
						InetAddress.getByName("192.168.1.119"),10000);
				ds.send(dp);
				//3.2�����Ͻ������,�����over���������˳�ѭ���رշ�����
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
