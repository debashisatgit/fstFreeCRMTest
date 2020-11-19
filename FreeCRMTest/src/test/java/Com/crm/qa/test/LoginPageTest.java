package Com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.crm.qa.base.TestBase;
import Com.crm.qa.pages.HomePage;
import Com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	//here fst create the constructor to call the property 
	
	public LoginPageTest() {    //create the constructor of loginpage test with super key word
		super();
	}
	
	//her sec define the annotasion 
	
	@BeforeMethod
	public void setup() {
		initialization();    //call the inilization method from base class
		
	    loginpage = new LoginPage();  //create the obj of LoginPage to call the methods
			
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Rediffmail");
		}
	
	@Test(priority=2)
	public void crmlogoimageTest() {
		boolean flag = loginpage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	

}
