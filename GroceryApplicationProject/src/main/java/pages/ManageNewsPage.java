package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and text()='More info ' ]")
	private WebElement manageNewsIcon;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	private WebElement newButton;
	
	@FindBy(xpath="//textarea[@id='news']")
	private WebElement newsTextArea;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveNewsButton;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	private  WebElement searchNewsIcon;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	private WebElement enterSearchNewsTitle;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchNewsButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and text()=' Reset']")
	private WebElement resetIcon;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement newsSuccessfullySavedMsg;
	
	@FindBy(xpath = "//h4[text()='Manage News']")
	private WebElement manageNewsText;
	
	@FindBy(xpath="//h4[text()='Search Manage News']")
	private WebElement searchNewsText;
	
	public void clickOnManageNewsIcon()
	{
		manageNewsIcon.click();
	}
	
	public void clickOnNewButton()
	{
		newButton.click();
		
	}
	
	public void enterNewsInTextArea(String news)
	{
		newsTextArea.sendKeys(news);
	}
	
	public void clickOnSaveNewsButton()
	{
		saveNewsButton.click();
	}

	
	public void clickOnSearchNewsIcon()
	{
		searchNewsIcon.click();
	}
	
	public void enterSearchNewsTitle(String SearchNews)
	{
		enterSearchNewsTitle.sendKeys(SearchNews);
	}
	
	public void clickOnSearchNewsButton()
	{
		searchNewsButton.click();
	}
	
	public void clickOnResetIcon()
	{
		resetIcon.click();
	}
	
	public Boolean isDisplayedNewsSavedAlertMsg()
	{
		return newsSuccessfullySavedMsg.isDisplayed();
	}
	
	public String resetPageHeading()
	{
		return manageNewsText.getText();
	}
	
	public String searchPageHeading()
	{
		return searchNewsText.getText();
	}
}
