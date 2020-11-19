package Com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {     //Step - 3, extend all the child class to base class and import it from base
	
	//page factory we have to define - obj repo
	
	@FindBy(name = "login")
	WebElement username;
	
	@FindBy(name = "passwd")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//u[contains(text(),'Create a new account')]")
	WebElement createaccountbutton;
	
	@FindBy(xpath = "//u[contains(text(),'Forgot Password?')]")
	WebElement forgotpassword;
	
	@FindBy(xpath = "//div[contains(@class,'logtext')]")
	WebElement crmlogo;
	
	//inilizating the page obj(step-4)
	public LoginPage(){                              //create a constructor of the login page 
		PageFactory.initElements(driver, this);     //pagefactory.initelement method is used inilize the obj with driver and "this"means current class
				
	}
	//Actions (step-5)
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean validateCrmImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String UN ,String PW) {
		username.sendKeys(UN);
		password.sendKeys(PW);
		loginbutton.click();
		
		return new HomePage();         //home page should be landing page after login page -validation here return homepage 
	}
	
	
  
}
