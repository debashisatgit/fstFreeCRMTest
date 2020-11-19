package Com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.crm.qa.comUtil.TestUtil;

public class TestBase {
	                            //fst with base class start the framework difining(step-01)
	public static WebDriver driver;   //1.after the class inilise the webDriver with static variable  (global level)
	public static Properties prop;    //3.after the class inilise the properties with static variable (global level)
	
	
	public TestBase() {       //2.create the test base class constructor method and 
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\THI1901459\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\Com\\crm\\qa\\config\\config.properties");
			prop.load(ip);                            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {                    //4.create a initialization method
		String browserName = prop.getProperty("browser");   //5.
		if (browserName.equals("chrome")) {                //6.
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\THI1901459\\cromeDriverEx\\chromedriver.exe"); 		//7.
			driver = new ChromeDriver();                  //8.use the static class driver
			
		}
		else if (browserName.equals("FF")) {
			System.out.println("FF is not lounching");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //fatching the data from util class
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICET_WAIT, TimeUnit.SECONDS);      //fatching the data from util class
		
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
