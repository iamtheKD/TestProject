package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReplyMessage {

	public static void ReplyEmoji(WebDriver driver)  throws InterruptedException {
		System.out.println("Going to select the last message");
		driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]")).click();
		Thread.sleep(5000);
		
		System.out.println("Going to reply message");
		elementPage.replybutton(driver).click();
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"
                + driver.findElement(
                        By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).getLocation().y + ")");
        WebElement editable = driver.switchTo().activeElement();
        editable.sendKeys("This is emoji reply");
        driver.switchTo().defaultContent();
	    Thread.sleep(5000);
		
		
		elementPage.sendMessageBtn(driver).click();
	    Thread.sleep(5000);
	    
	    String lastMessage = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]")).getAttribute("id");
	    System.out.println(lastMessage);
	   
	    Thread.sleep(5000);
	    
	    String messageStatus = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]//div[4]/div[1]")).getAttribute("class");
	    System.out.println(messageStatus);
		
	}
}
