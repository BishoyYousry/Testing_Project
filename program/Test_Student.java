package program;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.InvalidStudentIdException;
import Exceptions.InvalidStudentNameException;

class Test_Student {

	private Student student = new Student();
	
	
	@Test
	void test_setName_PositiveTesting() {
		
		try {
		student.setName("Bishoy Yousry");
		}catch(InvalidStudentNameException e){
			System.out.println(e);
		}
		String expected = "Bishoy Yousry";
		assertEquals(expected, student.getName(), "Test_Student::test_setName_PositiveTesting");
	}
	
	@Test
	void test_setName_NameStartsWithSpace()
	{
		//Enter a student name that starts with space
		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName(" Bishoy Yousry");	// The name starts with a space
		 });

		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_STARTS_WITH_SPACE;
		    String actualMessage = exception.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage), "Test_Student::test_setName_NameStartsWithSpace");		    		    		    		
	}
	
	
	@Test
	void test_setName_NameDoesnothaveSpaces()
	{
		//Enter a student name that does not have any spaces 
		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName("Bishoy");	// The name does not have spaces
		 });

		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ONE_SPACE;
		    String actualMessage = exception.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage), "Test_Student::test_setName_NameDoesnothaveSpaces");		    		    		    		
	}
	
	
	@Test
	void test_setName_NameHasNumbers()
	{
		//Enter a student name that does not have any spaces 
		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName("Bishoy12");	// The name does not have spaces
		 });

		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ALPHABETS;
		    String actualMessage = exception.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage), "Test_Student::test_setName_NameHasNumbers");		    		    		    		
	}
	
	@Test
	void test_setId_PositiveTesting()
	{
		String expected = "1900733s";
		student.setId("1900733s");
		assertEquals(expected, student.getId(), "Test_Student::test_setId_PositiveTesting");
	}
	
	
	@Test
	void test_setId_IDMustBeAlphanumeric()
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> {
			student.setId("s1900733");
		});
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_ALPHANUMERIC;
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage), "Test_Student::test_setId_IDMustBeAlphanumeric");
	}
	
}
