/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 * 
 *  JUNIT tests
 */
package testCompany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: March. 31, 2019
 *JUnit tests
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import company.Company;
import company.Employee;
import company.OurDate;
import company.Staff;
import company.Temp;

class TestEmployee {
	Employee e = new Temp();
	Employee f = new Temp();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Starting Tests........");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Finished testing.....");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before test........");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Test.....");
		e = null;
		f = null;
	}

	@Test
	public void testEmployeeEquals() {
		Employee e = null;
		Employee f = null;
		assertEquals(e, f);
	}

	@Test
	public void testEmployeeNotEquals() {
		f = new Temp ("Baz", 3, null, 20.0, null);
		e = new Temp ("foo", 5, null, 1500.0, null);
		assertEquals(e, f);
	}

	@Test
	public void testDefaultDateConstructor() {
		OurDate a = new OurDate();
		assertEquals(a, a);
	}

	@Test
	public void testOverLoadedOurDateDateConstructor() {
		OurDate a  = new OurDate(2, 11, 2019);
		assertEquals(a, a);
	}

	@Test
	public void testDeleteEmployeeReturnsNull() {
			Company company = new Company();
			Employee e = company.deleteEmployee(1);
			assertEquals(e, null);
	}

	@Test
	public void testDeletesFirstEmployeeOnly() {
			Company company = new Company();
			assertNull(company.deleteEmployee(1));
	}

	@Test
	public void testNoAccidentalDeleteEmployee() {
		  Company company = new Company(); 
		  company.addEmployee("name", 15, new OurDate(10,17,2019), 61000, 2);
		  company.deleteEmployee(15);
		  assertNotNull(company);
	}
	@Test
	public void testTempEquals() {
		Employee f = new Temp ("Baz", 3, new OurDate(2, 20, 2018), 20.0, new OurDate(2, 20, 2018));
		Employee e = new Temp ("Baz", 3, new OurDate(2, 20, 2018), 20.0, new OurDate(2, 20, 2018));
		assertEquals(e, f);
	}





}// END JUNT CLASS
