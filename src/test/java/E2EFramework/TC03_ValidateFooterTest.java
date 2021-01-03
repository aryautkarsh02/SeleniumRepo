package E2EFramework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AmazonLandingPage;
import pageObjects.Cricbuzz_Footer;
import resources.BaseClass;
import resources.ExpectedItems;

public class TC03_ValidateFooterTest extends BaseClass{
	
	WebDriver driver;
	Cricbuzz_Footer footer;
	
	/*@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		footer = new Cricbuzz_Footer(driver);
	}*/
	
	
	@BeforeClass
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		footer = new Cricbuzz_Footer(driver);
	}
	
	
	
	@Test(priority = 1)
	public void validateFooterLinks() throws InterruptedException
	{
		ExpectedItems expect = new ExpectedItems(); 
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement footerDriver = footer.returnFooterSection();
		
		//WebElement footerDriver = driver.findElement(By.xpath("//div[contains(@class,'cb-footer')]"));
		
		/*List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
		
		for(int i=0; i<footerLinks.size(); i++)
		{
			System.out.println(footerLinks.get(i).getText());
		} 
		*/
		
		System.out.println(footer.returnFooterFirstColumnHeading().getText());
		Assert.assertEquals(footer.returnFooterFirstColumnHeading().getText(), expect.returnCricbuzzFooterFirstColumnHeadingExpected());
		
		List<WebElement> footerFirstColumnLinks = footer.returnFirstColumnLinks();
		List<String> footerFirstColumnLinksActual = new ArrayList<String>();
		
		for(int i=0; i<footerFirstColumnLinks.size(); i++)
		{
			footerFirstColumnLinksActual.add(footerFirstColumnLinks.get(i).getText());
		}
		
		Assert.assertEquals(footerFirstColumnLinksActual, expect.returnCricbuzzFooterFirstColumnLinksExpected());
		
		footer.clickOnLinks_FirstColumn();
		
		Thread.sleep(7000);
		
		List<String> tabTitleListActual = footer.returnTabUrlListActual();
		/*for(int i=0; i<tabTitleListActual.size(); i++)
		{
			//System.out.println(tabTitleListActual.get(i));
		}*/
		
		Assert.assertEquals(tabTitleListActual, expect.returnTabTitleListExpected());

		
	}
	
	/*@AfterTest
	public void tearDown()
	{
		driver.close();
	}*/
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	

}
