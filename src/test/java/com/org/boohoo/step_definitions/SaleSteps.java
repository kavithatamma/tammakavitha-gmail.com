package com.org.boohoo.step_definitions;

import com.org.boohoo.page_elements.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class SaleSteps {

    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();
    private ProductDescription productDescription = new ProductDescription();
    private ShoppingBag shoppingBag1 = new ShoppingBag();
    private CheckOutPage checkOutPage = new CheckOutPage();
    private ShippingPage shippingPage = new ShippingPage();
    private BillingAndPaymentPage billingAndPaymentPage = new BillingAndPaymentPage();

    String expProdTitle,expColor;

    @Given("^User is on home page$")
    public void onHomePage() {
        String actualTitle = homePage.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "boohoo | Womens & Mens Clothes | Shop Online Fashion";
       // Assert.assertEquals("correct page",actualTitle,expectedTitle);
        assertThat(actualTitle,is(equalToIgnoringCase(expectedTitle)));
    }

    @When("^User move over sale menu$")
    public void user_move_over_sale_menu() {
        homePage.moveToSale();
    }

    @Then("^User click on special sales offer$")
    public void user_click_on_special_sales_offer() {
        homePage.clickSale80();
        String actualThumbNail = resultsPage.getThumbNail();
        //System.out.println("actual thumbnail " +actualThumbNail);
        assertThat(actualThumbNail, is(equalToIgnoringCase("WOMENS SALE")));
    }

    @Then("^user selects desired sale products$")
    public void user_selects_desired_sale_products() {
       String selectedProd =  resultsPage.selectAnyProduct();
        System.out.println("selected product " +" " + selectedProd);
    }
    @Then("^selected products description page should be loaded$")
    public void selected_products_description_page_should_be_loaded()  {

    }
    @When("^User mouse over sale menu and click on special sales offer$")
    public void user_mouse_over_sale_menu_and_click_on_special_sales_offer()  {
        homePage.moveToSale();
        homePage.clickSale80();
        String actualThumbNail = resultsPage.getThumbNail();
        //System.out.println("actual thumbnail " +actualThumbNail);
        assertThat(actualThumbNail, is(equalToIgnoringCase("WOMENS SALE")));

    }

    @Then("^user selects desired sale product and product description page should be loaded$")
    public void user_selects_desired_sale_product_and_product_description_page_should_be_loaded()  {
        String selectedProd =  resultsPage.selectAnyProduct();
        System.out.println("selected product " +" " + selectedProd);
    }

    //Change Colour sale steps
    @Given("^User is on ProductDescriptionPage$")
    public void user_is_on_ProductDescriptionPage(){
        homePage.moveToSale();
        homePage.clickSale80();
        resultsPage.selectAnyProduct();
    }

    @When("^User selects the colour$")
    public void user_selects_the_colour() throws InterruptedException {
        expColor =  productDescription.selectColour();
    }

    @Then("^Selected coloured product should be displayed$")
    public void selected_colour_should_be_displayed() throws InterruptedException {
       String[] expSplitColor = expColor.split(":");
       System.out.println("Exp color"+expSplitColor[1]);
        //System.out.println("expcolor color "+ expColor);
        //System.out.println("actual color"+actualColor);
       //String actualColor = productDescription.dispSelColor();
       //assertThat(actualColor,is(equalToIgnoringCase(expColor)));
    }

    //Change Size Step defs
       @When("^User selects the Size$")
    public void user_selects_the_Size() throws InterruptedException {
        productDescription.selectSize();
          }

    @Then("^Selected Size should be displayed$")
    public void selected_Size_should_be_displayed()  {
        System.out.println("displayed selected color = "+productDescription.dispSelSize());

    }
    // Entering qty stepdefs
    @When("^User enter \"([^\"]*)\"$")
    public void user_enter(String qty) throws InterruptedException {
        productDescription.selectColour();
        productDescription.selectSize();
        productDescription.enterQuantity(qty);
    }

    @Then("^Entered Quantity should be displayed$")
    public void Entered_Quantity_should_be_displayed(){

    }

    //Entering Negative values for qty step defs
    @Then("^Proper error message should be displayed$")
    public void proper_error_message_should_be_displayed()  {
    System.out.println("Please enter a value less than or equal to 10.");
    }

    // Adding product to the basket
    @When("^User enters product details and user clicks on ADD TO BAG$")
    public void user_enters_product_details_and_user_clicks_on_ADD_TO_BAG() throws InterruptedException {
        productDescription.selectColour();
        productDescription.selectSize();
        //productDescription.enterQuantity(String qty);
    }

    @Then("^Product should be added to the shopping bag$")
    public void product_should_be_added_to_the_shopping_bag(){

    }


    @Then("^selected products should be added to the basket$")
    public void selected_products_should_be_added_to_the_basket() throws InterruptedException {
    productDescription.selectColour();
    productDescription.selectSize();
    productDescription.addProductToBasket();
    }

    @When("^User clicks on shopping bag page$")
    public void User_clicks_on_shopping_bag_page()throws InterruptedException{
        homePage.moveToSale();
        homePage.clickSale80();
        resultsPage.selectAnyProduct();
        productDescription.selectColour();
        productDescription.selectSize();
        productDescription.addProductToBasket();
        expProdTitle = productDescription.getProdName();
        System.out.println("expected product title"+expProdTitle);
        Thread.sleep(5000);
        shoppingBag1.clickShoppingBag();
    }
    @Then("^selected products should be displayed in the basket$")
    public void selected_products_should_be_displayed_in_the_basket()  {
        String actualProdTitle = shoppingBag1.getActualProdTitle();
        System.out.println(shoppingBag1.getActualProdTitle());
        assertThat(actualProdTitle,is(equalToIgnoringCase(expProdTitle)));
    }
    @Given("^User is on shopping bag page$")
    public void User_is_on_shopping_bag_page() throws InterruptedException {
        homePage.moveToSale();
        homePage.clickSale80();
        resultsPage.selectAnyProduct();
        productDescription.selectColour();
        productDescription.selectSize();
        productDescription.addProductToBasket();
        shoppingBag1.clickShoppingBag();
    }
    @When("^User clicks on Checkout$")
    public void user_clicks_on_Checkout()  {
        shoppingBag1.clickCheckOut();
    }
    @Then("^Checkout Log In page should be loaded$")
    public void checkout_Log_In_page_should_be_loaded() {
        String actualTitle = checkOutPage.getCurrentUrl();
        System.out.println("checkout page title"+actualTitle);
        assertThat(actualTitle,is(endsWith("/checkout-login")));
    }
    @Given("^User is on checkout Login page$")
    public void user_is_on_checkout_Login_page() throws InterruptedException {
        homePage.moveToSale();
        homePage.clickSale80();
        resultsPage.selectAnyProduct();
        productDescription.selectColour();
        productDescription.selectSize();
        productDescription.addProductToBasket();
        Thread.sleep(5000);
        shoppingBag1.clickShoppingBag();
        shoppingBag1.clickCheckOut();
    }

    @When("^User clicks on Checkout as a Guest$")
    public void user_clicks_on_Checkout_as_a_Guest() throws InterruptedException {
        checkOutPage.clickcontinueasaGuest();
    }

    @Then("^Shipping page should be loaded$")
    public void shipping_page_should_be_loaded()  {
        String actualTitle = shippingPage.getCurrentUrl();
        System.out.println("shipping page title"+actualTitle);
        assertThat(actualTitle,is(endsWith("/shipping")));
    }

    @Given("^User is on shipping page$")
    public void user_is_on_shipping_page() throws InterruptedException {
        homePage.moveToSale();
        homePage.clickSale80();
        resultsPage.selectAnyProduct();
        productDescription.selectColour();
        productDescription.selectSize();
        productDescription.addProductToBasket();
        Thread.sleep(5000);
        shoppingBag1.clickShoppingBag();
        shoppingBag1.clickCheckOut();
        checkOutPage.clickcontinueasaGuest();
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_and_and_and_and(String FirstName, String LastName, String Email, String ConfirmEmail, String AdressLine1) {
    shippingPage.enterFirstName(FirstName);
    shippingPage.enterLastName(LastName);
    shippingPage.enterEmailAddress(Email);
    shippingPage.enterConfirmEmailAddress(ConfirmEmail);
    shippingPage.enterAddress1(AdressLine1);
    }

    @When("^User enters  \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_and_and(String City, String PostCode, String PhoneNumber)  {
        shippingPage.enterCity(City);
        shippingPage.enterPostalCode(PostCode);
        shippingPage.enterPhone(PhoneNumber);
    }

    @When("^User chooses proper Delivery Option$")
    public void user_chooses_proper_Delivery_Option() {
        shippingPage.chooseRandomDeliveryOptions();

    }
    @When("^User clicks on Proceed To Billing$")
    public void user_clicks_on_Proceed_To_Billing() throws InterruptedException {
        shippingPage.clickProceedToBilling();
        Thread.sleep(5000);

    }
    @Then("^Billing and payment page should be loaded$")
    public void billing_and_payment_page_should_be_loaded() {
       String actualTitle = billingAndPaymentPage.getCurrentUrl();
       assertThat(actualTitle,is(endsWith("/billing-continue")));
    }

}
