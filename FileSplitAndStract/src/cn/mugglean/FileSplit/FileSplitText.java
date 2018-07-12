/**
 * 文件切割，一个输入流，多个输出流
 * 注意：切割出来的文件后面还需要配置文件，因为要记录后缀名和文件个数以便在文件合并时使用
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
		//先判断源文件和目的文件对象存不存在
		if(!srcFile.exists()) {
			throw new RuntimeException(srcFile.getAbsolutePath()+",源文件不存在");
		}
		if (!destFile.exists()) {
			destFile.mkdir();
		}
		
		//一个输入流，为字节流
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = null;
		
		//缓冲数组
		byte[] buf=new byte[1024*1024];
		//往缓冲区存数据
		int count=0;
		int len=0;
		while((len=fis.read(buf))!=-1) {
			File partFile=new File(destFile, (++count)+".part");
			fos=new FileOutputStream(partFile);
			fos.write(buf, 0, len);
			fos.close();
		}
		//存储配置信息，应该使用Properties集合
		Properties prop=new Properties();
		prop.setProperty("filename", srcFile.getName());
		prop.setProperty("filecount", Integer.toString(count));
		
		//写properties文件，要定义输出流
		File configFile=new File(destFile,(++count)+".properties");
		fos=new FileOutputStream(configFile);
		prop.store(fos, "save information of file");
		
		fos.close();
		fis.close();
	}

}
