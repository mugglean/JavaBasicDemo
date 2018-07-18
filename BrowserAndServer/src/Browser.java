import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �Լ�дһ���������������Ϣ��Tomacat
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
		//1.����Socket,ע��TomocatĬ��8080�˿�
		Socket s=new Socket("192.168.1.119", 8080);
		//2.��ȡ���������������ͷ��Ϣ
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//2.1ע��һ��Ҫ���ͷ������ܴ������Ӧͷ��Ϣ�����Ҫ��һ���ո�
		out.println("GET /myweb/1.html HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Host: 192.168.1.253:9090");
		out.println("Connection: close");
		out.println();
		
		//3.��ȡӦ����Ϣ����ʱ�ļ�����2KB,��Ҫѭ����
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
