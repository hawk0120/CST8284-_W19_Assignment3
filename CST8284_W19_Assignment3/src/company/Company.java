/**Company.java
 * @author BradyHawkins
 * @version 1.0
 * Assignment title: CST8284_W19_Assign03_EmployementManagementSystem
 * Assignment due date: April. 14, 2019
 *
 *Represents an abstraction of an Company
 */
package company;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Company {
	/**
	 * New Araylist bounded to Employees instantiated to ensure added Employees are held somewhere
	 */
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	/**
	 * Company Class's no-arg constructor
	 */
	public Company() {} //Constructor

	/**
	 * Method gets the current length of employees
	 * <p>
	 * Method calls on employees Arraylist's method of size() to get the length of employees
	 * @return int
	 * 
	 */
	public int currentNumberEmployees() {
		return employees.size();
	}

	/**
	 * Method checks to see maximum employees have been reached in employees Arraylist
	 * @return boolean
	 */
	public boolean isMaximumEmployees() {
		try {
			return false;
		} catch (OutOfMemoryError e) {
			System.out.println("OutOfMemoryError thrown");
			return true;
		} //TryCatch used to catch OutOfMemoryError on Heap
	}

	/**
	 * Method gets an ArrayList of Employees
	 * @return ArrayList<Employee>
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Method searches through employees Arraylist to find an employee
	 * <p> 
	 * Method searches through employees Arraylist to find an employee. Method uses parameter employeeNumber to identify the employee
	 * @param empNumber
	 * @return Employee
	 */
	public Employee findEmployee(int empNumber) {
		/*
		 * loops through the employees list searching for an employee
		 * if statement compares the parameter passed by the CompanyConsole findEmployee()
		 *  to the the current employees number, if found returns the current employee
		 *  otherwise returns null.
		 */	
		if (employees.size() == 0) { //checks to ensure that employees arraylist isn't 0, if 0 returns null
			return null;
		} 

		for (Employee searchEmployee : employees) {
			if (searchEmployee.getEmployeeNumber() == empNumber) {
				return searchEmployee;
			}
		}

		return null;
	}
	/**
	 * Method deletes an Employee from employees Arraylist
	 * <p>
	 * Method deletes an Employee specified by the empNumber. If empNumber isn't found returns null.
	 * If empNumber is found, removes the Employee obj from employees Arraylist
	 * @param empNumber
	 * @return Employee
	 */
	public Employee deleteEmployee(int empNumber) {
		/*checks to ensure that employees arraylist isn't 0,
		 * loops through the employees list searching for an employee
		 * if statement compares the parameter passed by the CompanyConsole deleteEmployee()
		 *  to the the current employees number, if found prints the current employee and
		 *  calls calls the inheritted method from the Arraylist class to remove it from the Arraylist.
		 *  otherwise returns null.
		 */
		if (employees.size() == 0) {
			return null;
		}

		for (Employee deleteEmployee : employees) {
			if (deleteEmployee.getEmployeeNumber() == empNumber) {
				System.out.println(deleteEmployee);
				employees.remove(deleteEmployee);
				return deleteEmployee;
			}
		}

		return null;
	}

	/**
	 * This Method finds the most Senior Employee
	 * <p>
	 * Method checks to see if there employees Arraylist is empty. 
	 * If no, Compares the OurDate instance to each OurDate instance in the Employees obj that are contained int he employees Arraylist
	 * It then returns the oldest dates Employee obj
	 * @return Employee
	 */
	public Employee findSeniorEmployee() {
		if (employees.size() == 0) {
			System.out.println("There are no Employees");
			return null;
		}	
		int seniorEmployeeIndex = 0;
		Calendar calEarliestStartDate = (Calendar.getInstance()); //Calls an instance of calendar to get the earliest date it can be

		OurDate odEarliestStartDate = employees.get(seniorEmployeeIndex).getStartDate(); //sets the earliest startdate as the employee at index 0, 
		calEarliestStartDate.set(odEarliestStartDate.getYear(), odEarliestStartDate.getMonth(),
				odEarliestStartDate.getDay()); //Passes those day, month, and year to the obj declared above

		for (int employeeIndex = 1; employeeIndex < employees.size(); employeeIndex++) { //loops through employees to compare each date
			OurDate thisStartDate = employees.get(employeeIndex).getStartDate();
			Calendar calThisStartDate = Calendar.getInstance(); // need to load new instance..
			calThisStartDate.set(thisStartDate.getYear(), thisStartDate.getMonth(), thisStartDate.getDay());
			if (calThisStartDate.before(calEarliestStartDate)) {
				seniorEmployeeIndex = employeeIndex;
				calEarliestStartDate = calThisStartDate;
			}
		}
		return employees.get(seniorEmployeeIndex); //returns the most senior index found in the for loop above to pass to the CompanyConsole
	}

	/**
	 * Method instantiates subclasses of Employee
	 * <p>
	 * This method instantiates the subclasses of Employee. The method uses a switch statement. The condition is passed by emptype. 
	 * Each subclass is then instantiated and added the employees Arralist
	 * Otherwise returns null and no employee is added
	 * @param name
	 * @param employeeNumber
	 * @param date
	 * @param salary
	 * @param emptype
	 * @return Employee
	 */
	public Employee addEmployee(String name, int employeeNumber, OurDate date, double salary, int emptype) {		
		switch(emptype) {
		case 1:
			Manager manager = new Manager(name, employeeNumber, date, salary, null);
			employees.add(manager);
			return manager;
			// instantiates a new Manager and adds it to the employees arraylist, then returns that manager
		case 2:
			Staff staff = new Staff(name, employeeNumber, date, salary, null);
			employees.add(staff);
			return staff;			
			//instantiates a new Staff and adds it to the employees arraylist, then returns that staff
		case 3:
			Temp temp = new Temp(name, employeeNumber, date, salary, new OurDate());
			employees.add(temp);
			return temp;
			//instantiates a new Temp and adds it to the employees arraylist, then returns that temp
		}
		return null;		

	}

	/**
	 * Saves current employees list to file
	 *<p>
	 * Saves current employees list to file. Uses try/catch block to catch IOException that are common with File IO
	 * Writes employee Object to the file created. Closes the file
	 * @returns void
	 */
	public void saveEmployeeToFile() {
		//Saves employee List into a file called CurrentEmployees.emp

		try {
			FileOutputStream fileOut = new FileOutputStream("CurrentEmployees.emp");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

			for (Employee emp : employees) {
				objectOut.writeObject(emp);
			}	            	            
			fileOut.close();	
		} catch (IOException e) {
			System.err.println();
		}
	}

	/**
	 * loads an employee Arraylist from file
	 * <p>
	 * Loads an employee Arraylist from file. Uses try/catch block to catch EOFException, IOExceptio, ClassNotFOundException.
	 * @return void
	 */
	public void loadEmployeeFromFile(){
		//Loads employees from a file called CurrentEmployees.emp
		Employee emp;
		try {	

			InputStream ofs =  new FileInputStream("CurrentEmployees.emp");
			ObjectInputStream oos= new ObjectInputStream(ofs);
			while(true) {
				emp = (Employee)(oos.readObject());
				employees.add(emp);
			}				
		} catch (EOFException x) {
		} catch (IOException e ) {
		} catch (ClassNotFoundException c)  {
		} 
	}
}
