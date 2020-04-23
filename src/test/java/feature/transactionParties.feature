@login
Feature: User is able to save, update and delete records from transaction Parties dictionary

  @final
  Scenario: User can save a new record to dictionary
    Given user is on the home page
    When user switches to transaction Parties dictionary tab
#    And saves new record to dictionary
#      | Name     | Address | Phone |
#      | Viktor      | Kiev     | 0502501256 |
    And fills in the following fields
      | Name     | Address | Phone |
      | Viktor      | Kiev     | 0502501256 |
    And clicks on Create button
    Then user should see the record in dictionary

  @final
  Scenario: User can delete the record from dictionary
    Given user is on the home page
    When user switches to transaction Parties dictionary tab
    And saves new record to dictionary
      | Name     | Address | Phone |
      | Viktor      | Kiev     | 0502501256 |
    Then user should see the record in dictionary
    When user deletes new record from dictionary
    Then user should not see the record in dictionary

  @final
  Scenario: User can update the record from dictionary
    Given user is on the home page
    When user switches to transaction Parties dictionary tab
    And saves new record to dictionary
      | Name     | Address | Phone |
      | Viktor      | Kiev     | 0502501256 |
    Then user should see the record in dictionary
    When user updates new record from dictionary with values
      | Name     | Address | Phone |
      | Oleg      | Minsk     | 0505001020 |
    Then user should see the updated record in dictionary
