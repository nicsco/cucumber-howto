Feature: Classic Math #1 : addition and subtraction

  As we have to be sure that a computer is able to execute all
  mathematical operations, a verification test must be set.


  Scenario: Calculate an ADDITION (i.e. buying some cucumbers)
    Given I start with 7 cucumbers
    When I buy 3 cucumbers
    Then I have 10 cucumbers


  Scenario:  Calculate a SUBTRACTION (i.e. eating some cucumbers)
    Given I start with 7 cucumbers
    When I eat 3 cucumbers
    Then I have 4 cucumbers

