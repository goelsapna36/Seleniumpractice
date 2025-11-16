package SeleniumP;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        // 1. Locate element
        WebElement search = driver.findElement(By.id("APjFqb"));

        // 2. Type something
        search.sendKeys("Chatgpt");

        // 3. Refresh page → Stored element becomes OLD
        driver.navigate().refresh();

        // 4. TRY using OLD element → This will create StaleElementReferenceException
        //Thread.sleep(2000);
      
        try {
        	 search.sendKeys("chatgpt");
        	 
        }
        catch (StaleElementReferenceException e) {
        	search = driver.findElement(By.id("APjFqb"));

            // 2. Type something
            search.sendKeys("Chatgpt");

        	System.out.println("always run");
        	
        }
        //driver.quit();
        
    }
}
