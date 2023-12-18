package Assignment1vin;

public class AmazonCartTest {

	public static void main(String[] args) {
		BrowserUtilvin  brvin = new BrowserUtilvin();
		
		brvin.launchBrowser("chrome");
		brvin.launchUrl("http://www.amazon.com");
		
		String pageurl = brvin.getPageUrl();
		if(pageurl.contains("amazon"))
		System.out.println("page url test is passed");
		
		String pagetitle = brvin.getPageTitle();
		if(pagetitle.contains("Smile more"))
		     System.out.println("smile more is presented");
		else {
			System.out.println("smile more is not presented");
		}
		
//		 if(Boolean.equals("true")) {
//			 System.out.println("pagesource has the value");
//		 }
		
		brvin.quit();
		

	}

}
