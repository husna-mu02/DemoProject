package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class LoginPage {
	@FindBy(name = "username")WebElement userName;
	@FindBy(xpath = "//input[@name='password']")WebElement passWord;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signIn;
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashBoard;
	@FindBy(xpath = "//button[@data-dismiss='alert']")WebElement alert;
	
	public WebDriver driver; 
	public LoginPage(WebDriver driver) {
		//driver = driver; here both are local, so use this keyword
		this.driver = driver;
		PageFactory.initElements(driver, this);//initElements used to initialise web elements
	}
	
	public void enterTheUsername(String userName2) {
		userName.sendKeys(userName2);
	}
	public void enterThePassword(String passWord2) {
		passWord.sendKeys(passWord2);
	}
	public void clickTheSighIn() {
		signIn.click();
		//PageUtilities pageUtilities = new PageUtilities();
		//pageUtilities.selectByVisibleText(alert, null);
	}
	public boolean isHomePageDisplayed() {
	return dashBoard.isDisplayed();
	}
	
	public boolean isAlertDisplayed() {
	return alert.isDisplayed();
	}
	
}
