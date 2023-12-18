package Assignment1vin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksGetFooter {

	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		List <WebElement> allLinks = driver.findElements(By.xpath("//div[text()='Get to Know Us']/parent::div//a"));
         for(WebElement e : allLinks) {
        	 String text = e.getText();
        	 System.out.println(text);
         }
		  
	}

}
