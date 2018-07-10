/**
 * �Լ�д��LineNumberReader���ܶ�ÿһ�����ݵ�ͬʱ�����к�
 * ֻ��Ҫ�̳�BufferedReader�����ټ���һ������������
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
	//������һ���м�����
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
	 * ���Ǹ����ж�һ�еķ���
	 */
	public  String myReadLine() throws IOException {
		lineNumber++;
		return super.myReadLine();
	}

}
