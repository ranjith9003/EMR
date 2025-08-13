Feature: Case creation functionality with mandatory fields

   
  Scenario: Clinical chemistry case Creation
    Given the user is on the login page of DLW
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully for creating case
    When the user click the add new case
    When the user enters the patient's first name
    And the user enters the patient's last name
    And the user selects gender
    And the user enters date of birth
    And the user enters mobile number
    And the user enters address line 1 in case
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the Clinical chemistry case type for cases
    And the user enters the  collection date
    And the user enters the  received date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code in case
    And the user selects the specimen types
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test for clinical chemistry
    Then validating all the test names are present or not
    When the user clicks the add test button in clinical chemistry
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    And check if the case is already created and proceed
    And get the accession Id from the created case
