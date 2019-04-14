/**Manager.java
 * @author BradyHawkins
 * @version 1.0
 * Course Name: CST8284
 * Assignment title: CST8284_W19_Assign03_EmployementManagementSystem
 * Assignment due date: April. 14, 2019
 *
 *Represents an abstraction of an Manager
 */
package company;

import java.util.Scanner;

public class Manager extends Employee {
	/**
	 * Field created to hold a string that represents the title of the Employee
	 */
	private String title;
	/**
	 * Constructor
	 * Instantiates it with initial values
	 */
	public Manager() {
		this("Unknown", 2, new OurDate(30, 03, 2019), 6000.0, "Mid Level Manager");
	} 	
	
	/**
	 * Base Construct
	 * Supers up to Employee to get passed params
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 * @param title
	 */
	public Manager(String name, int employeeNumber, OurDate startDate, double salary, String title) {
		super( name,
			employeeNumber,
			startDate,
			salary);
		this.setTitle(title);
	} 
	
	/**
	 * returns a String that represents the title of the manager
	 * @return String
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Passes the variable title to constructor of the class
	 * @param title
	 * @return void
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Overridden from parent class
	 * Loads a new scanner obj passes the input to title
	 */
	@Override
	public void loadExtraInfo() {
		Scanner sc = new Scanner(System.in); //creates a new scanner obj 
		System.out.println("Enter the Manager's Title: "); 
			title = sc.nextLine(); //sets title to the input of the user
		this.setTitle(title); //passes the variable title to the setter of class
	}
	/**
	 * returns a formatted set of Strings to pass to parent classes
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString() + "\t " + title;
	}
	/**
	 * Checks to see if an obj is equal to another obj of this class
	 * @retruns boolean
	 */
	@Override	
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Manager other = (Manager) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate()) && 
				this.getTitle().equals(other.getTitle())
				); 			
	}
	
}// End of class
