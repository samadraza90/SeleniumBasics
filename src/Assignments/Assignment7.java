package Assignments;

import java.util.*;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment7 {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Samad//Selenium/chromedriver-win64//chromedriver.exe");
		String env = "headless";
		Scanner sc = new Scanner(System.in);
		String inputenv = sc.nextLine();
		// headless chrome browser execution
		if (inputenv.equalsIgnoreCase(env)) {
			ChromeOptions Options = new ChromeOptions();
			Options.addArguments("--headless=new", "--start-maximize");
			driver = new ChromeDriver(Options);
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		List<WebElement> trows = driver.findElements(By.xpath("//table[@name='courses']//tbody//tr"));
		System.out.println(trows.size());

		System.out.println(driver.findElements(By.xpath("//table[@name='courses']//tbody//tr//th")).size());

		List<WebElement> rowData = driver.findElements(By.xpath("//table[@name='courses']//tbody//tr[3]//td"));

		for (int i = 0; i < rowData.size(); i++) {
			System.out.println(rowData.get(i).getText());
		}

	}

}
