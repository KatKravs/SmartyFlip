
Feature: Donate Page
  @donate
  Scenario: Verify Donate Page title is displayed
    Given User open HOME_PAGE
    When User clicks DONATE_LINK
    When User verifies DONATE_PAGE
