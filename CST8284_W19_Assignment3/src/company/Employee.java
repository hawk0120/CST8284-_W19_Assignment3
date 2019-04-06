/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 *
 *Represents an abstraction of an employee
 */

package company;


public abstract class Employee {
	private String name;
	private int employeeNumber;
	private OurDate startDate;
	private double salary;

	//constructor
	public Employee() {
		this("unknown", -9, new OurDate(), 1);
	}
	//overloaded costructor
	public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		this.setName(name);
		this.setEmployeeNumber(employeeNumber);
		this.setStartDate(startDate);
		this.setSalary(salary);
	}
	//returns a String that represents the full name
	public String getName() {
		return name;
	}
	//returns a int that represents the employee number, easy way to index employees
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	//returns an OurDate object that represents the start date
	public OurDate getStartDate() {
		return startDate;
	}
	//returns a double that represents the salary
	public double getSalary() {
		return salary;
	}
	//passes the name variable to constructor of the class
	private void setName(String name) {
		this.name = name;
	}
	//passes the employeeNumber variable to the constructor of the class
	private void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	//passes the startDate variable to the constructor in class
	private void setStartDate(OurDate startDate) {
		this.startDate = startDate;
	}
	//passes the  salary variable to the constructor of class
	private void setSalary(double salary) {
		this.salary = salary;
	}
	//returns a nicely formatted set of Strings to pass to parent classes
	@Override
	public String toString() {
		return name + " " + employeeNumber + " " + startDate + " " + salary;				
	}
	// checks to see if an obj is equal to another obj of this class
	@Override	
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Employee other = (Employee) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate())); 			
	}
	//abstract method to be overridden in subclass for loading classes info
	public abstract void loadExtraInfo();
}
