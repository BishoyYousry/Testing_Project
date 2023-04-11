import java.io.*;
import java.util.ArrayList;

public class FileIO
{
    private String path;
    private ArrayList<Student> students;
    private Course course;
    public FileIO()
    {
        students = new ArrayList<Student>();
        course = new Course("","",0,0,0,0,0);
    }

    public void set_path(String path)
    {
        this.path = path;
    }
    public String get_path()
    {
        return this.path;
    }
    public void read_file()
    {
        String line;
        int lineNumber = 0;
        try
        {
            FileReader fileReader = new FileReader(path);
            BufferedReader buffer = new BufferedReader(fileReader);

            // reading the file, line by line
            while((line = buffer.readLine()) != null)
                store_data(line,lineNumber++);
            buffer.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception: " +e);
        }
    }
    public void write_file()
    {
    }
    public void store_data(String line, int lineNumber)
    {
        String[] words =line.split(",");
        if(lineNumber == 0)
        {
            course.setName(words[0]);
            course.setCode(words[1]);
        }
        else
        {
            Student student = new Student(words[0],words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5]),0,"",0);

            students.add(student);
        }
    }
}
