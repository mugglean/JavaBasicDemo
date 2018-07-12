/**
 * �ļ��иһ������������������
 * ע�⣺�и�������ļ����滹��Ҫ�����ļ�����ΪҪ��¼��׺�����ļ������Ա����ļ��ϲ�ʱʹ��
 */
package cn.mugglean.FileSplit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



/**
 * @author wangchengan
 *
 */
public class FileSplitText {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File srcFile = new File("test.mp3");
		File destFile = new File("tempfile");
		fileSplit(srcFile, destFile);
	}

	public static void fileSplit(File srcFile, File destFile) throws IOException {
		//���ж�Դ�ļ���Ŀ���ļ�����治����
		if(!srcFile.exists()) {
			throw new RuntimeException(srcFile.getAbsolutePath()+",Դ�ļ�������");
		}
		if (!destFile.exists()) {
			destFile.mkdir();
		}
		
		//һ����������Ϊ�ֽ���
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = null;
		
		//��������
		byte[] buf=new byte[1024*1024];
		//��������������
		int count=0;
		int len=0;
		while((len=fis.read(buf))!=-1) {
			File partFile=new File(destFile, (++count)+".part");
			fos=new FileOutputStream(partFile);
			fos.write(buf, 0, len);
			fos.close();
		}
		//�洢������Ϣ��Ӧ��ʹ��Properties����
		Properties prop=new Properties();
		prop.setProperty("filename", srcFile.getName());
		prop.setProperty("filecount", Integer.toString(count));
		
		//дproperties�ļ���Ҫ���������
		File configFile=new File(destFile,(++count)+".properties");
		fos=new FileOutputStream(configFile);
		prop.store(fos, "save information of file");
		
		fos.close();
		fis.close();
	}

}
