package Assignment1vin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageSrcAlt {
	
	static WebDriver driver;

	public static void main(String[] args) {
			
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		String src = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(src);
		
		String altval = driver.findElement(By.tagName("img")).getAttribute("alt");
		System.out.println(altval);
		
		
	}

}
