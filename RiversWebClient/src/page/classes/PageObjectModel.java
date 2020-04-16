package page.classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import webConstants.Constants;

public class PageObjectModel {
	
	    public static WebDriver driver;
	    ExtentReports report;
	    ExtentTest test;
		
		@BeforeMethod
		@BeforeTest
		public void setUp() throws Exception{
		
		report = new ExtentReports("//Users//manish//Desktop//Rivers//Reports//loginTest.html");
		test = report.startTest("Login Successful");
		
		// Below code is for making notification allow
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		// 1-Allow, 2-Block, 0-default
		prefs.put("profile.default_content_setting_values.notifications", 1);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "/Users/manish/Desktop/Manish/Workspace/Selenium/chromedriver");
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.baseURL);
		
		test.log(LogStatus.INFO, "Browser Started...");
	}
		
		
		@Test
		public void login() throws InterruptedException, AWTException{

			Thread.sleep(5000);
			elementPage.country(driver).sendKeys("India");
			test.log(LogStatus.INFO, "Selected country INDIA");
			
			Thread.sleep(6000);
			elementPage.enterNumber(driver).sendKeys(Constants.phoneNumber);
			test.log(LogStatus.INFO, "Added number");
			
			Thread.sleep(5000);
			elementPage.confirmPhoneNumber(driver).click();
		
			Thread.sleep(5000);
			elementPage.otpField(driver).sendKeys("0"+"0"+"0"+"0");
			test.log(LogStatus.INFO, "Entering OTP");
			
			Thread.sleep(5000);
			elementPage.submitBtn(driver).click();
		    
		    Thread.sleep(10000);
		    WebElement cubeButton = elementPage.newCubeIcon(driver);
		    AssertJUnit.assertEquals(true, cubeButton.isDisplayed());
		    System.out.println("Registration Successful");
		    test.log(LogStatus.PASS, "Logged in Successful");
		    
		    Thread.sleep(5000);
		    elementPage.searchBarP2pRoster(driver).sendKeys("Manish Test");
		    
		    Thread.sleep(5000);
		    elementPage.searchFirstResultP2p(driver).click();
		    
		    Thread.sleep(5000);
		    
		    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"
	                + driver.findElement(
	                        By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).getLocation().y + ")");
	        WebElement editable = driver.switchTo().activeElement();
	        editable.sendKeys("Anand Somani");
	        driver.switchTo().defaultContent();
		    Thread.sleep(5000);
		    
		    elementPage.sendMessageBtn(driver).click();
		    Thread.sleep(5000);
		    
		    String lastMessage = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]")).getAttribute("id");
		    System.out.println(lastMessage);
		   
		    Thread.sleep(5000);
		    
		    String messageStatus = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]//div[3]/div[1]")).getAttribute("class");
		    System.out.println(messageStatus);
		   
		    Thread.sleep(2000);
		    
		    elementPage.AttachmentBtn(driver).click();
		    
		    Thread.sleep(2000);
		    elementPage.SelectFrCompBtn(driver).click();
   
		    StringSelection stringSelection = new StringSelection(Constants.AttachmentFilePath);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		    
		    Thread.sleep(2000);
		    Robot robot = new Robot();

		    robot.keyPress(KeyEvent.VK_META);
		    robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_META);
		    robot.keyRelease(KeyEvent.VK_TAB);
		   
		    robot.delay(2000);
		    robot.keyPress(KeyEvent.VK_META);
		    robot.keyPress(KeyEvent.VK_SHIFT);
		    robot.keyPress(KeyEvent.VK_G);
		    robot.keyRelease(KeyEvent.VK_META);
		    robot.keyRelease(KeyEvent.VK_SHIFT);
		    robot.keyRelease(KeyEvent.VK_G);
		    
		    robot.delay(2000);
		    robot.keyPress(KeyEvent.VK_META);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_META);
		    robot.keyRelease(KeyEvent.VK_V);
		    
		    robot.delay(5000);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		   
		    
		    Thread.sleep(5000);
		    elementPage.FileCaptionTextBox(driver).sendKeys("Test1");
		    
		    Thread.sleep(5000);
		    elementPage.sendFileBtn(driver).click();
		    
		    String lastMessage2 = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]")).getAttribute("id");
		    System.out.println(lastMessage2);
		   
		    Thread.sleep(5000);
		    
		    String messageStatus2 = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]//div[3]/div[1]")).getAttribute("class");
		    System.out.println(messageStatus2);

		}
		
		@AfterMethod
		@AfterTest
		public void tearDown() throws Exception {
			driver.quit();
			report.endTest(test);
			report.flush();
		}
}
