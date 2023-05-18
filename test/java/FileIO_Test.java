import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import program.Course;
import program.FileIO;
import program.Student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileIO_Test
{


    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_BackSlashPath_PositiveTesting()
    {
        FileIO file = new FileIO();
        String path = ".\\src\\test\\java\\InputFile TestCases\\Test_setPath_BackSlashPath_PositiveTesting.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThat(file.get_path()).isEqualTo(path);
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_RelativePath_ExceptionThrown()
    {
        FileIO file = new FileIO();
        String path = "./src/test/java/InputFile TestCases/Test_setPath_RelativePath_ExceptionThrown.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThat(file.get_path()).isEqualTo(path);
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_NotFoundPath_ExceptionThrown()
    {
        FileIO file = new FileIO();
        String path = "./src/test/java/InputFile TestCases/12.txt";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_PathWithSpecialCharacter_ExceptionThrown()
    {
        FileIO file = new FileIO();
        String path = "$./src/test/java/InputFile TestCases/Test_setPath_PathWithSpecialCharacter_ExceptionThrown.txt";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_EmptyPath_ExceptionThrown()
    {
        FileIO file = new FileIO();
        String path = "";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }


    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_NullPath_ExceptionThrown()
    {
        FileIO file = new FileIO();
        assertThrows(NullPointerException.class,() ->file.set_path(null));
    }

    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("equivalence_partitioning_testing")
    void Test_readFile_PositiveTesting()
    {
        FileIO file = new FileIO();
        String path = "./src/test/java/InputFile TestCases/Test_readFile_PositiveTesting.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertDoesNotThrow(file::read_file);

        //Actual Stored Data
        List<Student> students =  file.getStudents();
        Course course = file.getCourse();

        //Expected Input Course Data
        String ExpectedCourseName = "Computer Organization";
        String ExpectedCourseCode = "CSE221s";

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
}
