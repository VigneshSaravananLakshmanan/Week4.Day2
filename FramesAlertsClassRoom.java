package week4.Day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAlertsClassRoom {

	public static void main(String[] args) throws InterruptedException {
		
		
		/* To disable the notifications */
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notification");
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver(options);
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		/* Wait for 5 seconds */
		Thread.sleep(3000);
		
		/* A sweet alert gets popped up and hence the control is moved to alert */
		//Alert alert2 = driver.switchTo().alert();
		
		/* accept the cookies. This is a sweet alert and hence it works like normal selenium . Dont want to invoke Alert class  */
        driver.findElementById("accept-choices").click();

		
		/* Try me button is within the Frame and hence, move the control to Frame */
		driver.switchTo().frame("iframeResult");
		
		
		/* Once moved to the Frame, click on Try me button */
		driver.findElementByXPath("//button[@onclick='myFunction()']").click();
		
		/* An prompt alert pops up and hence the control is moved to Alert window */
		Alert alert = driver.switchTo().alert();
		
		/* Enter the values in the textbox*/
		alert.sendKeys("Vignesh");
		
		/* Print the display content of the alert box */
		System.out.println("The text within the Alert box is "+alert.getText());
		
		/* Click on Ok button within the alert box*/
		alert.accept();
		
		
		/* Move the control out of the Frame to parent page */
		driver.switchTo().defaultContent();
		
		/* Wait for 5 seconds */
		Thread.sleep(5000);
		 
		
		/* Close the browser */
		driver.close();

	}

}
