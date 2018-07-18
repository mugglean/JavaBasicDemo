/**
 * �ϴ�ͼƬ�ͻ��٣���ΪҪ�÷������������ʣ�����Ҫ�ѷ�������I/O��Ӧ�𲿷ֳ����
 */
package cn.mugglean.UploadPic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wangchengan
 *
 */
public class UpLoadPic implements Runnable {
	private Socket s;
	public UpLoadPic(Socket s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"�Ѿ�����....");
		
		try {
			//1.��ȷԴ
			InputStream isSoc=s.getInputStream();
			//2.��ȷĿ��
			File dir=new File("temfile");
			File file=getFile(dir, ip);
			FileOutputStream fos=new FileOutputStream(file);
			//3.Ƶ����д
			byte[] buf=new byte[1024];
			int len=0;
			while ((len=isSoc.read(buf))!=-1) {
				fos.write(buf, 0, len);
			}
			//4.������Ϣ���ͻ���
			OutputStream osSoc=s.getOutputStream();
			osSoc.write("�ϴ��ɹ�".getBytes());
			//5.�ر���Դ
			s.close();
			fos.close();			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private File getFile(File dir, String ip) {
		if (!dir.exists()) {
			dir.mkdir();
		}
		//2.1�����ļ����ظ����������ʱ��Ҫ���ļ��µ����֣���Ȼ�Ḳ���ļ�
		int count=1;
		File file=new File(dir, ip+"("+count+")"+".jpg");
		//2.2Ҫʹ��while�жϣ���Ϊ�ڶ����߳��жϵ�ʱ���Ƕ���ж�
		while(file.exists()) {
			count++;
			file=new File(dir, ip+"("+count+")"+".jpg");
		}
		return file;
	}

}
