Feature: Test login functionality of CRC web application


  Scenario: Checking all the field values of Assigned to me tab and Modified by me tab
    When user is on Assigned to me tab
    Then user is able to see the given fields for available cases
    When user is navigated to Modified by me tab
    Then user is able to see modified cases with given field values

  Scenario: Retrieving the tabs
    Given user is on landing page
    When clicked upon Assigned to me tab
    Then user is able to access Assigned to me tab
    When clicked upon  Modified by me tab
    Then user is able to access Modified by me tab
    When clicked upon All active reviews tab
    Then user is able to access All active reviews tab
