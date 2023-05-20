import Exceptions.InvalidStudentNameException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Main_Test {

    /*
     ************************************************************
     ************************************************************
     * The following Test cases are related to BlackBox Testing
     ************************************************************
     ************************************************************
     */


    @Test
    @Tag("integration")
    @Tag("blackbox")
    @Tag("bottomUp")
    @Tag("stress")
    void Test_main_StressTest()
    {
        String userInput = "./src/test/java/InputFile TestCases/Test_main_StressTest.txt";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertDoesNotThrow(()->Main.main(null));
    }


    /*
     ************************************************************
     ************************************************************
     * The following Test cases are related to WhiteBox Testing
     ************************************************************
     ************************************************************
     */

    @Test
    @Tag("integration")
    @Tag("whitebox")
    @Tag("bottomUp")
    void Test_main_EnterValidPath()
    {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        String userInput = ".\\src\\test\\java\\InputFile TestCases\\Test_main_EnterValidPath.txt";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertDoesNotThrow(()->Main.main(null));
        String expectedMessage = "Successfully wrote to the file.";
        String actualMessage = outputStreamCaptor.toString();
        assertThat(expectedMessage).contains(actualMessage);
    }


    @Test
    @Tag("integration")
    @Tag("whitebox")
    @Tag("bottomUp")
    void Test_main_EnterInvalidPath()
    {
        String userInput = ".\\src\\test\\java\\InputFile TestCases\\11.txt";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(FileNotFoundException.class, ()->Main.main(null));
    }

    @Test
    @Tag("integration")
    @Tag("whitebox")
    @Tag("bottomUp")
    void Test_main_EnterValidPathButInvalidStudentName()
    {
        String userInput = "./src/test/java/InputFile TestCases/Test_main_EnterValidPathButInvalidStudentName.txt";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(InvalidStudentNameException.class, ()->Main.main(null));
    }


}
