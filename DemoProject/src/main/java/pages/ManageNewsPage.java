package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	@FindBy(name = "username")WebElement userName;
	@FindBy(name = "password")WebElement passWord;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signIn;
	
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement manageNews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")WebElement newsTextField;
	@FindBy(xpath = "//button[text()='Save']")WebElement saveButton; 
	@FindBy(xpath = "//div[@class='col-sm-12']")WebElement alert;
	
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickTheManageNews() {
		manageNews.click();
	}
	
	public void clickNew() {
		newButton.click();
	}
	
	public void enterTheNews(String enternews) {
		newsTextField.sendKeys(enternews);
	}
	
	public void clickTheSave() {
		saveButton.click();
	}
	
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
		
	}
	
	
	
}
