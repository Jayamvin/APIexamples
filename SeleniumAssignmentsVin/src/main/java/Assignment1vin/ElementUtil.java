package Assignment1vin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

 private WebDriver driver;	
	

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
// findElement methods 
	
	public String doGetElementAttribute(By locator, String value) {
		return getElement(locator).getAttribute(value);
	}
	
	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
		
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
// findElements methods 	
	
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	// WAF : capture the text of all the page links and return List<String>.
			public List<String> getElementsTextList(By locator) {
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
			public List<String> getElementsAttributeList(By locator, String attrName) {
				List<WebElement> eleList = getElements(locator);
				List<String> eleAttrList = new ArrayList<String>();// pc=0 {}

				for (WebElement e : eleList) {
					String attrValue = e.getAttribute(attrName);
					eleAttrList.add(attrValue);
				}

				return eleAttrList;

			}

}
