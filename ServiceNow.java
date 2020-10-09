package week4.Day2;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		/* Launch the browser */
		driver.navigate().to("https://dev68594.service-now.com/");
		
		/* Login into the page */
		
		/* Login page is within the Frame. */
		List<WebElement> frameCount = driver.findElementsByXPath("//iFrame");
		
		/* Switching to first frame using the index */
		driver.switchTo().frame(0);
		
		driver.findElementById("user_name").sendKeys("admin");
		
		driver.findElementById("user_password").sendKeys("India@123");
		
		driver.findElementById("sysverb_login").click();
		
		driver.switchTo().parentFrame();
		
		/* It takes time for all the elements to get loaded. Hence a wait time of 5 seconds is induced */
		Thread.sleep(8000);
		
		
		/* Invoking Action Class */
		Actions builder = new Actions(driver);
		
		WebElement searchBox = driver.findElementByXPath("//input[@id='filter']");
		
		builder.moveToElement(searchBox).click().perform();
		
		driver.findElementByXPath("//input[@id='filter']").sendKeys("Incident");
		
		Thread.sleep(2000);
		
		
		/* Scrolling down the web page */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		WebElement allIncidents = driver.findElementByXPath("(//div[contains(text(),'All')])[2]");
		
		js.executeScript("arguments[0].scrollIntoView(true);",allIncidents);
		
		builder.moveToElement(allIncidents).click().perform();
		
		
		/* Click on New button */
		driver.findElementByXPath("//button[contains(text(),'New')]").click();
		
		
		
		
		
		
		
		
		

	}

}
