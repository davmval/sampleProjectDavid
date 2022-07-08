Feature: Admin uses the leave page for employees

  @Admin
  Scenario: admin adds a new employee leave
    Given admin is on assign leave page
    When admin inputs all employee information
    And admin creates employee leave
    Then employee leave is confirmed

  @Admin
  Scenario: admin searches for employee leave
    Given admin is on leave list page
    And search all parameter is checked
    When admin searches for employee leave
    Then the leave can be viewed
    Then the leave is not visible

  @Admin
  Scenario: admin cancels leave for employee
    Given admin is on leave list page
    When admin applies the cancel action
    Then the employee leave is now canceled