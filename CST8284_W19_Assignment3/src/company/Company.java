/*Course Name: CST8284
 * Student Name: Brady Hawkins
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
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public Company() {} //Constructor

	//returns the length of employees
	public int currentNumberEmployees() {
		return employees.size();
	}

	//No maximum because of Arraylist so returns false
	public boolean isMaximumEmployees() {
		return false;
	}

	//getter for the arraylist of employees, returns employees
	public ArrayList<Employee> getEmployees() {
		return employees;
	}


	public Employee findEmployee(int empNumber) {
		if (employees.size() == 0) { //checks to ensure that employees arraylist isn't 0, if 0 returns null
			return null;
		} 
		/*
		 * loops through the employees list searching for an employee
		 * if statement compares the parameter passed by the CompanyConsole findEmployee()
		 *  to the the current employees number, if found returns the current employee
		 *  otherwise returns null.
		 */
		for (Employee searchEmployee : employees) {
			if (searchEmployee.getEmployeeNumber() == empNumber) {
				return searchEmployee;
			}
		}

		return null;
	}
	/*checks to ensure that employees arraylist isn't 0,
	 * loops through the employees list searching for an employee
	 * if statement compares the parameter passed by the CompanyConsole deleteEmployee()
	 *  to the the current employees number, if found prints the current employee and
	 *  calls calls the inheritted method from the Arraylist class to remove it from the Arraylist.
	 *  otherwise returns null.
	 */
	public Employee deleteEmployee(int empNumber) {
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

	//Passes in 5 parameters to instantiate a new Employee, 
	// 5th param decides which case in the switch statement to invoke. 	
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
	}//End Method 

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
	}//End Method	
}// end class
