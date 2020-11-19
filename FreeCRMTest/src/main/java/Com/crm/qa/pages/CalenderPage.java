package Com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase{
	
	@FindBy(xpath ="//h4[contains(text(),'Calendar ')]")
	WebElement calenderLabel;
	
	@FindBy(xpath ="//span[@class='fc-button fc-button-next fc-state-default fc-corner-right']")
	WebElement clicknextDay;
	
	@FindBy(xpath ="//input[@id='subject_event']")
	WebElement Subject;
	
	@FindBy(xpath ="//input[@id='location_event']")
	WebElement Location;
	
	@FindBy(xpath ="//input[@id='start_date']")
	WebElement ClickStartTime;
	
	@FindBy(xpath ="//a[contains(text(),'29')]")
	WebElement SelectkStartTime;
	
	@FindBy(xpath ="//input[@id='end_date']")
	WebElement ClickkEndTime;
	
	@FindBy(xpath ="//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover' and contains(text(),'29')]")
	WebElement SelectkEndTime;
	
	@FindBy(xpath ="//span[contains(text(),'Save')]")
	WebElement SaveAppointment;
	
	public CalenderPage() {        //creating the cunstructor of home page 
		PageFactory.initElements(driver, this); 
		
	}
	
	public boolean verifycalenderLabel() {
		return calenderLabel.isDisplayed();
	}
	
	//here if we want to click a particular label from the calender header need to create a generic xpath for 5 elements and can store in string
	
	public void selectheaderLabel(String labelname) {
		driver.findElement(By.xpath("//div[@id='rdCalendarView']//div[contains(text(),'"+labelname+"')]")).click();
	}   //div[@id='rdCalendarView']//div[contains(text(),'Today')] , New Appointment
	
	public void createNewAppoitment(String subname , String locname) {
		
		Subject.sendKeys(subname);
		Location.sendKeys(locname);
		ClickStartTime.click();
		SelectkStartTime.click();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='selectFrom']")));
		select.selectByVisibleText("02:00p");
		ClickkEndTime.click();
		SelectkEndTime.click();
		select.selectByVisibleText("02:15p");
		SaveAppointment.click();
		
		
	}
	
	
	
	
	
	
	

}
