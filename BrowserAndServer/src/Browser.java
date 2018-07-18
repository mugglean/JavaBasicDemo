import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 自己写一个浏览器，发送信息给Tomacat
 */

/**
 * @author wangchengan
 *
 */
public class Browser {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建Socket,注意Tomocat默认8080端口
		Socket s=new Socket("192.168.1.119", 8080);
		//2.获取流对象并且输出请求头信息
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//2.1注意一定要发送服务器能处理的响应头信息，最后要有一个空格
		out.println("GET /myweb/1.html HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Host: 192.168.1.253:9090");
		out.println("Connection: close");
		out.println();
		
		//3.获取应答信息，此时文件大于2KB,需要循环读
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		
		int len = 0;
		String str=null;
		while((len=in.read(buf))!=-1) {
		str = new String(buf,0,len);
		System.out.println(str);
		}
		
		s.close();
		
	}

}
