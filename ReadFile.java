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
	String[][] student;
	String[] course = new String[3];
	String split = ",";
/*---------------------------------------------------------------------------
 * [Function Name]: readFile
 *
 * [Description]:  Function read file and extract students and courses information from it
 *
 * [Args]:         filePath: a String
 *
 * [Returns]:      Void
 *
 ----------------------------------------------------------------------------------*/
	public void readFile(String filePath)
	{
		String myline;

	    Path path = Paths.get(filePath);

		try {

			Long lines = Files.lines(path).count();		//get number of lines
			student = new String[5][lines.intValue()-1]; 	//specify the array size
  
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
		   }
	       bufread.close();
		   print_result();

	    }
	    catch(IOException e)
	    {
	       System.out.println("Exception: " + e);
	    }
	}
	
/*---------------------------------------------------------------------------
 * [Function Name]: manipulation
 *
 * [Description]:  manipulation information ethier it is student info or course info 
 *
 * [Args]:         splitted: an array of strings
 *
 * [Returns]:      Void
 *
 ----------------------------------------------------------------------------------*/
	
	public void manipulation(String[] splitted){
		if (splitted.length > 3){
			student[0][index] = splitted[0];					// Student Name
			student[1][index] = splitted[1];					// Student Number	

			Integer mark = Integer.parseInt(splitted[2]) + Integer.parseInt(splitted[3]) + Integer.parseInt(splitted[4]) + Integer.parseInt(splitted[5]);
			
			student[2][index] = Integer.toString(mark);				// Student Mark	
			student[3][index] = Mark_to_Grade(mark);				// Student Grade
			student[4][index] = Grade_to_GPA(student[3][index]);			// Student GPA
			index++;

		}else{
			course[0] = splitted[0];						// Course Name
			course[1] = splitted[1];						// Course Code
			course[2] = splitted[2];						// Course Full Mark
		}
	}

/*---------------------------------------------------------------------------
 * [Function Name]: Mark_to_Grade
 *
 * [Description]:  get the student mark and convert it into what is equivalent in grade letters
 *
 * [Args]:         mark: an Integer
 *
 * [Returns]:      String
 *
 ----------------------------------------------------------------------------------*/
	
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
	
/*---------------------------------------------------------------------------
 * [Function Name]: Grade_to_GPA
 *
 * [Description]:  get the student grade and convert it into what is equivalent in GPA
 *
 * [Args]:         grade: a String
 *
 * [Returns]:      String
 *
 ----------------------------------------------------------------------------------*/
	
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

/*---------------------------------------------------------------------------
 * [Function Name]: print_result()
 *
 * [Description]:  print students and courses information arrays
 *
 * [Args]:         Void
 *
 * [Returns]:      Void
 *
 ----------------------------------------------------------------------------------*/
	
	public void print_result(){
		try {
			File myObj = new File("./result.txt");
			if (myObj.createNewFile()) {
			  	System.out.println("File created: " + myObj.getName());
			} else {
			  	System.out.println("File already exists.");
			}

			FileWriter myWriter = new FileWriter("./result.txt");
			//print course information
			myWriter.write("Subject Name: " + course[0] + "\t\tMax Mark: " + course[2] + "\n\n");
			
			//print students information
			myWriter.write("Student name \t| Student number \t| GPA \t| Grade" + "\n---------------------------------------------------\n");
			for(int i = 0; i < index; i++)
				myWriter.write(student[0][i] + " \t| " + student[1][i] + " \t\t\t| " + student[4][i] + " \t| " + student[3][i] + "\n");
			myWriter.close();

		  } catch (IOException e) {
				System.out.println("Exception: " + e);
		  }
	}
}
