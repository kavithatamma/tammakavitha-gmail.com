Feature: Sale
  As an end  User
  I want to view products in sale
  so that I can purchase  products

  @HomePage
  Scenario: Purchase sale products
    Given User is on home page
    When User mouse over sale menu and click on special sales offer
    Then user selects desired sale product and product description page should be loaded

  @ChooseColour
  Scenario: Choose the colour
    Given User is on ProductDescriptionPage
    When User selects the colour
    Then Selected coloured product should be displayed

  @ChooseSize
  Scenario: Choose the Size
    Given User is on ProductDescriptionPage
    When User selects the Size
    Then Selected Size should be displayed

  @ChoosePosQty
  Scenario Outline:Select the Quantity
    Given User is on ProductDescriptionPage
    When User enter "<qty>"
    Then Entered Quantity should be displayed
    Examples:
      | qty|
      |10|

  @ChooseNegQty
  Scenario Outline:Select the Quantity
    Given User is on ProductDescriptionPage
    When User enter "<qty>"
    Then Proper error message should be displayed
    Examples:
      | qty|
      |11|

    @AddProdToShoppingBag
    Scenario: Adding product to Shopping Bag
    Given User is on ProductDescriptionPage
    When User enters product details and user clicks on ADD TO BAG
    Then Product should be added to the shopping bag


  @ShoppingBag
  Scenario: Shopping Bag
    Given User is on home page
    When User clicks on shopping bag page
    Then selected products should be displayed in the basket

  @Checkout
  Scenario: CheckOut
    Given User is on shopping bag page
    When User clicks on Checkout
    Then Checkout Log In page should be loaded

  @GuestUser
  Scenario: CheckOut As a Guest User
    Given User is on checkout Login page
    When User clicks on Checkout as a Guest
    Then Shipping page should be loaded

  @ShippingDetails
  Scenario Outline: Filling shipping details
    Given User is on shipping page
    When User enters "<FirstName>" and "<LastName>" and "<Email>" and "<ConfirmEmail>" and "<AddressLine1>"
    And User enters  "<City>" and "<Postcode>" and "<PhoneNumber>"
    And User chooses proper Delivery Option
    And User clicks on Proceed To Billing
    Then Billing and payment page should be loaded
    Examples:
      |FirstName|LastName|Email|ConfirmEmail|AddressLine1|City|Postcode|PhoneNumber|
      |Savi     |Rdy     |Savirdy@gmail.com|Savirdy@gmail.com|Betchworth Road|Luton|LU1 1BB|07801501667|