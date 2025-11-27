package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	
	@Test
	public void verifyTheUserIsAbleToNavigateToTheManageNewsPage() throws IOException {
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUsername(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSighIn();
		
		String enternews = ExcelUtilities.readStringData(0, 0, "managenewspage");
		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickTheManageNews();
		manageNewsPage.clickNew();
		manageNewsPage.enterTheNews(enternews);
		manageNewsPage.clickTheSave();
		boolean newsDisplayed = manageNewsPage.isAlertDisplayed();
		Assert.assertTrue(newsDisplayed);
		
	}
}
