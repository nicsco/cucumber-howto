Feature: Classic Math #3 : division

  As we have to be sure that a computer is able to execute all
  mathematical operations, a verification test must be set.


  Scenario: Calculate a simple DIVISION (i.e. share cucumbers with 2 friends)
    Given I start with 4 cucumbers
    When I share the cucumber(s) with 2 friends
    Then I have 2 cucumbers


  Scenario Outline: Calculate more DIVISIONS (i.e. sharing cucumbers with friends)

  NB: that this scenario must check both exact and inexact division

    Given I start with an <initial amount> of cucumbers
    When I share the cucumber(s) with <number of friends> friends
    Then Each of us has a <final amount> of cucumber(s)

    Examples:
      | initial amount | number of friends | final amount |
      | 4              | 2                 | 2            |
      | 6              | 5                 | 1.2          |
      | 9              | 3                 | 3.0          |
