package variousConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LearnTestNG {

	 WebDriver driver;
	 String browser =null;
	  String url = null;
	  
//	 @BeforeSuite 
//	  public void beforeSuite() {
//		  System.out.println("I am before Suite");
//	  }

//	 @BeforeTest
//	  public void beforeClass() {
//		 readConfig() ;
//		  System.out.println("I am before class");
		  
//	 }
	  
	  @BeforeClass            //Remember BeforeClass or BeforeTest
	  public void readConfig() {
		  
	 	  Properties prop = new Properties();
		  //FileReader //InputStream //BufferReader //Scanner
		  
		  try {
			 InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			 prop.load(input);
		    browser =	 prop.getProperty("browser");
			 System.out.println("Used Browser: "+ browser);
			    url =	 prop.getProperty("url");

			 
		  }catch(IOException e) {
			  e.printStackTrace();
			  
		  }
		  
	  }
	  
	  
	 	@BeforeMethod
		public void init() {
			
	 		if(browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
	 		}else if(browser.equalsIgnoreCase("firefox")){	
	System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
	 		}	
			
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
/*		
		@Test
		public void loginTest() {
			System.out.println(driver.getTitle());
			Assert.assertEquals("Login page not found!!", "Login - iBilling1", driver.getTitle());
			
			
			// Storing Web Element
			// Element Library
			
			//type name =value
			
		//	driver.findElement(By.xpath("//input[@id='username']"));
			WebElement username_field_element = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement password_field_element = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			WebElement signing_button_element = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
//			WebElement dashboard_field_element = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]"));
			
			
			
			

			
			username_field_element.clear();
			username_field_element.sendKeys("demo@techfios.com");
			password_field_element.clear();
			password_field_element.sendKeys("abc123");
			signing_button_element.click(); 
			
			WebElement customer_button_element = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
			WebElement add_customer_button_element = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
			
			WebElement dashboard_button_element = driver.findElement(By.linkText("Dashboard"));	
			String actualdashboard = dashboard_button_element.getText();	
			Assert.assertEquals(actualdashboard, "Dashboard", "Dashboard page not found!!");

			System.out.println(driver.getTitle());
			
		//	WebElement customer_button_element = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
		//	WebElement add_customer_button_element = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
			customer_button_element.click();
			add_customer_button_element.click(); 
			
			WebElement fullname_field_element = driver.findElement(By.xpath("//input[@id='account']"));
//			WebElement dropdown_field_element = driver.findElement(By.xpath("//select[@id='cid']"));
			WebElement dropdown_field_element = driver.findElement(By.xpath("//select[@id=\"cid\"]"));
			WebElement email_field_element = driver.findElement(By.xpath("//input[@id='email']"));
			WebElement phone_field_element = driver.findElement(By.xpath("//input[@id='phone']"));
			WebElement address_field_element = driver.findElement(By.xpath("//input[@id='address']"));
			WebElement city_field_element = driver.findElement(By.xpath("//input[@id= 'city']"));
			WebElement stateRegion_field_element = driver.findElement(By.xpath("//input[@id= 'state']"));
			WebElement country_field_element = driver.findElement(By.xpath("//input[@id= 'state']"));
			WebElement zipostalcode_field_element = driver.findElement(By.xpath("//input[@id= 'zip']"));
//			WebElement tag_field_element = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']"));
			WebElement save_field_element = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
			
			
			
			
			
		}

	
*/
	

@Test
public void addcustomerTest(){
	
// Storing Element:  By library
	
	By username_field_locator =By.xpath("//input[@id='username']");
	By password_field_locator =By.xpath("//*[@id=\"password\"]");
	By signing_button_locator =By.xpath("/html/body/div/div/div/form/div[3]/button"); 
	By dashboard_field_locator =By.xpath("//h2[contains(text(),' Dashboard ')]");
	
	By customer_button_locator = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By add_customer_button_locator = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
//	driver.findElement(customer_button_locator).click();
//	driver.findElement(add_customer_button_locator).click(); 
	
	By fullname_field_locator = By.xpath("//input[@id='account']");
//	By dropdown_field_locator = By.xpath("//select[@id='cid']"));
	By dropdown_field_locator = By.xpath("//select[@id=\"cid\"]");
	By email_field_locator = By.xpath("//input[@id='email']");
	By phone_field_locator = By.xpath("//input[@id='phone']");
	By address_field_locator = By.xpath("//input[@id='address']");
	By city_field_locator = By.xpath("//input[@id= 'city']");
	By stateRegion_field_locator = By.xpath("//input[@id= 'state']");
	By country_field_locator = By.xpath("//input[@id= 'state']");
	By zipostalcode_field_locator = By.xpath("//input[@id= 'zip']");
//	By tag_field_locator = By.xpath("//ul[@class='select2-selection__rendered']"));
	By save_field_locator = By.xpath("//*[@id=\"submit\"]");
	
	
// Login Data
	String loginId = "demo@techfios.com";
	String password = "abc123";
	
// Test Data  ?? Cannot be changed 
	String fullName = "Test June";
	String companyName = "Techfios";
	String  emailAddress = "test@gmail.net";
	String phoneNumber = "2379104";
	String streetAddress = "Linclosn Street";
	String cityName = "Arlinter";

	Assert.assertEquals(driver.getTitle(), "Login - iBilling", "Login page not found!!");
	
// Log in
	driver.findElement(username_field_locator).sendKeys(loginId);
	driver.findElement(password_field_locator).sendKeys(password);
	driver.findElement(signing_button_locator).click();
	
	WebElement dashboard_button_element = driver.findElement(By.linkText("Dashboard"));	
	String actualdashboard = dashboard_button_element.getText();
//	Assert.assertEquals(actualdashboard, "Dashboard", "Dashboard page not found!!");
//	WebDriverWait wait = new WebDriverWait(driver, 5);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard_field_locator));
	
	waitForElement(driver ,4, dashboard_field_locator);

	Assert.assertEquals(actualdashboard, "Dashboard", "Dashboard page not found!!");
	
	
	driver.findElement(customer_button_locator).click();
	
	waitForElement(driver ,10, add_customer_button_locator);

	
//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(customer_button_locator)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(add_customer_button_locator));
//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(add_customer_button_locator)));
	
	driver.findElement(add_customer_button_locator).click();
	
	
	
	Random rnd = new Random();
	int generatedNo = rnd.nextInt(999);
	
	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(fullname_field_locator));
	driver.findElement(fullname_field_locator).sendKeys(fullName+generatedNo);
	driver.findElement(dropdown_field_locator).sendKeys(companyName+generatedNo);
	
	
	driver.findElement(email_field_locator).sendKeys(generatedNo+ emailAddress);
//	waitForElement(driver ,5, dashboard_field_locator);
//	dropDown(WebElement dashboard_button_element );
	driver.findElement(phone_field_locator).sendKeys(phoneNumber+generatedNo);
	driver.findElement(address_field_locator).sendKeys(generatedNo+"  "+streetAddress);
	driver.findElement(city_field_locator).sendKeys(cityName);
	
	
}	

public void waitForElement(WebDriver driver, int timeInSeconds, By locator) {
	WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

}
/*
public void dropDown(WebElement companyname){
	WebElement dropdown_field_element  = null;
	Select sel = new Select(dropdown_field_element);
	sel.getOptions();
	List<WebElement> webelement = sel.getOptions();
	for(WebElement i: webelement);
	WebElement i = null;
	System.out.println(i.getText());
}

/*
@AfterMethod
public void tearDown() throws InterruptedException {
	Thread.sleep(2000);
	driver.close(); // kills the process of the web driver
//	driver.quit();// actually closes the browser window
}
*/

}


