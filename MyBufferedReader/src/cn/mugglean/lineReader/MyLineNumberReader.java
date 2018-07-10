/**
 * 自己写的LineNumberReader，能读每一行数据的同时加上行号
 * 只需要继承BufferedReader而后再加上一个计数器即可
 */
package cn.mugglean.lineReader;

import java.io.IOException;
import java.io.Reader;

import cn.mugglean.buffer.MyBufferedReader;

/**
 * @author wangchengan
 *
 */
public class MyLineNumberReader extends MyBufferedReader {
	//定义了一个行计数器
	private int lineNumber=0;
	public MyLineNumberReader(Reader reader) {
		super(reader);
	}	
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	/*
	 * 覆盖父类中读一行的方法
	 */
	public  String myReadLine() throws IOException {
		lineNumber++;
		return super.myReadLine();
	}

}
