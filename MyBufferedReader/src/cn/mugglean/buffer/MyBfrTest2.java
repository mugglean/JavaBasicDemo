/**
 * 
 */
package cn.mugglean.buffer;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author wangchengan
 *
 */
public class MyBfrTest2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MyBufferedReader myBufferedReader=new MyBufferedReader(new FileReader("IO²âÊÔÎÄ¼þ.txt"));
		String str=null;
		while ((str=myBufferedReader.myReadLine())!=null) {
			System.out.println(str);
		}
		myBufferedReader.myClose();
	}

}
