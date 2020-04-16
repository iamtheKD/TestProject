package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Emoticon {
	public static void Emoji(WebDriver driver) throws InterruptedException {
		System.out.println("test1");
		elementPage.emojis(driver).click();
		Thread.sleep(5000);
		elementPage.emojis_smile_heart(driver).click();
		Thread.sleep(5000);
		
		elementPage.sendMessageBtn(driver).click();
	    Thread.sleep(5000);
	    
	    String lastMessage = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]")).getAttribute("id");
	    System.out.println(lastMessage);
	   
	    Thread.sleep(6000);
	    
	    String messageStatus = driver.findElement(By.xpath("//div[@class='messages-wrapper']//div[contains(@class,'last')]//div[3]/div[1]")).getAttribute("class");
	    System.out.println(messageStatus);
		
	} 
}
	