public class CourseDBElement implements Comparable
{
	private String id;
	private int crn;
	private int numberofCredits;
	private String roomNumber;
	private String instructor;
	
	
	/**
	 * Default Constructor
	 */
	public CourseDBElement() 
	{
		id = "";
		crn = 0;
		numberofCredits = 0;
		roomNumber = "";
		instructor = "";
	}
	/**
	 * Constructor that takes the five parameters
	 * @param id
	 * @param crn
	 * @param numCredits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int numberofCredits, String roomNumber, String instructor)
	{
		this.id = id;
		this.crn = crn;
		this.numberofCredits = numberofCredits;
		this.roomNumber = roomNumber;
		this.instructor = instructor;
	}
	
	/**
	 * The compareTo method that returns 0 if the two elements have the same crn, 
	 * -1 is the element crn is less than the other cn
	 * and 1 if the element crn is greater than the other crn being compared
	 */
	@Override
	public int compareTo(CourseDBElement element)
	{
		if(element.crn == crn) 
		{
			return 0;
		}
		else if(element.crn < crn) 
		{
			return -1;
		}
		else 
		{
			return 1;
		}
	}
	
	
	/**
	 * Sets id
	 * @param id
	 */
	public void setID(String id)
	{
		this.id = id;
	}
	
	
	/**
	 * Gets current id
	 * @return id
	 */
	public String getID() {
		return id;
	}
	
	
	/**
	 * Sets CRN
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	/**
	 * Gets current CRN
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}
	
	/**
	 * Sets number of Credits
	 * @param numCredits
	 */
	public void setNumOfCredits(int numberofCredits)
	{
		this.numberofCredits = numberofCredits;
	}
	
	/**
	 * Gets current numberOfCredits
	 * @return numCredits
	 */
	public int getNumOfCredits()
	{
		return numberofCredits;
		
	}
	
	/**
	 * Sets the room number 
	 * @param roomNum
	 */
	public void setRoomNum(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	/**
	 * Gets current room number
	 * @return roomNum
	 */
	public String getRoomNum()
	{
		return roomNumber;
		
	}
	
	/**
	 * Sets the instructor name 
	 * @param instructor
	 */
	public void setInstructor(String instructor)
	{
		this.instructor = instructor;
	}
	
	/**
	 * Gets current instructor
	 * @return instructor
	 */
	public String getInstuctor()
	{
		return instructor;
		
	}
	/**
	 * Gets CRN and converts it into string, which then the hashcode of the string is returned
	 * @return crnString.hashCode()
	 */
	
	public int hashCode()
	{
		String crnString = crn + "";
		return crnString.hashCode();
	}
	
	/**
	 * @return  a string representation of the five parameters 
	 */
	public String toString()
	{
		String stringDisplay = "\nCourse:" + id + "CRN:" + crn + "Credits:" + numberofCredits + "Instructor:" + instructor + "Room:" + roomNumber;
		return stringDisplay;
	}
	
	
}