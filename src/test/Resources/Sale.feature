Feature : Sale
  Scenario: Adding sale item to the basket

  Given I am on Home page
  When I click on SALE menu
  Then SALE sub-options should be loaded
  Then click on sale sub-option sale items should be displayed
  Then Add the selected sale item to the shopping bag