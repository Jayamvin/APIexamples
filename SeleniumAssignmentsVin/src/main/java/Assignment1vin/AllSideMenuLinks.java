package Assignment1vin;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllSideMenuLinks {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By sideMenu = By.className("list-group-item");
		
		ElementUtil eleUtil = new ElementUtil(driver);
				
		List<String> menuLinkList = eleUtil.getElementsTextList(sideMenu);
		System.out.println(menuLinkList.size());
		
		    for(String e: menuLinkList) {
		    	System.out.println(e);
		    }
		
		    List<String> expectedMenu = Arrays.asList("Login", "Register", "My Account");
			
			if(menuLinkList.containsAll(expectedMenu)) {
				System.out.println("All verification links --- PASS");
			}
					
		
		

		
		
		
		
		
		
//		List<WebElement> menuLinks = driver.findElements(sideMenu);
//		
//		System.out.println(menuLinks.size());
//		
//		for(WebElement e : menuLinks) {
//			String text = e.getText();
//			System.out.println(text);
//		}
//		
		
		
		
		
		

	}

}
