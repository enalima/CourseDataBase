import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class CourseDBStructure implements CourseDBStructureInterface
{
	protected int size;
	protected LinkedList<CourseDBElement> hashTable[];
	
	/**
	 *Constructor using parameter size
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) 
	{
		this.size = size;
		hashTable = new LinkedList[size];
	}
	/**
	 * Constructor needed for Junit testing
	 * @param testing
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int size)
	{
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	/**
	 * Method that takes a given CourseDBElement object and adds it into hashtable.
	 * If the index of the CRN is null, creates new linked list and adds element to index
	 * if the index all ready has an element within it, it shouldn't add it to said index
	 * @param element
	 */
	@Override
	public void add(CourseDBElement element) 
	{
		int index = element.hashCode() % size;
		if(hashTable[index] == null) 
		{
			hashTable[index] = new LinkedList<CourseDBElement>();
			hashTable[index].add(element);
		}
	}
	/**
	 * public courseDBE element get method that gets the crn of the element
	 * If the index of CRN does not exist in hash table, it will throw the IOException.
	 * If it does, it runs through hashtable bucket until the crn is matched
	 * @param crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException
	{
		String crnString = crn + "";
		int index = crnString.hashCode() % size;
		if(hashTable[index] == null) 
		{
			throw new IOException();
		}
		else 
		{
			for(int i = 0; i < size; i++)
			{
				CourseDBElement dbElement = hashTable[index].get(i);
				if(dbElement.getCRN() == crn) 
				{
					return dbElement;
				}
			}
			return null;
		}
	}
		
	/**
	 * public ArrayList show all method that displays contents of element in the hash table
	 * @return string representation of content within said element
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		ArrayList<String> displayContent =new ArrayList<String>();
		for(int i=0;i<size;i++) 
		{
			while(hashTable[i]!=null) 
			{
				for(int j=0;j<hashTable[i].size();j++)
				{
					CourseDBElement element= (CourseDBElement) hashTable[i].get(j);
					displayContent.add("\n"+element.toString());
				}
				break;
			}
		}
		return displayContent;
	}
	
	/**
	 * Method that gets the size of hash table.
	 * @return size
	 */
	@Override
	public int getTableSize() 
	{
		return size;
	}

	
	
	
	
	
}