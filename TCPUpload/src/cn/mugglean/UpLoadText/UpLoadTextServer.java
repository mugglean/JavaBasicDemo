/**
 * 使用TCP上传文本的服务器端,读取成功后，发出“上传成功”给客户端
 * 源：Socket流
 * 目的：文件输出流
 * Bug:从socket写到文件的时候也要加上换行和自动刷新
 */
package cn.mugglean.UpLoadText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangchengan
 *
 */
public class UpLoadTextServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("上传文本服务器端驱启动");
		//1.创建Socket
		ServerSocket ss=new ServerSocket(10003);
		//2.获取客户端对象
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"成功连接....");
		//3.确定源，转成字节流加上缓冲区
		BufferedReader bufr=new BufferedReader(new InputStreamReader(s.getInputStream()));
		//4.确定输出流
		File file=new File("2.txt");
		BufferedWriter bufw=new BufferedWriter(new FileWriter(file));
		//5.频繁读写
		String line=null;
		while((line=bufr.readLine())!=null) {
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		//6.给客户端返回信息
		OutputStream outSoc=s.getOutputStream();
		outSoc.write("上传成功".getBytes());
		//7.关闭资源
		bufw.close();
		bufr.close();
		s.close();
	}

}
