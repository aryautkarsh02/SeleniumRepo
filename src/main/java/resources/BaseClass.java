package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Drive D_Projects\\SeleniumE2EFramework\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Drive D_Projects\\SeleniumTraining\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		return driver;
	}
	
	public void selectGeneric(WebElement element, String type, String value)
	{
		Select select = new Select(element);
		switch(type)
		{
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
			
		case "value":
			select.selectByValue(value);
			break;
			
		case "text":
			select.selectByVisibleText(value);
			break;
		}
		
		
	}
	
	public void actionMove(WebDriver driver, WebElement targetElement)		//Move to a particular element
	{
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform();
	}
	
	public void actionMoveAndClick(WebDriver driver, WebElement targetElement)		//Move to a particular element and click on it
	{
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).click().build().perform();
	}
	

}
