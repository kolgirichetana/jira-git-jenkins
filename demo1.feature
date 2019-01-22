@LoginFail
Feature: Demo1

  TestLogin

  @ORPHAN
  Scenario: LoginTest
    Given User is on Borland login page
    When User enters valid user name and password
    Then User navigates to Catalog page
