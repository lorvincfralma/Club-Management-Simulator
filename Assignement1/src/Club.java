import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 
 * The class {@code Club} is used to contain the main method to simulate the system.
 * It also contains lists of persons and activities and methods used to visualize
 * the content of the lists.
 * @author Vincenzo Fraello (299647) and Lorenzo Di Palma (299636).
 * @version 1.1
 *
 */

public class Club {

	/**
	 *  Class fields:
	 *  
	 *  clubName - It is the club's name.
	 *  clubMemberList - It contains club's members.
	 *  clubAdminList - It contains club's administrators.
	 *  clubCourseList - It contains club's courses.
	 *  clubCompetitionList - It contains club's competitions.
	 *
	 */
	
	private String clubName;
	protected List<People> clubMemberList = new LinkedList<>();
	protected List<People> clubAdminList = new LinkedList<>();
	protected List<Activities> clubCourseList = new LinkedList<>();
	protected List<Activities> clubCompetitionList = new LinkedList<>();
	
	/**
	 * Class constructor.
	 * 
	 * @param name It is the club's name.
	 *
	 */

	public Club(final String name){
		this.setClubName(name);
	}
	
	/**
	 * Method used to get club's name.
	 * 
	 * @return Club's name.
	 *
	 */
	
	public String getClubName() {
		return clubName;
	}
	
	/**
	 * Method used to set club's name.
	 * 
	 * @param clubName It is the club's name parameter.
	 *
	 */

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	/**
	 * Method used to print the list that contains club's members or list 
	 * that contains club's administrator.
	 * 
	 * @param l It is the list that contains members's or administrator's club.
	 * @param role It is a string that defines the people's role.
	 *
	 */

	static public void printPeopleList(List<People> l, String role) {
		System.out.println(role + "'s club list:\n");
		
		for (People e : l) {
			System.out.println("[ID: " + e.getID() + ", Name: " + e.getName() + ", Surname: " + e.getSurname()
					+ ", email: " + e.getEmail() + ", Password: " + e.getPassword() + "]");
		}
		
		System.out.println();
	}

	/**
	 * Method used to print the list that contains club's activities (i.e courses or competitions).
	 *
	 * @param l It is the list that contains courses's or competition's club.
	 * @param a It is a string that defines the activity.
	 *
	 */

	static public void printActivitiesList(List<Activities> l, String a) {
		System.out.println(a + "'s club list:\n");
		
		for (Activities e : l) {
			System.out.println("[name: " + e.getName()+ "]\n");			
			e.printList(a, e.peopleList);
		}
		
		System.out.println();	
	}

	/**
	 *  The main method is used to execute the simulation.
	 *
	 *  @param args Not used
	 *  @throws IOException 
	 *
	 */
	
