import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

		public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Samad\\Selenium\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.co.in/");
			List<WebElement> L = driver.findElements(By.tagName("a"));
			for(WebElement link : L) {
				System.out.println(link.getText()+ "-" + link.getAttribute("href"));
			}
			driver.quit();
		}
}
