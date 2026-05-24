package Assignments;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Samad\\Selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Samad Raza Khan");
		driver.findElement(By.name("email")).sendKeys("samadraza90@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Samad@123");
		driver.findElement(By.id("exampleCheck1")).click();

		List<WebElement> options = driver.findElements(By.id("exampleFormControlSelect1"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Male")) {
				option.click();
				break;
			}
		}
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("18021998");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed();
		System.out.println(
				driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

		driver.quit();
	}
}
