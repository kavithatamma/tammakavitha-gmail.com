package com.org.boohoo;

import com.org.boohoo.driver.DriverManager;
import com.org.boohoo.page_elements.HomePage;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegressionSuite  {
    private HomePage homePage = new HomePage();

    @Test
    public void sale()
    {
       String title = homePage.getTitle();
       System.out.println(title);
        homePage.moveToSale();
        homePage.clickSale80();
    }
}
