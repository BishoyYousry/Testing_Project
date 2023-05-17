import Exceptions.InvalidCourseCodeException;
import Exceptions.InvalidCourseNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import program.Course;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Course_Test
{

	private final Course course = new Course();

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
	void Test_setName_PositiveTesting()
	{
		String courseName = "Computer";
		assertDoesNotThrow(() ->course.setName(courseName));
		assertThat(course.getName()).isEqualTo(courseName);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_NameContainsNumbers_ExceptionThrown()
	{
		String courseName = "CSE123";
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> course.setName(courseName));
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_NameStartsWithNumbers_ExceptionThrown()
	{
		String courseName = "123";
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> course.setName(courseName));
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_NameContainsSpace_StoredSuccessfully()
	{
		String courseName = "CSE Subject";
		assertDoesNotThrow(() ->course.setName(courseName));
		assertThat(course.getName()).isEqualTo(courseName);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_NameStartsWithSpace_ExceptionThrown()
	{
		String courseName = " CSE Subject";
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> course.setName(courseName));
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_START_WITH_SPACE;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_NameIsEmpty_ExceptionThrown()
	{
		String courseName = "";
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> course.setName(courseName));
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_PositiveTesting()
	{
		String courseName = "Computer";
		Course[] course = {null};
		assertDoesNotThrow(() ->course[0] = new Course(courseName,"CSE123s"));
		assertThat(course[0].getName()).isEqualTo(courseName);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NameContainsNumbers_ExceptionThrown()
	{
		String courseName = "CSE123";
		Course[] course = {null};
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> {
			course[0] = new Course(courseName, "CSE123s");
			assertThat(course[0].getName()).isEqualTo(courseName);
		});
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NameStartsWithNumbers_ExceptionThrown()
	{
		String courseName = "123";
		Course[] course = {null};
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> {
			course[0] = new Course(courseName, "CSE123s");
		});
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NameContainsSpace_StoredSuccessfully()
	{
		String courseName = "CSE Subject";
		Course[] course = {null};
		assertDoesNotThrow(() ->course[0] = new Course(courseName,"CSE123s"));
		assertThat(course[0].getName()).isEqualTo(courseName);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NameStartsWithSpace_ExceptionThrown()
	{
		String courseName = " CSE";
		Course[] course = {null};
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> {
			course[0] = new Course(courseName, "CSE123s");
		});
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_START_WITH_SPACE;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NameIsEmpty_ExceptionThrown()
	{
		String courseName = "";
		Course[] course = {null};
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> {
			course[0] = new Course(courseName, "CSE123s");
		});
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setCode_SixCharacters_PositiveTesting()
	{
		String courseCode = "CSE123";
		assertDoesNotThrow(() ->course.setCode(courseCode));
		assertThat(course.getCode()).isEqualTo(courseCode);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setCode_SevenCharacters_PositiveTesting()
	{
		String courseCode = "CSE123s";
		assertDoesNotThrow(() ->course.setCode(courseCode));
		assertThat(course.getCode()).isEqualTo(courseCode);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CS123","123"})
	void Test_setCode_NumberOfAlphabetIsLessThanThree_ExceptionThrown(String courseCode)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setCode_NumberOfAlphabetIsGreaterThanThree_ExceptionThrown()
	{
		String courseCode = "CSEA123";
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE12","cse"})
	void Test_setCode_NumberOfDigitsIsLessThanThree_ExceptionThrown(String courseCode)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setCode_NumberOfDigitsIsGreaterThanThree_ExceptionThrown()
	{
		String courseCode = "CSE1234";
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"123CSE","cs123e"})
	void Test_setCode_DifferentOrder_ExceptionThrown(String courseCode)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE123S","CSE123A"})
	void Test_setCode_DifferentSeventhCharacter_ExceptionThrown(String courseCode)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_LAST_CHAR;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE 123","C@S123s","cse-123"," "})
	void Test_setCode_SpecialCharacter_ExceptionThrown(String courseCode)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE123sA","C@S123s1","CSE123s$","cse123ss"})
	void Test_setCode_ExtraItemAfterSeventh_ExceptionThrown(String courseCode)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> course.setCode(courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_SixCharacters_PositiveTesting()
	{
		Course[] course = {null};
		String courseCode = "CSE123";
		assertDoesNotThrow(() ->course[0] = new Course("Computer",courseCode));
		assertThat(course[0].getCode()).isEqualTo(courseCode);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_SevenCharacters_PositiveTesting()
	{
		Course[] course = {null};
		String courseCode = "CSE123s";
		assertDoesNotThrow(() ->course[0] = new Course("Computer",courseCode));
		assertThat(course[0].getCode()).isEqualTo(courseCode);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CS123","123"})
	void Test_ParametrizedConstructor_NumberOfAlphabetIsLessThanThree_ExceptionThrown(String courseCode)
	{
		Course[] course = {null};
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NumberOfAlphabetIsGreaterThanThree_ExceptionThrown()
	{
		Course[] course = {null};
		String courseCode = "CSEA123";
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE12","cse"})
	void Test_ParametrizedConstructor_NumberOfDigitsIsLessThanThree_ExceptionThrown(String courseCode)
	{
		Course[] course = {null};
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NumberOfDigitsIsGreaterThanThree_ExceptionThrown()
	{
		Course[] course = {null};
		String courseCode = "CSE1234";
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"123CSE","cs123e"})
	void Test_ParametrizedConstructor_DifferentOrder_ExceptionThrown(String courseCode)
	{
		Course[] course = {null};
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE123S","CSE123A"})
	void Test_ParametrizedConstructor_DifferentSeventhCharacter_ExceptionThrown(String courseCode)
	{
		Course[] course = {null};
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_LAST_CHAR;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE 123","C@S123s","cse-123"})
	void Test_ParametrizedConstructor_SpecialCharacter_ExceptionThrown(String courseCode)
	{
		Course[] course = {null};
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CSE123sA","C@S123s1","CSE123s$","cse123ss"})
	void Test_ParametrizedConstructor_ExtraItemAfterSeventh_ExceptionThrown(String courseCode)
	{
		Course[] course = {null};
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> {
			course[0] = new Course("Computer",courseCode);
		});
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}


	/*
	 ************************************************************
	 ************************************************************
	 * The following Test cases are related to WhiteBox Testing
	 ************************************************************
	 ************************************************************
	 */

	@ParameterizedTest
	@ValueSource(strings = {"$Embedded Systems", "+SW dev", "Data12 Base", "M_ ", "Mr. DB"})
	@Tag("whitebox")
	@Tag("branch_coverage")
	@DisplayName("Test case to fail the first condition that related to alphabets")
	void Test_setName_EnterSomeTestCasesToFailTheFirstCondition_ExceptionThrown(String name)
	{
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class,
				()->course.setName(name));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}


	@Test
	@Tag("whitebox")
	@Tag("branch_coverage")
	void Test_setName_EnterNameThatStartsWithSpace_ExceptionThrown()
	{
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class,
				()->course.setName(" DB"));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_START_WITH_SPACE;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}

	@Test
	@Tag("whitebox")
	@Tag("branch_coverage")
	void Test_setName_EnterNameWithoutAnySpaces_ExceptionThrown()
	{
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class,
				()->course.setName("DataBase"));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ONE_SPACE;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "ABCDE", "ABCDEFGH"})
	@Tag("whitebox")
	@Tag("conditional_coverage")
	@DisplayName("Test the first condition in setCode function that is related to the length of" +
			"the code which must be 6 or 7")
	void Test_setCode_EnterCodeToTestTheFirstCondition_ExceptionThrown(String code)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class,
				()->course.setCode(code));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}


	@ParameterizedTest
	@ValueSource(strings = {"CSE12_", "123CSE", "CSEABC"})
	@Tag("whitebox")
	@Tag("conditional_coverage")
	@DisplayName("Test the second condition in setCode function. To pass it must has 3chars + 3 no.")
	void Test_setCode_EnterCodeToTestTheSecondCondition_ExceptionThrown(String code)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class,
				()->course.setCode(code));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}

	@ParameterizedTest
	@ValueSource(strings = {"CSE123_", "123CSEs", "      s"})
	@Tag("whitebox")
	@Tag("conditional_coverage")
	@DisplayName("Test the third condition in setCode function. To pass it must has 3chars + 3 no. + 1 char")
	void Test_setCode_EnterCodeToTestTheThirdCondition_ExceptionThrown(String code)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class,
				()->course.setCode(code));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}


	@ParameterizedTest
	@ValueSource(strings = {"CSE123h", "cse950S"})
	@Tag("whitebox")
	@Tag("conditional_coverage")
	@DisplayName("Test the fourth condition in setCode function. the 7th char must be 's'")
	void Test_setCode_EnterCodeToTestTheFourthCondition_ExceptionThrown(String code)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class,
				()->course.setCode(code));
		String actualMessage = exception.getMessage();
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_LAST_CHAR;
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}

}