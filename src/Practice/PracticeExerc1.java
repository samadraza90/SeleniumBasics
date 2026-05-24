package Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class PracticeExerc1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C://Samad//Selenium//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Samad\\ss.png");
		
		FileUtils.copyFile(source, destination);
			
		int count = driver.findElements(By.tagName("a")).size();

		System.out.println("Count of Link in the page is " + count);

		// Below step is counting by filtering the objects directly using xpath
		/*
		 * System.out.println( "Count of line in the footer is " +
		 * driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());
		 */

		// Below code we are separately creating a footerdriver for the footer of the
		// page
		WebElement footer = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope

		// Now we will just find the elements in that footer web element
		System.out.println("Count of link in the footer is " + footer.findElements(By.tagName("a")).size());
		//Limiting the webdriver scope to a specific coloumn in the page
		WebElement coloumndriver = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		//3 count of links in 1 coloumn
		System.out.println("Count of Links in 1st coloumn is "+coloumndriver.findElements(By.tagName("a")).size());
		
		//Clicking on every link in that column
		for(int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++){
			
			String openinnewtab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(openinnewtab);
			Thread.sleep(5000);
		}
			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			
			
			while(it.hasNext()) 
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		
		
		
		//driver.quit();

	}

}
