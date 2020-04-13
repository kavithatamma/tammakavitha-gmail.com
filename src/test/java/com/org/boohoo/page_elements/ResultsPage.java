package com.org.boohoo.page_elements;

import com.org.boohoo.driver.DriverManager;
import com.org.boohoo.utils.RandomNumberHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends DriverManager {
    @FindBy(css = "div.product-tile-name>a")
    private List<WebElement>  saleItems;

    public String selectAnyProduct() {
        if (saleItems.size() == 0) {
            System.out.println("There are no sale items");
        }
        int prodCount = saleItems.size();
        int randomSaleItem = new RandomNumberHelper().generateRandomNumber(prodCount);
        System.out.println("randomly selected  sale item" +" "+ randomSaleItem);
        String prodSelected = saleItems.get(randomSaleItem).getText();
        saleItems.get(randomSaleItem).click();
        return prodSelected;
    }
}
