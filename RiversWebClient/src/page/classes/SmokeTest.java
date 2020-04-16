package page.classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import webConstants.Constants;

public class SmokeTest {

    public static WebDriver driver;  
    ExtentReports extent;
    ExtentTest logger;   
    
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception{
	
	//extent = new ExtentReports("//Users//manish//Desktop//Rivers//Reports//loginTest.html");
	//extent = new ExtentReports("‎⁨⁩/Users/kuldeep⁩/Desktop⁩/Rivers-Project⁩/⁨Report⁩/STMExtentReport.html", false);
	extent = new ExtentReports(System.getProperty("/‎⁨⁩/Users/kuldeep⁩/Desktop⁩/Rivers-Project⁩/⁨Report")+"/test-output/RiversWeb.html", true);
	
	extent
    .addSystemInfo("Host Name", "Rivers WebClient")
    .addSystemInfo("Environment", "Production")
    .addSystemInfo("User Name", "Kuldeep");
    extent.loadConfig(new File(System.getProperty("//Users/kuldeep⁩/Desktop⁩/Rivers-Project⁩/⁨Report")+ "\\extent-config.xml"));
	
	logger = extent.startTest("Login Successful");
	
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_setting_values.notifications", 1);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", prefs);

	System.setProperty("webdriver.chrome.driver", "/Users/kuldeep/Downloads/Telegram Desktop/RiversWebClient/lib/chromedriver");
	driver = new ChromeDriver(options);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(Constants.baseURL);
	
	logger.log(LogStatus.INFO, "Browser Started...");
	}

	@Test (priority=1)
	public void Login() {
		try {
			Login.Registration(driver);
			logger = extent.startTest("Login Successful");
			logger.log(LogStatus.PASS, "Login Test PASS");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}	
	}
	
	@Test (priority=2)
	public void p2pChat() {
		try {
			p2pChat.p2pChat(driver);
			logger = extent.startTest("Chat sent success");
			logger.log(LogStatus.PASS, "p2pChat Test PASS");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}	
	}

	@Test (priority=3)
	public void SendFile() {
		try {
			SendFile.SendFile(driver);
			logger = extent.startTest("File sharing successful");
			logger.log(LogStatus.PASS, "File sharing Test PASS");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}	
	}	

	
	@Test (priority=4)
	public void Emoticon() {
		try {
			Emoticon.Emoji(driver);
			logger = extent.startTest("File sharing successful");
			logger.log(LogStatus.PASS, "File sharing Test PASS");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}	
	}
	
	@Test (priority=5)
	public void ReplyMessage() {
		try {
			ReplyMessage.ReplyEmoji(driver);
			logger = extent.startTest("File sharing successful");
			logger.log(LogStatus.PASS, "File sharing Test PASS");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}	
	}
	

	@AfterMethod
	 public void getResult(ITestResult result){
	 if(result.getStatus() == ITestResult.FAILURE){
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 }else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
	}

	
	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		extent.endTest(logger);
		extent.flush();
	}
	

}
