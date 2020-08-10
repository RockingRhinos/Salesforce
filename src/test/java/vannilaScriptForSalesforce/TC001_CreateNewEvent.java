package vannilaScriptForSalesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TC001_CreateNewEvent {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

//		Authentication
		driver.findElementById("username").sendKeys("samdavid@testleaf.com");
		driver.findElementById("password").sendKeys("samchennai92");
		driver.findElementById("Login").click();

		Thread.sleep(20000);
		
//		Click SVG Icon
		WebElement svg = driver.findElementByXPath("//div[@class='slds-global-header__item']//li[4]//a");
		svg.sendKeys(Keys.ENTER);
		
//		Click New Event and maximize it
		Actions builder = new Actions(driver);
		builder.click(driver.findElementByXPath("(//span[text()='New Event'])[1]")).perform();
		Thread.sleep(2000);
		builder.click(driver.findElement(By.xpath("//button[@title='Maximize']"))).perform();
		
		driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		
		driver.close();
		
	}
	
}