	public static void main(String[] args) throws IOException {
		
        PrintStream originalOut = System.out; // This instruction implicit replace System.out with originalOut.
        
        PrintStream fileOut = new PrintStream("./Simulation.txt"); // Create a new file output stream.
        
        System.setOut(fileOut); // Redirect standard out to file.

	
		System.out.println("----------------------------------------------------------------");
		System.out.println("|                   	    SIMULATION                         |");
		System.out.println("----------------------------------------------------------------\n");
		
		System.out.println("Authors: Vincenzo Fraello (299647) - Lorenzo Di Palma (299636)\n");
		
		System.out.println("\n1) Crea un amministratore, alcuni soci e alcune attività\n");

			// TEST 1
		
		Club club = new Club("CLUB");

		Administrator a = new Administrator("A-Francesco", "Bianchi", "fr.bianchi@gmail.com", "af2346tyr");
		Administrator a1 = new Administrator("A-Concetto", "Di Maria", "cn.dm@libero.it", "afgtry34");
		
		a.insertPeopleClub(club.clubAdminList, a, "Administrator");
		a.insertPeopleClub(club.clubAdminList, a1, "Administrator");

		Member m = new Member("M-Mario", "Rossi", "mario.rossi@gmail.com", "afdgt54");
		Member m1 = new Member("M-Pippo", "Verdi", "pippo.verdi@gmail.com", "t6fg67d8");
		Member m2 = new Member("M-Giorgio", "Manchi", "giorgio.macnhi@gmail.com", "qrt5647t");
		Member m3 = new Member("M-Lorenzo", "Frassi", "lorenzo.frs@gmail.com", "fa23459o");
		Member m4 = new Member("M-Vincenzo", "De Magistri", "vnz.dmg@gmail.com", "vnsfagx7");

		Course c = new Course("C-Corsa");
		Course c1 = new Course("C-Salto in alto");
		Course c2 = new Course("C-Basket");
		
		a.insertActivitiesClub(club.clubCourseList, c, "Course");
		a.insertActivitiesClub(club.clubCourseList, c1, "Course");
		a.insertActivitiesClub(club.clubCourseList, c2, "Course");

		Competition cc = new Competition("G-Corsa");
		Competition cc1 = new Competition("G-Basket");
		
		a.insertActivitiesClub(club.clubCompetitionList, cc, "Competition");
		a.insertActivitiesClub(club.clubCompetitionList, cc1, "Competition");		
		
		System.out.println("\n2) L’amministratore aggiunge, rimuove e modifica dei soci\n");		

			// TEST 2

		a.insertPeopleClub(club.clubMemberList, m, "Member");

		printPeopleList(club.clubMemberList, "Member");

		a.insertPeopleClub(club.clubMemberList, m1, "Member");

		printPeopleList(club.clubMemberList, "Member");

		a.insertPeopleClub(club.clubMemberList, m2, "Member");

		printPeopleList(club.clubMemberList, "Member");

		a.insertPeopleClub(club.clubMemberList, m3, "Member");

		printPeopleList(club.clubMemberList, "Member");

		a.insertPeopleClub(club.clubMemberList, m4, "Member");

		printPeopleList(club.clubMemberList, "Member");
		
			/* 
			 * SIMULAZIONI DI TEST AGGIUNTIVA:
			 * 
			 * 	viene testato che quando un membro viene rimosso dal club 
			 * 	automaticamente non deve più essere iscritto in nessuna attività.
			 *
			*/
		
//				m.subscribe(m, c, "Course");
//				m.subscribe(m1, c, "Course"); // a member can't subscribe another member
//				m1.subscribe(m1, c, "Course");
//				m2.subscribe(m2, c, "Course");
//				
//				m.subscribe(m, cc, "Competition");
//				m1.subscribe(m1, cc, "Competition");
//				
//				m.subscribe(m, c1, "Course");
//				
//				c.printList("Course", c.peopleList);
//				cc.printList("Competition", cc.peopleList);
//				c1.printList("Course", c1.peopleList);
//								
//				People.clearList(m.delete(m, c, "Course"));			
//				
//				a.deletePeopleClub(club.clubMemberList, m, "Member"); // l'amministratore rimuove il membro.
//				
//				c.printList("Course", c.peopleList);
//				cc.printList("Competition", cc.peopleList);
//				c1.printList("Course", c1.peopleList);
				
				//a.modifyPeopleData(m);

		Member member_delected = m1;
		
		System.out.println("Member to delete: " + "[ID: " + member_delected.getID() + ", Name: "
				+ member_delected.getName() + ", Surname: " + member_delected.getSurname() + ", email: "
				+ member_delected.getEmail() + "]\n");
		
		a.deletePeopleClub(club.clubMemberList, member_delected, "Member");	
				
		Member member_modify = m; 
		
		// This will be printed into console
		
		System.out.println("Member to modify: " + "[ID: " + member_modify.getID() + ", Name: " + member_modify.getName()
						+ ", Surname: " + member_modify.getSurname() + ", email: " + member_modify.getEmail() + "]\n");
		
		// This will be printed into Simulation.txt
		
		originalOut.println("Modify Member: " + "[ID: " + member_modify.getID() + ", Name: " + member_modify.getName()
		+ ", Surname: " + member_modify.getSurname() + ", email: " + member_modify.getEmail() + "]\n");
		
		// a.modifyPeopleData(m); // --> you can call this method to modify member's data but you need to show result in console.
		
		// These are the instructions executed when you call a.modifyPeopleData.
		
		 	@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
			originalOut.println("Insert 'null' if you don't want to modify: ");
			
			originalOut.print("Enter Name: ");
			String name = input.next();
			if(!(name.equals("null"))) m.setName(name);		
			
			originalOut.print("Enter Surname: ");
			String surname = input.next();
			if(!(surname.equals("null"))) m.setSurname(surname);
			
			originalOut.print("Enter Email: ");
			String email = input.next();
			if(!(email.equals("null"))) m.setEmail(email);
			
			originalOut.print("Enter Password: ");
			String passwd = input.next();
			if(!(passwd.equals("null"))) m.setPassword(passwd);
		
		//
		
		originalOut.println("\nSimulation.txt has been created...");
		
		System.setOut(fileOut); // From this point continue to write output in file.
		
		System.out.println("Member [" + member_modify.getID() + ", " + member_modify.getName() +"] modification has been successfully carried out.\n");
		
		printPeopleList(club.clubMemberList, "Member");

		System.out.println("\n3) Il sistema sceglie un socio\n");

			// TEST 3

		Random r = new Random();

		int maxM = club.clubMemberList.size();
		int maxC = club.clubCourseList.size();
		int maxCC = club.clubCompetitionList.size();
		
		int idRandomM = r.nextInt(maxM);
		int idRandomC = r.nextInt(maxC);
		int idRandomCC = r.nextInt(maxCC);
		
		
		People member_selected = club.clubMemberList.get(idRandomM);
		Activities course_selected = club.clubCourseList.get(idRandomC);
		Activities competiton_selected = club.clubCompetitionList.get(idRandomCC);

		System.out.println("[ID: " + member_selected.getID() + ", Name: " + member_selected.getName() + ", Surname: "
				+ member_selected.getSurname() + ", email: " + member_selected.getEmail() + "]");

		System.out.println(
				"\n4) Il socio si iscrive a una gara e a un corso e poi cancella l’iscrizione di una delle due attività\n");

			// TEST 4

		for (People s : club.clubMemberList) {
			if (s.getID() == member_selected.getID()) {
				s.subscribe(s, course_selected, "Course");

				course_selected.printList("Course", course_selected.peopleList);

				s.subscribe(s, competiton_selected, "Competition");

				competiton_selected.printList("Competition", competiton_selected.peopleList);
				
				People.clearList(s.delete(s, course_selected, "Course"));
			}
		}

		System.out.println("\n5) Infine il sistema presenta le informazioni possedute da soci, amministratori e attività\n");

			// TEST 5		
		
		printPeopleList(club.clubAdminList, "Admin"); // print info administrator
	
		printPeopleList(club.clubMemberList, "Member"); 	// print info member
				
		printActivitiesList(club.clubCourseList, "Course"); // print info course
		
		printActivitiesList(club.clubCompetitionList, "Competition"); // print info competition*/
	}	
}