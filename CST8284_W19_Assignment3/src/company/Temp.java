/**Temp.java
 * @author BradyHawkins
 * @version 1.0
 * Course Name: CST8284
 * Assignment title: CST8284_W19_Assign03_EmployementManagementSystem
 * Assignment due date: April. 14, 2019
 *
 *Represents an abstraction of an Temporay Employee
 */
package company;

import java.util.Scanner;

public class Temp extends Employee {
	/**
	 * Field created to hold an OurDate obj that represents the last day of the contract of the Employee
	 */
	private OurDate endContractDate;
	/**
	 * Constructor
	 * Instantiates it with initial values
	 */
	public Temp() {
		this("Unkown", 1, new OurDate(30, 03, 2019), 5000.0, new OurDate(31, 03, 2019));
	}
	/**
	 * Base Constructor
	 * Supers up to get the parameters instantiated in Employee
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 * @param endConstractDate
	 */
	public Temp(String name, int employeeNumber, OurDate startDate, double salary, OurDate endConstractDate) {
		super( name,
				employeeNumber,
				startDate,
				salary);
		this.setEndContractDate(endConstractDate);
	}
	
	/**
	 * returns an OurDate that represents the last date of a contract
	 * @return OurDate
	 */
	public OurDate getEndContractDate() {
		return endContractDate;
	}
	/**
	 * passes the endContractDate variable to the constructor
	 * @param endContractDate
	 * @return void
	 */
	public void setEndContractDate(OurDate endContractDate) {
		this.endContractDate = endContractDate;
	}
	/**
	 * Overridden from parent class
	 * This method askes for the end of the date of the contracct
	 * @return void
	 */
	@Override
	public void loadExtraInfo() {
		Scanner sc = new Scanner(System.in); //Creates a new scanner obj
		System.out.println("DATE ");
			System.out.println("YEAR: ");
			int year = sc.nextInt();
			System.out.println("MONTH: ");
			int month = sc.nextInt();
			System.out.println("DAY: ");
			int day = sc.nextInt();
			//creates variable and takes input to create an OurDate obj
			OurDate date = new OurDate(day, month, year);			
		this.setEndContractDate(date); //passes the OurDate obj to the setter
	}
	/**
	 * returns a formatted set of Strings to pass to parent classes
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString() + "\t " + endContractDate;
	}
	/**
	 * returns a nicely formatted set of Strings to pass to parent classes
	 */
	@Override	
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Temp other = (Temp) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate()) && 
				this.getEndContractDate().equals(other.getEndContractDate())
				); }	
} // End of class

