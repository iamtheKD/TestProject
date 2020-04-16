package page.classes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import webConstants.Constants;

public class SendFile {
	
    public static WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    
    @Test
	public static void SendFile(WebDriver driver) throws InterruptedException, AWTException {


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

}
