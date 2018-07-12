/*
 * ���и���ļ��ϲ���һ������ʱΪ���������һ���������ʹ��������
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
		//�ж��ļ��治����
		if(!srcFile.exists()) {
			throw new RuntimeException(srcFile.getAbsolutePath()+",Դ�ļ�������");
		}
		if (!destFile.exists()) {
			destFile.mkdir();
		}
		
		//��ȡProperties��Ϣ
		
		//��ȡԴ�ļ����µ�properties�ļ�
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
		
		//��ȡ��׺��
		String filename=prop.getProperty("filename");
		//�������ת�壡��������
		String[] names=filename.split("\\.");
		String endName=names[names.length-1];
		
		
		//������������ϲ��ɼ��ϣ���ʱҪת��Enumeration����Ϊ�������Ĺ��캯����Enumeration
		ArrayList<FileInputStream> a1=new ArrayList<FileInputStream>();
		int filecount=Integer.parseInt(prop.getProperty("filecount"));
		for (int i = 1; i <= filecount; i++) {
			a1.add(new FileInputStream(srcFile.getName()+"\\"+i+".part"));
		}
		Enumeration<FileInputStream> enumeration=Collections.enumeration(a1);
		SequenceInputStream sis=new SequenceInputStream(enumeration);
		
		FileOutputStream fos=new FileOutputStream(destFile.getName()+"\\"+"United."+endName);
		
		//����������
		byte[] buf=new byte[1024*1024];
		int len=0;
		while ((len=sis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		
		
		
		sis.close();
		fos.close();
		
		
	}

}
