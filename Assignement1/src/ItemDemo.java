/**
 * 
 * The class {@code ItemDemo} is a class used to tracks all correspondence between People and Activities.
 * 
 */

public class ItemDemo<P, A>{
	
	/**
	 *
	 * Class fields.
	 * 
	 * P - It is a generic type. In this case it will be an instance of People.
	 * A - It is a generic type. In this case it will be an instance of Activities.
	 *
	 */
	
	private P person;
	private A activities;
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param p It is the instance of People.
	 * @param a It is the instance of Activities.
	 *
	 */
	
	public ItemDemo(final P p, final A a) {
		setPerson(p);
		setActivities(a);		
	}

	/**
	 *
	 * Method used to get the person. In this case to get the instance of People.
	 * 
	 * @return It returns the instance of People.
	 *
	 */
	
	public P getPerson() {
		return this.person;
	}
	
	/**
	 * 
	 * Method used to get activities. In this case to get the instance of Activities.
	 * 
	 * @return It returns the instance of activity.
	 *
	 */
	
	public A getActivities() {
		return this.activities;
	}
	
	/**
	 * 
	 * Method used to set person.
	 * 
	 * @param p It is the instance of People.
	 *
	 */
		
	public void setPerson(final P p){
		this.person = p;
	}
	
	/**
	 * 
	 * Method used to set activities.
	 * 
	 * @param a It is the instance of Activities.
	 *
	 */
	
	public void setActivities(final A a){
		this.activities = a;
	}	
}
