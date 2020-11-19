package Com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.crm.qa.base.TestBase;
import Com.crm.qa.comUtil.TestUtil;
import Com.crm.qa.pages.CalenderPage;
import Com.crm.qa.pages.HomePage;
import Com.crm.qa.pages.LoginPage;

public class CalenderPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage  homePage;
	CalenderPage calenderPage;
	
	String sheetName = "Appointment";
	
	public CalenderPageTest() {    //create the constructor of loginpage test with super key word
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();    //call the inilization method from base class
		
	    loginpage = new LoginPage();  //create the obj of LoginPage to call the methods
	    homePage =   loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    calenderPage = new CalenderPage();
	    homePage.clickOnCalenderTab();
	}
	
	@Test(priority=1)
	public void CalenderPageLabel() {
		Assert.assertTrue(calenderPage.verifycalenderLabel(), "calender label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getRedidTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);     //returen type of the data frm util file is obj data[][] , lasr row in util
		return data;                                           //change void to obj arrar[][]
		
	}
	
	
	@Test(priority=2,dataProvider="getRedidTestData")         //add the dataProvider with name
	public void SelectHeaderLabel(String Subject , String Location) {                        //tack the data frm data provider
		calenderPage.selectheaderLabel("New Appointment");     //tacking the data from string label name 
		//calenderPage.selectheaderLabel("Today");            //can give multiple option using singlr method
		//calenderPage.createNewAppoitment("testsubject", "testlocation");
		calenderPage.createNewAppoitment(Subject, Location);  //this is data driven process with set of datas 
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
