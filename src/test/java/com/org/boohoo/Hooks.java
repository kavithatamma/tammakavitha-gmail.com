package com.org.boohoo;

import com.org.boohoo.driver.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks  {
    public  DriverManager driverManager=new DriverManager();

    @Before
    public void setUp() {
        driverManager.openBrowser();
    }
    @After
    public void tearDown() { driverManager.closeBrowser();
    }
}
