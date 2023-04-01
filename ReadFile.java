import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
	public void readFile(String filePath)
	{
		String myline;
	    
	    try
	    {
	       FileReader fileReader = new FileReader(filePath);
	       BufferedReader bufread = new BufferedReader(fileReader);
	       
	       // reading the file, line by line
	       while((myline = bufread.readLine()) != null)
	          System.out.println(myline);
	       
	       bufread.close();
	    }
	    catch(IOException e)
	    {
	       System.out.println("Exception: " + e);
	    }
	}
}
