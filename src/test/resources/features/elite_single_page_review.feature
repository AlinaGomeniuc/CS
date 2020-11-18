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


  Scenario Outline: Verify sending review form with empty fields
    When Click on REVIEW tab
    And Populate review form with "<username>" "<email>" "<message>"
    And Click on SEND button
    Then A warning message "Fill out this field" appears

    Examples:
      | username | email          | message |
      |          | test@test.com  | abc     |
      |  test    |                | abc     |
      |  test    | test@test.com  |         |
