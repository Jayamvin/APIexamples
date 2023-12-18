package Assignment1vin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigbasketActions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");

		
//		WebElement srcEle = driver.findElement(By.id("draggable"));
//		WebElement targetEle = driver.findElement(By.id("droppable"));
//
//		//user actions: w3c webdriver standards/protocols
//		//selenium 3 --> selenium 4
//		Actions act = new Actions(driver);
//		
////		act
////			.clickAndHold(srcEle)
////					.moveToElement(targetEle)
////							.release()
////								.perform();
//										
//						
//		act.dragAndDrop(srcEle, targetEle).perform();
//		
		
		By shop = By.xpath("(//span[text()='Shop by'])[2]");
        WebElement web1 = driver.findElement(shop);
        
      //div[@id ='headlessui-menu-items-:R9bclm:']//a
      //div[@id ='headlessui-menu-items-:R9bclm:']//a[text()='Green Tea']
        // giving the current class object
		
		Actions act = new Actions(driver);
	     act.moveToElement(web1).click().build().perform();
	     act.moveToElement(driver.findElement(By.xpath("//div[@id ='headlessui-menu-items-:R9bclm:']//a[text()='Beverages']")))
	      .moveToElement(driver.findElement(By.xpath("//div[@id ='headlessui-menu-items-:R9bclm:']//a[text()='Tea']")))
	      .moveToElement(driver.findElement(By.xpath("//div[@id ='headlessui-menu-items-:R9bclm:']//a[text()='Green Tea']")))
	      .build().perform();
		
		
		
		
	}

}
