
public class Course {
	private String name;
	private String code;
	private final int activitiesFullMark;
	private final int oralPracticalFullMark;
	private final int midtermFullMark;
	private final int finalFullMark;
	private final int totalFullMark;


	public Course() {
		super();
		activitiesFullMark = 10;
		oralPracticalFullMark = 10;
		midtermFullMark = 20;
		finalFullMark = 60;
		totalFullMark = 100;
	}
	
	
	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;
		activitiesFullMark = 10;
		oralPracticalFullMark = 10;
		midtermFullMark = 20;
		finalFullMark = 60;
		totalFullMark = 100;
	}


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

