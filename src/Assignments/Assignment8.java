package Assignments;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Assignment8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Samad//Selenium/chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		TakesScreenshot ts =  (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Samad\\Selenium\\SeleniumBasics\\screenshots\\sss.jpg");
		
		Files.copy(source, des);
		
		driver.close();
		
		
	}
}	