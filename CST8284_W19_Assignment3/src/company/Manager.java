/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 *
 *Represents an abstraction of an Manager
 */
package company;

import java.util.Scanner;

public class Manager extends Employee {
	private String title;
	// Constructor
	public Manager() {
		this("Unknown", 2, new OurDate(30, 03, 2019), 6000.0, "Mid Level Manager");
	} 	
	
	//Overloaded constructor, supers up to Employee to get passed params
	public Manager(String name, int employeeNumber, OurDate startDate, double salary, String title) {
		super( name,
			employeeNumber,
			startDate,
			salary);
		this.setTitle(title);
	} 
	
	//returns a String that represnts the title of the manager
	public String getTitle() {
		return title;
	}
	//passes the variable title to constructor of the class
	public void setTitle(String title) {
		this.title = title;
		
	}
	//overridden from parent class
	@Override
	public void loadExtraInfo() {
		Scanner sc = new Scanner(System.in); //creates a new scanner obj 
		System.out.println("Enter the Manager's Title: "); 
			title = sc.nextLine(); //sets title to the input of the user
		this.setTitle(title); //passes the variable title to the setter of class
	}
	//returns a nicely formatted set of Strings to pass to parent classes
	@Override
	public String toString() {
		return super.toString() + "\t " + title;
	}
	// checks to see if an obj is equal to another obj of this class
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
