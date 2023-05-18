import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import program.Course;
import program.FileIO;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileIO_Test
{

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_ForwardSlashPath_PositiveTesting()
    {
        FileIO file = new FileIO();
        String path = "./src/test/java/InputFile TestCases/2.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThat(file.get_path()).isEqualTo(path);
    }
/*
    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_BackSlashPath_PositiveTesting()
    {
        FileIO file = new FileIO();
        String path = "D:\\Testing\\src\\test\\java\\InputFile TestCases\\2.txt";
        assertDoesNotThrow(() ->file.set_path(path));
        assertThat(file.get_path()).isEqualTo(path);
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_RelativePath_ExceptionThrown()
    {
        FileIO file = new FileIO();
        String path = "InputFile TestCases/2.txt";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_NotFoundPath_ExceptionThrown()
    {
        FileIO file = new FileIO();
        String path = "InputFile TestCases/12.txt";
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_setPath_PathWithSpecialCharacter_ExceptionThrown()
    {
        FileIO file = new FileIO();
        String path = "InputFile TestCases/12.txt";
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
        String path = null;
        assertThrows(FileNotFoundException.class,() ->file.set_path(path));
    }
*/
}
