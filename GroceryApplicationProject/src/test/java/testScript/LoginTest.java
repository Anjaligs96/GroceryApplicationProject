package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	
	HomePage homepage;
	
	@Test(priority=1,description="Verify whether user is able to login with valid credentials",retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1);
		homepage=loginpage.clickOnSignInButton();
		
		//Assertion
		boolean dashboarddisplay=loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay,"User is unable to login with valid credentials");

	}

	@Test(priority=2,description="Verify whether user is able to login with valid username and invalid password",groups="smoke")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {

		String username1=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1).clickOnSignInButton();
		
		//Assertion
		String actual=loginpage.pageHeading();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was able to login with invalid password");
		
	}

	@Test(priority=3,description="Verify whether user is able to login with invalid username and valid password",groups="smoke")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username1=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1).clickOnSignInButton();
		
		//Assertion
		String actual=loginpage.pageHeading();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was able to login with invalid password");
	}

	@Test(priority=4,description="Verify whether user is able to login with invalid username and invalid password",dataProvider = "loginProvider")
	public void verifyUserLoginWithInValidCredentials(String username1, String password1) throws IOException {
		//String username1=ExcelUtility.getStringData(3, 0, "LoginPage");
		//String password1=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1).clickOnSignInButton();
		
		//Assertion
		String actual=loginpage.pageHeading();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was able to login with invalid password");
		
		
	}
	
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
	return new Object[][] { new Object[] {"admin123","admin1234"},
	new Object[] {"123","123"},
	//new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}

}
