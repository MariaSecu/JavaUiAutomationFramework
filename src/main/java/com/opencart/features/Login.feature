Feature: Login Flow Test Suite

  @run
  Scenario Outline: An error message is displayed when trying to log in with invalid data
    Given The "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" link is accessed
    And the following set of credentials is entered into the login form:
      | <email>    |
      | <password> |
    When "loginButtonInput" from "LoginPage" is clicked
    Then the following error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | atribute                       | email           | password       |
      | email input data (not existent | valid@email.com | wrong email    |
      | password input data            | valid@email.com | wrong password |

  @run
  Scenario Outline: A valid user is able to log into the system
    Given The "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" link is accessed
    And the following set of credentials is entered into the login form:
      | <email>    |
      | <password> |
    When "loginButtonInput" from "LoginPage" is clicked
    Then the url contains the following keyword: "account"
    Examples:
      | email                    | password              |
      | omega.schmeler@yahoo.com | vyge2wf90k8kjpyl27h7z |

