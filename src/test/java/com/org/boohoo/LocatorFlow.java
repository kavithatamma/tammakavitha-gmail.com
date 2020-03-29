package com.org.boohoo;

import com.org.boohoo.driver.DriverManager;
import com.org.boohoo.utils.RandomNumberHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LocatorFlow  {
  public static WebDriver driver;
    @Test
    public void sale() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.boohoo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        WebElement sale = driver.findElement(By.linkText("SALE"));
        Actions action = new Actions(driver);
        action.moveToElement(sale).build().perform();
        WebElement sale80 = driver.findElement(By.xpath("(//ol[@class='menu-title hide-womens-mobile hide-on-global-offers-tab'])[1]"));
        sale80.click();
        List<WebElement> saleItems = driver.findElements(By.xpath("//div[@class='search-result-content js-search-result-content']/ul[@id='search-result-items']/li[@class='grid-tile']"));
        int size = saleItems.size();
        System.out.println(size);
        if(size == 0 )
        {
            System.out.println("there are no sale items ");
        }
        Random rand =new Random();

        int randomIndex = rand.nextInt(size-1);
        System.out.println(randomIndex);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saleItems.get(randomIndex));
        WebElement selectedItem = saleItems.get(randomIndex);
        // Thread.sleep(2000);
        selectedItem.click();
    }
}
