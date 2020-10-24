import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * The class {@code People} is used to manage club's members and administrators.
 * 
 */

public class People {
	
	/**
	 * Class fields:
	 * 
	 * id - It is the unique identifier for all club's people.
	 * name - It is the name of the club's member or administrator.
	 * surname - It is the surname of the club's member or administrator.
	 * email - It is the email of the club's member or administrator.
	 * password - It is the password of the club's member or administrator.
	 * peopleActivitiesList - It is a list that contains all correspondence between people and activities.
	 * 						  It is used to remove a member or administrator from all activities
	 * 						  when a member or administrator is removed from the club.
	 */
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	static protected List<ItemDemo<People, Activities>> peopleActivitiesList = new LinkedList<>();
	
	/**
	 * Class constructor.
	 * 
	 * @param name It is the name of the member or administrator.
	 * @param surname It is the surname of the member or administrator.
	 * @param email It is the email of the member or administrator.
	 * @param password It is the password of the member or administrator.
	 *
	 */
	
	public People(final String name, final String surname, final String email, final String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.id = getUpdateId(); // this method is used to assign an unique identifier to a member or administrator.
	}
		
	/**
	 *
	 * This method is used to delete the item from the list of correspondence between People and Activities
	 * when a People (i.e Member or Administrator) delete itself from a course or competition.
	 *
	 * @param param It is the Item to delete from the list of correspondence between People and Activities.
	 *
	 */

	static public void clearList(final ItemDemo<People, Activities> param) {		
		if(param != null) {
			for(int i = 0; i < peopleActivitiesList.size(); i++){			
				if(peopleActivitiesList.get(i).getPerson().getID() == param.getPerson().getID() && peopleActivitiesList.get(i).getActivities().getName() == param.getActivities().getName()){
					peopleActivitiesList.remove(i);
				}
			}
		}
	}
	
	/**
	 * 
	 * This method is used to delete a member or administrator from all activities (i.e course or competition)
	 * when it is removed from the club.
	 * This method uses the delete method to unsubscribe people from a course or competition.
	 * At the same time it is removed from the correspondence list.
	 * 
	 * @param param It is the People to delete from all activities.
	 * 
	 *
	 */
	
	public void deleteFromAllActivities(final People param) {
		for(int i = 0; i < peopleActivitiesList.size(); i++){			
			if(peopleActivitiesList.get(i).getPerson().getID() == param.getID()){
				param.delete(param, peopleActivitiesList.get(i).getActivities(), "GENERICS");
				peopleActivitiesList.remove(i);
			}
		}
	}
	
	/**
	 * This method is used by a member or administrator to subscribe itself 
	 * in a course or competition.
	 * 
	 * @param p It is Member/Administrator who want subscribe.
	 * @param a It is the activity where people will be subscribed.
	 * @param act It is a string used to indicate the activity (i.e Course or Competition).
	 * @return The return is used only to exit from the method.
	 *
	 */
	
	public int subscribe(final People p, final Activities a, final String act) {
		if(p.getID() == this.getID()) {	// a member or admin can't subscribe another member or admin in an activity.		
			for(People s: a.peopleList) {
				if(s.getID() == p.getID()) {
					System.out.println("You are already enrolled in the " + act + ".\n");
					return 1;
				}
			}
			
			a.peopleList.add(p);
			
			ItemDemo<People, Activities> it = new ItemDemo<>(p, a);
			peopleActivitiesList.add(it); // adding into correspondence list <People, Activity>
				
			System.out.println(act + " registration has been successfully completed.\n");
			return 0;
		}
		
		else {
			System.out.println("You cannot add another person into the " + act + ".\n");
			return -1;
		}
	}
	
	/**
	 * This method is used by a member or administrator to delete itself from
	 * a course or competition.
	 * 
	 * @param p It is Member/Administrator who want unsubscribe.
	 * @param a It is the activity where people will be delete.
	 * @param act It is a string that defines the activity.
	 * @return It returns the item deleted.
	 *
	 */
	
	public ItemDemo<People, Activities> delete(final People p, final Activities a, final String act) {
		ItemDemo<People, Activities> it = new ItemDemo<>(p, a);		
		if(this.getID() == p.getID()) {	// a member or admin can't delete another member or admin from an activity.
			for(People s: a.peopleList) {				
				if(s.getID() == p.getID()) {				
					a.peopleList.remove(s);					
					System.out.println(p.getName() + " has been successfully removed from the " + act + ".\n");
					return it;
				}
			}
			
			System.out.println("You are not registered for the " + act + ".\n");
			return null;
		}
		
		else {
			System.out.println("You cannot remove another person from the " + act + ".\n");
			return null;
		}
	}
	
	
	/**
	 * 
	 * This method tracks id values readed from a file called "id.txt" continuously updated.
	 * This file is readed and rewrited at each creation of an instance of Member/Administrator.
	 * The id uniquely identifies a club member or administrator.
	 * 
	 * @return ID to be assigned to the member/administrator.
	 *
	 */
	
	static public int getUpdateId() {
			
		String file= "C:\\Users\\vince\\eclipse-workspace\\Assignement1\\id.txt";
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(file));
		} 		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line = null;
		
		try {
			line = reader.readLine();
		}		
		catch (IOException e) {
			e.printStackTrace();
		}
				
		int ID = Integer.parseInt(line);
		
		ID++;
		
		String str = Integer.toString(ID);
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file);
		} 		
		catch (IOException e) {

			e.printStackTrace();
		}
		
		try {
			writer.write(str);
		} 		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			reader.close();
		} 		
		catch (IOException e) {
			e.printStackTrace();
		}
		    
	    try {
			writer.close();
		} 
	    catch (IOException e) {
			e.printStackTrace();
		}
		
		return ID;
	}
	
	/**
	 *
	 * Method used to return id.
	 *
	 * @return Id of the instance of the class.
	 *
	 */
	
	public int getID() {		
		return this.id;
	}
	
	/**
	 * 
	 * Method used to return name.
	 * 
	 * @return Name of the instance of the class.
	 *
	 */
		
	public String getName() {		
		return this.name;
	}
	
	/**
	 * 
	 * Method used to return surname
	 * 
	 * @return Surname of the instance of the class.
	 *
	 */
	
	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * 
	 * Method used to return email
	 * 
	 * @return Email of the instance of the class.
	 *
	 */
	
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * 
	 * Method used to return password
	 * 
	 * @return Password of the instance of the class.
	 *
	 */
	
	public String getPassword() {
		return this.password;
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
	
	/**
	 * 
	 * Method used to set surname of the instance of the class.	
	 *
	 * @param surname New surname.
	 *
	 */
	
	public void setSurname(final String surname) {
		this.surname = surname;
	}
	
	/**
	 * 
	 * Method used to set email of the instance of the class.
	 * 
	 * @param  email New email.
	 *
	 */
	
	public void setEmail(final String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * Method used to set password of the instance of the class.
	 * 
	 * @param password New password.
	 *
	 */
	
	public void setPassword(final String password) {
		this.password = password;
	}	
}