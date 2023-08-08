package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

public class Login extends Base{
	
	private String username = "vinayjain";
	private String pass = "acedrfvrtgb";
	private String failMessage = "Epic sadface: Username and password do not match any user in this service";
	private String testurl = "https://www.saucedemo.com/v1/";
	//private WebDriver driver;
	
	private String userLoc = "//input[@name=\"user-name\"]";
	private String passLoc = "password";
	private String btnLoc = "login-button";
	SoftAssert soft = new SoftAssert();
	
	@Test(description="Negative test case",priority = 2, groups = {"regression", "negative"})
	public void login() {
		System.out.println("login run");
		//driver = Base.driver;
		driver.get(testurl);
		soft.assertEquals(driver.getTitle(), "Swag Labs");
		driver.findElement(By.xpath(userLoc)).sendKeys(username);
		driver.findElement(By.id(passLoc)).sendKeys(pass);
		driver.findElement(By.id(btnLoc)).click();
		String text = driver.findElement(By.xpath("//h3")).getText();
		soft.assertEquals(text, failMessage);
		soft.assertAll();
	}
	
	@Test(description = "positive test case",priority = 1, groups = {"regression", "smoke"})
	public void loginPos() {
		driver.get(testurl);
		soft.assertEquals(driver.getTitle(), "Swag Labs");
		driver.findElement(By.xpath(userLoc)).sendKeys("standard_user");
		driver.findElement(By.id(passLoc)).sendKeys("secret_sauce");
		driver.findElement(By.id(btnLoc)).click();
		String text = driver.findElement(By.xpath("//h3")).getText();
		soft.assertEquals(text, failMessage);
		soft.assertAll();
		
	}

}
