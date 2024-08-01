import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Старт сессии
        driver.get("https://google.com");
        WebElement input_field = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        input_field.click();
    }
}
