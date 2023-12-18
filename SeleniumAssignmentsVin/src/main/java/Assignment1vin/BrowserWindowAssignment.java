package Assignment1vin;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// parent
		
		String parentWindowId = driver.getWindowHandle();
        System.out.println(parentWindowId);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		
		//1. fetch the windows ID:		
				Set<String> handles = driver.getWindowHandles();
				
				Iterator<String> it = handles.iterator();
				
				String win1Id = it.next();
				System.out.println("win1 window id: " + win1Id);
				
				String win2Id = it.next();
				System.out.println("win2 window id: " + win2Id);

				Thread.sleep(3000);
				
		//2. switching work:
				driver.switchTo().window(win2Id);
				System.out.println("win2Id window URL:" + driver.getCurrentUrl());
				
				driver.close();//child window will be closed
				
				Thread.sleep(3000);

				
				//back to parent window:
				driver.switchTo().window(win1Id);
				System.out.println("win1 window URL:" + driver.getCurrentUrl());


		
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();

	//1. fetch the windows ID:		
		Set<String> handles2 = driver.getWindowHandles();
		
		Iterator<String> it2 = handles2.iterator();
		
		String win3Id = it2.next();
		System.out.println("win3 window id: " + win3Id);
		
		String win4Id = it2.next();
		System.out.println("win4 window id: " + win4Id);

		Thread.sleep(3000);
		
	//2. switching work:
		driver.switchTo().window(win4Id);
		System.out.println("win4Id window URL:" + driver.getCurrentUrl());
		
		driver.close();//child window will be closed
		
		Thread.sleep(3000);

		
		//back to parent window:
		driver.switchTo().window(win3Id);
		System.out.println("parent window URL:" + driver.getCurrentUrl());

		
		
		
	
		
		
//		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
//		
//		Thread.sleep(7000);
//		
//		String window3 = driver.getWindowHandle();
//		System.out.println(window3);
//		driver.switchTo().window(window3);
//		Thread.sleep(3000);
		
		
//		String url3 = driver.getCurrentUrl();
		
//		System.out.println(url3);
		
//		Thread.sleep(3000);
		
//		driver.close();
//		Thread.sleep(1000);
//		
	//	driver.switchTo().window(parentWindowId);
		
//		Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
//		
//		Thread.sleep(3000);
//		
//		String window4 = driver.getWindowHandle();
//		driver.switchTo().window(window4);
//		
//		Thread.sleep(3000);
//		String title4 = driver.getTitle();
//		String url4 = driver.getCurrentUrl();
//		System.out.println(title4);
//		System.out.println(url4);
//		Thread.sleep(3000);
//		driver.close();
//		Thread.sleep(3000);
//		driver.switchTo().window(parentWindowId);
//		
//		
//		
		
		
		
		

	}

}
