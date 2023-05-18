import Exceptions.InvalidCourseCodeException;
import Exceptions.InvalidCourseNameException;
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
	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_PositiveTesting()
	{
		Course course = new Course();
		String courseName = "Computer Architecture";
		assertDoesNotThrow(() ->course.setName(courseName));
		assertThat(course.getName()).isEqualTo(courseName);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_NameContainsNumbers_ExceptionThrown()
	{
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
		String courseName = "CSE Subject";
		assertDoesNotThrow(() ->course.setName(courseName));
		assertThat(course.getName()).isEqualTo(courseName);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setName_NameStartsWithSpace_ExceptionThrown()
	{
		Course course = new Course();
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
		Course course = new Course();
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
		String courseName = "Computer Architecture";
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
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> new Course(courseName, "CSE123s"));
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
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () -> new Course(courseName, "CSE123s"));
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
		InvalidCourseNameException exception = assertThrows(InvalidCourseNameException.class, () ->  new Course(courseName, "CSE123s"));
		String expectedMessage = InvalidCourseNameException.INVALID_COURSE_NAME_ALPHABETIC;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setCode_SixCharacters_PositiveTesting()
	{
		Course course = new Course();
		String courseCode = "CSE123";
		assertDoesNotThrow(() ->course.setCode(courseCode));
		assertThat(course.getCode()).isEqualTo(courseCode);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_setCode_SevenCharacters_PositiveTesting()
	{
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
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
		Course course = new Course();
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
		assertDoesNotThrow(() ->course[0] = new Course("Computer Architecture",courseCode));
		assertThat(course[0].getCode()).isEqualTo(courseCode);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_SevenCharacters_PositiveTesting()
	{
		Course[] course = {null};
		String courseCode = "CSE123s";
		assertDoesNotThrow(() ->course[0] = new Course("Computer Architecture",courseCode));
		assertThat(course[0].getCode()).isEqualTo(courseCode);
	}

	@ParameterizedTest
	@Tag("unit")
	@Tag("blackbox")
	@ValueSource(strings = {"CS123","123"})
	void Test_ParametrizedConstructor_NumberOfAlphabetIsLessThanThree_ExceptionThrown(String courseCode)
	{
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NumberOfAlphabetIsGreaterThanThree_ExceptionThrown()
	{
		String courseCode = "CSEA123";
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
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
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}

	@Test
	@Tag("unit")
	@Tag("blackbox")
	void Test_ParametrizedConstructor_NumberOfDigitsIsGreaterThanThree_ExceptionThrown()
	{
		String courseCode = "CSE1234";
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
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
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
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
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
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
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
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
		InvalidCourseCodeException exception = assertThrows(InvalidCourseCodeException.class, () -> new Course("Computer Architecture",courseCode));
		String expectedMessage = InvalidCourseCodeException.INVALID_COURSE_CODE_PATTERN;
		String actualMessage = exception.getMessage();
		assertThat(actualMessage).contains(expectedMessage);
	}
}