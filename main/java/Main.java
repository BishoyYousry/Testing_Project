import Exceptions.*;
import program.*;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException,
            InvalidCourseMarkException, InvalidStudentMarksException, InvalidCourseNameException,
            InvalidStudentIdException, InvalidStudentNameException, InvalidCourseCodeException {
        String path;
        System.out.println("Enter excel file path: ");
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();
        FileIO f;
        f = new FileIO(path);
        f.read_file();
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