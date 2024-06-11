@TC_04 @Test
Feature: Login Scenario
  Scenario Outline: Login with locked user
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with lockedUser error "<err>"

    Examples:
      | username | password | err |
      |alice@example.com |10203040 | Sorry, this user has been locked out. |
