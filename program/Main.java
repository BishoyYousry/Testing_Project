package program;

import Exceptions.InvalidStudentMarksException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		try {
			student.setActivitiesMark(value);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		} catch (InputMismatchException e)
		{
			System.out.println(e + "hhhhh");
		}
	}
}
