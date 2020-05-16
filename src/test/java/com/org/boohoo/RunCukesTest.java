package com.org.boohoo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Resources",
                tags="@AddProdToShoppingBag",
                dryRun = true
                )
public class RunCukesTest {

}
