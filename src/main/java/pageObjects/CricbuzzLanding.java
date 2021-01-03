package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CricbuzzLanding {
	
	public WebDriver driver;
	
	public CricbuzzLanding(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//By logo = By.xpath("//a[@class='cb-hm-text']/img");
	
	@FindBy(xpath="//a[@class='cb-hm-text']/img")
	WebElement logo;
	
	/*@FindBy(xpath="//a[@class='cb-hm-mnu-itm']")
	WebElement topBarStaticLinks;*/
	
	By topBarStaticLinks = By.xpath("//a[@class='cb-hm-mnu-itm']");
	
	/*@FindBy(xpath="//div[contains(@class,'cb-subnav')]/a")
	WebElement topBarDropdownLinks;*/
	
	By topBarDropdownLinks = By.xpath("//div[contains(@class,'cb-subnav')]/a");
	
	@FindBy(xpath="(//div[contains(@class,'cb-subnav')])[6]")
	WebElement topBarDropDownLink_More;
	
	@FindBy(xpath="//div[@id='newsDropDown']/a") //News on Green bar
	WebElement newsDropdown;
	
	By newsDropdownLinks = By.xpath("(//nav[@class='cb-sub-navigation'])[1]/a"); //News Dropdown links
	
	@FindBy(xpath="//div[@id='seriesDropDown']/a")  //Series dropdown on Green bar
	WebElement seriesDropdown;
	
	By seriesDropdownLinks = By.xpath("(//nav[@class='cb-sub-navigation'])[2]/a"); //Series Dropdown links
	
	@FindBy(xpath="//a[contains(text(),'All Series')]")
	WebElement allSeriesLink;
	
	@FindBy(xpath="//div[@id='teamDropDown']/a")
	WebElement teamsDropdown;
	
	By teamsDropdownLinks = By.xpath("//a[contains(@class,'cb-sub-lg-sec-item')]"); //Test teams list in Teams dropdown.
	
	@FindBy(xpath="(//div[@class='cb-sub-lg-sec']/h4)[1]")  //return "Test Teams" heading in teams dropdown
	WebElement testTeamsHeading;	
	
	@FindBy(xpath="(//div[@class='cb-sub-lg-sec']/h4)[2]")  //return "Test Teams" heading in teams dropdown
	WebElement associateHeading;	
	
	@FindBy(xpath="//a[@class='cb-sub-lg-more']")	//return "More" hyperlink from Teams dropdown
	WebElement moreHyperlink_Tramsdrpdwn;
	
	@FindBy(xpath="//div[@id='cb-news-blck']/h2")	//return "Latest News" heading
	WebElement latestNewsHeading;
	
	@FindBy(xpath="//div[@id='hm-photos-blk']/h2")
	WebElement latestPhotosHeading;
	
	@FindBy(xpath="//div[@id='hm-photos-blk']/following-sibling::div/h2")
	WebElement scheduleHeading;
		
		
	/**********************************************************************************************************/


	public WebElement returnLogo()
	{
		return logo;
		
	}
	
	public List<WebElement> returnTopBarStaticLinks()
	{
		List<WebElement> topBarStaticLinksList = new ArrayList<WebElement>();
		topBarStaticLinksList = driver.findElements(topBarStaticLinks);
		return topBarStaticLinksList;
		//return topBarStaticLinks;
	}
	
	public List<WebElement> returnTopBarDropdownLinks()
	{
		List<WebElement> topBarDropdownLinksList = new ArrayList<WebElement>();
		topBarDropdownLinksList = driver.findElements(topBarDropdownLinks);
		return topBarDropdownLinksList;
		//return topBarDropdownLinks;
	}
	
	public WebElement returnTopBarMoreLink()
	{
		return topBarDropDownLink_More;
	}
	
	public WebElement returnNewsDropdown()
	{
		return newsDropdown;
	}
	
	public List<WebElement> returnNewsDropdownLinks()
	{
		List<WebElement> newsDropdownLinksList = new ArrayList<WebElement>();
		newsDropdownLinksList =	driver.findElements(newsDropdownLinks);
		return newsDropdownLinksList;
	}
	
	public WebElement returnSeriesDropdown()
	{
		return seriesDropdown;
	}
	
	public List<WebElement> returnSeriesDropdownLinks()
	{
		List<WebElement> seriesDropdownLinksList = new ArrayList<WebElement>();
		seriesDropdownLinksList = driver.findElements(seriesDropdownLinks);
		return seriesDropdownLinksList;
	}
	
	public WebElement returnAllSeriesLink()
	{
		return allSeriesLink;
	}
	
	public WebElement returnTeamsDropdown()
	{
		return teamsDropdown;
	}
	
	public WebElement returnTestTeamsHeading()
	{
		return testTeamsHeading;
	}
	
	public WebElement returnAssociateHeading()
	{
		return associateHeading;
	}
	
	public List<WebElement> returnTeamsDropdownLinks()
	{
		List<WebElement> teamsDropdownLinksList = new ArrayList<WebElement>();
		teamsDropdownLinksList = driver.findElements(teamsDropdownLinks);
		return teamsDropdownLinksList;
		
	}
	
	public WebElement returnMoreHyperLink()
	{
		return moreHyperlink_Tramsdrpdwn;
	}
	
	public WebElement returnLatestNewsHeading()
	{
		return latestNewsHeading;
	}
	
	public WebElement returnLatestPhotosHeading()
	{
		return latestPhotosHeading;
	}
	
	public WebElement returnScheduleHeading()
	{
		return scheduleHeading;
	}
	
	
	
	
	
	
	
	
	

}
