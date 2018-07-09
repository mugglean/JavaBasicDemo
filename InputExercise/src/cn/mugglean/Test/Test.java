package cn.mugglean.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import cn.mugglean.domain.Student;
import cn.mugglean.tool.getInfoTool;

public class Test {

	public static void main(String[] args) throws IOException {
		//创建了一个自然排序相反顺序的比较器
		Comparator<Student> comparator=Collections.reverseOrder();
		Set<Student> students=getInfoTool.getStudentInfo(comparator);
		File file=new File("studentInfo.txt");
		getInfoTool.wtrite2file(students, file);
	}

}
