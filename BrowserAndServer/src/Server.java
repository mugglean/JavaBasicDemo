import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ��һ����������ȡ��������͵�����
 * ���к�������������Լ���IP��ַ+�˿ںž��ܷ���
 * ���ӡ����Ӧͷ��Ϣ
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
		//1.����һ��Socket
		ServerSocket ss=new ServerSocket(8090);
		Socket s=ss.accept();
		
		//2.���������������
		InputStream isSoc=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=isSoc.read(buf);
		String str=new String(buf,0, len);
		System.out.println(str);
		
		//3.���ͻ������
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font size='9' color='red'>��ӭ���٣�����ʵ����Զ���ķ�����!</font>");
		//4.�ر���Դ
		s.close();
		ss.close();
	}

}
