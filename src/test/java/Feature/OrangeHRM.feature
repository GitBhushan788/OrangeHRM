Feature: Test OrangeHRM Application

  Scenario: Validate login functionality
    Given user on login page
    When user enter valid credintioals
    And user click on login button
    Then user validate Home page Title

  Scenario: validate home page functionality
    Given user on home page and validate logo
    And user validate Title
    And user validate Url

  Scenario: add Employee in PIM Page
    Given user on Home page and click on PIM Link
    When user click on add Employee button
    And uer enter firstname "ramesh" middlename "suresh" lastname "pandy"
    Then user capture employee ID
    And user click on save button

  Scenario: Add Employee more details
    Given User validate employeeId
    When user enter otherId as "345" and select nationality "Indian"
    And user select marrital status "Married"
    And user select gender
    Then click on MoreDetailsSave button
