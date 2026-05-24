package Assignments;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Samad//Selenium//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Clicking on the check box and grabbing the text
		driver.findElement(By.id("checkBoxOption2")).click();
		String Opt = driver.findElement(By.xpath("//label[normalize-space()='Option2']")).getText().trim();
		// System.out.println("The text is" + Opt);

		// Selecting the dropdown and selecting dynamically by the checkbox text
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));

		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(Opt);

		// Sending the text to the alert box
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Opt);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		// getting the text from Alert and Accepting the text
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		// verifying the alert text contains or option variable
		if (alertText.contains(Opt)) {
			System.out.println("Alert message success");
		} else
			System.out.println("Something wrong with execution");
		driver.quit();
	}

}
