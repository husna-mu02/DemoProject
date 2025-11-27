package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base{
	@Test
	public void loginPage() {
		String username = "admin";
		String password = "admin";
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys(username);
		WebElement passWord = driver.findElement(By.name("password"));
		passWord.sendKeys(password);
		WebElement signIn = driver.findElement(By.xpath("//button[text()= 'Sign In' ]"));
		signIn.click();
		WebElement dashBoard = driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean isHomePageDisplayed = dashBoard.isDisplayed();
		Assert.assertTrue(isHomePageDisplayed); //asserTrue method - to pass the variable and check if it is true in assertTrue, if it's true- test case passes, else fails.
	}
	@Test
	public void incorrectUsername() {
		String username = "husna";
		String password = "admin";
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys(username);
		WebElement passWord = driver.findElement(By.name("password"));
		passWord.sendKeys(password);
		WebElement signIn = driver.findElement(By.xpath("//button[text()= 'Sign In' ]"));
		signIn.click();
		WebElement alert = driver.findElement(By.xpath("//button[@data-dismiss='alert']"));
		boolean isAlertDisplayed = alert.isDisplayed();
		Assert.assertTrue(isAlertDisplayed);
	}
	@Test
	public void incorrectPassword() {
		String username = "admin";
		String password = "husna";
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys(username);
		WebElement passWord = driver.findElement(By.name("password"));
		passWord.sendKeys(password);
		WebElement signIn = driver.findElement(By.xpath("//button[text()= 'Sign In' ]"));
		signIn.click();
		WebElement alert = driver.findElement(By.xpath("//button[@data-dismiss='alert']"));
		boolean isAlertDisplayed = alert.isDisplayed();
		Assert.assertTrue(isAlertDisplayed);
	}
	@Test
	public void incorrectUsernameAndPassword() {
		String username = "husna";
		String password = "hey";
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys(username);
		WebElement passWord = driver.findElement(By.name("password"));
		passWord.sendKeys(password);
		WebElement signIn = driver.findElement(By.xpath("//button[text()= 'Sign In' ]"));
		signIn.click();
		WebElement alert = driver.findElement(By.xpath("//button[@data-dismiss='alert']"));
		boolean isAlertDisplayed = alert.isDisplayed();
		Assert.assertTrue(isAlertDisplayed);
	}
}
