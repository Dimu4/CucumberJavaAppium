@signup
Feature: Instagram signup

  Scenario: As Instagram user, I can create new account
    Then I type "alex" into username field
    And I type "password" into password field
    Then I tap on Signup button
    And I verified "Failed Signup" message