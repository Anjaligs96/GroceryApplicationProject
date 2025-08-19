package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUSersPage {
	
	WebDriver driver;

	public AdminUSersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	private WebElement clickOnnewbutton;
	@FindBy(xpath="//input[@id='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectusertype;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	private WebElement searchButton;
	@FindBy(xpath="//input[@name='un']")
	private WebElement searchUserName;
	@FindBy(xpath="//select[@name='ut']")
	private WebElement searchUsertype;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement clickOnUserSearchButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()=' Reset']")
	private WebElement resetButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement userSavedAlertMsg;
	
	@FindBy(xpath="//h4[text()='Admin Users']")
	WebElement searchAdminUsersText;
	
	

	@FindBy(xpath="h4[text()='Admin Users']")
	WebElement resetAdminUsersText;
	

     
	public void clickOnNewButton()
	{
		clickOnnewbutton.click();
	}
	
	public void enterUsernameOnUserNameField(String username1)
	{
		username.sendKeys(username1);
	}
	
	public void enterPasswordOnPasswordField(String password1)
	{
		password.sendKeys(password1);
	}
	
	public void selectUserType(String usertype)
	{
	  Select select= new Select(selectusertype);
	  select.selectByVisibleText(usertype);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public void enterSearchUserName(String username2)
	{
		searchUserName.sendKeys(username2);
	}
	
	public void selectSearchUserType(String userchusertype)
	{
		Select select= new Select(searchUsertype);
		  select.selectByVisibleText(userchusertype);
	}
	
	public void clickOnSearchAdminUserButton()
	{
		clickOnUserSearchButton.click();
	}
	
	public void clickOnResetButton()
	{
		resetButton.click();
	}
	
	public Boolean isDisplayedUserSavedAlertMsg()
	{
		return userSavedAlertMsg.isDisplayed();
	}
	
	public Boolean isDisplayedSearchAdminUsersText()
	{
		return searchAdminUsersText.isDisplayed();
	}
	
	public Boolean isDisplayedResetAdminUsersText()
	{
		return resetAdminUsersText.isDisplayed();
	}
}
