Feature:  amazon search functionality

  Scenario: Positive scenario for Amazon search
    When I navigate to Amazon homepage
    And I search for iphone 13 case
    Then i should get more than 20 results
    And I validate the search result number