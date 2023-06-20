package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAmazon {
    ChromeDriver driver;
    public SearchAmazon()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        // Naviage to URL https://www.google.com/
        driver.get("https://www.google.com");
        // Enter text "amazon" Using Locator "ID" "APjFqb"|sendKeys("amazon")
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("amazon");
        // Click on "Google Search" button Using Locator "XPath" //input[@value='Google Search'][1]|button.click()
        WebElement googleSearchButton = driver.findElement(By.xpath("//input[@value='Google Search'][1]"));
        googleSearchButton.click();
        // Validate amazon.in or amazon.com is present on the page Using Locator "XPath" //span[@class='VuuXrf' and text()='Amazon.in'] | isDisplayed()
        WebElement text = driver.findElement(By.xpath("//span[@class='VuuXrf' and text()='Amazon.in'] "));
        System.out.println("Amazon is displayed :" +text.isDisplayed());
        
    }
    
}
