package Assignment1vin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TotalImages {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("http://amazon.com/");
//	    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20");
//		List<WebElement> imgList = driver.findElements(By.tagName("img"));
//		System.out.println(imgList.size());
//		
//		  for(WebElement e: imgList) {
//			String altval = e.getAttribute("alt");
//			String srcval = e.getAttribute("src");
//			
//			System.out.println(altval +"===="+ srcval);
//			
//		}
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		int linksCount = eleUtil.getElementsCount(links);
		System.out.println(linksCount);
	
		int imgaesCount = eleUtil.getElementsCount(images);
		System.out.println(imgaesCount);
		
//		List<String> actualLinkText = eleUtil.getElementsTextList(links);
//          System.out.println(actualLinkText);
//          
          
		List<String> hreflists = eleUtil.getElementsAttributeList(links, "href");
		for (String e: hreflists) {
			System.out.println(e);
		}
		
	//	System.out.println(hreflists);
          
	}
	
	
	// WAF : capture the text of all the page links and return List<String>.
		public static List<String> getElementsTextList(By locator) {
			List<WebElement> eleList = getElements(locator);//30 elements
			
			List<String> eleTextList = new ArrayList<String>();// pc=0 {}
			
			for (WebElement e : eleList) {
				String text = e.getText();

				if (text.length() != 0) {
					eleTextList.add(text);
				}
			}
			return eleTextList;
		}
		
		// WAF: capture specific attribute from the list:
		public static List<String> getElementsAttributeList(By locator, String attrName) {
			List<WebElement> eleList = getElements(locator);
			List<String> eleAttrList = new ArrayList<String>();// pc=0 {}

			for (WebElement e : eleList) {
				String attrValue = e.getAttribute(attrName);
				eleAttrList.add(attrValue);
			}

			return eleAttrList;

		}

	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}


