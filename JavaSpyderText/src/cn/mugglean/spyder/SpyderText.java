package cn.mugglean.spyder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 使用Java爬取邮箱地址
 */

/**
 * @author wangchengan
 *
 */
public class SpyderText {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file=new File("SpyderText.html");
		//正则表达式，能粗略识别邮箱地址
		String regx="\\w+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";
		List<String> emailList=spyderemail(file,regx);
		for (String list : emailList) {
			System.out.println(list);
		}
	}

	private static List<String> spyderemail(File file, String regx) throws IOException {
		//判断文件是否存在
		if (!(file.exists()&&file.isFile())) {
			return null;
		}
		//创建正则表达式对象
		Pattern pattern=Pattern.compile(regx);
		//创建集合
		List<String> emailList=new ArrayList<String>();
		//使用流读取文件,读取文件+使用缓冲区
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line=null;
		while((line=br.readLine())!=null) {
			Matcher matcher=pattern.matcher(line);
			//类似迭代器的正则表达式提取信息使用方法
			while(matcher.find()) {
				emailList.add(matcher.group());
			}
			}
		br.close();
		return emailList;
	}

}
