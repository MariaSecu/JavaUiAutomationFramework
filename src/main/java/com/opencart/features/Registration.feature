Feature: Register Flow Feature File

  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the PrivacyPolacy is enable
    And continueButton is clicked
    Then the new page url contains "=account/success&l" keyword

  Scenario: User remains on Registration Page when continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the PrivacyPolacy is enable
    Then the new page url contains "register" keyword