/**
 * 上传图片客户顿，因为要让服务器并发访问，所以要把服务器的I/O和应答部分抽出来
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
		System.out.println(ip+"已经连接....");
		
		try {
			//1.明确源
			InputStream isSoc=s.getInputStream();
			//2.明确目的
			File dir=new File("temfile");
			File file=getFile(dir, ip);
			FileOutputStream fos=new FileOutputStream(file);
			//3.频繁读写
			byte[] buf=new byte[1024];
			int len=0;
			while ((len=isSoc.read(buf))!=-1) {
				fos.write(buf, 0, len);
			}
			//4.返回信息给客户端
			OutputStream osSoc=s.getOutputStream();
			osSoc.write("上传成功".getBytes());
			//5.关闭资源
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
		//2.1考虑文件名重复的情况，此时需要给文件新的名字，不然会覆盖文件
		int count=1;
		File file=new File(dir, ip+"("+count+")"+".jpg");
		//2.2要使用while判断，因为第二个线程判断的时候是多次判断
		while(file.exists()) {
			count++;
			file=new File(dir, ip+"("+count+")"+".jpg");
		}
		return file;
	}

}
