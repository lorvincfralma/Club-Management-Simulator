import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * The class {@code Administrator} inherit from Member.
 * It defines club's administrator and methods used by them.
 * It inherit form Member because an Administrator operate member's activities 
 * and other functions that only an administrator can do.
 * 
 */

public class Administrator extends Member{

	/**
	 * Class constructor.
	 * 
	 * @param name It is the administrator's name.
	 * @param surname It is the administrator's surname.
	 * @param email It is the administrator's email.
	 * @param password It is the administrator's password.
	 */
	
	public Administrator(final String name, final String surname, final String email, final String password) {
		super(name, surname, email, password);
	}
	
	/**
	 * 
	 * Method used by administrator to insert a person into the club.
	 * 
	 * @param l It is the list where People will be inserted.
	 * @param p It is the member or administrator to insert.
	 * @param pers It is a string that defines the role.
	 * @return It is used to exit from the method.
	 * 
	 **/
		
	public int insertPeopleClub(final List<People> l, final People p, final String pers) {
		for(People s: l) {
			if(s.getID() == p.getID()) {
				System.out.println(pers + " ["  + p.getID() + ", " + p.getName() + "] " + "is already registered into the club.\n");
				return 1;
			}
		}
		
		l.add(p);
		System.out.println(pers + " registration [" + p.getID() + ", " + p.getName()+"] " + "into the club has been successfully carried out.\n");
		return 0;
	}
	
	/**
	 * 
	 * Method used by administrator to remove a person from the club.
	 * This method also call another method to remove from all activities the person
	 * who is removed from the club.
	 * 
	 * @param l It is the list where People will be removed.
	 * @param p It is the people to remove.
	 * @param pers It is a string that defines the role.
	 * @return It is used to exit from method.
	 * 
	 * {@link People#deleteFromAllActivities(People) }
	 **/

	public int deletePeopleClub(final List<People> l, final People p, final String pers) {
		for(People s: l) {
			if(s.getID() == p.getID()) {
				l.remove(s);				
				deleteFromAllActivities(s); // method that remove the person from all the club's activities.				
				System.out.println(pers + " [" + p.getID() + ", " + p.getName() + "] " + "remoaval has been successfully carried out.\n");
				return 1;
			}
		}
		
		System.out.println(pers + " is not registered with the club and therefore cannot be eliminated.\n");
		return 0;
	}	
	
	/**
	 * 
	 * Method used by administrator to modify member's data.
	 * 
	 * @param p Member or Administrator whose data needs to be modified.
	 * @throws FileNotFoundException
	 *
	 */
	
	public void modifyPeopleData(People p) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insert 'null' if you don't want to modify: ");
		
		System.out.print("Enter Name: ");
		String name = input.next();
		if(!(name.equals("null"))) p.setName(name);		
		
		System.out.print("Enter Surname: ");
		String surname = input.next();
		if(!(surname.equals("null"))) p.setSurname(surname);
		
		System.out.print("Enter Email: ");
		String email = input.next();
		if(!(email.equals("null"))) p.setEmail(email);
		
		System.out.print("Enter Password: ");
		String passwd = input.next();
		if(!(passwd.equals("null"))) p.setPassword(passwd); 
		
	}
	
	/**
	 * Method used by administrator to insert an activity into the club.
	 * 
	 * @param l It is list of the club's activity.
	 * @param a It is activity to insert into the club.
	 * @param act It is a string that defines the activity.
	 * @return It is used to exit from the method.
	 *
	 */
	
	public int insertActivitiesClub(final List<Activities> l, final Activities a, final String act) {
		for(Activities s: l) {
			if(s.getName() == a.getName()) {
				System.out.println(act + " already present in the club.\n");
				return 1;
			}
		}
		
		l.add(a);
		System.out.println(act + " [" + a.getName() + "] has been successfully entered into the club.\n");
		return 0;
	}
	
	/**
	 * Method used by administrator to delete activity from club.
	 * 
	 * @param l List of the club's activity.
	 * @param a Activity to delete into the club.
	 * @param act It is a string that defines the activity.
	 * @return It is used to exit from method.
	 *
	 */
	
	public int deleteActivityClub(final List<Activities> l, final Activities a, final String act) {
		for(Activities s: l) {
			if(s.getName() == a.getName()) {
				a.peopleList.clear(); // Deleting an activity it's important to clear the list of people subscribed in that activity.
				l.remove(s);
				System.out.println(act + " [" + a.getName() + "] has been successfully removed from the club.\n");
				return 1;
			}
		}
		
		System.out.println(act + " does not exist in the club so it cannot be deleted.\n");
		return 0;
	}	
	
	/**
	 * 
	 * Method used by administrator to modify activity's data.
	 * 
	 * @param a Activity to modify.
	 */

	public void modifyActivityData(Activities a) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insert 'null' if you don't want to modify: ");
		
		System.out.print("Enter Name: ");
		String name = input.next();
		if(!(name.equals("null"))) a.setName(name);			
	}
}