import Exceptions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import program.Course;
import program.FileIO;
import program.Student;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileIO_Test
{
    private final FileIO file = new FileIO();

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_ForwardSlashPath_PositiveTesting()
    {
        String path = "./src/test/java/InputFile TestCases/Test_setPath_ForwardSlashPath_PositiveTesting.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThat(file.get_path()).isEqualTo(path);
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_BackSlashPath_PositiveTesting()
    {
        String path = ".\\src\\test\\java\\InputFile TestCases\\Test_setPath_BackSlashPath_PositiveTesting.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThat(file.get_path()).isEqualTo(path);
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_NotFoundPath_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/12.txt";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_PathWithSpecialCharacter_ExceptionThrown()
    {
        String path = "$./src/test/java/InputFile TestCases/Test_setPath_PathWithSpecialCharacter_ExceptionThrown.txt";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_EmptyPath_ExceptionThrown()
    {
        String path = "";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }


    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_NullPath_ExceptionThrown()
    {
        assertThrows(NullPointerException.class,() ->file.set_path(null));
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_PositiveTesting()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_PositiveTesting.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertDoesNotThrow(file::read_file);

        //Actual Stored Data
        List<Student> students =  file.getStudents();
        Course course = file.getCourse();

        //Expected Input Course Data
        String ExpectedCourseName = "Computer Organization";
        String ExpectedCourseCode = "CSE221s";
        String ExpectedCourseMark = "100";

        //Expected Input Student Data
        List<String> ExpectedStudentName = new ArrayList<>(Arrays.asList("Bishoy Yousry", "Youssef Emad", "Omar AMonem", "Zeyad Mohamed", "Malek Malek"));
        List<String> ExpectedStudentId = new ArrayList<>(Arrays.asList("19007330", "17047640", "18004530", "17057430", "15349840"));
        List<Integer> ExpectedStudentActivitiesMark = new ArrayList<>(Arrays.asList(5, 10, 10, 8, 5));
        List<Integer> ExpectedStudentOralPracticalMark = new ArrayList<>(Arrays.asList(7, 10, 9, 8, 3));
        List<Integer> ExpectedStudentMidtermMark = new ArrayList<>(Arrays.asList(6, 20, 10, 14, 16));
        List<Integer> ExpectedStudentFinalMark = new ArrayList<>(Arrays.asList(55, 60, 50, 35, 60));

        //Course Assertions
        assertThat(course.getName()).isEqualTo(ExpectedCourseName);
        assertThat(course.getCode()).isEqualTo(ExpectedCourseCode);
        assertThat(course.getMaxMark()).isEqualTo(ExpectedCourseMark);

        // Student Assertions
        assertThat(students.size()).isEqualTo(ExpectedStudentName.size());

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            assertThat(student.getName()).isEqualTo(ExpectedStudentName.get(i));
            assertThat(student.getId()).isEqualTo(ExpectedStudentId.get(i));
            assertThat(student.getActivitiesMark()).isEqualTo(ExpectedStudentActivitiesMark.get(i));
            assertThat(student.getOralPracticalMark()).isEqualTo(ExpectedStudentOralPracticalMark.get(i));
            assertThat(student.getMidtermMark()).isEqualTo(ExpectedStudentMidtermMark.get(i));
            assertThat(student.getFinalMark()).isEqualTo(ExpectedStudentFinalMark.get(i));
        }

    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidStudentName_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidStudentName_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidStudentNameException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidStudentId_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidStudentId_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidStudentIdException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidStudentActivitiesMark_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidStudentActivitiesMark_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidStudentMarksException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidStudentOralPracticalMark_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidStudentOralPracticalMark_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidStudentMarksException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidStudentMidtermMark_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidStudentMidtermMark_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(NumberFormatException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidStudentFinalMark_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidStudentFinalMark_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidStudentMarksException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidCourseName_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidCourseName_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidCourseNameException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidCourseCode_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidCourseCode_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidCourseCodeException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_InvalidMaxMark_ExceptionThrown()
    {
        String path = "./src/test/java/InputFile TestCases/Test_readFile_InvalidMaxMark_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThrows(InvalidCourseMarkException.class, file::read_file);
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    void Test_write_file_PositiveTesting()
    {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        try {
            file.set_path("./src/test/java/InputFile TestCases/Test_write_file_PositiveTesting.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertDoesNotThrow(file::write_file);
        String expectedMessage = "Successfully wrote to the file.";
        assertThat(expectedMessage).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @DisplayName("The input file has some invalid data.The output must be created but contain null values")
    void Test_write_file_TheInputFileHasInvalidData()
    {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        try {
            file.set_path("./src/test/java/InputFile TestCases/Test_write_file_TheInputFileHasInvalidData_ExceptionThrown.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            file.read_file();
        } catch (IOException | InvalidStudentMarksException |
                InvalidCourseNameException | InvalidStudentIdException |
                InvalidStudentNameException | InvalidCourseCodeException|InvalidCourseMarkException e ) {
            e.printStackTrace();
        }
        assertDoesNotThrow(file::write_file);
        String expectedMessage = "Successfully wrote to the file.";
        assertThat(expectedMessage).isEqualTo(outputStreamCaptor.toString().trim());
        Course course = file.getCourse();
        assertThat(course.getName()).isEqualTo(null);
    }
}
