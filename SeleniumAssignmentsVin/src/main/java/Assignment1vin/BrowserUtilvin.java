package Assignment1vin;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtilvin {
	
public static void main(String[] args) {
	
}
			
	   private WebDriver driver;
	   
	
	public WebDriver launchBrowser(String browserName) {
		System.out.println("Launch Browser :" + browserName);
		
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
			
		default:
				System.out.println("Please enter correct bowser");
				
		}
		
		return driver;
		
	}	
		public void launchUrl(String urlname) {
			if(urlname == null) {
				System.out.println("urlname is null");
				throw new AutomationExceptionvin("NULL urlname");
			}
			System.out.println("Launched Browser successfully");
			driver.get(urlname);			
		}
		
		public void launchUrl(URL url) {
			if(url == null) {
				System.out.println("URL is null");
				throw new AutomationExceptionvin("NULL URL");
			}
		
			driver.navigate().to(url);			
		}
		
	
		public String getPageTitle() {		
			String title = driver.getTitle();
			System.out.println("page title is:"+ title);
			return title;
		}
		
		public String getPageUrl() {
			String pageurl = driver.getCurrentUrl();
			System.out.println("Page URL is:"+ pageurl);
			return pageurl;
		}
		
		public Boolean getPagesource(String value) {
			String pagesource = driver.getPageSource();
			if(pagesource.contains(value)) {
				return true;
			}
		    return false;
		}
		
		public void quit() {
			driver.quit();
			
		}
		public void close() {
			driver.close();
			
		}
	
		
		
	}
	
	


