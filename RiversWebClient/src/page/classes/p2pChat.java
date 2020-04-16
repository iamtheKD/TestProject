package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class p2pChat {
	
    public static WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    
    @Test
	public static void p2pChat(WebDriver driver) throws InterruptedException {

	    Thread.sleep(5000);
	    elementPage.searchBarP2pRoster(driver).sendKeys("Kd1");
	    
	    Thread.sleep(5000);
	    elementPage.searchFirstResultP2p(driver).click();
	    
	    Thread.sleep(5000);
	    
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"
                + driver.findElement(
                        By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).getLocation().y + ")");
        WebElement editable = driver.switchTo().activeElement();
        editable.sendKeys("Hi there ");
        driver.switchTo().defaultContent();
	    Thread.sleep(5000);
	    
	    elementPage.sendMessageBtn(driver).click();
	    Thread.sleep(5000);
	    
	    String lastMessage = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]")).getAttribute("id");
	    System.out.println(lastMessage);
	   
	    Thread.sleep(5000);
	    
	    String messageStatus = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]//div[3]/div[1]")).getAttribute("class");
	    System.out.println(messageStatus);
    }
}
