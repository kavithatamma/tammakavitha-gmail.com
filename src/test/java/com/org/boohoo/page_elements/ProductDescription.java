package com.org.boohoo.page_elements;

import com.org.boohoo.driver.DriverManager;
import com.org.boohoo.utils.RandomNumberHelper;
import junit.framework.TestCase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDescription extends DriverManager {
@FindBy(css =  "span.swatchanchor.js-swatchanchor.js-colorswatch[title*='Select Colour']")
    private List<WebElement> colorUk;

@FindBy(xpath = "(//span[@class='selected-value'])[1]")
private WebElement selColor;

@FindBy(xpath = "(//span[@class='selected-value'])[2]")
private WebElement selSize;

@FindBy(css = "[title*='Select Colour:']")
private WebElement actualColor;

@FindBy(xpath = "//ul[@class='swatches size clearfix']/li")
private List<WebElement> sizeUk;

@FindBy(id = "Quantity")
private WebElement quantity;

@FindBy(id = "add-to-cart")
private WebElement addToBag;

@FindBy(css = "h1.product-name.hidden-on-mobile.js-product-name")
private WebElement prodText;

    public String selectColour () throws InterruptedException {
        int colourUklength = colorUk.size();
       // String expColor;
        if(colourUklength == 0){
            TestCase.fail("choosen colour is not available");
        }
        int randomColourUkLength = new RandomNumberHelper().generateRandomNumber(colourUklength );
        WebElement selectedColour = colorUk.get(randomColourUkLength);
        Thread.sleep(3000);
        selectedColour.click();
        String expColor = selectedColour.getAttribute("title");
        Thread.sleep(3000);
        //driver.navigate().refresh();
       return expColor;
    }

    public void selectSize() throws InterruptedException {
        ;int sizeUklength = sizeUk.size();
        System.out.println("size of products"+sizeUklength);
        if(sizeUklength==0){
            TestCase.fail("choosen size is not available");
        }
        int randomSizeUkLength = new RandomNumberHelper().generateRandomNumber(sizeUklength);
        //System.out.println("selected  size  "+" " +randomSizeUkLength);
        WebElement selectedSize = sizeUk.get(randomSizeUkLength);
        Thread.sleep(3000);
        selectedSize.click();
        System.out.println("selected size = "+selectedSize.getText());
        //Thread.sleep(3000);
        driver.navigate().refresh();
    }
    public void enterQuantity(String qty){
        quantity.clear();
        quantity.sendKeys(qty);
    }
    public void addProductToBasket(){
        addToBag.click();
    }
    public String getProdName(){
        return prodText.getText();
    }

    public String dispSelColor(){
        return selColor.getText();
    }

    public String getActualColor(){
        return actualColor.getAttribute("title");
    }

    public String dispSelSize(){
        return selSize.getText();
    }

}
