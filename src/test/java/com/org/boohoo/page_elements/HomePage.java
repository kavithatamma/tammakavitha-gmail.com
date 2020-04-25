package com.org.boohoo.page_elements;

import com.org.boohoo.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverManager {
@FindBy(xpath = "//li[contains(@class,'sale-menu womens-womens-sale-menu')]/a" )
private WebElement sale;

@FindBy(linkText = "Sale - Up to 70% Off Everything")
    private WebElement sale80;

    public String getTitle(){
    return driver.getTitle();
}

public  void moveToSale(){
    Actions action = new Actions(driver);
    action.moveToElement(sale).build().perform();
    }

public void clickSale80()
{
    sale80.click();
}

}
