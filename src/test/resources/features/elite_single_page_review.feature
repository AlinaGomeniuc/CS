Feature: Check adding review functionality

  Background: User is on elite shoppy page
    Given Navigate to single page

  Scenario: Verify sending review form with invalid email
    When Click on REVIEW tab
    And Populate review form
      | username | email | message |
      | test     | test  | abc     |
    And Click on SEND button
    Then A warning message "Enter an email address" appears