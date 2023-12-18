package Assignment1vin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectAllCheckboxes {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("http://www.selectorshub.com/xpath-practice-page/");
		
		//input[contains(@id,'firstname_')]
		
		List <WebElement> checkboxList = driver.findElements(By.xpath("//input[contains(@id, 'ohrmList_chkSelectRecord')]"));
		 for(WebElement e : checkboxList) {
			 e.click();
			 
			 System.out.println("all checkboxes are clicked");
			 
		 }
		
	}

}
