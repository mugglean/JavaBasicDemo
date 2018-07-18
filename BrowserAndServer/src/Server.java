import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟一个服务器获取浏览器发送的数据
 * 运行后再浏览器输入自己的IP地址+端口号就能访问
 * 会打印出响应头信息
 */

/**
 * @author wangchengan
 *
 */
public class Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1.创建一个Socket
		ServerSocket ss=new ServerSocket(8090);
		Socket s=ss.accept();
		
		//2.接受浏览器的数据
		InputStream isSoc=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=isSoc.read(buf);
		String str=new String(buf,0, len);
		System.out.println(str);
		
		//3.发送回浏览器
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font size='9' color='red'>欢迎光临，你访问的是自定义的服务器!</font>");
		//4.关闭资源
		s.close();
		ss.close();
	}

}
