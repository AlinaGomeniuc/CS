Feature: Verify adding multiple products from Single Page.

  Background: User is on elite shoppy page
    Given Navigate to single page

  Scenario: Adding multiple products to cart
    When Scroll to products area
    And Click on 1 element ADD TO CART button
    And Click on 2 element ADD TO CART button
    Then Cart should contain 2 elements

