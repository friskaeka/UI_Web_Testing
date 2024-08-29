Feature: Test Automation Web

  @web
  Scenario: Tes Login Web Normal
    Given Open Web login page
    And User Input Username "standard_user"
    And User Input Password "secret_sauce"
    And User Click Login Button
    And User Will See Icon Chart in Homepage

  @web
  Scenario: Tes Login Web with locked user
    Given Open Web login page
    And User Input Username "locked_out_user"
    And User Input Password "secret_sauce"
    And User Click Login Button
    And User Will See Error Message "Sorry, this user has been locked out."

  @web
  Scenario: Tes Login Web to cart
    Given Open Web login page
    And User Input Username "standard_user"
    And User Input Password "secret_sauce"
    And User Click Login Button
    And User Will See Icon Chart in Homepage
    And User Add Item to Cart
    Then Verify Cart Item Match "1"

  @web
  Scenario: Tes Login Web Remove to cart
    Given Open Web login page
    And User Input Username "standard_user"
    And User Input Password "secret_sauce"
    And User Click Login Button
    And User Will See Icon Chart in Homepage
    And User Add Item to Cart
    And User Add Item to Cart
    Then Verify Cart Item Match "2"
    And User Remove Item To Cart
    Then Verify Cart Item Match "1"

  @web
  Scenario: Tes Login User See Your Chart
    Given Open Web login page
    And User Input Username "standard_user"
    And User Input Password "secret_sauce"
    And User Click Login Button
    And User Will See Icon Chart in Homepage
    And User Add Item to Cart
    Then Verify Cart Item Match "1"
    And User Click Icon Cart
    Then User Will See Button Checkout in your cart page

#  @web
#  Scenario: Tes Login Web with username and password invalid
#    Given Open Web login page
#    And User Input Username "locked_out_user"
#    And User Input Password "secret_saucee"
#    And User Click Login Button
#    And User Will See Error Message "Username and password do not match."