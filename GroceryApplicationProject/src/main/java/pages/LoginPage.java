package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//p[text()='Dashboard']")
	private WebElement dahsboard;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	private WebElement supermarketname;

	public LoginPage enterUserNameOnUserNameField(String username1) {
		username.sendKeys(username1);
		return this;

	}

	public LoginPage enterPasswordOnPasswordField(String password1) {
		password.sendKeys(password1);
		return this;
	}

	public HomePage clickOnSignInButton() {
		loginbutton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dahsboard.isDisplayed();
	}
	
	public String pageHeading()
	{
		return supermarketname.getText();
	}

}
