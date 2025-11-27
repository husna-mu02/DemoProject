package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;

public class Base {
	public  WebDriver driver;
	public FileInputStream fileInputStream;
	public Properties properties;
	@BeforeMethod (alwaysRun = true)
	@Parameters("browser") 
	public void browserInitialization(String browser) throws Exception {
		try{
			properties = new Properties();
			fileInputStream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileInputStream);
		}
		catch(Exception e){
			System.out.println(e);
		}
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("inval id");
		}
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	} 
	@AfterMethod (alwaysRun = true)
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshotUtility  = new ScreenshotUtility(); 
			screenshotUtility.getScreenShot(driver, iTestResult.getName());
		}
		//driver.quit();
		//driver.close();
	}
}
