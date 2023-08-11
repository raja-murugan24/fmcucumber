Feature: Test login functionality of CRC web application

  Scenario: User is logged in
    Given browser is navigated to Microsoft login page
    When user submit valid credentials to CRC web application
    Then user should be logged in