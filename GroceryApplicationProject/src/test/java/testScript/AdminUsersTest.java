package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.AdminUSersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends TestNGBase{
	
	@Test(priority=1,description="Verify whether user is able to add new User")
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException
	{
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterPasswordOnPasswordField(password1);
		loginpage.clickOnSignInButton();
		
		AdminUSersPage adminuserpage= new AdminUSersPage(driver);
		adminuserpage.clickOnAdminUsersIcon();
		adminuserpage.clickOnNewButton();
		
		RandomDataUtility random= new RandomDataUtility();
		String username2=random.createRandomUserName();
		String password2= random.createRandomPassword();
		
		
		//String username2=ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		//String password2=ExcelUtility.getStringData(0, 1, "AdminUsersPage");
		String usertype=ExcelUtility.getStringData(1, 0, "AdminUsersPage");
		adminuserpage.enterUsernameOnUserNameField(username2);
		adminuserpage.enterPasswordOnPasswordField(password2);
		
		adminuserpage.selectUserType(usertype);
		
		adminuserpage.clickOnSaveButton();
		
		//Assertion
		boolean savedAlertButtondisplay=adminuserpage.isDisplayedUserSavedAlertMsg();
		Assert.assertTrue(savedAlertButtondisplay,"User is unable to add new user");

		
	}
	
	@Test(priority=2,description="Verify whether user is able to search Admin User")
	public void verifyWhetherUserIsAbleToSearchAdminUser() throws IOException
	{
		
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterPasswordOnPasswordField(password1);
		loginpage.clickOnSignInButton();
		
		AdminUSersPage adminuserpage= new AdminUSersPage(driver);
		adminuserpage.clickOnAdminUsersIcon();
		adminuserpage.clickOnNewButton();
		
		
		//AdminUSersPage adminuserpage= new AdminUSersPage(driver);
		adminuserpage.clickOnSearchButton();
		
		String searchusername=ExcelUtility.getStringData(2, 0, "AdminUsersPage");
		String searchusertype=ExcelUtility.getStringData(2, 1, "AdminUsersPage");
		
		adminuserpage.enterSearchUserName(searchusername);
		adminuserpage.selectSearchUserType(searchusertype);
		
		adminuserpage.clickOnSearchAdminUserButton();
		

		//Assertion
		boolean searchAdminUserstext=adminuserpage.isDisplayedSearchAdminUsersText();
		Assert.assertTrue(searchAdminUserstext,"User is unable to search user");
	}
	
	@Test(priority=3,description="Verify whether user is able to click on Reset button")
	public void verifyWhetherUserIsAbleToClickOnResetBUtton() throws IOException
	{
		
		String username1=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterPasswordOnPasswordField(password1);
		loginpage.clickOnSignInButton();
		
		AdminUSersPage adminuserpage= new AdminUSersPage(driver);
		adminuserpage.clickOnAdminUsersIcon();
		adminuserpage.clickOnResetButton();
		
		//Assertion
		boolean resetAdminUserstext=adminuserpage.isDisplayedResetAdminUsersText();
		Assert.assertTrue(resetAdminUserstext,"User is unable to click on reset user");
		
		
	}

}
