/**
 * 
 * The class {@code Member} inherit from People.
 * It defines club's members and methods used by them.
 * 
 */

public class Member extends People{
	
	/**
	 * Class constructor.
	 * 
	 * @param name It is the member's name.
	 * @param surname It is the member's surname.
	 * @param email It is the member's email.
	 * @param password It is the member's password.
	 *
	 */
		
	public Member(final String name, final String surname, final String email, final String password) {
		super(name, surname, email, password);
	}		
}