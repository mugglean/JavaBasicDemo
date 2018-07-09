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
	 * 获取键盘录入的信息,按照自然排序
	 */
	public static Set<Student> getStudentInfo() throws IOException {
		return getStudentInfo(null);
	}
	/*
	 * 获取键盘录入的信息，按照指定比较器的顺序排序
	 */
	public static Set<Student> getStudentInfo(Comparator<Student> comp) throws IOException {
		//API推荐键盘录入方式
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		Set<Student> stuSet=null;
		if(comp==null) {
			stuSet=new TreeSet<Student>();
		}else {
			stuSet=new TreeSet<Student>(comp);
		}
		String line =null;
		//一行读入信息
		while((line=bufferedReader.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
			String[] strs=line.split(",");
			Student stu=new Student(strs[0], Integer.parseInt(strs[1]), Integer.parseInt(strs[2]), Integer.parseInt(strs[3]));
			stuSet.add(stu);
		}
		//键盘录入流不需要关闭资源，因为后面还需使用
		return stuSet;
	}
	/*
	 * 将键盘录入的信息写人文件中
	 * 抛出RuntimeException，以便在运行时发现
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
