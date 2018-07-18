/**
 * ʹ��TCP�ϴ��ı��Ŀͻ���,����File������Ըı������ļ�
 * ˼·��ȷ��Դ��Ŀ��
 * Դ�������ļ�
 * Ŀ�ģ�Socket��
 * Bug����Ϊд�����txt�ļ������б�Ȼ�л��з�������ÿ��д��Socket����ʱ����Ҫд���з���ˢ��
 * ��һ�ֽ��������ʹ��PrintWriter������������println�����������Զ�ˢ��
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
		System.out.println("�ϴ��ļ��Ŀͻ���������.....");
		//1.�����ͻ���Socket
		Socket s=new Socket("192.168.1.119", 10003);
		//2.ȷ��Դ���������ַ�����Ȼ����ϻ�����
		File file=new File("F:\\text1.txt");
		BufferedReader bufr=new BufferedReader(new FileReader(file));
		//3.ȷ��Ŀ�ģ�Socket�ֽ�����Ҫת�����ַ���,��ʹ�û������Ĺ���
		BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//4.���ж�д
		String line=null;
		while ((line=bufr.readLine())!=null) {
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		//5.�������
		s.shutdownOutput();
		//6.ͨ��Socket��������ȡ�������˷��ص�����
		InputStream isSoc=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=isSoc.read(buf);
		String str=new String(buf, 0, len);
		System.out.println(str);
		//7.�ر���Դ
		bufr.close();
		//bufw.close();
		s.close();
		
	}

}
