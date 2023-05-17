package program;

import Exceptions.*;

public class Course {
	private String name;
	private String code;

	public Course() {}
	
	
	public Course(String name, String code) throws  InvalidCourseNameException,InvalidCourseCodeException
	{
		this.setName(name);
		this.setCode(code);
	}


	public String getName() {
		return name;
	}
	public void setName(String name) throws InvalidCourseNameException{
		if(name.charAt(0) == ' ')
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_START_WITH_SPACE);	
		else if(!name.matches("^[a-zA-Z ]+$"))
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC);
		else if(!name.contains(" "))
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_NO_SPACE);
		else 
			this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) throws InvalidCourseCodeException{
		if(code.length() != 6 && code.length() != 7)
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

