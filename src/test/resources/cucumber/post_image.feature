@post
Feature: Instagram user can post a new image from Library

  Scenario: As Instagram user, I can post a new image
    Given I login to Instagram app with credentials:
      |Username |  igor       |
      |Password |  password   |
    Then I tap on "Post" button
    And I verify post image screen
    Then I tap on "choose_image" button
    And I tap on "OK" button
    And I tap on "Camera Roll" button
    Then I select 1st image from Gallery
    And I verify post image screen
#    And I type "New Message" into message field
    And I tap on "post_image" button
#    And I verified "Post Image" message
    And I tap on "OK" button






