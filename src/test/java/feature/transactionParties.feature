@login
Feature: User should be able to login

  @final
  Scenario: Login with  valid login
    Given user is on the home page
    When user login with valid login
    Then avatar should be on login screen

#  @final
#  Scenario: Login with  wrong login
#    Given user is on the login page
#    When user login with wrong login
#      | Login     | Password |
#      | Lena      | 909090     |
#    Then loginBox should be on login screen






#  loginPage.loginToPage(user, password);
#  checkExpectedResult("Avatar is displayed", homePage.isAvatarDisplayed());
#
#  transactionParties.tableView();
#  int rawsBefore = transactionParties.countTableRows();
#  transactionParties.addTableRecord(name, address, phone);
#  int rawsAfter = transactionParties.countTableRows();
#  Assert.assertEquals(rawsBefore + 1, rawsAfter);
#
#  String actualRecord = transactionParties.getTableRecord(rawsAfter - 1);
#  String expectedRecord = name + " " + address + " " + phone;
#  Assert.assertTrue("Table record wasn't updated", actualRecord.contains(expectedRecord));





















  #Feature: github login
#
#  @q
#  Scenario: login with  username and password in table
#    Given user is on github homepage
#    When user login to site
#      | Login     | Password |
#      | Lena      | pass     |
#    Then user is displayed login screen
#
#
#  @q
#  Scenario: 2222ogin without username and password
#    Given user is on github homepage
#    When user input 1111 login to the login field
#    When user input password password to the login field
#    When user clicks on Sign in button
#    Then user is displayed login screen
#
#
#
#  Scenario: 2111ogin without username and password
#    Given user is on github homepage
#    When user clicks on Sign in button
#    Then user is displayed login screen
#
#  @ignore
#  Scenario: 2333ogin without username and password
#    Given user is on github homepage
#    When user clicks on Sign in button
#    Then user is displayed login screen


#
#
#  @login
#Feature: User is able to proceed with login
#  In order to verify that login feature of shop works correctly
#  As a shop user
#  I should be able to login
#
#  @final @initial
#  Scenario: User can access login form and login
#    Given I am on the home page
#    And element "b2b-claim" should not be in page code
#    When I login as "private" user
#    Then element "b2b-claim" should not be in page code
#    And I click "user account dropdown" element
#    And I should see "Kundennummer" text on the page

