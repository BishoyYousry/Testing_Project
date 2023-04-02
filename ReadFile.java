import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File; 
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
	int index = 0;
	String[][] student = new String[5][0];
	String[] course = new String[3];
	String split = ",";

	public void readFile(String filePath)
	{
		String myline;

	    Path path = Paths.get(filePath);

		try {

			Long lines = Files.lines(path).count();
			student = new String[5][lines.intValue()];
  
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}

	    try
	    {
	       FileReader fileReader = new FileReader(filePath);
	       BufferedReader bufread = new BufferedReader(fileReader);
	       
	       // reading the file, line by line
	       while((myline = bufread.readLine()) != null){
				String[] splitted = myline.split(split);
				manipulation(splitted);
	          	// System.out.println(myline);
		   }
	       bufread.close();
		   print_result();

	    }
	    catch(IOException e)
	    {
	       System.out.println("Exception: " + e);
	    }
	}

	public void manipulation(String[] splitted){
		if (splitted.length > 3){
			student[0][index] = splitted[0];						// Student Name
			student[1][index] = splitted[1];						// Student Number	

			Integer mark = Integer.parseInt(splitted[2]) + Integer.parseInt(splitted[3]) + Integer.parseInt(splitted[4]) + Integer.parseInt(splitted[5]);
			
			student[2][index] = Integer.toString(mark);				// Student Mark	
			student[3][index] = Mark_to_Grade(mark);				// Student Grade
			student[4][index] = Grade_to_GPA(student[3][index]);	// Student GPA
			index++;

		}else{
			course[0] = splitted[0];								// Course Name
			course[1] = splitted[1];								// Course Code
			course[2] = splitted[2];								// Course Full Mark
		}
	}

	public String Mark_to_Grade(Integer mark) {
		String Grade;
		if(mark >= 97)
			Grade = "A+";
		else if(mark >= 93)
			Grade = "A";
		else if(mark >= 89)
			Grade = "A-";
		else if(mark >= 84)
			Grade = "B+";
		else if(mark >= 80)
			Grade = "B";
		else if(mark >= 76)
			Grade = "B-";
		else if(mark >= 73)
			Grade = "C+";
		else if(mark >= 70)
			Grade = "C";
		else if(mark >= 67)
			Grade = "C-";
		else if(mark >= 64)
			Grade = "D+";	
		else if(mark >= 60)	
			Grade = "D";
		else
			Grade = "F";
	
		return Grade;
	}

	public String Grade_to_GPA(String grade){
		String GPA;

		if(grade == "F")
			GPA = "0";
		else if(grade == "D")
			GPA = "1";
		else if(grade == "D+")
			GPA = "1.3";
		else if(grade == "C-")
			GPA = "1.7";
		else if(grade == "C")
			GPA = "2";
		else if(grade == " C+")
			GPA = "2.3";
		else if(grade == "B-")
			GPA = "2.7";
		else if(grade == "B")
			GPA = "3";
		else if(grade == "B+")
			GPA = "3.3";
		else if(grade == "A-")
			GPA = "3.7";
		else 
			GPA = "4";

		return GPA;
	}

	public void print_result(){
		// System.out.println("Subject Name: " + course[0] + "\tMax Mark: " + course[2] + "\n");
		// System.out.println("Student name \t Student number \t GPA \t Grade");
		// for(int i = 0; i < index; i++)
		// 	System.out.println(student[0][i] + " \t " + student[1][i] + " \t\t " + student[4][i] + " \t " + student[3][i] );

		try {
			File myObj = new File("./result.txt");
			if (myObj.createNewFile()) {
			  	System.out.println("File created: " + myObj.getName());
			} else {
			  	System.out.println("File already exists.");
			}

			FileWriter myWriter = new FileWriter("./result.txt");
			myWriter.write("Subject Name: " + course[0] + "\t\tMax Mark: " + course[2] + "\n\n");
			myWriter.write("Student name \t| Student number \t| GPA \t| Grade" + "\n---------------------------------------------------\n");
			for(int i = 0; i < index; i++)
				myWriter.write(student[0][i] + " \t| " + student[1][i] + " \t\t\t| " + student[4][i] + " \t| " + student[3][i] + "\n");
			myWriter.close();

		  } catch (IOException e) {
				System.out.println("Exception: " + e);
		  }
	}
}
