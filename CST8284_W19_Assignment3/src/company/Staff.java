/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 * 
 * 
 * Represents a Staff
 */

package company;

import java.util.Scanner;

public class Staff extends Employee {
	
	private String department;
	
	//Constructor
	public Staff() {
		this("Unknown", 5, new OurDate(30, 03, 2019), 4300.0, "Finance");
	}
	
	//overloaded constructor, supers up to parent class to get params
	public Staff(String name, int employeeNumber, OurDate startDate, double salary, String department) {
		super(name,
			employeeNumber,
			startDate,
			salary);
		this.setDepartment(department);
	}
	
	//returns a string that represents the department
	public String getDepartment() {
		return department;
	}
	//passes the department variable to the constructor
	public void setDepartment(String department) {
		this.department = department;
	}
	//Overriden from parent class
	@Override
	public void loadExtraInfo() {
		Scanner sc = new Scanner(System.in); //Creates a new scanner obj
		System.out.println("Enter the Employee's Department: "); 
		String department = sc.nextLine(); //asks for the department of the employee
		this.setDepartment(department); //passes that employee's department to the setter
	}
	//returns a nicely formatted set of Strings to pass to parent classes
	@Override
	public String toString() {
		return super.toString() + "\t " + department;
	}
	//returns a nicely formatted set of Strings to pass to parent classes
	@Override	
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Staff other = (Staff) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate()) && 
				this.getDepartment().equals(other.getDepartment())
				); 			
	}
	
	
} // End of class
