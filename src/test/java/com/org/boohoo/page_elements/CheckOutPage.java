package com.org.boohoo.page_elements;

import com.org.boohoo.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends DriverManager {
    @FindBy(xpath = "(//button[@type='submit'])[3]")
    private WebElement continueasaGuest;

    public void clickcontinueasaGuest() throws InterruptedException {
        continueasaGuest.click();
        Thread.sleep(5000);
    }

}
