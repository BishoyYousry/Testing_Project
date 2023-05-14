import Exceptions.InvalidStudentIdException;
import Exceptions.InvalidStudentMarksException;
import Exceptions.InvalidStudentNameException;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import program.Student;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

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
	void Test_SetName_NameIsAnIntegerValue() {
		String expected = "12";
		InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () -> {
			student.setName(expected);
		});
		String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ALPHABETS;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
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
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_DOES_NOT_START_WITH_NUMBERS;
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
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, () ->
				student.setId(""));
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_INVALID_LENGTH;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	void Test_setActivitiesMark_NormalValue_PositiveTesting()
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
	@Tag("BVA_strategy")
	void Test_setActivitiesMark_LowerBoundValue_PositiveTesting()
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
	@Tag("BVA_strategy")
	void Test_setActivitiesMark_UpperBoundValue_PositiveTesting()
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
	@Tag("BVA_strategy")
	void Test_setActivitiesMark_OutLowerBoundValue_ExceptionThrown()
	{
		assertThrows(InvalidStudentMarksException.class, () -> student.setActivitiesMark(-1));
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	void Test_setActivitiesMark_OutUpperBoundValue_ExceptionThrown()
	{
		assertThrows(InvalidStudentMarksException.class, () -> student.setActivitiesMark(11));
	}


	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {0, 5, 10})
	void Test_setOralPracticalMark_positiveTesting(int oralPracticalMark)
	{
		try {
			student.setOralPracticalMark(oralPracticalMark);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
		int actual = student.getOralPracticalMark();
		int expected = oralPracticalMark;
		assertThat(actual).isEqualTo(expected);
	}

	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {-1, 11})
	void Test_setOralPracticalMark_EnterValuesOutOfBounds_ExceptionThrown(int oralPracticalMark)
	{
		assertThrows(InvalidStudentMarksException.class, () ->
				student.setOralPracticalMark(oralPracticalMark));
	}

	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {0, 10, 20})
	void Test_setMidtermMark_positiveTesting(int midtermMark)
	{
		try {
			student.setMidtermMark(midtermMark);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
		int actual = student.getMidtermMark();
		int expected = midtermMark;
		assertThat(actual).isEqualTo(expected);
	}


	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {-1, 21})
	void Test_setMidtermMark_EnterValuesOutOfBounds_ExceptionThrown(int midtermMark)
	{
		assertThrows(InvalidStudentMarksException.class, ()->student.setMidtermMark(midtermMark));
	}


	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {0, 30, 60})
	void Test_setFinalMark_positiveTesting(int finalMark)
	{
		try {
			student.setFinalMark(finalMark);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
		int actual = student.getFinalMark();
		int expected = finalMark;
		assertThat(actual).isEqualTo(expected);
	}

	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {-1, 61})
	void Test_setFinalMark_EnterValuesOutOfBounds_ExceptionThrown(int finalMark)
	{
		assertThrows(InvalidStudentMarksException.class, ()->student.setMidtermMark(finalMark));
	}


	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {0, 50, 100})
	void Test_setTotalMark_positiveTesting(int totalMark)
	{
		try {
			student.setTotalMark(totalMark);
		} catch (InvalidStudentMarksException e) {
			e.printStackTrace();
		}
		int actual = student.getTotalMark();
		int expected = totalMark;
		assertThat(actual).isEqualTo(expected);
	}


	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {-1, 101})
	void Test_setTotalMark_EnterValuesOutOfBounds_ExceptionThrown(int totalMark)
	{
		assertThrows(InvalidStudentMarksException.class, ()->student.setMidtermMark(totalMark));
	}

}