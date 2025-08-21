package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{
	
	HomePage homepage;
	@Test(priority=1,description="Verify whether user is able to successfully logout")
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException
	{
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1);
		homepage=loginpage.clickOnSignInButton().clickOnAdminIcon();
		
		//HomePage homepage= new HomePage(driver);
		homepage.clickOnAdminIcon();
		loginpage=homepage.clickOnLogout();
		
		
		//Assertion
		String actual=homepage.loginpageHeading();
		String expected="7rmart supermarkete";
		Assert.assertEquals(actual, expected,"User was unable to logout");
	}
	
	

}
