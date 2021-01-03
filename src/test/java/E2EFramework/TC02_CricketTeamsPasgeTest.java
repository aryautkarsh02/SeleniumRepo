package E2EFramework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CricbuzzLanding;
import pageObjects.CricketTeamsPage;
import resources.BaseClass;
import resources.ExpectedItems;

public class TC02_CricketTeamsPasgeTest extends BaseClass{
	
	WebDriver driver;
	CricketTeamsPage ctp;
	CricbuzzLanding cl;
	
	/*@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		ctp = new CricketTeamsPage(driver);
		cl = new CricbuzzLanding(driver);
	}*/
	
	@BeforeClass
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		ctp = new CricketTeamsPage(driver);
		cl = new CricbuzzLanding(driver);
	}
	
	
	
	@Test(enabled=false)
	public void dynamicScroll()
	{
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//nav[@id='cb-main-menu']/a[3]")).click();
		
		try {
		    long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		    System.out.println(lastHeight);

		    while (true) {
		    	Thread.sleep(3000);
		        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight-800);");
		        Thread.sleep(2000);

		        long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		        System.out.println(newHeight);
		        if (newHeight == lastHeight) {
		            break;
		        }
		        lastHeight = newHeight;
		    }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
	
	@Test(priority =1)
	public void validateHeadings()
	{
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		Actions action = new Actions(driver);
		action.moveToElement(cl.returnTeamsDropdown()).build().perform();
		action.moveToElement(cl.returnMoreHyperLink()).click().build().perform();
		String headingCricketTeamsActual = ctp.returnHeadingCricketTeams().getText();
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(ctp.returnHeadingLatestNews()));
		String headingLatestNewsActual = ctp.returnHeadingLatestNews().getText();
		
		Assert.assertEquals(headingCricketTeamsActual, "Cricket Teams");
		
		Assert.assertEquals(headingLatestNewsActual, "LATEST NEWS");	
		
	}
	
	@Test (priority = 2)
	public void verifyTeamCategories()
	{
		ExpectedItems exp = new ExpectedItems();
		List<WebElement> TeamsCategoriesLinks = ctp.returnTeamsCategoryLinks(); 
		
		List<String> TeamsCategoryLinksActual = new ArrayList<String>();
		for(int i=0; i<TeamsCategoriesLinks.size(); i++)
		{
			TeamsCategoryLinksActual.add(TeamsCategoriesLinks.get(i).getText());
		}
		
		Assert.assertEquals(TeamsCategoryLinksActual, exp.returnTeamsCategoriesExpected());
		
	}
	
	
	@Test(priority =3)
	public void validateTwitterWidget() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(ctp.returnTwitteriFrame()));
		//WebElement childdriverIFrame = driver.findElement(By.xpath("//iframe[@id='twitter-widget-0']"));
		
		driver.switchTo().frame(ctp.returnTwitteriFrame());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ctp.returnHeadingTweets());		
		
		System.out.println(ctp.returnHeadingTweets().getText());
		String twitterHeadingActual = ctp.returnHeadingTweets().getText();
		Assert.assertEquals(twitterHeadingActual, "Tweets by @cricbuzz");
		
		//WebElement childdriverIFrame =  ctp.returnTwitteriFrame();
		
		Thread.sleep(5000);
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight-1000)");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Load more Tweets']")));
		
		String buttonLoadMoreTweetsTextActual = driver.findElement(By.xpath("//button[text()='Load more Tweets']")).getText();
		String buttonLoadMoreTweetsTextExpected = "Load more Tweets";
		Assert.assertEquals(buttonLoadMoreTweetsTextActual, buttonLoadMoreTweetsTextExpected);
		driver.switchTo().defaultContent();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ctp.returnHeadingCricketTeams());
	}
	
	@Test (priority = 4)
	public void validateTeamsList()
	{
		List<WebElement> InternationalTeamsList = new ArrayList<WebElement>();
		InternationalTeamsList = ctp.returnTeams();
		
		List<String> InternationalTeamsListActual = new ArrayList<String>();
		for(int i=0; i<InternationalTeamsList.size(); i++)
		{
			InternationalTeamsListActual.add(InternationalTeamsList.get(i).getText());
			//System.out.println(InternationalTeamsList.get(i).getText());
		}
	}
	
	@Test(dataProvider = "dataInSearch", priority= 5)
	public void validateSearchBox(String inputString) throws InterruptedException
	{
		ExpectedItems expect = new ExpectedItems();
		Actions action = new Actions(driver);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ctp.returnSearchBox());
		String searchBoxPlaceholderActual=ctp.returnSearchBox().getAttribute("placeholder");
		String searchBoxPlaceholderExpected = "Search";
		
		Assert.assertEquals(searchBoxPlaceholderActual, searchBoxPlaceholderExpected);
		
		Thread.sleep(1500);
		
		action.moveToElement(ctp.returnSearchBox()).click().build().perform();
		
		String searchBoxPlaceholderActual2 = ctp.returnSearchBox().getAttribute("placeholder");
		String searchBoxPlaceholderExpected2 = expect.returnSearchBarPlaceholderExpected();
		
		Assert.assertEquals(searchBoxPlaceholderActual2, searchBoxPlaceholderExpected2);
		
		ctp.returnSearchBox().sendKeys(inputString);
		Thread.sleep(2000);
		System.out.println("done");
		ctp.returnSearchBox().clear();
		
		ctp.returnSearchBox().sendKeys(Keys.ESCAPE);
		//ctp.returnSearchBox().
	}
	
	@DataProvider
	public Object[][] dataInSearch()
	{
		Object data[][] = new Object[2][1];
		
		data[0][0] = "India";
		data[1][0] = "England";
		
		return data;
		
	}
	
	//(//div[@class='cb-yr-tmline'])[1]/a
	
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
