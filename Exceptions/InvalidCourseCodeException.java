package Exceptions;

public class InvalidCourseCodeException extends Exception {
	private static final long serialVersionUID = 1L;

	//Exception Messages
	public static final String INVALID_COURSE_CODE_PATTERN = "Course Code must Start with 3 alphabetic chars then 3 numbers and the last character is s (optional)";
	public static final String INVALID_COURSE_CODE_LAST_CHAR = "Course Code may end with char s only";
	
	InvalidCourseCodeException()
	{
		super();
	}
	
	public InvalidCourseCodeException(String message)
	{
		super(message);
	}
}
