package program;

import Exceptions.InvalidStudentMarksException;

public class Main {
	public static void main(String args[])
	{
		Student student = new Student();
		Integer value = null;
		try {
			student.setActivitiesMark(value);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
	}
}
