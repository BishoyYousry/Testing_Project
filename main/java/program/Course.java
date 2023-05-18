package program;

import Exceptions.*;

public class Course {
	private String name;
	private String code;
	private String maxMark;
	public Course()
	{
		this.name = "";
		this.code= "";
		this.maxMark="";
	}
	
	
	public Course(String name, String code,String maxMark) throws  InvalidCourseNameException,InvalidCourseCodeException,InvalidCourseMarkException
	{
		this.setName(name);
		this.setCode(code);
		this.setMaxMark(maxMark);
	}
	public void setMaxMark(String maxMark) throws InvalidCourseMarkException {
		if(!maxMark.equals("100"))
			throw new InvalidCourseMarkException(InvalidCourseMarkException.INVALID_COURSE_MARK);
		else
      		this.maxMark=maxMark;
	}

	public String getMaxMark(){
		return this.maxMark;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) throws InvalidCourseNameException{
		if(!name.matches("^[a-zA-Z ]+$"))
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC);	
		else if(name.charAt(0) == ' ')
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_START_WITH_SPACE);
		else if(!name.contains(" "))
			throw new InvalidCourseNameException(InvalidCourseNameException.INVALID_COURSE_NAME_ONE_SPACE);
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
		else if(code.length() == 7 && !(code.matches("^[a-zA-Z]{3}[0-9]{3}[a-zA-Z]$")))
			throw new InvalidCourseCodeException(InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN);
		else if(code.length() == 7 && code.charAt(6)!= 's')
			throw new InvalidCourseCodeException(InvalidCourseCodeException.INVALID_COURSE_CODE_LAST_CHAR);
		else
			this.code = code;
	}
	
}

