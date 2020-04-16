 package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementPage {
	public static WebElement element = null;

	//Country selection
	public static WebElement country(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//input[@placeholder='Select Country']")); 
		return element;
	}
	
	//Enter mobile number
	public static WebElement enterNumber(WebDriver driver) {
		element = driver.findElement(By.id("phoneNumber"));
		return element;
	}
	
	//Confirm phone number button
	public static WebElement confirmPhoneNumber(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='btn log-btn']"));
		return element;
	}

	public static WebElement mtUserName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		return element;
	}
	
	public static WebElement mtUNext(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\\\"identifierNext\\\"]"));
		return element;
	}
	
	public static WebElement mtPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='password']"));
		return element;
	}
	
	public static WebElement mtPNext(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		return element;
	}
	
	public static WebElement firstMessageMt(WebDriver driver) {
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[1]"));
		return element;
	}
	
	public static WebElement otpField(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='otp']"));
		return element;
	}
	
	public static WebElement submitBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='btn log-btn']"));
		return element;
	}
	
	public static WebElement newCubeIcon(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(@class,'circle-icon new-circle')]"));
		return element;
	}
	
	public static WebElement searchBarP2pRoster(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='Search for chats and messages...']"));
		return element;
	}
	
	public static WebElement searchFirstResultP2p(WebDriver driver) {
		element = driver.findElement(By.xpath("//body/div[@id='root']/div[@class='full-screen wrapper']/div[@class='full-screen rivers']/div[@class='full-screen window']/div[@class='content-column room-rivers']/div[@class='riverz-body']/div[@class='search-wrapper']/div[1]/div[2]"));
		return element;
	}
	
	public static WebElement sendMessageBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='input-icon icon-send']"));
		return element;
	}
	
	public static WebElement AttachmentBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='dropup btn-group']"));
		return element;
	}
	
	public static WebElement SelectFrCompBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Select from Computer')]"));
		return element;
	}
	
	public static WebElement FileCaptionTextBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//textarea[@placeholder='Add Title or Description']"));
		return element;
	}
	
	public static WebElement sendFileBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		return element;
	}
	
	public static WebElement emojis(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='input-container']/div[@class='input-icon'][1]"));
		return element; 
	}
	
	public static WebElement emojis_smile_heart(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@aria-label='😍, heart_eyes']"));
		return element; 
	}
	
	public static WebElement replybutton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(text(),'Reply')]"));
		return element; 
	}
	
	
	
}
