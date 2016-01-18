@login
Feature: Instagram login

  Scenario: As Instagram user, I can succesfully login
    When I tap on Login button
    Then I type "alex01" into username field
    And I type "password01" into password field
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
      |alex01    |password01|
      |igor01    |secret    |
