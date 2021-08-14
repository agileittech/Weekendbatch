package org.magnitia.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngwithselenium {
	WebDriver webdriver;
@BeforeTest
public void precondition() {
	System.setProperty("webdriver.gecko.driver","C:\\Magnitia Batch_Weekend\\Seleniummvn\\src\\test\\resources\\geckodriver.exe");
    webdriver =new FirefoxDriver();
}
@Test(priority = 1)
public void openurl() {
	webdriver.get("https://www.phptravels.net/home");
	String Expected = "PHPTRAVELS | Travel Technology Partner";
	String Actual = webdriver.getTitle();
	Assert.assertEquals(Actual, Expected);
}
@Test(priority =2,dependsOnMethods = "openurl")
public void clickmyaccount() {
	webdriver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div")).click();
    Actions a = new Actions(webdriver);
    WebElement login =  webdriver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[1]"));
    a.moveToElement(login).click().build().perform();
    WebDriverWait wd = new WebDriverWait(webdriver, 30);
    wd.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    Assert.assertEquals(webdriver.getTitle(), "Login");
    
}
@Test(priority =3,dependsOnMethods = "clickmyaccount")
public void login() {
	webdriver.findElement(By.name("username")).sendKeys("user@phptravels.com");
	webdriver.findElement(By.name("password")).sendKeys("demouser");
	webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/button")).click();
	WebDriverWait wd = new WebDriverWait(webdriver, 30);
    wd.until(ExpectedConditions.titleIs("My Account"));
	Assert.assertEquals(webdriver.getTitle(), "My Account");
}
//
//customer
//Email user@phptravels.com
//Password demouser

}
