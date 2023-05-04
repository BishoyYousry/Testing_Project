package Exceptions;

public class InvalidStudentNameException extends Exception{
		
	public static final long serialVersionUID = 1L;
	//Exception Messages
	public static final String INVALID_STUDENT_NAME_ALPHABETS = "Student name must be alphabetic characters";
	public static final String INVALID_STUDENT_NAME_ONE_SPACE = "Student name must has at least one space";
	public static final String INVALID_STUDENT_NAME_STARTS_WITH_SPACE = "Student name must not start with space";
	
	public InvalidStudentNameException() {
		super();
	}
	
	public InvalidStudentNameException(String message) {
		super(message);
	}
	
}
