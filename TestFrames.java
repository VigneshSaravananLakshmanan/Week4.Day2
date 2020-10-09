package week4.Day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("http://leafground.com/pages/frame.html");
		
		/* Get the title of the page */
		System.out.println("The title of the page is "+driver.getTitle());
		
		
		/* ****************** I am Inside the Frame ***************************** */
		
		/* Switching to Frame 0 */
		driver.switchTo().frame(0);  // switching to the Frame using Index
		
		/* click on "Click-Me" button within the Frame */
		driver.findElementById("Click").click();
		
		System.out.println(driver.findElementById("Click").getText());
		
		/* Switching back from frame */
		driver.switchTo().parentFrame();
		
		/* ****************** I am Inside the Nested Frame ***************************** */
		
		
		/* Switching to Frame 1 */
		driver.switchTo().frame(1);  // switching to the Frame index
		driver.switchTo().frame(0);  // Switching inside the nested frame
		
		/* click on "Click-Me" button within the Frame */
		driver.findElementById("Click1").click();
		
		System.out.println(driver.findElementById("Click1").getText());
		
		/* Switching back from frame */
		driver.switchTo().defaultContent();
		
		
		/* ******************** Find the total number of Frames *************************** */
		
		/* Get the count of iFrame */
		int size = driver.findElementsByXPath("//iFrame").size();
		
		System.out.println("The number of iFrames within the DOM is "+size);
		
		int count = 0;

		for(int i=0;i<=size-1;i++)
		{
			driver.switchTo().frame(i);
			
			count+= driver.findElementsByXPath("//iFrame").size();
			
			driver.switchTo().parentFrame();
			
		}
		
		int total_Frames = size+count;
		
		System.out.println("The total number of Frames is "+total_Frames);
		
		
		driver.close();

	}

}
