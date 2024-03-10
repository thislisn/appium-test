Feature: Carousel

  @vodqa
  Scenario: test Carousel feature
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I swipe up on Sample List Page
    And I go to Carousel Page
    Then I check Carousel Page is displayed
    And I check Carousel index is "1"
    When I swipe left on Carousel Page
    Then I check Carousel index is "2"