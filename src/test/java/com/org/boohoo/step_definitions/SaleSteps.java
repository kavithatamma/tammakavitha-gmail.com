package com.org.boohoo.step_definitions;

import com.org.boohoo.page_elements.HomePage;
import com.org.boohoo.page_elements.ProductDescription;
import com.org.boohoo.page_elements.ResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SaleSteps {

    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();
    private ProductDescription productDescription = new ProductDescription();

    @Given("^User is on home page$")
    public void onHomePage() {
        String actualTitle = homePage.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "boohoo | Womens & Mens Clothes | Shop Online Fashion";
        Assert.assertEquals("correct page",actualTitle,expectedTitle);
    }

    @When("^User move over sale menu$")
    public void user_move_over_sale_menu() {
        homePage.moveToSale();

    }

    @Then("^User click on special sales offer$")
    public void user_click_on_special_sales_offer() {
        homePage.clickSale80();
    }

    @Then("^user selects desired sale products$")
    public void user_selects_desired_sale_products() {
       String selectedProd =  resultsPage.selectAnyProduct();
        System.out.println("selected product " +" " + selectedProd);

    }

    @Then("^selected products should be added to the basket$")
    public void selected_products_should_be_added_to_the_basket() throws InterruptedException {
    productDescription.selectColour();
    productDescription.selectSize();
    productDescription.addProductToBasket();
    }
}
