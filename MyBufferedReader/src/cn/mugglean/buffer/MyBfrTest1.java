
package cn.mugglean.buffer;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author wangchengan
 *
 */
public class MyBfrTest1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MyBufferedReader myBufferedReader=new MyBufferedReader(new FileReader("IO²âÊÔÎÄ¼þ.txt"));
		int ch=0;
		while ((ch=myBufferedReader.myRead())!=-1) {
			System.out.print((char)ch);
		}
		myBufferedReader.myClose();
	}

}
