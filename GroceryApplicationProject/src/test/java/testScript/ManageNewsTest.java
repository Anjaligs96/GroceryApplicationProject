package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.AdminUSersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
	
  HomePage homepage;
  ManageNewsPage managenewspage;
	@Test(priority=1,description="Verify whether user is able to Add News")
	public void verifyWhetherUserIsAbleToAddNews() throws IOException
	{
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1);
		homepage=loginpage.clickOnSignInButton();
		
		//ManageNewsPage managenewspage= new ManageNewsPage(driver);
		managenewspage=homepage.clickOnManageNewsIcon();
		
		//adminuserpage=homepage.clickOnAdminUsersIcon().clickOnNewButton();

		
		managenewspage.clickOnNewButton().enterNewsInTextArea(ExcelUtility.getStringData(0, 0, "ManageNewsPage")).clickOnSaveNewsButton();
		
		
		//Assertion
		boolean savedNewsAlertButtondisplay=managenewspage.isDisplayedNewsSavedAlertMsg();
		Assert.assertTrue(savedNewsAlertButtondisplay,"User is unable to save new News");

		
		
	}
	
	@Test(priority=2,description="Verify whether user is able to search for a news")
	public void verifyWhetherUserIsAbleToSearchNews() throws IOException
	{
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1);
		homepage=loginpage.clickOnSignInButton();
		
		//ManageNewsPage managenewspage= new ManageNewsPage(driver);
		managenewspage=homepage.clickOnManageNewsIcon().clickOnSearchNewsIcon().enterSearchNewsTitle(ExcelUtility.getStringData(0, 0, "ManageNewsPage")).clickOnSearchNewsButton();
		

		//Assertion
		String actual=managenewspage.searchPageHeading();
		String expected="Search Manage News";
		Assert.assertEquals(actual, expected,"User was unable to click on search icon");
		
		
	}
	
	@Test(priority=3,description="Verify whether user is able to click on Reset button")
	public void verifyWhetherUserIsAbleToClickOnResetButton() throws IOException
	{
		
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterPasswordOnPasswordField(password1);
		homepage=loginpage.clickOnSignInButton();
		
		//ManageNewsPage managenewspage= new ManageNewsPage(driver);
		managenewspage=homepage.clickOnManageNewsIcon().clickOnResetIcon();
		

		//Assertion
		String actual=managenewspage.resetPageHeading();
		String expected="Manage News";
		Assert.assertEquals(actual, expected,"User was able to click on reset icon");
		
	}

}
