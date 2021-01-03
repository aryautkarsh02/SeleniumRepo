package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cricbuzz_Footer {
	WebDriver driver;

	public Cricbuzz_Footer(WebDriver driver) {
		//driver = this.driver;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'cb-footer')]")
	WebElement footerLocator;
	
	@FindBy(xpath="(//div[contains(@class,'cb-footer')]/div/div/following-sibling::div)[1]")
	WebElement footer_FirstColumn;
	
	@FindBy(xpath="(//div[contains(@class,'cb-footer')]/div/div/following-sibling::div)[1]/div")
	WebElement footer_FirstColumnHeading;
	
	By footer_FirstColumnLinks = By.xpath("(//div[contains(@class,'cb-footer')]/div/div/following-sibling::div)[1]/ul/li/a/span[2]");
	
	@FindBy(xpath="(//div[contains(@class,'cb-footer')]/div/div/following-sibling::div)[2]/div")
	WebElement footer_SecondColumnHeading;
	
	By footer_SecondColumnLinks = By.xpath("(//div[contains(@class,'cb-footer')]/div/div/following-sibling::div)[2]/ul/li/a/span[2]");

	@FindBy(xpath="(//div[contains(@class,'cb-footer')]/div/div/following-sibling::div)[3]/div")
	WebElement footer_ThirdColumnHeading;
	
	By footer_ThirdColumnLinks = By.xpath("(//div[contains(@class,'cb-footer')]/div/div/following-sibling::div)[3]/ul/li/a/span[2]");
	
	
	//************************************************************************************************
	
	public WebElement returnFooterSection()
	{
		return footerLocator;
	}

	public WebElement returnFooterFirstColumnHeading()
	{
		return footer_FirstColumnHeading;
	}
	
	
	public List<WebElement> returnFirstColumnLinks()
	{
		List<WebElement> firstColumnLinks = new ArrayList<WebElement>();
		firstColumnLinks = driver.findElements(footer_FirstColumnLinks);
		return firstColumnLinks;
	}
	
	public WebElement returnSecondColumnHeading()
	{
		return footer_SecondColumnHeading;
	}
	
	public List<WebElement> returnSecondColumnLinks()
	{
		List<WebElement> secondColumnLinks = new ArrayList<WebElement>();
		secondColumnLinks = driver.findElements(footer_SecondColumnLinks);
		return secondColumnLinks;
	}
	
	public WebElement returnThirdColumnHeading()
	{
		return footer_ThirdColumnHeading;
	}
	
	public List<WebElement> returnThirdColumnLinks()
	{
		List<WebElement> thirdColumnLinks = new ArrayList<WebElement>();
		thirdColumnLinks = driver.findElements(footer_ThirdColumnLinks);
		return thirdColumnLinks;
	}
	
	public void clickOnLinks_FirstColumn()
	{
		Actions action = new Actions(driver);
		//String openInTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		List<WebElement> firstColumnLinks = driver.findElements(footer_FirstColumnLinks);
		for(int i=0; i<firstColumnLinks.size(); i++)
		{
			action.moveToElement(firstColumnLinks.get(i)).keyDown(Keys.CONTROL).click().build().perform();
			
		}
		
		
	}
	
	public List<String> returnTabUrlListActual() throws InterruptedException
	{
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		Iterator<String> itr = ids.iterator();
		
		List<String> tabUrlList = new ArrayList<String>();
		String parentId=itr.next();
		System.out.println("Parent Tab - " + parentId);
		driver.switchTo().window(parentId);
		while(itr.hasNext())
		{
			String child=itr.next();
			driver.switchTo().window(child);
			Thread.sleep(2000);
			System.out.println("Child tab - " + child + " "+driver.getCurrentUrl());
			
			tabUrlList.add(driver.getCurrentUrl());
		}
		driver.switchTo().window(parentId);
		return tabUrlList; 
		
	}
	
	
	
}
