package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CricketTeamsPage {
	
	public WebDriver driver;
	public CricketTeamsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Teams')]")
	WebElement heading_CricketTeams;
	
	By teamsCategories = By.xpath("//nav[@class='cb-schdl-nvtb']/a");
	
	By teamsLinks = By.xpath("//div[contains(@class,'cb-col-25')]/following-sibling::h2/a");
	
	@FindBy(xpath="//div[@id='latest-news-mod']/h4")
	WebElement heading_LatestNews;
	
	
	@FindBy(xpath="//a[@class='cb-more-btn']")
	WebElement button_MoreNews;
	
	@FindBy(xpath="//iframe[@id='twitter-widget-0']")
	WebElement twitterFrame;
	
	@FindBy(xpath="//h1[contains(@class,'timeline-Header-title')]")
	WebElement headingTweets;
	
	@FindBy(xpath="//input[@id='search_bar']")
	WebElement searchBox;
	//**************************************************************************************
	
	public WebElement returnHeadingCricketTeams()
	{
		return heading_CricketTeams;
	}
	
	public List<WebElement> returnTeamsCategoryLinks()
	{
		List<WebElement> teamsCategoryLinks = new ArrayList<WebElement>();
		teamsCategoryLinks = driver.findElements(teamsCategories);
		return teamsCategoryLinks;
		
	}
	
	public List<WebElement> returnTeams()
	{
		List<WebElement> teamsList = new ArrayList<WebElement>();
		teamsList = driver.findElements(teamsLinks);
		return teamsList;
	}
	
	public WebElement returnHeadingLatestNews()
	{
		return heading_LatestNews;
	}
	
	public WebElement retutnMoreNewsButton()
	{
		return button_MoreNews;
	}
	
	public WebElement returnHeadingTweets()
	{
		return headingTweets;
	}
	
	public WebElement returnTwitteriFrame()
	{
		return twitterFrame;
	}
	
	public WebElement returnSearchBox()
	{
		return searchBox;
	}
	
	
	
	
	
	

	
	
	

}
