package page.classes;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.relevantcodes.extentreports.LogStatus;
import webConstants.Constants;    

public class Login {
	
	@Test
	public static void Registration(WebDriver driver) throws InterruptedException {
	
	Thread.sleep(5000);
	elementPage.country(driver).sendKeys("India");
	
	Thread.sleep(6000);
	elementPage.enterNumber(driver).sendKeys(Constants.phoneNumber);
	
	Thread.sleep(5000);
	elementPage.confirmPhoneNumber(driver).click();

	Thread.sleep(5000);
	elementPage.otpField(driver).sendKeys("0"+"0"+"0"+"0");
	
	Thread.sleep(5000);
	elementPage.submitBtn(driver).click();
    
    Thread.sleep(10000);
    WebElement cubeButton = elementPage.newCubeIcon(driver);
    AssertJUnit.assertEquals(true, cubeButton.isDisplayed());
    System.out.println("Registration Successful");

	}
}

	