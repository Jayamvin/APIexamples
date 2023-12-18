package Assignment1vin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//amazon- get to know us all links

public class SideMenuItemClick {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By sideLinks =By.xpath("//div[@class='list-group']/a");
		clickOnElement(sideLinks, "Register");
	}
		
//		List<WebElement> sideLinks = driver.findElements(By.xpath("//div[@class='list-group']/a"));
//		 System.out.println(sideLinks.size());
//		 
//		 for(WebElement e: sideLinks) {
//			 String text = e.getText();
//			  String href = e.getAttribute("href");
//			 System.out.println(text);
//			 System.out.println(href);
//			  if(text.contains("Register")) {
//				  e.click();
//				  break;
//			  }
//			 
//		 }
//
//	}


//create utility
      public static void clickOnElement(By locator, String eleText) {
	     List<WebElement> sideLinks = driver.findElements(locator);
	 System.out.println(sideLinks.size());
	 
	 for(WebElement e: sideLinks) {
		 String text = e.getText();		
		 System.out.println(text);
		 if(text.contains(eleText)) {
			  e.click();
			  break;
		  }
	 }
      
      }
}
	
	
	
	
	


