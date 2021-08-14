package org.magnitia.testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class Testngdemo {
@Test(priority = 1)
public void myfirsttestcase() {
	System.out.println("This is my 1st test case ");
	Assert.assertEquals("Actual", "Expected");
	System.out.println("This line wont be printed as i will use hard assertion");
}
@Test(priority =3)
public void mysecondtestcase() {
	SoftAssert a = new SoftAssert();
	a.assertEquals("Actual", "Expcted");
	System.out.println("This is my 2nd test case");
	a.assertAll();
}
@Test(priority =2,dependsOnMethods = "myfirsttestcase")
public void mythirdtestcase() {
	System.out.println("This is my 3rd test case");
}
@BeforeTest
public void preconditions() {
	System.out.println("This is precondition");
}
@AfterTest
public void postconditions() {
	System.out.println("This is post condition");
}
}
