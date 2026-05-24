import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String name = "Samad";
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		String text = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		Assert.assertEquals(text, "Hello "+name+",");
		System.out.println(text);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		System.out.println("Successfully Logged In and Logged Out");
		driver.quit();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement((By.xpath("//input[@placeholder='Name']"))).sendKeys("Samad Raza Khan");
		driver.findElement((By.xpath("//input[@placeholder='Email']"))).sendKeys("samadraza90@gmail");
		driver.findElement((By.xpath("//input[@placeholder='Phone Number']"))).sendKeys("8976874291");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String Passtext = driver.findElement(By.cssSelector("form p")).getText();
		String [] Passarray = Passtext.split("'");
		String password = Passarray[1].split("'")[0];
		return password;
	}

}