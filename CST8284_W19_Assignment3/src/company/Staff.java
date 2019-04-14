/**Staff.java
 * @author BradyHawkins
 * @version 1.0
 * Course Name: CST8284
 * Assignment title: CST8284_W19_Assign03_EmployementManagementSystem
 * Assignment due date: April. 14, 2019
 *
 *Represents an abstraction of a Staff
 */
package company;

import java.util.Scanner;

public class Staff extends Employee {
	/**
	 * Field created to hold a string that represents the department of the Employee
	 */
	private String department;
	
	/**
	 * Constructor
	 * Instantiates it with initial values
	 */
	public Staff() {
		this("Unknown", 5, new OurDate(30, 03, 2019), 4300.0, "Finance");
	}
	
	/**
	 * Base constructor
	 * Supers up to parent class to get params
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 * @param department
	 */
	public Staff(String name, int employeeNumber, OurDate startDate, double salary, String department) {
		super(name,
			employeeNumber,
			startDate,
			salary);
		this.setDepartment(department);
	}
	
	/**
	 * Returns a string that represents the department
	 * @return String
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * Passes the department variable to the constructor
	 * @param department
	 * @return void
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * Overriden from parent class
	 * Creates a new scanner object that gets a string input and passes it to department
	 * @return void
	 */
	@Override
	public void loadExtraInfo() {
		Scanner sc = new Scanner(System.in); //Creates a new scanner obj
		System.out.println("Enter the Employee's Department: "); 
		String department = sc.nextLine(); //asks for the department of the employee
		this.setDepartment(department); //passes that employee's department to the setter
	}
	/**
	 * Returns a  formatted set of Strings to pass to parent classes
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString() + "\t " + department;
	}
	/**
	 * Compares to objects
	 * @return boolean
	 */
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
