import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Test_ReadWrite {
	
	@Test
	void test1() {
		ReadWrite rw = new ReadWrite();
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/1.txt");
		String [] expected = {"Computer Organization","CSE221s", "100"};
		String [] actual = rw.course;
		assertArrayEquals("Test_ReadWrite::test1", expected, actual);
	}
	
	
	@Test
	void test2() {
		ReadWrite rw = new ReadWrite();
		String [] expected = {"Bishoy Yousry","Youssef Emad","Omar AMonem","Zeyad Mohamed","Malek Malek"};	
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/2.txt");
		String [] actual = rw.student[0];
		assertArrayEquals("Test_ReadWrite::test2", actual, expected);
	}
	
	@Test
	void test3() {
		ReadWrite rw = new ReadWrite();
		String [] expected = {"1900733", "1704764", "1800453", "1705743", "1534984"};	
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/3.txt");
		String [] actual = rw.student[1];
		assertArrayEquals("Test_ReadWrite::test3", actual, expected);
	}
	
	@Test
	void test4()
	{
		ReadWrite rw = new ReadWrite();
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/4.txt");
		String [] actual = rw.student[2];
		String [] expected  = {"73", "100", "79", "65", "84"};
		assertArrayEquals("Test_ReadWrite::test4", actual, expected);
	}
	

	@Test
	void test5()
	{
		ReadWrite rw = new ReadWrite();
		Integer [] marks = {59, 60, 62, 64, 66, 67, 69, 70, 72, 73, 75, 76, 79, 80, 83, 84, 88, 89, 92, 93, 96, 97, 99, 100};
		String [] expected = {"F", "D", "D", "D+", "D+", "C-", "C-", "C", "C", "C+", "C+", "B-", "B-", "B", "B", "B+", "B+",
							  "A-", "A-", "A", "A", "A+", "A+", "A+"};
		String [] actual = new String[24];
		for(int i = 0; i < marks.length; i++)
			actual[i] = rw.markToGrade(marks[i]);	
		assertArrayEquals("Test_ReadWrite::test5", actual, expected);
	}
	
	@Test
	void test6()
	{
		ReadWrite rw = new ReadWrite();
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/6.txt");
		//String [] actual = rw.student[0];
		String expected  = "The file doesn’t include the course data";
		//assertArrayEquals("Test_ReadWrite::test6", actual, expected);
	}
	
	@Test
	void test7() {
		ReadWrite rw = new ReadWrite();
		String expected = "The file doesn’t include the course data";	
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/7.txt");
		//String actual = rw.student[1];
		//assertEquals("Test_ReadWrite::test7", actual, expected);
	}
	
	@Test
	void test8() {
		ReadWrite rw = new ReadWrite();
		String expected = "The marks must be >= zero";	
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/8.txt");
		//String [] actual = rw.student[1];
		//assertArrayEquals("Test_ReadWrite::test8", actual, expected);
	}
	
	@Test
	void test9() {
		ReadWrite rw = new ReadWrite();
		String expected = "The marks must be integers";	
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/9.txt");
		//String [] actual = rw.student[1];
		//assertArrayEquals("Test_ReadWrite::test9", actual, expected);
	}
	
	@Test
	void test10() {
		ReadWrite rw = new ReadWrite();
		String expected = "The total marks must be <= 100";	
		rw.readWrite("/media/bishoy/6E90FAC190FA8F39/ASU/Senior1/2nd Term/SW Testing/Project_Invironment/src/10.txt");
		//String [] actual = rw.student[1];
		//assertArrayEquals("Test_ReadWrite::test10", actual, expected);
	}
	
}
