/*
 * 将切割的文件合并成一个，此时为多个输入流一个输出流，使用序列流
 */

package cn.mugglean.FileStract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

public class FileStractDemo {

	public static void main(String[] args) throws IOException {
		File srcFile=new File("tempfile");
		File destFile=new File("combinationfile");
		stractFile(srcFile,destFile);

	}
	
	public static void stractFile(File srcFile, File destFile) throws FileNotFoundException, IOException {
		//判断文件存不存在
		if(!srcFile.exists()) {
			throw new RuntimeException(srcFile.getAbsolutePath()+",源文件不存在");
		}
		if (!destFile.exists()) {
			destFile.mkdir();
		}
		
		//读取Properties信息
		
		//获取源文件夹下的properties文件
		File propfile=null;
		File[] files=srcFile.listFiles();
		for (File fileInsrc : files) {
			if (fileInsrc.getName().endsWith(".properties")) {
				propfile=fileInsrc;
			}
		}
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(propfile);
		prop.load(fis);
		fis.close();
		
		//抽取后缀名
		String filename=prop.getProperty("filename");
		//必需加上转义！！！！！
		String[] names=filename.split("\\.");
		String endName=names[names.length-1];
		
		
		//将多个输入流合并成集合，此时要转成Enumeration，因为序列流的构造函数是Enumeration
		ArrayList<FileInputStream> a1=new ArrayList<FileInputStream>();
		int filecount=Integer.parseInt(prop.getProperty("filecount"));
		for (int i = 1; i <= filecount; i++) {
			a1.add(new FileInputStream(srcFile.getName()+"\\"+i+".part"));
		}
		Enumeration<FileInputStream> enumeration=Collections.enumeration(a1);
		SequenceInputStream sis=new SequenceInputStream(enumeration);
		
		FileOutputStream fos=new FileOutputStream(destFile.getName()+"\\"+"United."+endName);
		
		//缓冲区数组
		byte[] buf=new byte[1024*1024];
		int len=0;
		while ((len=sis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		
		
		
		sis.close();
		fos.close();
		
		
	}

}
