package Assignment1vin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetImageSrcAltvalue {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20");
		
		String src = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(src);
		
		String alt = driver.findElement(By.className("img-responsive")).getAttribute("alt");
		System.out.println(alt);
		
		String title = driver.findElement(By.tagName("img")).getAttribute("title");
		System.out.println(title);
		
		
//		<img src="https://naveenautomationlabs.com/opencart/image/cache/catalog/demo/apple_cinema_30-228x228.jpg" 
//				alt="Apple Cinema 30&quot;" title="Apple Cinema 30&quot;" class="img-responsive">
		
		
		
	
	
}
}