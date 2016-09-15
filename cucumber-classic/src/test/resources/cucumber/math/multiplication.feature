Feature: Classic Math #2 : multiplication

  As we have to be sure that a computer is able to execute all
  mathematical operations, a verification test must be set.

  Scenario: Calculate a MULTIPLICATION (i.e. buying 3 cucumbers)

    Given A "cucumber" in the grocery store costs $1.07
    When I buy 3 "cucumber"
    Then The final bill is $3.21


  Scenario:  Calculate a more complex MULTIPLICATION (i.e. calculate cucumber's bill price)
    Given The cucumbers in the grocery store have the following prices
      | small cucumber | $0.85 |
      | large cucumber | $1.07 |
    When I buy 3 "small cucumber"
    And I buy 4 "large cucumber"
    Then The final bill is $6.83

