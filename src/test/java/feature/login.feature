@login
Feature: User is able to login

  @final
  Scenario: User should be redirected to the home page after login with valid credentials
    Given user is on the login page
    When user login with valid credentials
    Then avatar should be on the home page

  @final @negative
  Scenario: User can not login with wrong credentials
    Given user is on the login page
    When user login with wrong credentials
      | Login     | Password |
      | Lena      | 80808080     |
    Then login form should be on the login page