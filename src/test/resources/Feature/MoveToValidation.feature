Feature: Bulk Process Cases - Move to Validation
@movetovalidation
  Scenario: Move all cases to validation for a specific Ordering Facility
    Given I launch the Labsquire application
    And I login with username  and password
    When I navigate to the "PROCESSING" section
    And I filter cases by Ordering Facility 
    Then I should see the filtered results containing 
    And I move all cases to validation with reason 
