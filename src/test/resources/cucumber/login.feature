Feature: Instagram login

  @login
  Scenario: Login as Igor
    When I tap on Login button
    Then I type "login" into username field
    And I type "password" into password field
    Then I tap on Login button
    And I verify user is logged in






