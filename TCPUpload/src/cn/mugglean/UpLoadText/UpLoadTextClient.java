/**
 * 使用TCP上传文本的客户端,更改File对象可以改变输入文件
 * 思路：确定源和目的
 * 源：本地文件
 * 目的：Socket流
 * Bug：因为写入的是txt文件，其中必然有换行符，所以每次写给Socket流的时候需要写换行符和刷新
 * 另一种解决方法是使用PrintWriter方法，里面有println方法开可以自动刷新
 */
package cn.mugglean.UpLoadText;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wangchengan
 *
 */
public class UpLoadTextClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("上传文件的客户端启动了.....");
		//1.建立客户端Socket
		Socket s=new Socket("192.168.1.119", 10003);
		//2.确定源。首先是字符流，然后加上缓冲区
		File file=new File("F:\\text1.txt");
		BufferedReader bufr=new BufferedReader(new FileReader(file));
		//3.确定目的，Socket字节流，要转换成字符流,再使用缓冲区的功能
		BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//4.进行读写
		String line=null;
		while ((line=bufr.readLine())!=null) {
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		//5.结束标记
		s.shutdownOutput();
		//6.通过Socket输入流读取服务器端返回的数据
		InputStream isSoc=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=isSoc.read(buf);
		String str=new String(buf, 0, len);
		System.out.println(str);
		//7.关闭资源
		bufr.close();
		//bufw.close();
		s.close();
		
	}

}
