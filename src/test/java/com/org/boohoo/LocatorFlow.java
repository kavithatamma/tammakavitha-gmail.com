package com.org.boohoo;

import com.org.boohoo.utils.RandomNumberHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
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
        WebElement sale = driver.findElement(By.xpath("//li[contains(@class,'sale-menu womens-womens-sale-menu')]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(sale).build().perform();
        WebElement sale80 = driver.findElement(By.linkText("Sale - Up to 70% Off Everything"));
        sale80.click();
        List<WebElement> saleItems = driver.findElements(By.cssSelector("div.product-tile-name>a"));
        int size = saleItems.size();
        System.out.println("total sale items "+" " + size);
        if(size == 0 )
        {
            System.out.println("there are no sale items ");
        }
        //Random rand =new Random();
        //int randomIndex = rand.nextInt(size);
        //System.out.println(randomIndex);*/
        int randomSaleItem = new RandomNumberHelper().generateRandomNumber(size);
        System.out.println("randomly selected  sale item" +" "+ randomSaleItem);
        WebElement selectedItem = saleItems.get(randomSaleItem);
        selectedItem.click();
        String actualProdTitle = driver.getTitle();

        // randomly choosing colour
        List<WebElement> colourUk = driver.findElements(By.xpath("//ul[@class ='swatches color clearfix']/li"));
        int colourUklength = colourUk.size();
        System.out.println(" total color length" + " " +colourUklength);
        //int randomColourUkLength = rand.nextInt(colourUklength);
        int randomColourUkLength = new RandomNumberHelper().generateRandomNumber(colourUklength );
        System.out.println("randomly selected  color" + " " +randomColourUkLength);
        WebElement selectedColour = colourUk.get(randomColourUkLength);
        Thread.sleep(3000);
        selectedColour.click();
        Thread.sleep(3000);
        driver.navigate().refresh();

        //randomly choosing length
        List<WebElement> sizeUk = driver.findElements(By.xpath("//ul[@class='swatches size clearfix']/li"));
        int sizeUklength = sizeUk.size();
        System.out.println("total size length "+" " +sizeUklength);
        //int randomSizeUkLength = rand.nextInt(sizeUklength);
        int randomSizeUkLength = new RandomNumberHelper().generateRandomNumber(sizeUklength);
        System.out.println("selected  size  "+" " +randomSizeUkLength);
        WebElement selectedSize = sizeUk.get(randomSizeUkLength);
        Thread.sleep(3000);
        selectedSize.click();
       // System.out.println("total size length"+selectedSize);
        Thread.sleep(3000);
        WebElement addToBag = driver.findElement(By.id("add-to-cart"));
        addToBag.click();
        String prodBasketTitle = driver.getTitle();

        //assertion
       /* if(actualProdTitle.equalsIgnoreCase(prodBasketTitle))
        {
            System.out.println("correct product added to basket");
        }
        else
        {
            System.out.println("product didn't match");
        } */
        Assert.assertEquals("correct product",actualProdTitle, prodBasketTitle);

    }

    @Test
    public void saleList(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.boohoo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        WebElement sale = driver.findElement(By.xpath("//li[contains(@class,'sale-menu womens-womens-sale-menu')]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(sale).build().perform();
        WebElement sale80 = driver.findElement(By.linkText("Sale - Up to 70% Off Everything"));

    }
}
