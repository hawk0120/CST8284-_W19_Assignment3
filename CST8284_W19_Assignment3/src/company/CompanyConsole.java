/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 *
 *Driver for the application
 */
package company;

import java.util.Scanner;


public class CompanyConsole {

	private static final int ADDEMPLOYEE = 1;
	private static final int DISPLAYEMPLOYEES = 2;
	private static final int DISPLAYSENIOREMPLOYEE = 3;
	private static final int FIND_EMPLOYEE = 4;
	private static final int DELETE_EMPLOYEE = 5;
	private static final int SAVE_EMPLOYEES_TO_FILE = 6;
	private static final int LOAD_EMPLOYEES_FROM_FILE = 7;
	private static final int EXIT = 9;

	private Company startUp;

	Scanner in = new Scanner(System.in);

	public CompanyConsole() {
		startUp = new Company();
	}

	public static void main (String [] args) {	
		CompanyConsole console = new CompanyConsole();
		console.menu();	
	}

	public void menu(){	
		int choice;
		do{

			System.out.println("********************************************************");
			System.out.println(CompanyConsole.ADDEMPLOYEE + ".  ADD EMPLOYEE");
			System.out.println(CompanyConsole.DISPLAYEMPLOYEES+ ".  DISPLAY EMPLOYEES");
			System.out.println(CompanyConsole.DISPLAYSENIOREMPLOYEE+ ".  DISPLAY SENIOR EMPLOYEE");
			System.out.println(CompanyConsole.FIND_EMPLOYEE+ ".  FIND AN EMPLOYEE");
			System.out.println(CompanyConsole.DELETE_EMPLOYEE+ ".  DELETE AN EMPLOYEE");
			System.out.println(CompanyConsole.SAVE_EMPLOYEES_TO_FILE+ ". SAVE EMPLOYEES");
			System.out.println(CompanyConsole.LOAD_EMPLOYEES_FROM_FILE+ ". LOAD EMPLOYEES ");
			System.out.println(CompanyConsole.EXIT + ".  EXIT ");
			System.out.println("*******************************************************\n");

			System.out.print("SELECTION: ");

			choice = in.nextInt();
			in.nextLine(); 

			switch(choice){
			case CompanyConsole.ADDEMPLOYEE:
				addEmployee();
				break;
			case CompanyConsole.DISPLAYEMPLOYEES:
				displayEmployees();
				break;
			case CompanyConsole.DISPLAYSENIOREMPLOYEE:
				displaySeniorEmployee();
				break;
			case CompanyConsole.FIND_EMPLOYEE:
				findEmployee();
				break;
			case CompanyConsole.DELETE_EMPLOYEE:
				deleteEmployee();
				break;
			case CompanyConsole.SAVE_EMPLOYEES_TO_FILE:
				startUp.saveEmployeeToFile();
				break;
			case CompanyConsole.LOAD_EMPLOYEES_FROM_FILE:
				startUp.loadEmployeeFromFile();
				break;
			case CompanyConsole.EXIT:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("INVALID CHOICE; PLEASE RE-ENTER");
			}	
		} while(choice != CompanyConsole.EXIT); //end do and exit program
	}
	private void displaySeniorEmployee() {
		if(startUp.getEmployees().size() == 0){
			System.out.println("There are no employees\n");
		}
		else{
			Employee e = startUp.findSeniorEmployee();
			System.out.println("SENIOR EMPLOYEE:\n" +e.toString());
		}
	}
	private void displayEmployees() {
		System.out.println("NAME\t\t\tEMPLOYEE NO.\tSTART DATE\tSALARY\n");	
		for(int i = 0; i < startUp.currentNumberEmployees(); i++)
			if (startUp.getEmployees().get(i) !=null)
				System.out.println(startUp.getEmployees().get(i));	
	}
	private void deleteEmployee() {
		System.out.println("What is the Employee Number: ");
		Employee del = startUp.deleteEmployee(in.nextInt());
		if(del != null) {
			System.out.println("The deleted employee was succesfully deleted" );
		} else {
			System.out.println("The employee could not be deleted");

		}
	}

	private void findEmployee() {
		System.out.println("What is the Employee Number: ");
		Employee searchEmployee = startUp.findEmployee(in.nextInt()); //Creates a new employee to pass to the Company's findEmployee()
		if(searchEmployee != null) { //ensures that the employee instantiated above is null, prints resulting statement from the subclass
			System.out.println("The located employee is ");
			System.out.println(searchEmployee);
		} else {
			System.out.println("The employee could not be found");
		}
	}
	private void addEmployee() {	
		if(startUp.isMaximumEmployees()) //Checks to see if new employees are allowed to be added
			System.out.println("Attempt to exceed maximum Employee array size;\n" +
					"can't add another employee");
		else{  

			System.out.println("ENTER NEW EMPLOYEE INFORMATION:\n");
			System.out.print("NAME: ");
			String name = in.nextLine();

			System.out.print("EMPLOYEE NUMBER: ");
			int employeeNumber = in.nextInt();

			System.out.println("HIRING DATE");
			System.out.print("YEAR: ");
			int year = in.nextInt();

			System.out.print("MONTH: ");
			int month = in.nextInt();

			System.out.print("DAY: ");
			int day = in.nextInt();

			System.out.println("SALARY: ");
			double salary = in.nextDouble();

			System.out.println("Employee Type (Manager = 1, Staff = 2, Temp = 3)");
			System.out.println();
			System.out.println("Enter the Employee Type: ");
			int emptype = in.nextInt();

			Employee employee = startUp.addEmployee(name, employeeNumber, new OurDate(day, month, year), salary, emptype);
			employee.loadExtraInfo(); //loads extra info depends on which subclass is passed back to this class

		}//end else
	}
}//END CLASS COMPANYCONSOLE
