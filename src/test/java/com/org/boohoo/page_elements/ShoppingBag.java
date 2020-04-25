package com.org.boohoo.page_elements;

import com.org.boohoo.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBag extends DriverManager {
    @FindBy(css = "span#js-minicart-quantity")
    private WebElement shoppingBag;

    @FindBy(css="div.name>a[title *='Go to Product']")
    private WebElement actualProdTitle;

    @FindBy(css="button.js-first-button-checkout")
    private WebElement checkOut;

    public void clickShoppingBag(){
        shoppingBag.click();
    }

    public String getActualProdTitle(){
        return actualProdTitle.getText();
    }
    public void clickCheckOut(){
        checkOut.click();
    }
}
