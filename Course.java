package Pack1;

public class Course {
	private String name;
	private String code;
	static final int activitiesFullMark = 10;
	static private final int oralPracticalFullMark = 10;
	static private final int midtermFullMark = 20;
	static private final int finalFullMark = 60;
	static private final int totalFullMark = 100;

	public Course()
	{
		
	}
	
	
	public Course(String name, String code) {
		this.name = name;
		this.code = code;
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

