package Com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//a[contains(text(),'Debashis Test')]")
	WebElement userNameLabel;
	
	@FindBy(xpath ="//div[@class='side_btm']/div/h4/following::div/h4[@class='rd_calendar_link']")
	WebElement CalenderTab;
	
	@FindBy(xpath ="//a[contains(text(),'Drafts')]")
	WebElement Drafts;
	
	@FindBy(xpath ="//h4[contains(text(),'Address Book') and @class='rd_contacts_link']")
	WebElement AddressBook;
	
	
	//inilizating the page obj
	public HomePage() {        //creating the cunstructor of home page 
		PageFactory.initElements(driver, this); 
		
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public CalenderPage clickOnCalenderTab() {
		CalenderTab.click();
		return new CalenderPage();           //landing page is calender page so return calender page 
	}
	public DraftsPage verifyDraftsTab() {
		Drafts.click();
		return new DraftsPage();            //landing page is calender page so return calender page 
	}                                       //thats why we have to create each page class to return the landing page
	
	
	

}
