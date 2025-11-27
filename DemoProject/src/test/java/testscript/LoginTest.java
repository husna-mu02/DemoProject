package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{
	 
	@Test (groups = {"regression"}, retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		//String userName = "admin";
		//String passWord = "admin";
		String userName = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passWord = ExcelUtilities.readStringData(1, 1, "loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUsername(userName);
		loginPage.enterThePassword(passWord);
		loginPage.clickTheSighIn();
		boolean homepage = loginPage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
	}
	@Test
	public void verifyTheUserIsUnableToLoginUsingInvalidPassword() throws IOException {
		String username = ExcelUtilities.readStringData(2, 0, "loginpage");
		String password = ExcelUtilities.readStringData(2, 1, "loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUsername(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSighIn();
		boolean homepage = loginPage.isAlertDisplayed();
		Assert.assertTrue(homepage);
	}
	@Test
	public void verifyTheUserIsUnableToLoginUsingInvalidUsername() throws IOException {
		String username =ExcelUtilities.readStringData(3, 0, "loginpage");
		String password = ExcelUtilities.readStringData(3, 1, "loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUsername(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSighIn();
		boolean homepage = loginPage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
	}
	@Test
	public void verifyTheUserIsUnableToLoginUsingInvalidPasswordAndUsername() throws IOException {
		String username = ExcelUtilities.readStringData(4, 0, "loginpage");
		String password = ExcelUtilities.readStringData(4, 1, "loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUsername(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSighIn();
		boolean homepage = loginPage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
		
		
	}
	
	
}
