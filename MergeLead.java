package week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		/* Launch the browser */
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		
		/* Enter Username */
		driver.findElementById("username").sendKeys("demosalesmanager");
		
		/* Enter the password */
				
				driver.findElementById("password").sendKeys("crmsfa");
				
				
				/* Click Login */
				driver.findElementByClassName("decorativeSubmit").click();
				
				
				/* Click crm/sfa link */
			driver.findElementByPartialLinkText("CRM/SFA").click();
			
			
			/* Click on Create Lead */
			driver.findElementByXPath("//a[contains(text(),'Create Lead')]").click();
			
			/* Click on Merge Lead */
			driver.findElementByPartialLinkText("Merge Leads").click();
			
			/* Click on Icon near From Lead */
			driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a/img").click();
			
			/* Get the Session ID of windows */
			Set<String> windows = driver.getWindowHandles();
			
			/* Copy the Set details into List to use get(i) function */
			List<String>listWindows= new ArrayList<String>(windows);
			
			//String secondWindow = listWindows.get(1);
			
			/* move the Control to Second Window */
			driver.switchTo().window(listWindows.get(1));
			
			/* Enter Lead ID */
			driver.findElementByXPath("//label[contains(text(),'Lead ID')]/following::input[@name='id']").sendKeys("10050");
			
			driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			
			Thread.sleep(4000);
			
			
			Actions builder = new Actions(driver);
			
			WebElement Element = driver.findElementByXPath("//table[@class='x-grid3-row-table']//td//a");
			
			builder.moveToElement(Element).click().perform();
			

		    /* Switching to Parent Window */
            String firstWindow = listWindows.get(0);
			
			/* move the Control to First Window */
			driver.switchTo().window(firstWindow);
			
			
			/* Click on Icon near To Lead */
			driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a/img").click();
			
			/* Get the Session ID of windows */
			Set<String> windows1 = driver.getWindowHandles();
			
			/* Copy the Set details into List to use get(i) function */
			List<String>listWindows1= new ArrayList<String>(windows1);
			
			/* Move the control to Third Window */
            String thirdWindow = listWindows1.get(1);
            
			driver.switchTo().window(thirdWindow);
			
			/* Enter the lead ID */
			/* Enter Lead ID */
			driver.findElementByXPath("//label[contains(text(),'Lead ID')]/following::input[@name='id']").sendKeys("10052");
			
			driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			
			Thread.sleep(5000);
			
			WebElement Element1 = driver.findElementByXPath("//table[@class='x-grid3-row-table']//td//a");
			
			builder.moveToElement(Element1).click().perform();
			
			/* Move the control to Parent Window */
            String parentWindow = listWindows1.get(0);
            
            driver.switchTo().window(parentWindow);
            
            
            /* Click on Merge button */
            driver.findElementByClassName("buttonDangerous").click();
             
            
            /* Switch to Alert */
            Alert alert = driver.switchTo().alert();
            
            System.out.println("The content within the alert is "+alert.getText());
            alert.accept();
            
            /* Click on Find Leads */
            driver.findElementByPartialLinkText("Find Leads").click();
            
            driver.findElementByXPath("//label[contains(text(),'Lead ID')]/following::input").sendKeys("10050");
            
            driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
            
               
            Thread.sleep(5000);
            
            
            /* Verify that the merged record is not displayed */
            if(driver.findElementByXPath("//div[contains(text(),\"No records to display\")]").isDisplayed())
            {
            	System.out.println("No Records to display appears in the screen");
            }
            else
            {
            	System.out.println("there is no message to display");
            }
            
            
            /* Close all the browsers */
            driver.quit();
           


	}

}
