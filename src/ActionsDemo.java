import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://Samad//Selenium//chromedriver-win64//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.google.com");

		// this Action class which has all the actions which can be performed to
		// simulate mouse and keyboard moments
		Actions a = new Actions(driver);
		// Here we are hovering over an element on the page
		a.moveToElement(driver.findElement(By.xpath("//button[@role='link']"))).build().perform();
		// here we are going in the search box and sending the text in capital form by
		// simulating the shift press key

		a.moveToElement(driver.findElement(By.xpath("//textarea[@title='Search']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("xda").build().perform();

		// performing a right click on an element
		a.moveToElement(driver.findElement(By.xpath("//a[text()='Gmail']"))).contextClick().build().perform();
	}

}
