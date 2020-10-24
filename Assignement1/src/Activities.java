import java.util.LinkedList;
import java.util.List;

/**
 * 
 * The class {@code Activities} is used to manage courses and competitions.
 * 
 */

public class Activities {
	
	/**
	 *
	 * Class fields.
	 * 
	 * name - It is the activity's name.
	 * peopleList - It is the list that contains all people (i.e member or admin) subscribed at that activity.
	 *
	 */
	
	private String name;
	protected List<People> peopleList = new LinkedList<>();
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param name It is the acitivity's name.
	 *
	 */
	
	public Activities (final String name) {
		this.name = name;
	}
	
	/**
	 *  
	 *  Method used to print administrator's or member's list subscribed in a course or competition.
	 *
	 *  @param a It is a string that defines the activity.
	 *  @param list It is the list to print.
	 *
	 */
	
	public void printList(final String a, final List<People> list) {		
		System.out.print("Activity -> " + a + ": " + this.getName() + " -> [ ");
		for(People s: list) {
			System.out.print(s.getName() + " ");
		}
		
		System.out.println("]\n");
	}
	
	/**
	 * 
	 * Method used to return name of Activities.
	 * 
	 * @return Name of the instance of the class.
	 *
	 */
	
	public String getName() {		
		return this.name;
	}	
	
	/**
	 *
	 * Method used to set name of the instance of the class.
	 * 
	 * @param name New name.
	 *
	 */
	
	public void setName(final String name) {		
		this.name = name;
	}
}
