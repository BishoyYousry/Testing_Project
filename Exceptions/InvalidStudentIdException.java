package Exceptions;

public class InvalidStudentIdException extends Exception{
	
	private static final long serialVersionUID = 1L;
	//Exception Messages
	public static final String INVALID_STUDENT_ID_8Chars = "Student id must consists of 8 chars";
	public static final String INVALID_STUDENT_ID_ALPHANUMERIC = "Student id must contain alphabetic chars";
	public static final String INVALID_STUDENT_ID_START_WITH_NUMBERS = "Student id must start with numbers";
	
	InvalidStudentIdException()
	{
		super();
	}
	
	InvalidStudentIdException(String message)
	{
		super(message);
	}
}
