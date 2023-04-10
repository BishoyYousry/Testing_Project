package Courses_and_Students;

public class Course {
	private String name;
	private String code;
	private static int activitiesFullMark;
	private static int oralPracticalFullMark;
	private static int midtermFullMark;
	private static int finalFullMark;
	private static int totalFullMark;

	public Course(String name, String code, int activitiesFullMark, int oralPracticalFullMark, int midtermFullMark,
			int finalFullMark, int totalFullMark) {
		super();
		this.name = name;
		this.code = code;
		this.activitiesFullMark = activitiesFullMark;
		this.oralPracticalFullMark = oralPracticalFullMark;
		this.midtermFullMark = midtermFullMark;
		this.finalFullMark = finalFullMark;
		this.totalFullMark = totalFullMark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
