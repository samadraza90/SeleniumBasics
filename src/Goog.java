import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goog {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Launch Chrome
        driver.get("https://www.google.com"); // Open Google

        WebElement searchBox = driver.findElement(By.name("q")); // Locate search box
        searchBox.sendKeys("Selenium WebDriver"); // Type search query
        searchBox.submit(); // Submit the form

        driver.quit(); // Close browser
    }
}