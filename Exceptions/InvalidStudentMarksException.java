package Exceptions;

public class InvalidStudentMarksException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//Exception Messages
	public static final String INVALID_STUDENT_ACTIVITIES_MARK = "Student activities mark range must be between 0 to 10";
	public static final String INVALID_STUDENT_ORAL_PRACTICAL_MARK = "Student oral practical mark range must be between 0 to 10";
	public static final String INVALID_STUDENT_MIDTERM_MARK = "Student activities range must be between 0 to 20";
	public static final String INVALID_STUDENT_FINAL_MARK = "Student activities range must be between 0 to 60";
	public static final String INVALID_STUDENT_TOTOAL_MARK = "Student activities range must be between 0 to 100";
	
	InvalidStudentMarksException(){
		super();
	}
	
	public InvalidStudentMarksException(String message)
	{
		super(message);
	}

}