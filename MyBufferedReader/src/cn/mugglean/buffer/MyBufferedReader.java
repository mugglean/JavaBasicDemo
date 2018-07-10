package cn.mugglean.buffer;

import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {
	private Reader reader;
	//记录了数组中元素存在的个数
	private int count=0;
	private int index=0;
	private char[] buffer=new char[1024];
	
	public MyBufferedReader(Reader reader) {
		super();
		this.reader = reader;
	}
	/*
	 * 模拟BufferedReader的read()方法
	 * 直接使用Reader的read方法读取字符到缓冲区数组，如果数组里的元素没有被myRead()方法读完的话就按照数组下标慢慢返回数组中的元素
	 * 如果读完了就再读字符到缓冲区数组，直到没有字符读了为止（即返回-1）
	 * 使用了缓冲区过后，更多的是读数组中的元素操作
	 */
	public int myRead() throws IOException {
		if (count==0) {
			count=reader.read(buffer);
			index=0;
		}
		if (count<0) {
			return -1;
		}
		//每从数组中读一个字符，角标加一，数组中元素个数减一
		char ch=buffer[index];
		count--;
		index++;
		return ch;	
		}
	/*
	 * 模拟BufferedReader的readLine()方法
	 * realine()方法调用了read(),从缓冲区中读取了数据到自己的缓冲区，自己的缓冲区中只存储换行符之前的数据
	 */
	public String myReadLine() throws IOException {
		//readLine()方法有自己的缓冲区数组，使用StringBuilder速度更快
		StringBuilder stringBuilder=new StringBuilder();
		int ch=0;
		while ((ch=myRead())!=-1) {
			//在windows操作系统中，换行符为"\r\n"
			if (ch=='\r') {
				continue;
			}
			if (ch=='\n') {
				return stringBuilder.toString();
			}
			stringBuilder.append((char)ch);
		}
		//如果最后一行有数据但是没有换行符,此时上面的循环已经把数据读到stringBuilder里去了，那么直接返回就好了
		if (stringBuilder.length()!=0) {
			return stringBuilder.toString();
		}
		return null;
	}
	/*
	 * 自己的close方法其实是把类中的Reader流关闭了
	 */
	public void myClose() throws IOException {
		reader.close();
	}
	//下面两个是抽象类的方法，必须覆盖
	@Override
	public void close() throws IOException {
	}

	@Override
	public int read(char[] arg0, int arg1, int arg2) throws IOException {
		
		return 0;
	}

}
