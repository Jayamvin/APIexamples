package Assignment1vin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//15--yes, privacy policy

public class IFrameHandleAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();//browser - chrome

		//page
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page
		Thread.sleep(3000);
		
//		driver.findElement(By.cssSelector("#imageTemplateContainer img")).click(); 
		
		driver.findElement(By.xpath("//div[@id='imageTemplateContainer']/img")).click();
		Thread.sleep(3000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
//		//iframe[contains(@id, 'frame-one')]
		
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("automation");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("San Diego");
		driver.findElement(By.id("RESULT_TextArea-5")).sendKeys("selenium practice test");
		Thread.sleep(3000);
		
		
		//driver.findElement(By.className("//div[@class='file_upload_files']")).click();
		//driver.findElement(By.name("RESULT_FileUpload-6")).sendKeys("C:/vindhya/API Class/VinJavaClassNotes"); //give a file path
		
		
		
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("Vindhya");
		driver.findElement(By.id("RESULT_TextField-9")).sendKeys("Nalluri");
		driver.findElement(By.id("RESULT_TextField-10")).sendKeys("8210 Torrey Gardens Place");
		driver.findElement(By.id("RESULT_TextField-12")).sendKeys("San Diego");
		driver.findElement(By.id("RESULT_RadioButton-13")).sendKeys("California");
//		driver.findElement(By.id("RESULT_FileUpload-6")).sendKeys("automation");
//		driver.findElement(By.id("RESULT_FileUpload-6")).sendKeys("automation");
//		driver.findElement(By.id("RESULT_FileUpload-6")).sendKeys("automation");
//		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		String header = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(header);
				

	}

}
