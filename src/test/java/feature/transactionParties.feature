@login
Feature: User should be able to save, update and delete records from transaction Parties dictionary

  @final
  Scenario: User can save new record to dictionary
    Given user is on the home page
    When user go to transaction Parties dictionary
    And save new record to dictionary
      | Name     | Address | Phone |
      | Viktor      | Kiev     | 0502501256 |
    Then user should see the added record in dictionary

  @final
  Scenario: User can delete a record from dictionary
    Given user is on the home page
    When user go to transaction Parties dictionary
    And save new record to dictionary
      | Name     | Address | Phone |
      | Viktor      | Kiev     | 0502501256 |
    Then user should see the added record in dictionary
    And delete new record from dictionary
    Then user should not see the record in dictionary

  @final
  Scenario: User can update a record from dictionary
    Given user is on the home page
    When user go to transaction Parties dictionary
    And save new record to dictionary
      | Name     | Address | Phone |
      | Viktor      | Kiev     | 0502501256 |
    Then user should see the added record in dictionary
    And update new record from dictionary with values
      | Name     | Address | Phone |
      | Oleg      | Minsk     | 0505001020 |
    Then user should see the updated record in dictionary
