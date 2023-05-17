import Exceptions.InvalidStudentIdException;
import Exceptions.InvalidStudentMarksException;
import Exceptions.InvalidStudentNameException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

	/*
	 ************************************************************
	 ************************************************************
	 * The following Test cases are related to BlackBox Testing
	 ************************************************************
	 ************************************************************
	 */


	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_Student_TestConstructor1PositiveTesting() {

		Student student1 = null;
		try {
			student1 = new Student("Dalia Assad", "1900688s", "A+", "4");
		} catch (InvalidStudentIdException | InvalidStudentNameException e) {
			e.printStackTrace();
		}
		assert student1 != null;
		assertThat(student1.getName()).isEqualTo("Dalia Assad");
		assertThat(student1.getId()).isEqualTo("1900688s");
		assertThat(student1.getGrade()).isEqualTo("A+");
		assertThat(student1.getGpa()).isEqualTo("4");
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_Student_TestConstructor1EnterInvalidNameAndId_MustThrowTwoExceptions() {
		try {
			new Student("Dalia", "1900688", "A+", "4");
		} catch (InvalidStudentIdException e) {
			String actualMessage2 = e.getMessage();
			String expectedMessage2 = InvalidStudentIdException.INVALID_STUDENT_ID_INVALID_LENGTH;
			assertThat(expectedMessage2).isEqualTo(actualMessage2);
		} catch (InvalidStudentNameException e) {
			String expectedMessage1 = InvalidStudentNameException.INVALID_STUDENT_NAME_ONE_SPACE;
			String actualMessage1 = e.getMessage();
			assertThat(expectedMessage1).isEqualTo(actualMessage1);
		}


	}


	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_Student_TestConstructor2PositiveTesting() {
		Student student1 = null;
		try {
			student1 = new Student("Dalia Assad", "1900688s", 5, 0, 20, 60, 1);
		} catch (InvalidStudentNameException | InvalidStudentMarksException | InvalidStudentIdException e) {
			e.printStackTrace();
		}
		assert student1 != null;
		assertThat(student1.getName()).isEqualTo("Dalia Assad");
		assertThat(student1.getId()).isEqualTo("1900688s");
		assertThat(student1.getActivitiesMark()).isEqualTo(5);
		assertThat(student1.getOralPracticalMark()).isEqualTo(0);
		assertThat(student1.getMidtermMark()).isEqualTo(20);
		assertThat(student1.getFinalMark()).isEqualTo(60);
		assertThat(student1.getTotalMark()).isEqualTo(1);
	}



	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_Student_TestConstructor2EnterInvalidName_Id_Midterm_FinalMarks_ThrowExceptions() {
		try {
			new Student(" Mido ", "?@", 5, 0, -1, 61, 100);
		} catch (InvalidStudentNameException e) {
			String actualMessage = e.getMessage();
			String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_STARTS_WITH_SPACE;
			assertThat(actualMessage).isEqualTo(expectedMessage);
		} catch (InvalidStudentIdException e) {
			String actualMessage = e.getMessage();
			String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_DOES_NOT_START_WITH_NUMBERS;
			assertThat(actualMessage).isEqualTo(expectedMessage);
		} catch (InvalidStudentMarksException e) {
			String actualMessage = e.getMessage();
			String expectedMessage = InvalidStudentMarksException.INVALID_STUDENT_MIDTERM_MARK;
			assertThat(actualMessage).isEqualTo(expectedMessage);
		}

	}




	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetName_PositiveTesting() {
		try {
		student.setName("Bishoy Yousry");
		}catch(InvalidStudentNameException e){
			e.printStackTrace();
		}
		String expected = "Bishoy Yousry";
		assertThat(student.getName()).isEqualTo(expected);
	}


	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_SetName_NameIsAnIntegerValue() {
		String expected = "12";
		InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () ->
			student.setName(expected));
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

		InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class, () ->
				student.setName(""));

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
		int actual = student.getActivitiesMark();
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
		int actual = student.getActivitiesMark();
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
		int actual = student.getActivitiesMark();
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
		assertThat(actual).isEqualTo(oralPracticalMark);
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
		assertThat(actual).isEqualTo(midtermMark);
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
		assertThat(actual).isEqualTo(finalMark);
	}

	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {-1, 61})
	void Test_setFinalMark_EnterValuesOutOfBounds_ExceptionThrown(int finalMark)
	{
		assertThrows(InvalidStudentMarksException.class, ()->student.setFinalMark(finalMark));
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
		assertThat(actual).isEqualTo(totalMark);
	}


	@Tag("unit")
	@Tag("blackbox")
	@Tag("BVA_strategy")
	@ParameterizedTest
	@ValueSource(ints = {-1, 101})
	void Test_setTotalMark_EnterValuesOutOfBounds_ExceptionThrown(int totalMark)
	{
		assertThrows(InvalidStudentMarksException.class, ()->student.setTotalMark(totalMark));
	}



	/*
	 ************************************************************
	 ************************************************************
	 * The following Test cases are related to WhiteBox Testing
	 ************************************************************
	 ************************************************************
	 */

	@ParameterizedTest
	@ValueSource(strings = {"$Ramy Lwiz", "+MrRamy", "Bishoy12 Yousry", "a_ ", "Mr. Mido"})
	@Tag("whitebox")
	@Tag("branch_coverage")
	@DisplayName("Test case to fail the first condition that related to alphabets")
	void Test_setName_EnterSomeTestCasesToFailTheFirstCondition_ExceptionThrown(String name)
	{
		InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class,
				()->student.setName(name));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_ALPHABETS;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}


	@Test
	@Tag("whitebox")
	@Tag("branch_coverage")
	void Test_setName_EnterNameThatStartsWithSpace_ExceptionThrown()
	{
		InvalidStudentNameException exception = assertThrows(InvalidStudentNameException.class,
				()->student.setName(" Bosha"));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidStudentNameException.INVALID_STUDENT_NAME_STARTS_WITH_SPACE;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}


	@ParameterizedTest
	@Tag("whitebox")
	@Tag("conditional_coverage")
	@ValueSource(chars = {'0' - 1, '9' + 1})
	@DisplayName("This test case is to test the second condition that related to the first number" +
				 "it must to be [0:9]")
	void Test_setId_EnterValuesToTestTheSecondCondition_ExceptionThrown(char c)
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, ()->
				student.setId(c + "9007333"));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_DOES_NOT_START_WITH_NUMBERS;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}


	@ParameterizedTest
	@Tag("whitebox")
	@Tag("conditional_coverage")
	@ValueSource(chars = {'`', 'a' - 1, 'z' + 1, 'A' - 1, 'Z' + 1, ' '})
	@DisplayName("This test case is to test the third condition that related to the id must be alphanumeric")
	void Test_setId_EnterValuesToTestTheThirdCondition_ExceptionThrown(char c)
	{
		InvalidStudentIdException exception = assertThrows(InvalidStudentIdException.class, ()->
				student.setId("1900733" + c));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_ALPHANUMERIC;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}


	@ParameterizedTest
	@Tag("whitebox")
	@Tag("conditional_coverage")
	@ValueSource(chars = {'`', 'a' - 1, 'z' + 1, 'A' - 1, 'Z' + 1, ' '})
	@DisplayName("This test case is to test the fourth condition that related to each intermediate digit" +
				 "if the condition was not true, it must throw INVALID_STUDENT_ID_GENERAL")
	void Test_setId_EnterValuesToTestTheFourthCondition_ExceptionThrown(char c)
	{
		String idValue = "1900733s";
		char [] charArray = idValue.toCharArray();
		InvalidStudentIdException exception;
		for (int i = 1; i <= 6; i++)
		{
			charArray[i] = c;
			String newString = new String(charArray);
			exception = assertThrows(InvalidStudentIdException.class, ()->
					student.setId(newString));
			String actualMessage = exception.getMessage();
			String expectedMessage = InvalidStudentIdException.INVALID_STUDENT_ID_GENERAL;
			assertThat(actualMessage).isEqualTo(expectedMessage);
		}
	}

}