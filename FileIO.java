package Pack1;

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
        course = new Course();
    }

    public FileIO(String path)
    {
        this.path = path;
        students = new ArrayList<Student>();
        course = new Course();
    }

    /*
     * Description: identifying the location(path) of the input file
     *
     * Input: the path of the file like D:/Testing/2.txt
     *
     * Output: The function return nothing as it assigns the location of the file inside the path attribute only
     *
     */
    public void set_path(String path)
    {

        this.path = path;
    }

    /*
     * Description: This function gets the location of the file
     *
     * Input: no input is passed
     *
     * Output: The function return the location of the file related to the current object
     *
     */
    public String get_path()
    {
        return this.path;
    }

    /*
     * Description: read the input file that holds data of students as Student name, Student number, Student Activities mark,
                    Oral/Practical mark, Midterm exam mark and Final exam mark
     *
     * Input: no input as it depends on the path of the file that is passed with the constructor itself
     *
     * Output: The function return nothing as it reads the input file and stores its data in object attributes
     *
     */
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

    /*
     * Description: write the excel file that holds the results of student, the file is present in the same path as input file
     *
     * Input: no input as it depends on the data stored
     *
     * Output: The function return nothing as it write the results file only with extension .csv
     *
     */
    public void write_file()
    {
        try
        {
            path = path.substring(0,path.lastIndexOf('/') + 1);

            FileWriter writer = new FileWriter(path + "Results.csv");

            writer.append("Subject Name:" + course.getName());
            writer.append(',');
            writer.append(',');
            writer.append(',');
            writer.append(',');
            writer.append(',');
            writer.append(',');

            writer.append("Max Mark: 100");
            writer.append(',');
            writer.append(',');
            writer.append("\n\n");
            writer.append("Student name");
            writer.append(',');
            writer.append(',');
            writer.append(',');
            writer.append("Student number");
            writer.append(',');
            writer.append(',');
            writer.append("GPA");
            writer.append(',');
            writer.append(',');
            writer.append("Grade");
            writer.append(',');
            writer.append(',');
            writer.append('\n');
            // Write the data to the file
            for (Student student : students)
            {
                writer.append(student.getName());
                writer.append(',');
                writer.append(',');
                writer.append(',');
                writer.append(student.getId());
                writer.append(',');
                writer.append(',');
                writer.append(student.getGpa());
                writer.append(',');
                writer.append(',');
                writer.append(student.getGrade());
                writer.append(',');
                writer.append(',');
                writer.append('\n');
            }

            // Close the FileWriter object
            writer.flush();
            writer.close();

            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /*
     * Description: store data for each student when parsing file line by line
     *
     * Input: Every line in file , line number as line number 0 holds course info while other lines holds student info
     *
     * Output: The function return nothing as it stores the data in attributes which are course & arraylist of students
     *
     */
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
            Student student = new Student();
                    student.setName(words[0]);
                    student.setId(words[1]);
                    student.setActivitiesMark(Integer.parseInt(words[2]));
                    student.setOralPracticalMark(Integer.parseInt(words[3]));
                    student.setMidtermMark(Integer.parseInt(words[4]));
                    student.setFinalMark(Integer.parseInt(words[5]));
                    student.setTotalMark(Calculator.compute_total_mark(student.getActivitiesMark(),student.getOralPracticalMark(),student.getMidtermMark(),student.getFinalMark()));
                    student.setGrade(Calculator.compute_Grade(student.getTotalMark()));
                    student.setGpa(Calculator.compute_GPA(student.getGrade()));
            students.add(student);
        }
    }
}
