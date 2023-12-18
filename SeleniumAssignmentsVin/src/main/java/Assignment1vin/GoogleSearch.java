package Assignment1vin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		
		By searchField = By.name("q");
	
		By searchXpath = By.xpath("//div[@class='wM6W7d']/span");
		
		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		
		Thread.sleep(3000);
		
		List<WebElement> suggList = driver.findElements(searchXpath);
		
		System.out.println(suggList.size());
		
		for(WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains("interview questions")) {
				  e.click();
				  break;
			}
			
		}
		
//		Search(searchField, searchXpath, "Selenium Automation", "interview questions");
//		
//				
//    public static void Search(By searchField1, By searchXpath1, String searchKey, String suggName)throws InterruptedException{
//    
//     driver.findElement(searchField).sendKeys(searchKey);
//		
//		Thread.sleep(3000);
//		
//		List<WebElement> suggList = driver.findElements(searchXpath);
//		
//		System.out.println(suggList.size());
//		
//		for(WebElement e : suggList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.contains(suggName)) {
//				  e.click();
//				  break;
//			}
//			
//		}
//    	
    	
    }

		
		
		

	

}
