/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign03_EmployementManagementSystem
 * Assignment due date: April. 14, 2019
 * 
 * 
 * Represents a date
 */

package company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;


public class OurDate implements java.io.Serializable {

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

	/// base constructor. Note input format: day, month, year, NOT year, month, day
	// as used in Calendar constructor
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

	public boolean setOurDate(String s) {
		boolean result = true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			String[] dmy = s.split("/");
			setYear(Integer.parseInt(dmy[2]));
			setMonth(Integer.parseInt(dmy[1]));
			setDay(Integer.parseInt(dmy[0]));
			CAL.setTime(dateFormat.parse(s));  // use calendar to check for impossible dates
			return result;
		} catch (NumberFormatException g) {
			throw new InputMismatchException("Bad input value; date " + s + " contains non-numeric value");
		} catch (IllegalArgumentException f) {
			throw new InputMismatchException("Bad data type passed to an internal method");
		}  catch (ParseException h) {
			throw new InputMismatchException("Date " + s + " not possible");
		} catch (RuntimeException e) {
			throw new InputMismatchException("General Runtime exception thrown setting start date");
		} 
	}




	//returns a nicely formatted set of Strings to pass to parent classes
	@Override
	public boolean equals(Object obj) {
		return obj instanceof OurDate;
	}	

} //End of class
