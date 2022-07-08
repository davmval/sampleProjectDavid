Feature: Admin logs into the OrangeHRM website

  @Login
  Scenario Outline: Admin logs in with credentials
    Given admin is on login page
    When admin inputs credentials "<username>" and password: "<password>"
    Then OrangeHRM Dashboard homepage is confirmed
    Examples:
      | username    | password |
      | Admin       | admin123 |

  @Login
  Scenario: Admin inputs empty data on login page
    Given admin is on login page
    When admin inputs credentials "" and password: ""
    Then not credentials message is show

  @Login
  Scenario Outline: Admin inputs wrong credentials on login page
    Given admin is on login page
    When admin inputs credentials "<wrongUsername>" and password: "<WrongPassword>"
    Then invalid credentials message is show
    Examples:
      | wrongUsername      | WrongPassword   |
      | davidvalero | 123456 |
      | mufasa   | simba123 |