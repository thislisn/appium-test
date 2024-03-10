Feature: Native View Demo Page

  @vodqa
  Scenario: test Native View Demo Page content
    Given I open Samples List Page
    Then I check Sample List Page is displayed
    When I go to Native View Demo Page
    Then I check Native View Demo Page is displayed
    And I check text block "Hello World, I'm View one" on Native View Demo Page is displayed
    And I check text block "Hello World, I'm View two" on Native View Demo Page is displayed
    And I check text block "Hello World, I'm View three" on Native View Demo Page is displayed