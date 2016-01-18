@signup
Feature: Instagram signup

  Scenario: As Instagram user, I can create new account
    Then I type "alex01" into username field
    And I type "password01" into password field
    Then I tap on Signup button
    And I verify that new user has been created