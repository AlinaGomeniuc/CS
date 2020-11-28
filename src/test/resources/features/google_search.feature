Feature: Check search functionality

  Scenario: Verify opening google page
    When Populate URL box with "https://www.google.co.in"
    Then Redirects to google main page