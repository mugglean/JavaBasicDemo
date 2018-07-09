package cn.mugglean.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import cn.mugglean.domain.Student;

public class getInfoTool {
	/*
	 * ��ȡ����¼�����Ϣ,������Ȼ����
	 */
	public static Set<Student> getStudentInfo() throws IOException {
		return getStudentInfo(null);
	}
	/*
	 * ��ȡ����¼�����Ϣ������ָ���Ƚ�����˳������
	 */
	public static Set<Student> getStudentInfo(Comparator<Student> comp) throws IOException {
		//API�Ƽ�����¼�뷽ʽ
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		Set<Student> stuSet=null;
		if(comp==null) {
			stuSet=new TreeSet<Student>();
		}else {
			stuSet=new TreeSet<Student>(comp);
		}
		String line =null;
		//һ�ж�����Ϣ
		while((line=bufferedReader.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
			String[] strs=line.split(",");
			Student stu=new Student(strs[0], Integer.parseInt(strs[1]), Integer.parseInt(strs[2]), Integer.parseInt(strs[3]));
			stuSet.add(stu);
		}
		//����¼��������Ҫ�ر���Դ����Ϊ���滹��ʹ��
		return stuSet;
	}
	/*
	 * ������¼�����Ϣд���ļ���
	 * �׳�RuntimeException���Ա�������ʱ����
	 */
	public static void wtrite2file(Set<Student> studentSet,File destFile) throws IOException {
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(destFile));
			for (Student student : studentSet) {
				bw.write(student.getName()+" "+student.getSumScore());
				bw.newLine();
				bw.flush();
			}
			
		} finally {
			if (bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}

}
