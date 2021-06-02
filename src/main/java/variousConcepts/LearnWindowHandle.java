
package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
	
WebDriver driver;
	
	@Test
	public void init() {  // initialization
		
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");// using forward slide(/) or backslide(\\)
	
	// System.setProperty("webdriver.chromr.drivr", ".\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.yahoo.com");
	//	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
	//	System.out.println(driver.getWindowHandle());
		String handle = driver.getWindowHandle();
		System.out.println(handle);
		
// There is nothing like switch to parent windowhandle. I just try to see what happens when you 
// switch to parent frame if the window handle or identifier will be the same
// I am just trying to explore different coding thought lines!
		driver.switchTo().parentFrame();
		System.out.println("==========="+driver.switchTo().parentFrame());
		System.out.println("==========="+driver.getTitle());
		
// Remember anytime we open a new tab ,computer generates unique window identifier or id called window handle		
	// transfering the driver from one window tab to another is what we are to learn in window handling!!
	// As the window closes the id also vanishes	
		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
		driver.findElement(By.xpath("//input[@id='ybar-search']")).click();
	/*	
		System.out.println(driver.getTitle());
			String handle1 = driver.getWindowHandle();
			System.out.println(handle1);
			*/
		
		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
		
		System.out.println(driver.getTitle());
		Set<String> handle2 = driver.getWindowHandles();
	//	System.out.println(handle2);
		for(String i : handle2) {
			System.out.println(i);
			driver.switchTo().window(i);
			

			
		}
		
		System.out.println(driver.getTitle());
// why is the two window tabs opened generating same window handle
		driver.switchTo().window(handle);
		System.out.println(driver.getTitle());
		
		// There is nothing like switch to parent windowhandle. I just try to see what happens when you 
		// switch to parent frame if the window handle or identifier will be the same
		// I am just trying to explore different coding thought lines!

		
		System.out.println("==================================");
		driver.switchTo().parentFrame();
		System.out.println(driver.switchTo().parentFrame());
		System.out.println(driver.getTitle());
	}

}
