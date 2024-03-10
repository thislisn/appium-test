Feature: Vertical Swiping

  @vodqa
  Scenario: test Vertical Swiping Page feature
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I go to Vertical Swiping Page
    Then I check Vertical Swiping Page is displayed
    And I check that text block "Appium" is "not displayed" on Vertical Swiping Page
    When I swipe down on Vertical Swiping Page
    Then I check that text block "Appium" is "displayed" on Vertical Swiping Page