package labcodeinspection;

import java.util.Scanner;
import java.util.logging.Logger;

@SuppressWarnings("PMD.UseUtilityClass")
public class EmailApp {
	
	/**
	*
	*
	* @method main
	*/
	@SuppressWarnings("PMD.GuardLogStatement")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Logger log = Logger.getLogger(EmailApp.class.getName());
		log.fine("Enter your first name: ");
	
		String firstName = sc.nextLine();

		log.fine("Enter your last name: ");
		
		String lastName = sc.nextLine();

		log.fine("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");
		
		int depChoice = sc.nextInt();
		sc.close();

		Email email = new Email(firstName, lastName);
		email.setDeparment(depChoice);
		email.generateEmail();
		email.showInfo();
	}
	

}
