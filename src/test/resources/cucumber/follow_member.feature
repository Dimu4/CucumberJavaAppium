@follow
Feature: Instagram user can follow a user from userlist

  Scenario: follow a user and check if following
    Given I login to Instagram app with credentials:
      |Username |  igor       |
      |Password |  password   |
    Given I tap on "cell_1" button
    Then I make a swipe down gesture
    #Then I wait "3" sec
    Then I wait for "cell_1_following" element
    Then I verify that "cell_1_following" is presented
    