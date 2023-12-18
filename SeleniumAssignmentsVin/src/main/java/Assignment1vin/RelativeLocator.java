package Assignment1vin;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		
//        driver.findElement(By.xpath("(//div/label)[10] /input")).click();
//		
//		driver.findElement(By.xpath("(//input[@type = 'checkbox']")).isEnabled();
//		
//		WebElement ele = driver.findElement(By.linkText("Kamloops, Canada"));
//
//		//right of ele:
//		String rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
//		System.out.println(rightIndex);
//		
		
//		WebElement ele = driver.findElement(By.xpath("(//label[@class='radio-inline'])[1]"));
//		
//		driver.findElement(with(By.xpath("//input[@name='newsletter']"))).toRightOf(ele)).click();
//		
//		    ele.click();
//		
//		    
//		WebElement ele2 = driver.findElement(By.xpath("//b[text()='Privacy Policy']"));
//		
//		("//input[@type='checkbox']")
	}

}
