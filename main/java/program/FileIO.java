package program;

import Exceptions.*;

import java.io.*;
import java.util.ArrayList;

public class FileIO
{
    private String path;
    private final ArrayList<Student> students;
    private final Course course;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Course getCourse() {
        return course;
    }

    public FileIO()
    {
        students = new ArrayList<>();
        course = new Course();
    }

    public FileIO(String path) throws FileNotFoundException
    {
        this.set_path(path);
        students = new ArrayList<>();
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
    public void set_path(String path) throws FileNotFoundException,NullPointerException
    {
        if(path == null)
            throw new NullPointerException("The path is empty");

        File file = new File(path);

        if (file.exists())
        {
            this.path = path;
        }
        else
        {
            throw new FileNotFoundException("File not found: " + path);
        }
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
    public void read_file() throws IOException, InvalidStudentMarksException, InvalidCourseNameException, InvalidStudentIdException, InvalidStudentNameException, InvalidCourseCodeException, InvalidCourseMarkException {
        String line;
        int lineNumber = 0;

        try (FileReader fileReader = new FileReader(path);
             BufferedReader buffer = new BufferedReader(fileReader)) {

            // reading the file, line by line
            while ((line = buffer.readLine()) != null) {
                store_data(line, lineNumber++);
            }
        }
    }


    /*
     * Description: write the Excel file that holds the results of student, the file is present in the same path as input file
     *
     * Input: no input as it depends on the data stored
     *
     * Output: The function return nothing as it write the results file only with extension .csv
     *
     */
    public void write_file() throws IOException
    {
        String filePath = null;
        if(path.contains("/"))
        {
            filePath = path.substring(0, path.lastIndexOf('/') + 1) + "Results_";
            filePath = filePath + path.substring(path.lastIndexOf('/') + 1);
        }
        else
        {
            filePath = path.substring(0, path.lastIndexOf('\\') + 1) + "Results_";
            filePath = filePath + path.substring(path.lastIndexOf('\\') + 1);
        }
        filePath = filePath.replace(".txt",".csv");
        try (FileWriter writer = new FileWriter(filePath)) {
            StringBuilder contentBuilder = new StringBuilder();

            contentBuilder.append("Subject Name:").append(course.getName()).append(",,,,,");
            contentBuilder.append("Max Mark: 100\n\n");
            contentBuilder.append("Student name,Student number,GPA,Grade\n");

            for (Student student : students) {
                contentBuilder.append(student.getName()).append(",");
                contentBuilder.append(student.getId()).append(",");
                contentBuilder.append(student.getGpa()).append(",");
                contentBuilder.append(student.getGrade()).append("\n");
            }
            writer.write(contentBuilder.toString());
            System.out.println("Successfully wrote to the file.");
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
    public void store_data(String line, int lineNumber) throws InvalidCourseNameException, InvalidCourseCodeException, InvalidStudentMarksException, InvalidStudentIdException, InvalidStudentNameException, InvalidCourseMarkException {
        String[] words =line.split(",");
        if(lineNumber == 0)
        {
            course.setName(words[0]);
            course.setCode(words[1]);
            course.setMaxMark(words[2]);
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