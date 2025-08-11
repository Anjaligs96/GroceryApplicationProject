package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement adminIcon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logout;
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	private WebElement supermarketName;

	public void clickOnAdminIcon() {
		adminIcon.click();
	}

	public void clickOnLogout() {
		logout.click();
	}
	
	public String loginpageHeading()
	{
		return supermarketName.getText();
	}

}
