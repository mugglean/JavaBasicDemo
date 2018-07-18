import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * 使用Java的URL对象获取的客户端，开启Tomacat后
 * 能根据url地址获得响应回来的信息
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
		//解析url中的数据。使用URL对象。
				String str_url = "http://localhost:8080/myweb/1.html?name=lisi";
				
				URL url = new URL(str_url);
	
				//通过openConnection();获取到该远程资源的连接对象。
				URLConnection conn = url.openConnection();
				System.out.println(conn);
				
				//调用连接对象的读取方法。准备读取资源。
				InputStream in = conn.getInputStream();
				
				byte[] buf = new byte[1024];
				int len = in.read(buf);
				String str = new String(buf,0,len);
				System.out.println(str);
	}

}
