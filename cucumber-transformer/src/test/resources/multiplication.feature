Feature: Money Transformer

  As we have to be sure that a computer is able to execute all
  mathematical operations, a verification test must be set.

  Scenario: Use the money transformer to calculate result's correctness

    Given A "cucumber" in the grocery store costs $1.07
    When I buy 3 "cucumber"
    Then The final bill is $3.21
