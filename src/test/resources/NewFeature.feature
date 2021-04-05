@AddToCart
Feature: Add to cart functionality

#  @Scenario1
#
#  Scenario: Ability of adding a product to cart
#    Given user goes to the 'Product' page
#    And user is on the 'Product' page
#    Then 'Add to cart' button is displayed
#    Then 'Item Name' button is displayed
##    And 'Add to cart' is on the right of the product
#    When user clicks to 'Add to cart' button
#    When user clicks to 'Proceed to checkout' button
#    Then user is on the 'Summary Checkout' page
##    And product 'Faded Short Sleeve T-shirts' is 'In stock'

  @Scenario1
  Scenario: Create an account
    Given user navigates to 'http://automationpractice.com/index.php'
    And user is on the 'Home Page' page
    When user clicks to 'Login' button
    And user is on the 'Authentication' page
    And user types new email into 'email create' field
    And user click to 'Create Account' button
    Then user is on the 'Account Creation' page
