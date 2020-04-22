@login
Feature: User should be able to login

  @final
  Scenario: User should be redirected to homepage after login with valid login
    Given user is on the login page
    When user login with valid login
    Then avatar should be on login screen

  @final
  Scenario: User can not login with wrong credentials
    Given user is on the login page
    When user login with wrong login
      | Login     | Password |
      | Lena      | 909090     |
    Then loginBox should be on login screen