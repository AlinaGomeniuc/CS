Feature: Check reply functionality for review

  Background: User is on elite shoppy page
    Given Navigate to single page

  Scenario: Check review reply
    When Click on REVIEW tab
    And Click on REPLY button
    Then A review reply form appears
