package cn.mugglean.buffer;

import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {
	private Reader reader;
	//��¼��������Ԫ�ش��ڵĸ���
	private int count=0;
	private int index=0;
	private char[] buffer=new char[1024];
	
	public MyBufferedReader(Reader reader) {
		super();
		this.reader = reader;
	}
	/*
	 * ģ��BufferedReader��read()����
	 * ֱ��ʹ��Reader��read������ȡ�ַ������������飬����������Ԫ��û�б�myRead()��������Ļ��Ͱ��������±��������������е�Ԫ��
	 * ��������˾��ٶ��ַ������������飬ֱ��û���ַ�����Ϊֹ��������-1��
	 * ʹ���˻��������󣬸�����Ƕ������е�Ԫ�ز���
	 */
	public int myRead() throws IOException {
		if (count==0) {
			count=reader.read(buffer);
			index=0;
		}
		if (count<0) {
			return -1;
		}
		//ÿ�������ж�һ���ַ����Ǳ��һ��������Ԫ�ظ�����һ
		char ch=buffer[index];
		count--;
		index++;
		return ch;	
		}
	/*
	 * ģ��BufferedReader��readLine()����
	 * realine()����������read(),�ӻ������ж�ȡ�����ݵ��Լ��Ļ��������Լ��Ļ�������ֻ�洢���з�֮ǰ������
	 */
	public String myReadLine() throws IOException {
		//readLine()�������Լ��Ļ��������飬ʹ��StringBuilder�ٶȸ���
		StringBuilder stringBuilder=new StringBuilder();
		int ch=0;
		while ((ch=myRead())!=-1) {
			//��windows����ϵͳ�У����з�Ϊ"\r\n"
			if (ch=='\r') {
				continue;
			}
			if (ch=='\n') {
				return stringBuilder.toString();
			}
			stringBuilder.append((char)ch);
		}
		//������һ�������ݵ���û�л��з�,��ʱ�����ѭ���Ѿ������ݶ���stringBuilder��ȥ�ˣ���ôֱ�ӷ��ؾͺ���
		if (stringBuilder.length()!=0) {
			return stringBuilder.toString();
		}
		return null;
	}
	/*
	 * �Լ���close������ʵ�ǰ����е�Reader���ر���
	 */
	public void myClose() throws IOException {
		reader.close();
	}
	//���������ǳ�����ķ��������븲��
	@Override
	public void close() throws IOException {
	}

	@Override
	public int read(char[] arg0, int arg1, int arg2) throws IOException {
		
		return 0;
	}

}
