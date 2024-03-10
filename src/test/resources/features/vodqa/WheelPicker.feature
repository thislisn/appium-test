Feature: Wheel Picker

  @vodqa
  Scenario: test Wheel Picker feature
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I swipe up on Sample List Page
    And I go to Wheel Picker Demo Page
    Then I check Wheel Picker Demo Page is displayed
    And I check current status is "Current Color: red" on Wheel Picker Demo Page
    When I pick Colour "green" on Wheel Picker Demo Page
    Then I check current status is "Current Color: green" on Wheel Picker Demo Page