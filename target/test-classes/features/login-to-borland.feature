@Test
Feature: Login to Borland

  Login with valid user name 

  @CIT-4 @OPEN @Test
  Scenario: Login with valid credentials
    Given User is on Borland login page
    When User enters valid user name and password
    Then User navigates to Catalog page
