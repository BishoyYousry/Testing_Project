import Exceptions.InvalidStudentIdException;
import Exceptions.InvalidStudentNameException;

import program.Student;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class Student_Test {

	private final Student student = new Student();
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp()
	{
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	void Test_SetName_PositiveTesting() {
		
		try {
		student.setName("Bishoy Yousry");
		}catch(InvalidStudentNameException e){
			System.out.println(e);
		}
		String expected = "Bishoy Yousry";
		assertThat(student.getName()).isEqualTo(expected);
	}
	
	@Test
	void Test_SetName_NameStartsWithSpace_ExceptionThrown()
	{
		//Enter a student name that starts with space
		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName(" Bishoy Yousry");	// The name starts with a space
		 });

		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_STARTS_WITH_SPACE;
		    String actualMessage = exception.getMessage();
        assertThat(actualMessage).contains(expectedMessage);
	}
	
	
	@Test
	void Test_SetName_NameWithoutSpaces_ExceptionThrown()
	{
		//Enter a student name that does not have any spaces 
		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName("Bishoy");	// The name does not have spaces
		 });

		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ONE_SPACE;
		    String actualMessage = exception.getMessage();
            assertThat(actualMessage).contains(expectedMessage);
	}
	
	
	@Test
	void Test_SetName_NameHasNumbers_ExceptionThrown()
	{
		//Enter a student name that does not have any spaces 
		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName("Bishoy12");	// The name does not have spaces
		 });
		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ALPHABETS;
		    String actualMessage = exception.getMessage();
			assertThat(actualMessage).contains(expectedMessage);
	}
	
	@Test
	void Test_SetId_PositiveTesting()
	{				
		String expected = "1900733s";
		assertDoesNotThrow(() -> student.setId("1900733s"));
		assertThat(student.getId()).isEqualTo(expected);
	}
	
	
	@Test
	void Test_SetId_IDMustBeAlphanumeric_ExceptionThrown()
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> student.setId("s1900733"));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_DOESNOT_START_WITH_NUMBERS;
	    String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

}