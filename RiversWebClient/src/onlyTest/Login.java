package onlyTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		String baseURL = "https://trial.rivers.im/";
		
		// Below code is for making notification allow
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		// 1-Allow, 2-Block, 0-default
		prefs.put("profile.default_content_setting_values.notifications", 1);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "/Users/manish/Desktop/Manish/Workspace/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		driver.findElement(By.className("form-control")).sendKeys("India");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("phoneNumber")).sendKeys("8527799401");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='btn log-btn']")).click();
		System.out.println("Enter OTP");
		
		Thread.sleep(40000);
		
		driver.quit();

	}

}
