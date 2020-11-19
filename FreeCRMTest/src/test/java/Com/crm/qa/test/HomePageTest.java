package Com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.crm.qa.base.TestBase;
import Com.crm.qa.pages.CalenderPage;
import Com.crm.qa.pages.HomePage;
import Com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{         //ctrl+shift+O all the import will done shortcut
	LoginPage loginpage;
	HomePage  homePage;
	CalenderPage calenderPage;
	
	public HomePageTest() {    //create the constructor of HomePage test with super key word
		super();               //fst it will call the prop file from base class by using the super (s-1)
	}
	
	@BeforeMethod
	public void setup() {
		initialization();    //call the inilization method from base class to inilized the driver	(s-2)
		calenderPage = new CalenderPage();
	    loginpage = new LoginPage();  //create the obj of LoginPaSge to call the methods
	    homePage =   loginpage.login(prop.getProperty("username"), prop.getProperty("password")); //by creating the obj of login we can call login function (s-3)
	    
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Rediffmail","Home page title is not matching msg"); //the msg will come only the tc will fail
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyCalenderTabTest() {
		calenderPage = homePage.clickOnCalenderTab();
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	// if we run it ,it will call fst the super call cunstructor where thr property file is there
	// then it will com under @Before method -it will call inilization method where it will launch chrome,maximized, wait, URL and all
	//then go to login page by calling the login obj and enter the un pw and returning the home page
	//then it will go @test get the title fst and then  verify the title with assections
	//then it will go to @After metheod and close the browser
	//for running all together create a source folder in your project,add a testng.xml file in it and add all the test classes 
	//can also create multiple testng.xml file to run multiple classes ex_ sanity or regression
	//after refresh the project go to test output - go to index.html - propertys - copy and past it in browser to see OP
	//emailable-report.html is also there to check the reports
	//to improve the pofermance of script we can use @casheLookup-it will store the element in cashe memory and directly access it from the cashe it selef it will not go to browser again and again
	
	
}
