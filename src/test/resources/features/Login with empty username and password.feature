@TC_02 @Test
Feature: Login Scenario empty username and password

  Scenario Outline: Login with empty username and password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with username error "<err>"

    Examples:
      | username | password | err |
      |          |          | Username is required |



