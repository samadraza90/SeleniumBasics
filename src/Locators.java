import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Samad\\Selenium\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Samad");
		driver.findElement(By.name("inputPassword")).sendKeys("hello");
		driver.findElement(By.className("signInBtn")).click();
		String error = driver.findElement(By.cssSelector("p.error")).getText();
		if(error != null)System.out.println(error);
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Forgot password is been clicked and Registration page has opened
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Samad");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Sam@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();//locator by xpath with tagname using index
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Samk@gmail.com");//locator by cssSelector with tagname using index
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("88888");//locator by xpath using tags //parentagname/childpath
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Samad");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");//regular expression partial text
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		driver.quit();

	}

}
