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
	
	public Student(String name, String id, String grade, String gpa) throws InvalidStudentIdException,
			InvalidStudentNameException {
		super();
		this.setName(name);
		this.setId(id);
		this.setGrade(grade);
		this.setGpa(gpa);
	}

	public Student(String name, String id, int activitiesMark, int oralPracticalMark, int midtermMark, int finalMark,
			int totalMark) throws InvalidStudentNameException, InvalidStudentIdException,
			InvalidStudentMarksException {
		super();
		this.setName(name);
		this.setId(id);
		this.setActivitiesMark(activitiesMark);
		this.setOralPracticalMark(oralPracticalMark);
		this.setMidtermMark(midtermMark);
		this.setFinalMark(finalMark);
		this.setTotalMark(totalMark);
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
	 *  			1- 8 (numeric characters) or (7 numeric characters +1 alphabetic char)(12345678 or 1234567D)
	 *  			2- Student id should start with numbers, and might end with only one alphabetic character
	 * */
	
	public void setId(String id) throws InvalidStudentIdException {
		if(id.length()!= 8)
			throw new InvalidStudentIdException(InvalidStudentIdException.INVALID_STUDENT_ID_INVALID_LENGTH);
		else if(id.charAt(0)<'0'|| id.charAt(0)>'9')
			throw new InvalidStudentIdException(InvalidStudentIdException.INVALID_STUDENT_ID_DOES_NOT_START_WITH_NUMBERS );
		else if((id.charAt(7)<'0'||id.charAt(7)>'9')&&(id.charAt(7)<'a'||id.charAt(7)>'z')&&(id.charAt(7)<'A'||id.charAt(7)>'Z'))
			throw new InvalidStudentIdException(InvalidStudentIdException.INVALID_STUDENT_ID_ALPHANUMERIC );
		else if((id.charAt(1)<'0'||id.charAt(1)>'9')||(id.charAt(2)<'0'||id.charAt(2)>'9')||(id.charAt(3)<'0'||id.charAt(3)>'9')||(id.charAt(4)<'0'||id.charAt(4)>'9')||(id.charAt(5)<'0'||id.charAt(5)>'9')||(id.charAt(6)<'0'||id.charAt(6)>'9'))
			throw new InvalidStudentIdException(InvalidStudentIdException.INVALID_STUDENT_ID_GENERAL);
		else
			this.id = id;
	}
	
	public int getActivitiesMark(){
		return activitiesMark;
	}
	public void setActivitiesMark(int activitiesMark) throws InvalidStudentMarksException{
		if (activitiesMark<0 || activitiesMark>10)
			throw new InvalidStudentMarksException(InvalidStudentMarksException.INVALID_STUDENT_ACTIVITIES_MARK);
		else
			this.activitiesMark = activitiesMark;
	}
	public int getOralPracticalMark() {
		return oralPracticalMark;
	}
	public void setOralPracticalMark(int oralPracticalMark)throws InvalidStudentMarksException {
		if(oralPracticalMark<0 || oralPracticalMark>10)
			throw new InvalidStudentMarksException(InvalidStudentMarksException.INVALID_STUDENT_ORAL_PRACTICAL_MARK);
		else
			this.oralPracticalMark = oralPracticalMark;
	}
	public int getMidtermMark() {
		return midtermMark;
	}
	public void setMidtermMark(int midtermMark)throws InvalidStudentMarksException {
		if(midtermMark<0 || midtermMark>20)
			throw new InvalidStudentMarksException(InvalidStudentMarksException.INVALID_STUDENT_MIDTERM_MARK);
		else
			this.midtermMark = midtermMark;
	}
	public int getFinalMark() {
		return finalMark;
	}
	public void setFinalMark(int finalMark) throws InvalidStudentMarksException{
		if(finalMark<0 || finalMark>60)
			throw new InvalidStudentMarksException(InvalidStudentMarksException.INVALID_STUDENT_FINAL_MARK);
		else
			this.finalMark = finalMark;		
	}
	public int getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(int totalMark)throws InvalidStudentMarksException {
		if(totalMark<0 || totalMark>100)
			throw new InvalidStudentMarksException(InvalidStudentMarksException.INVALID_STUDENT_TOTAL_MARK);
		else
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