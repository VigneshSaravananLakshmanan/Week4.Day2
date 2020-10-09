package week4.Day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Set up the driver */
		WebDriverManager.chromedriver().setup();

		/* Invoking the Chrome driver class */
		ChromeDriver driver = new ChromeDriver();

		/* expanding the windows */
		driver.manage().window().maximize();
		

		/* Launch the URL */
		driver.navigate().to("http://leafground.com/pages/Alert.html");

		/* Get the page Title */
		System.out.println("The title of the page is :" + driver.getTitle());

		/* ********************* SIMPLE ALERT *******************8888 */

		driver.findElementByXPath("//button[@onclick='normalAlert()']").click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("The content within the Simple alert is " + alert.getText());

		alert.accept();

		/* ****************** CONFIRM ALERT ***************************** */

		driver.findElementByXPath("//button[@onclick='confirmAlert()']").click();

		alert.dismiss();

		driver.findElementByXPath("//button[@onclick='confirmAlert()']").click();

		System.out.println("The content within the Confirm alert is " + alert.getText());

		alert.accept();

		/* *******************************PROMPT BOX ****************************** */

		driver.findElementByXPath("//button[@onclick='confirmPrompt()']").click();

		alert.dismiss();

		driver.findElementByXPath("//button[@onclick='confirmPrompt()']").sendKeys("This is a prompt Alert box");

		System.out.println("The content within the Prompt alert is " + alert.getText());

		alert.accept();

		/* *******************************LINE BREAKS ****************************** */

		driver.findElementByXPath("//button[@onclick='lineBreaks()']").click();

		System.out.println("The content within the LineBreaks alert is " + alert.getText());

		alert.accept();

		/* *******************************SWEET ALERT ****************************** */

		driver.findElementByXPath("//button[@onclick='sweetalert()']").click();

		System.out.println(driver.findElementByXPath("//div[@class='swal-modal']").getText());

		driver.findElementByXPath("//button[contains(text(),'OK')]").click();

		driver.close();

	}

}
