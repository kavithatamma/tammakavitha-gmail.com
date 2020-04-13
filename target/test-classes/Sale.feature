Feature: Sale
  As an end  User
  I want to view products in sale
  so that I can purchase  products

  Scenario: Purchase sale products
    Given User is on home page
    When User move over sale menu
    Then User click on special sales offer
    Then user selects desired sale products
    Then selected products should be added to the basket