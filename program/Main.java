package program;

import Exceptions.InvalidStudentNameException;

public class Main {
	public static void main(String args[])
	{
		Student student = new Student();
		try {
			student.setName(" Bishoy Yousry");
		} catch (InvalidStudentNameException e) {			
			System.out.println(e);
		}
		System.out.println(student.getName());
	}
}
