Feature: Long Press

  @vodqa
  Scenario: test Long press feature
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I go to LongPress Demo Page
    Then I check Long Press Demo Page is displayed
    When I long tap Long Press button on Long Press Demo Page
    Then I check alert with message "you pressed me hard :P" is displayed on Long Press Demo Page