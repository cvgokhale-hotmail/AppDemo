Feature: Login Scenario


  Scenario Outline: Login with valid username and password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then I should see Products page with title "<title>"

    Examples:
      | username | password | title |
      |bob@example.com |10203040 |   |

  Scenario Outline: Login with locked user
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with an error "<err>"

    Examples:
      | username | password | err |
      |alice@example.com |10203040 | Provided credentials do not match any user in this service |

  Scenario Outline: Login with invalid username and password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with an error "<err>"

    Examples:
      | username | password | err |
      | 1@2.com |f-o-o | Provided credentials do not match any user in this service |

  Scenario Outline: Login with empty username and password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with an error "<err>"

    Examples:
      | username | password | err |
      |          |          | Provided credentials do not match any user in this service |

  Scenario Outline: Login with empty password
    Given I am on login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login button
    Then login should fail with an error "<err>"

    Examples:
      | username | password | err |
      |bob@example.com|          | Provided credentials do not match any user in this service |



