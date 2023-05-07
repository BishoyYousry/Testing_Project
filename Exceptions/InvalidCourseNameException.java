package Exceptions;

public class InvalidCourseNameException extends Exception{
	private static final long serialVersionUID = 1L;

	//Exception Messages
	public static final String INVALID_COURSE_NAME_START_WITH_SPACE = "Course Name must Start with alphabetic chars";
	public static final String INVALID_COURSE_NAME_ALPHABETIC = "Course Name must contain alphabetic chars only";
	
	public InvalidCourseNameException()
	{
		super();
	}
	
	public InvalidCourseNameException(String message)
	{
		super(message);
	}
}
