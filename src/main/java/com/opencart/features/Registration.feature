Feature: Register Flow Feature File

  Background: The "https://andreisecuqa.host/" is accessed

  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And "privacyPolacy" from "RegisterPage" is clicked
    And "continueButton" from "RegisterPage" is clicked
    Then the url contains the following keyword: "account"

  Scenario: User remains on Registration Page when continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And "privacyPolacy" from "RegisterPage" is clicked
    Then the url contains the following keyword: "account"

  Scenario Outline: Error messages are displayed when trying to register with invalid <attribute> date
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    And the registration form is completed with the following data:
      | firstName | dfvghsgggggg       |
      | lastName  | Ischimov           |
      | email     | ischimov@gmail.com |
      | password  | Random             |
    When "continueButton" from "RegisterPage" is clicked
    Then the following error messages is displayed:
      | Warning: You must agree to the Privacy Policy! |
      #| <errorField> must to be between 1 and 32 characters! |

    Examples:
      | firstName   | lastName | email  | password | errorField |
      | fhfdfahdfka | random   | random | random   | First Name |
      | Valid       | gy454546 | random | random   | Last Name  |