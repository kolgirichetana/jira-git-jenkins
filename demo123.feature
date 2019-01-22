Feature: Demo123

  @CIT-5 @OPEN
  Scenario: LoginFeature
    Given User is on Borland login page
    When User enters valid user name and password
    Then User navigates to Catalog page
