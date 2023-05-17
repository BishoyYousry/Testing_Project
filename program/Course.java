package program;

import Exceptions.*;

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
	public void setName(String name) throws InvalidCourseNameException{
		if(!name.matches("^[a-zA-Z ]+$"))
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC);	
		else if(name.charAt(0) == ' ')
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_START_WITH_SPACE);	
		else 
			this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) throws InvalidCourseCodeException{
		if(code.length() != 6 &&code.length() != 7)
			throw new InvalidCourseCodeException(InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN);
		else if(code.length() == 6 && !(code.matches("^[a-zA-Z]{3}[0-9]{3}$")))
			throw new InvalidCourseCodeException(InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN);	
		else if(code.length() == 7 && !(code.matches("^[a-zA-Z]{3}[0-9]{3}[a-zA-Z]{1}$")))
			throw new InvalidCourseCodeException(InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN);
		else if(code.length() == 7 && code.charAt(6)!= 's')
			throw new InvalidCourseCodeException(InvalidCourseCodeException.INVALID_COURSE_CODE_LAST_CHAR);
		else
			this.code = code;
	}
	
}

