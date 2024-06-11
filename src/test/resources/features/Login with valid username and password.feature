@TC_05 @Test
Feature: Login Scenario

  Scenario Outline: Login with valid username and password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then I should see Products page with title "<title>"

    Examples:
      | username | password | title |
      |bob@example.com |10203040 |Products|


