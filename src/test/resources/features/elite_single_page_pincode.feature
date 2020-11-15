Feature: Check delivery, payment options, and charges of the product using a pincode.

  Background: User is on elite shoppy page
    Given Navigate to single page

  Scenario: Check product pincode
    When Populate pincode input field with "123abc"
    And Click on CHECK button
    Then Redirects to a new page with required info
