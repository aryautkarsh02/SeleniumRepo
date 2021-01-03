package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.BaseClass;

public class AmazonLandingPage extends BaseClass{
	WebDriver driver;

	public AmazonLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement amazonLogo;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//span[@id='nav-search-submit-text']/input")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='nav-search-facade']/i")
	WebElement searchCategoryDropdownButton;
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement searchCategoryDropdown;
	
	/*@FindBy(xpath="//select[@id='searchCategoryDropdown']/option")
	WebElement searchCategories;*/
	
	By searchCategories = By.xpath("//select[@id='searchCategoryDropdown']/option");
	
	@FindBy(xpath="//div[@class='nav-search-facade']/span")
	WebElement selectedCategory;
	
	@FindBy(xpath="(//div[@class='nav-line-1-container']/span)[1]")
	WebElement helloSignIn;
	
	@FindBy(xpath="//span[@class='nav-line-2 nav-long-width']/text()")
	WebElement accountAndLists;
	
	@FindBy(xpath="//a[@id='nav-orders']")
	WebElement returnsAndOrders;
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']/i")
	WebElement triggerHamburgerMenu;
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
	WebElement hamburgerMenuButton;
	
	@FindBy(xpath="//a[@id='nav-link-prime']")
	WebElement tryPrime;
	
	@FindBy(xpath="//span[@class='nav-line-2']/span[2]")
	WebElement changeCountryDropdownButton_LandingPage;
	
	@FindBy(xpath="//a[@id='icp-flyout-mkt-change']/span/div")
	WebElement changeCountryHyperlink;
	
	@FindBy(xpath="//span[@class='a-button-inner']/i")
	WebElement preferredCountryDropdownButton;
	
	By preferredCountryList = By.xpath("//div[@id='a-popover-2']/div/div/ul/li/a/div/div/div/following-sibling::div[1]/span");
	////a[@id='icp-selected-country_0']/div/div/div/following-sibling::div[1]/span
	
	@FindBy(xpath="//div[@id='hmenu-canvas-background']/div")
	WebElement closeHamburgerMenu;
	
	public WebElement returnAmazonLogo()
	{
		return amazonLogo;
	}
	
	public WebElement returnSearchBox()
	{
		return searchBox;
	}
	
	public WebElement returnSearchButton()
	{
		return searchButton;
	}
	
	public WebElement returnSearchCategoryDropdown()
	{
		return searchCategoryDropdown;
	}
	
	public WebElement returnHelloSignIn()
	{
		return helloSignIn;
	}
	
	
	public WebElement returnAccountAndLists()
	{
		return accountAndLists;
	}
	
	public WebElement returnReturnsAndOrders()
	{
		return returnsAndOrders;
	}
	
	public WebElement returnTryPrime()
	{
		return tryPrime;
	}
	
	public WebElement returnTriggerHamburgerMenuButton()
	{
		return triggerHamburgerMenu;
	}
	
	public WebElement preferredRegionDropdownButton()
	{
		return preferredCountryDropdownButton;
	}
	
	
	
	public void triggerSearchCategoryDropdown() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(searchCategoryDropdownButton).click().build().perform();
		//String javascript = "document.getElementById('nav-search-dropdown-card');";
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		//WebElement element = (WebElement)js.executeScript(javascript);
		//element.click();
		js.executeScript("arguments[0].click();", searchCategoryDropdownButton);
		//searchCategoryDropdownButton.click(); */
	}
	
	public String selectAmazonPantry()
	{
		selectGeneric(searchCategoryDropdown, "text", "Amazon Pantry");
		String selectedCategoryText = selectedCategory.getText();
		return selectedCategoryText;
		
	}
	
	public void hamburgerMenu() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(triggerHamburgerMenu).click().build().perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[text()='help & settings']")));
		actionMoveAndClick(driver, closeHamburgerMenu);
	}
	
	public String clickChangeCountryHyperlink() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(changeCountryDropdownButton_LandingPage));
		actionMove(driver, changeCountryDropdownButton_LandingPage);
		Thread.sleep(2000);
		actionMoveAndClick(driver, changeCountryHyperlink);
		return(driver.getTitle());
				
		
	}
	
	public void prefferedCountryDropdown()
	{
		actionMoveAndClick(driver, preferredCountryDropdownButton);
		List<WebElement> countries = driver.findElements(preferredCountryList);
		for(int i=0; i<countries.size(); i++)
		{
			System.out.println(countries.get(i).getText());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
