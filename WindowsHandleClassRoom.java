package week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandleClassRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("http://leafground.com/");
		
		/* Launching the Windows button */
		driver.findElementByXPath("//img[@alt='Windows']").click();
			
				
		/* click on Open Home page*/
				driver.findElementByXPath("//button[@id='home']").click();
				
		
		/* The site opens in a new window */
				/* collecting the windows handler */
				Set<String> windowHandles = driver.getWindowHandles();
				
				/* Creating a List */
				List<String>windowsList = new ArrayList<String>(windowHandles);
				
				String secondPage = windowsList.get(1);
				
				/* Move the control to second page */
				driver.switchTo().window(secondPage);
				
				System.out.println(driver.getTitle());
				
				
				/* To close the first window, the control needs to be switched to first window */
				String firstPage = windowsList.get(0);
				
				/* Move the control to second page */
				driver.switchTo().window(firstPage);
				
				System.out.println("The page title of first page is "+driver.getTitle());
				
				driver.close();
				
				driver.switchTo().window(secondPage);
				
				System.out.println("The page title of Second page is "+driver.getTitle());
				
				
				
				

	}

}
