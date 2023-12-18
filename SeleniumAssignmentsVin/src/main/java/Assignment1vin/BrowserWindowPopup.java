package Assignment1vin;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindowPopup {

	
		public static void main(String[] args) throws InterruptedException {
			 WebDriver driver = new ChromeDriver();

			driver.get("https://classic.crmpro.com/");
			
			driver.findElement(By.name("username")).sendKeys("apiautomation");
			driver.findElement(By.name("password")).sendKeys("Selenium@12345");
			
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			Thread.sleep(3000);
			
			driver.switchTo().frame("mainpanel");				
			
			Thread.sleep(3000);
			
	//		driver.findElement(By.linkText("CONTACTS")).click();
			
			Actions act = new Actions(driver);
			
			act.moveToElement(driver.findElement(By.linkText("CONTACTS"))).build().perform();
			
			Thread.sleep(3000);
			
			act.moveToElement(driver.findElement(By.linkText("New Contact"))).click().build().perform();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//form[@id='contactForm']/table/tbody//tbody//input[@id='first_name']")).sendKeys("Anne");
			
			driver.findElement(By.xpath("//form[@id='contactForm']/table/tbody//tbody//input[@id='surname']")).sendKeys("Nal");
			
			driver.findElement(By.xpath("//form[@id='contactForm']/table/tbody//tbody//input[@value ='Lookup']")).click();

			//1. fetch the windows ID:		
			Set<String> handles = driver.getWindowHandles();
			
			Iterator<String> it = handles.iterator();
			
			String parentWindowId = it.next();
			System.out.println("parent window id: " + parentWindowId);
			
			String childWindowId = it.next();
			System.out.println("child window id: " + childWindowId);

			Thread.sleep(3000);
			
	       //2. switching work:
			driver.switchTo().window(childWindowId);
			System.out.println("child window URL:" + driver.getCurrentUrl());
			
			driver.findElement(By.id("search")).sendKeys("ABC");	
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@type = 'submit']")).click();
			
		    Thread.sleep(3000);

		    driver.findElement(By.linkText("ABC Tech")).click();
		
		    Thread.sleep(3000);
		    
		    driver.switchTo().window(parentWindowId);
		    
            driver.switchTo().frame("mainpanel");				
			
			Thread.sleep(3000);
		    
		    driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")).click();
		    
		
		}

}
