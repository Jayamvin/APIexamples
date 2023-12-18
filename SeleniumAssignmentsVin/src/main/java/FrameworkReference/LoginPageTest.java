package FrameworkReference;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {
	
	// this code and files are WIP(work in progress) on framework-- before properties file, constans file and utilities file 
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains("account/login"));
	}

	@Test(priority = 3)
	public void fogotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test(priority = 4)
	public void appLogoExistTest() {
		Assert.assertTrue(loginPage.isLogoExist());
	}

	@Test(priority = 5)
	public void loginTest() {
		Assert.assertTrue(loginPage.doLogin("augbatch2023@opencart.com", "Selenium@12345"));
	}


}
