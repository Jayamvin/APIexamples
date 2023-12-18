package Assignment1vin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebtable3 {

	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		//WebTable Traversing:
		
		//table[@id="customers"]/tbody/tr[2]/td[3]
		//table[@id="customers"]/tbody/tr[3]/td[3]
		
	
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[3]";
		
		for(int row = 2; row<=rowCount; row++) { //2 to 7
			String actXpath = beforeXpath + row + afterXpath; ////table[@id='customers']/tbody/tr[3]/td[1]
			//System.out.println(actXpath);
			String country = driver.findElement(By.xpath(actXpath)).getText();
			System.out.println(country);
		}
		
		//th[text()='Company']/parent::tr/following-sibling::tr/td[3]
	
	}	
	

	

}
