import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * ʹ��Java��URL�����ȡ�Ŀͻ��ˣ�����Tomacat��
 * �ܸ���url��ַ�����Ӧ��������Ϣ
 */

/**
 * @author wangchengan
 *
 */
public class URLDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//����url�е����ݡ�ʹ��URL����
				String str_url = "http://localhost:8080/myweb/1.html?name=lisi";
				
				URL url = new URL(str_url);
	
				//ͨ��openConnection();��ȡ����Զ����Դ�����Ӷ���
				URLConnection conn = url.openConnection();
				System.out.println(conn);
				
				//�������Ӷ���Ķ�ȡ������׼����ȡ��Դ��
				InputStream in = conn.getInputStream();
				
				byte[] buf = new byte[1024];
				int len = in.read(buf);
				String str = new String(buf,0,len);
				System.out.println(str);
	}

}
