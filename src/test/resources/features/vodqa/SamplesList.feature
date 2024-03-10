Feature: Samples list

  @vodqa
  Scenario: test Samples list contents
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    And I check content on Sample List Page as in saved json
    When I swipe up on Sample List Page
    Then I check content on Sample List Page as in saved json