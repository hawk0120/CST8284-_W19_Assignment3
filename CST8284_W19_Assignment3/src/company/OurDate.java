/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 * 
 * 
 * Represents a date
 */

package company;

import java.util.Calendar;

public class OurDate {
	
	private static final Calendar CAL = Calendar.getInstance();
	private int day;
	private int month;
	private int year;
	
	//Constructor
	public OurDate() {
	this.day = CAL.get(Calendar.DATE);
	this.month = CAL.get(Calendar.MONTH);
	this.year = CAL.get(Calendar.YEAR);
	} 

	//Overloaded Constructor
	public OurDate(int day, int month, int year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	} 
	
	//returns an int that represents the day of the month
	public int getDay() {
		return day;
	}
	
	//passes the day variable to the constructor of the class
	private void setDay(int day) {
		this.day = day;
	}
	
	//returns an int that represents the month 
	public int getMonth() {
		return month;
	}
	
	//passes the month variable to the constructor
	private void setMonth(int month) {
		this.month = month;
	}
	
	//returns an int that represents the year
	public int getYear() {
		return year;
	}
	
	//passes the year variable to the constructor
	private void setYear(int year) {
		this.year = year;
	}
	//returns a nicely formatted set of Strings to pass to parent classes
	@Override	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	//returns a nicely formatted set of Strings to pass to parent classes
	@Override
	public boolean equals(Object obj) {
		return obj instanceof OurDate;
	}	
	
} //End of class
