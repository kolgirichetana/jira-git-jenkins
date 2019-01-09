@Test
Feature: Test Borland Demo site

  @Test
  Scenario: Browse the Catalog
    Given Open "Chrome" browser and launch GMO
    When user is on GMO home page
    Then click on Enter GMO button
    And verify user is on Catalog page
    And user close the browser
