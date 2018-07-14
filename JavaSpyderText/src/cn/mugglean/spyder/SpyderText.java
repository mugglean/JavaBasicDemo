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
 * ʹ��Java��ȡ�����ַ
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
		//������ʽ���ܴ���ʶ�������ַ
		String regx="\\w+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";
		List<String> emailList=spyderemail(file,regx);
		for (String list : emailList) {
			System.out.println(list);
		}
	}

	private static List<String> spyderemail(File file, String regx) throws IOException {
		//�ж��ļ��Ƿ����
		if (!(file.exists()&&file.isFile())) {
			return null;
		}
		//����������ʽ����
		Pattern pattern=Pattern.compile(regx);
		//��������
		List<String> emailList=new ArrayList<String>();
		//ʹ������ȡ�ļ�,��ȡ�ļ�+ʹ�û�����
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line=null;
		while((line=br.readLine())!=null) {
			Matcher matcher=pattern.matcher(line);
			//���Ƶ�������������ʽ��ȡ��Ϣʹ�÷���
			while(matcher.find()) {
				emailList.add(matcher.group());
			}
			}
		br.close();
		return emailList;
	}

}
