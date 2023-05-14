import Exceptions.InvalidStudentIdException;
import Exceptions.InvalidStudentMarksException;
import Exceptions.InvalidStudentNameException;

import org.junit.jupiter.api.Tag;
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
	@Tag("unit")
	@Tag("blackbox")
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
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetName_NameStartsWithSpace_ExceptionThrown()
	{

		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName(" Bishoy Yousry");	// The name starts with a space
		 });

		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_STARTS_WITH_SPACE;
		    String actualMessage = exception.getMessage();
        	assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetName_NameIsEmpty_ExceptionThrown()
	{

		InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			student.setName("");
		});

		String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ALPHABETS;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetName_NameWithoutSpaces_ExceptionThrown()
	{

		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName("Bishoy");	// The name does not have spaces
		 });

		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ONE_SPACE;
		    String actualMessage = exception.getMessage();
            assertThat(actualMessage).contains(expectedMessage);
	}
	
	
	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetName_NameHasNumbers_ExceptionThrown()
	{
		 InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			 student.setName("Bishoy12");	// The name contain numbers
		 });
		    String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ALPHABETS;
		    String actualMessage = exception.getMessage();
			assertThat(actualMessage).contains(expectedMessage);
	}
	
	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetId_PositiveTesting()
	{				
		String expected = "1900733s";
		assertDoesNotThrow(() -> student.setId("1900733s"));
		assertThat(student.getId()).isEqualTo(expected);
	}
	
	
	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetId_IDStartsWithAlphabet_ExceptionThrown()
	{

		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> student.setId("s1900733"));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_DOES_NOT_START_WITH_NUMBERS;
	    String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}





	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetId_IDLengthLessThan8chars_ExceptionThrown()
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> student.setId("1900"));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_INVALID_LENGTH;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetId_IDEndsWithTwoAlphabets_ExceptionThrown()
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> student.setId("123456ss"));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_GENERAL;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetId_IdDoesNotContainAnyNumber_ExceptionThrown()
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> student.setId("abcdefgh"));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_ALPHANUMERIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetId_IdContainSpecialChars_ExceptionThrown()
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> student.setId("123?5678"));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_GENERAL;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetId_IdIsEmpty_ExceptionThrown()
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () -> student.setId(""));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_INVALID_LENGTH;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	@Tag("boundary")
	void Test_setActivitiesMarkNormalValue_PositiveTesting()
	{
		int expected = 5;
		try {
			student.setActivitiesMark(5);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
		double actual = student.getActivitiesMark();
		assertThat(expected).isEqualTo(actual);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	@Tag("boundary")
	void Test_setActivitiesMarkLowerBoundValue_PositiveTesting()
	{
		int expected = 0;
		try {
			student.setActivitiesMark(0);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
		double actual = student.getActivitiesMark();
		assertThat(expected).isEqualTo(actual);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	@Tag("boundary")
	void Test_setActivitiesMarkUpperBoundValue_PositiveTesting()
	{
		int expected = 10;
		try {
			student.setActivitiesMark(10);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
		double actual = student.getActivitiesMark();
		assertThat(expected).isEqualTo(actual);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	@Tag("boundary")
	void Test_setActivitiesMarkOutLowerBoundValue_ExceptionThrown()
	{
		InvalidStudentMarksException exception = assertThrows(InvalidStudentMarksException.class, () ->
				student.setActivitiesMark(-1));
		String expectedMessage = InvalidStudentMarksException.INVALID_STUDENT_ACTIVITIES_MARK;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	@Tag("boundary")
	void Test_setActivitiesMarkOutUpperBoundValue_ExceptionThrown()
	{
		InvalidStudentMarksException exception = assertThrows(InvalidStudentMarksException.class, () ->
				student.setActivitiesMark(11));
		String expectedMessage = InvalidStudentMarksException.INVALID_STUDENT_ACTIVITIES_MARK;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setActivitiesMarkEmptyValue_ExceptionThrown()
	{
		Integer value = null;
		InvalidStudentMarksException exception = assertThrows(InvalidStudentMarksException.class, () ->
				student.setActivitiesMark(value));
		String expectedMessage = InvalidStudentMarksException.INVALID_STUDENT_ACTIVITIES_MARK;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setActivitiesMarkFloatValue_ExceptionThrown()
	{
		double value = 5.5;
		InvalidStudentMarksException exception = assertThrows(InvalidStudentMarksException.class, () ->
				student.setActivitiesMark(value));
		String expectedMessage = InvalidStudentMarksException.INVALID_STUDENT_ACTIVITIES_MARK;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

}