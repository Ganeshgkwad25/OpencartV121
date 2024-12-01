package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_AccountRegistrationTest {
	
	public WebDriver driver; 
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/#:~:text=iPhone.%20iPhone%20is%20a%20revolutionary%20new%20mobile%20phone");
		driver.manage().window().maximize();	
	}
	
	@AfterClass
	void teardown()
	{
	driver.quit();	
	}
	
	@Test
	public void verify_account_registration()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		repage.setFirstName("Dell");
		repage.setLastName("Laptop");
		repage.setEmail("dell@gmail.com");
		repage.setPassword("Dell@123");
		repage.setPrivacyPolicy();
		repage.clickContinue();
		
		String confmsg = repage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	
}
