package Exceptions;

public class InvalidStudentIdException extends Exception{
	
	private static final long serialVersionUID = 1L;
	//Exception Messages]
	public static final String INVALID_STUDENT_ID_INVALID_LENGTH = "Student id must consists of 8 chars";
	public static final String INVALID_STUDENT_ID_ALPHANUMERIC = "Student id must contain alphanumeric char or number";
	public static final String INVALID_STUDENT_ID_DOES_NOT_START_WITH_NUMBERS = "Student id must start with numbers";
	public static final String INVALID_STUDENT_ID_GENERAL = "Invalid Student id";
	public static final String INVALID_STUDENT_ID_REPEATED = "Invalid Student ID - The ID is repeated";
	
	public InvalidStudentIdException()
	{
		super();
	}
	
	public InvalidStudentIdException(String message)
	{
		super(message);
	}
}