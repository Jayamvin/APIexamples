package Assignment1vin;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteContact {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();

			driver.get("https://classic.crmpro.com/");
			
			driver.findElement(By.name("username")).sendKeys("apiautomation");
			driver.findElement(By.name("password")).sendKeys("Selenium@12345");
			
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			Thread.sleep(3000);
			
			driver.switchTo().frame("mainpanel");				
			
			Thread.sleep(3000);
			
			driver.findElement(By.linkText("CONTACTS")).click();
			
		WebElement ele = driver.findElement(By.xpath("//a[text()= 'Anne Nal']"));	
			
		String ele1 = driver.findElement(By.xpath("//a[text()= 'Anne Nal']")).getText();
		System.out.println(ele1);
		
       driver.findElement(By.xpath("(//form[@id = 'vContactsForm']//tbody//tr)[7]//input[@type='checkbox']")).click();
		
		//right of ele:
		String rightele = driver.findElement(with(By.xpath("//a[text()='ABC Tech']")).toRightOf(ele)).getText();		
		System.out.println(rightele);
		
//		WebElement leftele = driver.findElement(with(By.xpath("//input[@type ='checkbox']")))).toLeftOf(ele).click();
		
		WebElement selectoption1 = driver.findElement(By.xpath("//select[@name ='do_action']"));
		
		Select select1 = new Select(selectoption1);
		
		select1.selectByValue("DELETE");
		
		driver.findElement(By.xpath("//input[@value='DO']")).click();

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		Thread.sleep(3000);
//		alert.accept();//accept the alert
		
		alert.dismiss();//cancel the alert
		
	
	
	
	}
	
	

}
