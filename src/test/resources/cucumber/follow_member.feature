@follow
Feature: Instagram user can follow a user from userlist

  Background:
    Given I login to Instagram app with credentials:
      |Username |  igor       |
      |Password |  password   |

  @followOne
  Scenario: follow a user and check if following
    Given I tap on cell1 button
    Then I make a swipe down gesture
    Then I wait for cellfollowing element
    Then I verify that cellfollowing is presented

  Scenario: unfollow scenario
      Given I tap on "cell_1_following" button
      Then I make a swipe down gesture
      Then I wait for "cell_1" element
      Then I verify that "cell_1" is presented

