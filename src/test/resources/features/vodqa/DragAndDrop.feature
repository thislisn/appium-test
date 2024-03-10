Feature: Drag and Drop

  @vodqa
  Scenario: test Drag and Drop feature
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I go to Drag & Drop Page
    Then I check Drag & Drop Page is displayed
    And I check Circle dropped title is not displayed
    When I drag and drop Drag Me button on Drag & Drop Page
    Then I check Circle dropped title is displayed