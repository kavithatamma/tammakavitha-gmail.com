package com.org.boohoo.page_elements;

import com.org.boohoo.driver.DriverManager;
import com.org.boohoo.utils.RandomNumberHelper;
import junit.framework.TestCase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDescription extends DriverManager {
@FindBy(xpath = "//ul[@class ='swatches color clearfix']/li")
    private List<WebElement> colorUk;

@FindBy(xpath = "//ul[@class='swatches size clearfix']/li")
private List<WebElement> sizeUk;

@FindBy(id = "add-to-cart")
private WebElement addToBag;

@FindBy(css = "h1.product-name.hidden-on-mobile.js-product-name")
private WebElement prodText;

    public void selectColour () throws InterruptedException {
        int colourUklength = colorUk.size();
        if(colourUklength == 0){
            TestCase.fail("choosen colour is not available");
        }
        int randomColourUkLength = new RandomNumberHelper().generateRandomNumber(colourUklength );
        WebElement selectedColour = colorUk.get(randomColourUkLength);
        Thread.sleep(3000);
        selectedColour.click();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    public void selectSize() throws InterruptedException {
        ;int sizeUklength = sizeUk.size();
        System.out.println("size of products"+sizeUklength);
        if(sizeUklength==0){
            TestCase.fail("choosen size is not available");
        }
        int randomSizeUkLength = new RandomNumberHelper().generateRandomNumber(sizeUklength);
        System.out.println("selected  size  "+" " +randomSizeUkLength);
        WebElement selectedSize = sizeUk.get(randomSizeUkLength);
        Thread.sleep(3000);
        selectedSize.click();
        //Thread.sleep(3000);
        driver.navigate().refresh();
    }
    public void addProductToBasket(){
        addToBag.click();
    }
    public String getProdName(){
        return prodText.getText();
    }

}
