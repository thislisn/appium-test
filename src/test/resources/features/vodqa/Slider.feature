Feature: Slider Page

  @vodqa
  Scenario: test Slider Page feature
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I go to Slider Page
    Then I check Slider Page is displayed
    And I check slide bar position is equal 0.0 on Slider Page
    When I fling Slider bar on Slider Page
    Then I check slide bar position is greater than 0.0 on Slider Page