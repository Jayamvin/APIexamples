package Assignment1vin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllFieldsRegistration {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
	//	driver.findElement(By.id("input-firstname")).sendKeys("Vindhya");
		
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");	
		By tele = By.id("input-telephone");
		By pwd = By.id("input-password");
		By pwdconf = By.id("input-confirm");
		
	//	driver.findElement(fname).sendKeys("Vindhya");
	//	getElement(fname).sendKeys("Vindhya");
		
		
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
			
		eleUtil.doSendKeys(fname, "Vindhya");
		eleUtil.doSendKeys(lname, "Nalluri");
		eleUtil.doSendKeys(email, "vin@123.com");
		eleUtil.doSendKeys(tele, "8584565689");
		eleUtil.doSendKeys(pwd, "vin@123");
		eleUtil.doSendKeys(pwdconf, "vin@123");
		
		// do below these two using relativelocator 
	
		driver.findElement(By.xpath("(//div/label)[10] /input")).click();
		
		driver.findElement(By.xpath("(//input[@type = 'checkbox']")).isEnabled();
		
		
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
