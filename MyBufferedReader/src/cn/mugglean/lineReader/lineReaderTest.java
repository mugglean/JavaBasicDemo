/**
 * 
 */
package cn.mugglean.lineReader;

import java.io.FileReader;
import java.io.IOException;


/**
 * @author wangchengan
 *
 */
public class lineReaderTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MyLineNumberReader lineNumberReader=new MyLineNumberReader(new FileReader("IO²âÊÔÎÄ¼ş.txt"));
		String str=null;
		while ((str=lineNumberReader.myReadLine())!=null) {
			System.out.println(lineNumberReader.getLineNumber()+":  "+str);
		}
		lineNumberReader.myClose();
	}

}
