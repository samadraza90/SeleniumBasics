package Assignments;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chorme.driver", "C:\\Samad\\Selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// storing the username and password in the list first
		List<WebElement> userinfo = driver.findElements(By.tagName("b"));
		// locating the user and password fields and storing it in List
		List<WebElement> formElements = driver.findElements(By.xpath("//input[@class='form-control']"));
		for (int i = 0; i < userinfo.size(); i++) {
			// inputting the data in form as the ratio is same
			formElements.get(i).sendKeys(userinfo.get(i).getText());
		}
		// clicking on the user radio button
		driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();
		// Clicking on the prompt
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']"))).click();
		// Selecting the Consultant Options
		Select userOptions = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		userOptions.selectByContainsVisibleText("Consultant");
		// accepting the terms and conditions
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		// clicking on SignIn button
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
		// find all the products on the page
		List<WebElement> addCart = driver.findElements(By.xpath("//button[@class='btn btn-info']"));

		for (int i = 0; i < addCart.size(); i++) {
			// adding all the products on the page into the cart
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}

		// clicking on Checkout button
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

		// clicking on Checkout button of Cart page
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn btn-success\"]")))
				.click();

		// selecting Country
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("IN");

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='suggestions']")));

		List<WebElement> contries = driver.findElements(By.xpath("//div[@class='suggestions']/ul"));

		for (WebElement contry : contries) {
			if (contry.getText().contains("India")) {
				contry.click();
				break;

			}
		}

		// click on terms
		driver.findElement(By.xpath("//label[@for='checkbox2']")).click();
		// click on purchase
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();

		String orderPlaced = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText();
		// Verifying the order is placed successfully
		System.out.println(orderPlaced);
		Assert.assertTrue(orderPlaced.contains("Success"));
		driver.quit();
	}

}
