@reto
Feature: Employee Management in OrangeHRM

  Scenario Outline: Add a new employee
    Given the user is on the OrangeHRM login page
    And logs in with valid credentials
    Then is redirected to the admin dashboard
    Given the user navigates to the "PIM" section
    When the user clicks on the "Add" button
    And fills out the employee registration form
      | firstName | middleName | lastName | username | password |
      | <firstName> | <middleName> | <lastName> | <username> | <password> |

    Then the new employee should be successfully added
    Examples:
      | firstName | middleName | lastName | username | password |
      | User      | test       | Automation     | User       | Admin123     |


