
public class Student {
	private String name;
	private String id;
	private int activitiesMark;
	private int oralPracticalMark;
	private int midtermMark;
	private int finalMark;
	private int totalMark;
	private String grade;
	private float gpa;
	
	
	public Student() {
		super();
	}
	
	public Student(String name, String id, String grade, float gpa) {
		super();
		this.name = name;
		this.id = id;
		this.grade = grade;
		this.gpa = gpa;
	}

	public Student(String name, String id, int activitiesMark, int oralPracticalMark, int midtermMark, int finalMark,
			int totalMark) {
		super();
		this.name = name;
		this.id = id;
		this.activitiesMark = activitiesMark;
		this.oralPracticalMark = oralPracticalMark;
		this.midtermMark = midtermMark;
		this.finalMark = finalMark;
		this.totalMark = totalMark;
	}

	public Student(String name, String id, int activitiesMark, int oralPracticalMark, int midtermMark, int finalMark,
			int totalMark, String grade, float gpa) {
		super();
		this.name = name;
		this.id = id;
		this.activitiesMark = activitiesMark;
		this.oralPracticalMark = oralPracticalMark;
		this.midtermMark = midtermMark;
		this.finalMark = finalMark;
		this.totalMark = totalMark;
		this.grade = grade;
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getActivitiesMark() {
		return activitiesMark;
	}
	public void setActivitiesMark(int activitiesMark) {
		this.activitiesMark = activitiesMark;
	}
	public int getOralPracticalMark() {
		return oralPracticalMark;
	}
	public void setOralPracticalMark(int oralPracticalMark) {
		this.oralPracticalMark = oralPracticalMark;
	}
	public int getMidtermMark() {
		return midtermMark;
	}
	public void setMidtermMark(int midtermMark) {
		this.midtermMark = midtermMark;
	}
	public int getFinalMark() {
		return finalMark;
	}
	public void setFinalMark(int finalMark) {
		this.finalMark = finalMark;
	}
	public int getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
}
