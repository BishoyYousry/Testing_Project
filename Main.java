import Exceptions.*;
import program.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        FileIO f = null;
        String filePath = "D:\\ASU\\Senior1\\2nd Term\\SW Testing\\Project_environmet\\src\\test\\java\\InputFile TestCases\\2.txt";
        try
        {
            f = new FileIO(filePath);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        if(f!=null)
        {
            try
            {
                f.read_file();
            }
            catch (InvalidStudentMarksException | InvalidCourseNameException | InvalidStudentIdException |
                   InvalidStudentNameException | InvalidCourseCodeException | IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                f.write_file();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}