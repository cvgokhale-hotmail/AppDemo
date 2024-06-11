@TC_01 @Test
Feature: Login Scenario

  Scenario Outline: Login with empty password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with password error "<err>"

    Examples:
      | username | password | err |
      |bob@example.com|          | Password is required |
