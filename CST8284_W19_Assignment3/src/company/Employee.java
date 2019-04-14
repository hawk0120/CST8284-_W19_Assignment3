/**Employee.java
 * @author BradyHawkins
 * @version 1.0
 * Course Name: CST8284
 * Assignment title: CST8284_W19_Assign03_EmployementManagementSystem
 * Assignment due date: April. 14, 2019
 *
 *Represents an abstraction of an employee
 */

package company;

import java.util.InputMismatchException;

public abstract class Employee implements java.io.Serializable {

	/**
	 * Fields created to hold values passed to class
	 */
	private String name;
	private int employeeNumber;
	private OurDate startDate;
	private double salary;

	/**
	 * Constructor
	 * Instantiates it with initial values
	 */
	public Employee() {
		this("unknown", -9, new OurDate(), 1);
	}
	/**
	 * Base constructor
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 */
	public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		this.setName(name);
		this.setEmployeeNumber(employeeNumber);
		this.setStartDate(startDate);
		this.setSalary(salary);
	}
	
	
	/**
	 * Retuns a String that represents the Employees name
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * returns a int that represents the employee number, easy way to index employees
	 * @return int
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * Returns an OurDate object that represents the start date
	 * @return OurDate
	 */
	public OurDate getStartDate() {
		return startDate;
	}
	/**
	 * returns a double that represents the salary
	 * @return double
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * Passes the name to isInputNameCorrect, if correct passes the name variable to constructor of the class
	 * @param name
	 * @return void
	 */
	private void setName(String name) {
		if(isInputNameCorrect(name)) {
			this.name = name;
		} 
	}
	/**
	 * Passes the employeeNumber to isDigit, if false passes the employeeNumber variable to the constructor of the class
	 * 
	 * @param employeeNumber
	 * @return void
	 * 
	 */
	private void setEmployeeNumber(int employeeNumber) {
		if (!(isDigit(employeeNumber))) {
			this.employeeNumber = employeeNumber;
		}
	}
	/**
	 * passes the startDate variable to the constructor in class
	 * @return void
	 * @param startDate
	 */
	private void setStartDate(OurDate startDate) {
		this.startDate = startDate;
	}
	/**
	 * passes the  salary variable to the constructor of class
	 * @param salary
	 * @return void
	 */
	private void setSalary(double salary) {
		this.salary = salary;

	}
	/**
	 * Returns a formatted set of Strings to pass to parent classes
	 * @return String
	 */
	@Override
	public String toString() {
		return name + " " + employeeNumber + " " + startDate + " " + salary;				
	}

	/**
	 * Passes a String value to check if that string contains character values
	 * Checks to see if name parameter has a digit in it
	 * @throws InputMismatchException
	 * @param name
	 * @return boolean
	 */
	public boolean isInputNameCorrect(String name) {

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (Character.isDigit(c)) {
				throw new InputMismatchException("Cannot enter a Numeric value into the name");
			} //loops through name, if digit is found - throw InputMismatchException
		}
		return true;
	}



	/**
	 * Passes an int parameter to check if that int contains any character values
	 * Checks to see if num parameter has a char in it
	 * @param num
	 * @return boolean
	 * @throws InputMismatchException
	 */
	public boolean isDigit(int num) {
		String str = Integer.toString(num);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!(Character.isDigit(c))) {
				throw new InputMismatchException("Cannot enter a character into a numeric value");
			} ////loops through num, if digit is found - throw InputMismatchException
		}
		return true;
	}



	/**
	 *  checks to see if an obj is equal to another obj of this class
	 *  @return boolean
	 *  @param obj
	 */
	@Override	
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Employee other = (Employee) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate())); 			
	}
	/**
	 * abstract method to be overridden in subclass for loading classes info
	 * @return void
	 */
	public abstract void loadExtraInfo();
}
