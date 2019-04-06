/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 * 
 * 
 * Represents a Temporary worker
 */
package company;

import java.util.Scanner;

public class Temp extends Employee {
	private OurDate endContractDate;
	//constructor
	public Temp() {
		this("Unkown", 1, new OurDate(30, 03, 2019), 5000.0, new OurDate(31, 03, 2019));
	}
	//Overloaded constructer, supers up to parent to get params
	public Temp(String name, int employeeNumber, OurDate startDate, double salary, OurDate endConstractDate) {
		super( name,
				employeeNumber,
				startDate,
				salary);
		this.setEndContractDate(endConstractDate);
	}
	
	//returns an OurDate that represents the last date of a contract
	public OurDate getEndContractDate() {
		return endContractDate;
	}
	//passes the endContractDate variable to the constructor
	public void setEndContractDate(OurDate endContractDate) {
		this.endContractDate = endContractDate;
	}
	//Overridden from parent class
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
	//returns a nicely formatted set of Strings to pass to parent classes
	@Override
	public String toString() {
		return super.toString() + "\t " + endContractDate;
	}
	//returns a nicely formatted set of Strings to pass to parent classes
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

