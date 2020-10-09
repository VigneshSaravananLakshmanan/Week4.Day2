package week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) {
		
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("http://leafground.com/pages/Window.html");
		
		String firstTitle = driver.getTitle();
		
		
		
		/* ************** OPEN HOME PAGE ******************************* */
		
		driver.findElementByXPath("//button[@onclick='openWin();']").click();  // It opened a new web page
		
		Set<String> setWindows = driver.getWindowHandles();
		
		List<String> listWindows = new ArrayList<String>(setWindows);
		
		String secondPage = listWindows.get(1);
		
		String firstPage = listWindows.get(0);
		
		driver.switchTo().window(secondPage);  // switches to second window
		
		driver.findElementByXPath("//img[@alt='logo Testleaf']").click(); //Click to navigate to home page
		
		
		driver.switchTo().window(secondPage).close();
		
		driver.switchTo().window(firstPage);
		
		String finalTitle = driver.getTitle();
		
		if(firstTitle.equals(finalTitle))
		{
			System.out.println("The page gets navigated to its initial page");
		}
		else
		{
			System.out.println("The control is not switched back to the initial page");
		}
		
		
		/* ******************* CLICK ON MULTIPLE WINDOWS ************************** */
		
		/* click on the Multiple window button */
		driver.findElementByXPath("//button[@onclick='openWindows()']").click();
		
		/* Get the list of Session ID's launched by the driver and count its Size */
		System.out.println("The number of Windows Opended on clicking openWindows is "+driver.getWindowHandles().size());
		
		/* To close all the newly opened windows and to navigate the control to main window */
		  /* Get the session Id of current window */
		String parentWindow = driver.getWindowHandle();
		
		/* Get the session ID's of all the windows opened by the driver */
		   Set<String> totalWindows = driver.getWindowHandles();
		   
		   for(String closeWindow:totalWindows)
		   {
			   if(!closeWindow.equals(parentWindow)) {
				   driver.switchTo().window(closeWindow).close();
				   driver.switchTo().window(parentWindow);
			   }
		   }
		
		
		
		

	}

}
