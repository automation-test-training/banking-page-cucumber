Feature: Transfer

  @wip
  Scenario: transfer in self account
    Given I have accounts:
      | 1001 | - cny 100000 |
      | 2001 | - cny 200000 |
    When I transfer 500 cny from "1001" to "2001"
    Then my balance should be:
      | 1001 | - cny 99500 |
      | 2001 | - cny 200500 |
