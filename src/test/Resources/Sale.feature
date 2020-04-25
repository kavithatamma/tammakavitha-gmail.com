Feature: Sale
  As an end  User
  I want to view products in sale
  so that I can purchase  products

#  Scenario: Purchase sale products
#    Given User is on home page
#    When User move over sale menu
#    Then User click on special sales offer
#    Then user selects desired sale products
#    Then selected products should be added to the basket

    #Scenario: Shopping Bag
      #Given User is on home page
     # When User clicks on shopping bag page
     # Then selected products should be displayed in the basket

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