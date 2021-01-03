package E2EFramework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CricbuzzLanding;
import resources.BaseClass;
import resources.ExpectedItems;

public class TC01_LandingPageTest extends BaseClass {
	WebDriver driver;
	CricbuzzLanding cl;
	
	BaseClass base = new BaseClass();
	
	/*@BeforeTest
	public void initialize() throws IOException
	{
	driver = initializeDriver();
	cl = new CricbuzzLanding(driver);
	
	
	}*/
	
	@BeforeClass
	public void initialize() throws IOException
	{
	driver = initializeDriver();
	cl = new CricbuzzLanding(driver);
	
	
	}
	
	
	
	
	@Test
	public void validateLogoTitle() throws IOException
	{
		
		
		driver.get("https://www.cricbuzz.com/" );
		//CricbuzzLanding cl = new CricbuzzLanding(driver);
		System.out.println(cl.returnLogo().getAttribute("title"));
		
		
	}
	
	@Test
	public void validateTopBarLinks() throws IOException
	{
		List<String> topBarLinksExpected = Arrays.asList("Live Scores", "Schedule", "Archives", "News", "Series", "Teams", "Videos", "Rankings", "More");
		List<String> topBarLinksActual = new ArrayList<String>();
		//CricbuzzLanding c2 = new CricbuzzLanding(driver);
		List<WebElement> topBarStaticLinks = new ArrayList<WebElement>();
		topBarStaticLinks = cl.returnTopBarStaticLinks();
		for(int i =0; i<topBarStaticLinks.size();i++)
		{
			System.out.println(topBarStaticLinks.get(i).getText());
			topBarLinksActual.add(topBarStaticLinks.get(i).getText());
		}
		
		List<WebElement> topBarDropdownLinks = new ArrayList<WebElement>();
		topBarDropdownLinks = cl.returnTopBarDropdownLinks();
		for(int i =0; i<topBarDropdownLinks.size();i++)
		{
			System.out.println(topBarDropdownLinks.get(i).getText());
			topBarLinksActual.add(topBarDropdownLinks.get(i).getText());
		}
		
		
		System.out.println(cl.returnTopBarMoreLink().getText());
		topBarLinksActual.add(cl.returnTopBarMoreLink().getText());
		Assert.assertEquals(topBarLinksActual, topBarLinksExpected, "Not equal");
		 
	}
	
	@Test
	public void validateNewsDropdownLinks()
	{
		//CricbuzzLanding c3 = new CricbuzzLanding(driver);
		List<String> newsDropdownLinksExpected = Arrays.asList("All Stories", "Latest News", "Topics", "Spotlight", "Opinions", "Specials", "Stats & Analysis", "Interviews", "Live Blogs", "Harsha Bhogle");
		Actions action = new Actions(driver);
		
		action.moveToElement(cl.returnNewsDropdown()).build().perform();
		List<WebElement> newsDropdownLinks = cl.returnNewsDropdownLinks();
		
		List<String> newsDropdownLinksActual = new ArrayList<String>();
		
		for(int i=0; i<newsDropdownLinks.size(); i++)
		{
			System.out.println(newsDropdownLinks.get(i).getText());
			newsDropdownLinksActual.add(newsDropdownLinks.get(i).getText());
		}
		
		Assert.assertEquals(newsDropdownLinksActual, newsDropdownLinksExpected, "Issue with News dropdown links");
	}
	
	@Test
	public void validateTeamsLinks()
	{
		Actions action = new Actions(driver);
		action.moveToElement(cl.returnTeamsDropdown()).build().perform();
		
		ExpectedItems expected = new ExpectedItems();
		
		//List<String> TeamsDropdownLinksExpected = Arrays.asList("India", "Ireland", "Pakistan", "Australia", "Sri Lanka", "Bangladesh", "England",
			//	"West Indies", "South Africa", "New Zealand", "Afghanistan", "Iran", "Belgium", "Italy", "Botswana", "Namibia", "Denmark", "Singapore", "Bermuda", "Canada", "Uganda", "Malaysia", "Netherlands");
	
		List<WebElement> teamsDropdownLinks = cl.returnTeamsDropdownLinks();
		List<String> teamsDropdownLinksActual = new ArrayList<String>();
		
		for(int i=0; i<teamsDropdownLinks.size(); i++)
		{
			System.out.println(teamsDropdownLinks.get(i).getText());
			teamsDropdownLinksActual.add(teamsDropdownLinks.get(i).getText());
			
		}
		
		List<String> teamsDropdownLinksExpected = expected.returnTeamsDropdownLinksExpected(); 
		
		Assert.assertEquals(teamsDropdownLinksActual, teamsDropdownLinksExpected);
		
		WebElement moreHyperlinkActual = cl.returnMoreHyperLink();
		Assert.assertEquals(moreHyperlinkActual.getText(), "More...");
		action.moveToElement(cl.returnLatestNewsHeading());

	}
	
	@Test(priority=1)
	public void validateHeadings() throws InterruptedException
	{
		driver.get("https://www.cricbuzz.com/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(cl.returnLatestNewsHeading()));
		System.out.println(cl.returnLatestNewsHeading().getText());
		
		Assert.assertEquals(cl.returnLatestNewsHeading().getText(), "LATEST NEWS");
		
		//Actions action = new Actions(driver);
		//action.moveToElement(cl.returnLatestNewsHeading());
		
		//WebElement childDriver = driver.findElement(By.xpath("//div[@class='cb-col.cb-col-20']"));
		
		//System.out.println(childDriver.findElement(By.xpath(".//div/h2")).getText());
		//driver.findElement(By.xpath("(//a[contains(@title,'BCB')])[1]")).click();
		/*String latestNewsExpected = "LATEST NEWS";
		String latestPhotosExpected = "LATEST PHOTOS";
		String scheduleExpected = "SCHEDULE";*/
		
		//Assert.assertEquals(cl.returnLatestNewsHeading().getText(), latestNewsExpected);
		//Assert.assertEquals(cl.returnLatestPhotosHeading().getText(), latestPhotosExpected);
		//Assert.assertEquals(cl.returnScheduleHeading().getText(), scheduleExpected);
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

