/**
 * 
 */
package cn.mugglean.domain;


/**
 * @author wangchengan
 *
 */
public class Student implements Comparable<Student>{
	private String name;
	private int mathScore;
	private int chineseScore;
	private int englishScore;
	private int sumScore;
	public Student(String name, int mathScore, int chineseScore, int englishScore) {
		super();
		this.name = name;
		this.mathScore = mathScore;
		this.chineseScore = chineseScore;
		this.englishScore = englishScore;
		this.sumScore=mathScore+chineseScore+englishScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getChineseScore() {
		return chineseScore;
	}
	public void setChineseScore(int chineseScore) {
		this.chineseScore = chineseScore;
	}
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	public int getSumScore() {
		return sumScore;
	}
	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sumScore;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sumScore != other.sumScore)
			return false;
		return true;
	}
	@Override
	//自然排序方法为升序排序
	public int compareTo(Student stu) {
		int temp=this.sumScore-stu.sumScore;
		return temp==0?this.name.compareTo(stu.name):temp;
	}
	
	
}
