package labcodeinspection;

import java.io.Serializable;
import java.util.Locale;
import java.util.logging.Logger;

public class Email implements Serializable {

	private String m_firstName; //NOPMD This field will be manipulated later
	private String m_lastName;  //NOPMD this field will be manipulated later
	private transient String password;
	private transient String department;
	private final transient int defaultpasswordLength;
	private transient String email;

	/**
	*
	*
	* @method Email
	*/
	
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
		this.defaultpasswordLength = 8;
	}
	
	
	/**
	*
	*
	* @method showInfo
	*/
	@SuppressWarnings("PMD.GuardLogStatement")
	public void showInfo() {
		Logger log = Logger.getLogger(Email.class.getName());
		log.fine("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		log.fine("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}
	
	/**
	*
	*
	* @method setDepartment
	*/
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			break;
		}
	}
	
	/**
	*
	*
	* @method randomPassword
	*/
	@SuppressWarnings("PMD.StringInstantiation")
	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}
	
	/**
	*
	*
	* @method generateEmail
	*/
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpasswordLength);
		this.email = this.m_firstName.toLowerCase(Locale.ROOT) + this.m_lastName.toLowerCase(Locale.ROOT) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
