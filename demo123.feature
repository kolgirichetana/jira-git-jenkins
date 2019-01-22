Feature: Demo123

  @ORPHAN
  Scenario: LoginFeature
    Given User is on Borland login page
    When User enters valid user name and password
    Then User navigates to Catalog page
