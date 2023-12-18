package Assignment1vin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllGetAttribute {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		String placeholder = driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
		System.out.println(placeholder);
		
		//doGetElementAttribute(pwd, "value");
		
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");	
		By tele = By.id("input-telephone");
		By pwd = By.id("input-password");
		By pwdconf = By.id("input-confirm");
	 
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(fname, "Vindhya");
		String fnameval = eleUtil.doGetElementAttribute(fname, "value");
		System.out.println(fnameval);
		
		eleUtil.doSendKeys(lname, "Nalluri");
		String lnameval = eleUtil.doGetElementAttribute(lname, "value");
		System.out.println(lnameval);
		
		eleUtil.doSendKeys(email, "vin@123.com");
		String emailval = eleUtil.doGetElementAttribute(email, "value");
		System.out.println(emailval);
		
		eleUtil.doSendKeys(tele, "8584565689");
		String televal = eleUtil.doGetElementAttribute(tele, "value");
		System.out.println(televal);
		
		eleUtil.doSendKeys(pwd, "vin@123");
		String pwdval = eleUtil.doGetElementAttribute(pwd, "value");
		System.out.println(pwdval);
		
		eleUtil.doSendKeys(pwdconf, "vin@123");
		String pwdconfval = eleUtil.doGetElementAttribute(pwdconf, "value");
		System.out.println(pwdconfval);
		
	}
	
	public static String doGetElementAttribute(By locator, String value) {
		return getElement(locator).getAttribute(value);
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	
}
