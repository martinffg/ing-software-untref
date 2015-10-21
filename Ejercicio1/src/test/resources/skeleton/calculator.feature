Feature: Calculator

  Scenario: add 2 and 2 should return 4
    Given I have a calculator
    When I add 2 and 2
    Then I get 4
