/**
 * 上传图片客户端，明确目的
 * 源：本地文件
 * 目的：Socket流
 * 思路：注意使用字节流
 * 
 */
package cn.mugglean.UploadPic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wangchengan
 *
 */
public class UploadPicClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("上传图片客户端开启.....");
		//1.开启Socket
		Socket s=new Socket("192.168.1.119", 10003);
		//2.明确输入
		File file=new File("F:\\watermalen.jpg");
		FileInputStream fis=new FileInputStream(file);
		//3.明确输出
		OutputStream osSoc=s.getOutputStream();
		//4.频繁读写
		byte[] buf=new byte[1024];
		int len=0;
		while ((len=fis.read(buf))!=-1) {
			osSoc.write(buf,0,len);
		}
		//5.结束标记
		s.shutdownOutput();
		//6.读取服务端数据
		InputStream inSoc=s.getInputStream();
		byte[] bufIn=new byte[1024];
		int lenIn=inSoc.read(bufIn);
		String str=new String(bufIn, 0, lenIn);
		System.out.println(str);
	
	}

}
