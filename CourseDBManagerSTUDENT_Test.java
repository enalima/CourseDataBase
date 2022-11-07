import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 *
 */
public class CourseDBManagerSTUDENT_Test {
	private CourseDBManager studentManager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		studentManager = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		studentManager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			studentManager.add("CMSC204",21703,4,"SCW217","Professor Kuijt");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		studentManager.add("GEOG101",21631,3,"Zoom","Professor Coronado");
		studentManager.add("MATH280",21320,4,"PerkBuilding117","Professor Wall");
		studentManager.add("NUTR101",21279,3,"HighTech401","Professor Muresan");
		ArrayList<String> list = studentManager.showAll();
		
		
  		assertEquals(list.get(1),"\nCourse:CMSC204 CRN:21703 Credits:4 Instructor:Professor Kuijt Room:SCW217");
  		assertEquals(list.get(1),"\nCourse:GEOG101 CRN:21631 Credits:3 Instructor:Professor Coronado Room:Zoom");
		assertEquals(list.get(2),"\nCourse:MATH280 CRN:21320 Credits:4 Instructor:Professor Wall Room:HighTech401");
		assertEquals(list.get(3),"\nCourse:NUTR101 CRN:21279 Credits:3 Instructor:Professor Muresan:HighTech401");
	}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() 
	{
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC240 21703 4 SCW217 Professor Kuijt");
			inFile.print("GEOG101 21631 3 Zoom Professor Coronado");
			
			inFile.close();
			studentManager.readFile(inputFile);

		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	
}