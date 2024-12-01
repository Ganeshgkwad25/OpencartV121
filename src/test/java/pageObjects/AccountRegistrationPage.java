package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	
	public AccountRegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname; 
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail; 
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdpolicy;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) 
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword (String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdpolicy.click();
	}
	
	public void clickContinue()
	{
		btncontinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch(Exception e) {
			return (e.getMessage());

		}
	}
	
}
