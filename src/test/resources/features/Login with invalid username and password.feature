@TC_03 @Test
Feature: Login Scenario invalid username and password

  Scenario Outline: Login with invalid username and password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with an error "<err>"

    Examples:
      | username | password | err |
      | 1@2.com |f-o-o | Provided credentials do not match any user in this service. |



