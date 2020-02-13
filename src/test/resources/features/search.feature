Feature: Booking search

  Scenario: Validation of hotels rating
    Given User on the search page
    And Hotel name is "Cosmos"
    When User performs search
    Then "Cosmos Hotel" appears in the search
    And Hotel has rating "7.0"