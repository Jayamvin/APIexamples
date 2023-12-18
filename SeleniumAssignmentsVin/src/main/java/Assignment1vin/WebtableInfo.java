package Assignment1vin;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//w3schools give all the company columns

public class WebtableInfo {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		driver.findElement(By.name("username")).sendKeys("apiautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		//driver.findElement(By.xpath("//a[text() = 'Josh Buttler']/parent::td/preceding-sibling::td/input[@type ='checkbox']")).click();
		
		SelectUser("Josh Buttler");
		
	    getUserInfo("Josh Buttler");
		
//	WebElement w = getUserCompanyname("Josh Buttler");    
//	//driver.findElement(By.xpath("//a[text() = 'Josh Buttler']/parent::td/following-sibling::td/a[@context='company']"));
//	System.out.println(w.getText());
//	
//	WebElement phone = getPhoneNumber("Josh Buttler"); 
//			//driver.findElement(By.xpath("(//a[text() = 'Josh Buttler']/parent::td/following-sibling::td)[2]/span[@context='phone']"));			
//	System.out.println(phone.getText());
//	
//	WebElement homephone = getHomePhnumber("Josh Buttler");
//			//driver.findElement(By.xpath("(//a[text() = 'Josh Buttler']/parent::td/following-sibling::td)[3]/span[@context='phone']"));			
//	System.out.println(homephone.getText());
//	
//	WebElement mobile = getMobile("Josh Buttler");
//			//driver.findElement(By.xpath("(//a[text() = 'Josh Buttler']/parent::td/following-sibling::td)[4]/span[@context='phone']"));			
//	System.out.println(mobile.getText());
//	
//	WebElement email = getEmail("Josh Buttler");
//			//driver.findElement(By.xpath("(//a[text() = 'Josh Buttler']/parent::td/following-sibling::td)[5]/a"));			
//	System.out.println(email.getText());	
//	
	}
	
	
	public static void SelectUser(String userName) {
		driver.findElement(By.xpath("//a[text() = '"+userName+"']/parent::td/preceding-sibling::td/input[@type ='checkbox']")).click();		
	}
	
	public static WebElement getUserCompanyname(String userName) {
		return driver.findElement(By.xpath("//a[text() = '"+userName+"']/parent::td/following-sibling::td/a[@context='company']"));		
	}
	
	public static WebElement getPhoneNumber(String userName) {
		return driver.findElement(By.xpath("(//a[text() = '"+userName+"']/parent::td/following-sibling::td)[2]/span[@context='phone']"));
	}
	
	public static WebElement getHomePhnumber(String userName) {
		return driver.findElement(By.xpath("(//a[text() = '"+userName+"']/parent::td/following-sibling::td)[3]/span[@context='phone']"));
	}
	
	public static WebElement getMobile(String userName) {
		return driver.findElement(By.xpath("(//a[text() = '"+userName+"']/parent::td/following-sibling::td)[4]/span[@context='phone']"));
	}
	
	public static WebElement getEmail(String userName) {
		return driver.findElement(By.xpath("(//a[text() = '"+userName+"']/parent::td/following-sibling::td)[5]/a"));
		
	}
	
	public static List<String> getUserInfo(String userName) {
		List<WebElement> UserInfo = driver.findElements(By.xpath("//a[text() = '"+userName+"']/parent::td/following-sibling::td"));
		List<String> colInfo = new ArrayList<String>();
		for(WebElement e :UserInfo) {
			String text = e.getText();
			colInfo.add(text);					
	}
	return colInfo;

	}	
	
//	List<WebElement> colEles = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
//	List<String> colValuesList = new ArrayList<String>();
//	for(WebElement e : colEles) {
//		String text = e.getText();
//		colValuesList.add(text);
//	}
//	return colValuesList;

	
	
	
}