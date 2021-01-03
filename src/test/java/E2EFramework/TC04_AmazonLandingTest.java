package E2EFramework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AmazonLandingPage;
import resources.BaseClass;

public class TC04_AmazonLandingTest extends BaseClass{
	
	WebDriver driver;
	AmazonLandingPage alp;
	
	/*@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		alp = new AmazonLandingPage(driver);
	}*/
	
	@BeforeClass
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		alp = new AmazonLandingPage(driver);
	}
	
	@Test(priority=1)
	public void verifyMiscAmazon() throws InterruptedException
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Assert.assertTrue(alp.returnAmazonLogo().isDisplayed(), "Amazon logo is displayed");
		Assert.assertTrue(alp.returnSearchBox().isDisplayed(), "Search Box is displayed");
		Assert.assertTrue(alp.returnSearchButton().isDisplayed(), "Search button is displayed");
		
	}
	
	@Test(priority=2)
	public void verifyAmazonPantrySelection() throws InterruptedException
	{
		//Thread.sleep(5000);
		alp.triggerSearchCategoryDropdown();
		
		//alp.triggerSearchCategoryDropdown();
		
		
		//wait.until(ExpectedConditions.visibilityOf(alp.returnSearchCategoryDropdown()));
		Assert.assertEquals("Amazon Pantry", alp.selectAmazonPantry());
	}
	
	@Test(priority=3)
	public void leftNavigationBar() throws InterruptedException
	{
		Assert.assertTrue(alp.returnTriggerHamburgerMenuButton().isDisplayed());
		alp.hamburgerMenu();
	}
	
	@Test(priority=4)
	public void validateChangeCountryFunctionality() throws InterruptedException
	{
		Assert.assertEquals(alp.clickChangeCountryHyperlink(), "Go to website");
		
	}
	
	@Test(priority=5)
	public void validateCountriesDropdown()
	{
		alp.prefferedCountryDropdown();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	/*@AfterTest
	public void tearDown()
	{
		driver.close();
	}*/
	
	
	

}
