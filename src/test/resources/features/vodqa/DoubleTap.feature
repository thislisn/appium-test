Feature: Double tap

  @vodqa
  Scenario: test Double tap feature
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I go to Double Tap Demo Page
    Then I check Double Tap Demo Page is displayed
    When I double tap Double Tap Me button on Double Tap Demo Page
    Then I check alert with message "Double tap successful!" is displayed on Double Tap Demo Page