package program;
import Exceptions.*; 

public class Student {
	private String name;
	private String id;
	private int activitiesMark;
	private int oralPracticalMark;
	private int midtermMark;
	private int finalMark;
	private int totalMark;
	private String grade;
	private String gpa;
	
	
	public Student() {
		super();
	}
	
	public Student(String name, String id, String grade, String gpa) {
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
			int totalMark, String grade, String gpa) {
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
	
	/* @Function Name: setName
	 * 
	 * @Inputs: Student name
	 * 
	 * @Description: Set the student name if the following conditions are achieved:
	 *  			  1- student name must be Alphabetic characters
	 *  			  2- has at least one space
	 *  			  3- should not start with space
	 * */
	
	public void setName(String name) throws InvalidStudentNameException{		
		if(!name.matches("[a-zA-Z ]+"))
			throw new InvalidStudentNameException(InvalidStudentNameException.INVALID_STUDENT_NAME_ALPHABETS);		
		if(name.charAt(0) == ' ')
			throw new InvalidStudentNameException(InvalidStudentNameException.INVALID_STUDENT_NAME_STARTS_WITH_SPACE);
		if(!name.contains(" "))
			throw new InvalidStudentNameException(InvalidStudentNameException.INVALID_STUDENT_NAME_ONE_SPACE);
		else
			this.name = name;
			
	}
	
	
	public String getId() {
		return id;
	}
	
	/* @Function Name: setId
	 * 
	 * @Inputs: Student id
	 * 
	 * @Description: Set the student id if the following conditions are achieved:
	 *  			1- Student Id must be alphanumeric characters
	 *  			2- Student Id length = 8 chars
	 *  			3- Student Id should start with numbers, and might end with only one alphabetic character
	 * */
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
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	
}
