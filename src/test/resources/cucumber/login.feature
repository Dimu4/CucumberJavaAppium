@login
Feature: Instagram login

  Scenario: As Instagram user, I can succesfully login
    When I tap on Login button
    Then I type "igor" into username field
    And I type "password" into password field
    Then I tap on Login button
    And I verify user is logged in

  Scenario Outline: As Instagram user, I can succesfully login
    When I tap on Login button
    Then I type "<username>" into username field
    And I type "<password>" into password field
    Then I tap on Login button
    And I verify user is logged in
    Examples:
      |username  | password |
      |igor      |password  |
      |alex      |password  |
