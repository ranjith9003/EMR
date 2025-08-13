Feature: PracticeFusion order creation

  @practicefusion
  Scenario: PractiseFusion order creation with valid login credentials
    Given Launch the practice fusion url
    When enter the username and password in practicefusion
    And click on the login button in practice fusion
    And click on the charts
    And click on the add patients
    And he user enters the first name
    And the user enters the last name
    And the user enters the gender
    And the user enters the DOB
    And click on the mobile number
    And click on the email id
    And the user enters the address
    And the user enters the zipcode
    And the user enters the save button
    And click on the action button
    And click on add lab order
    And click on the Vendor for order
    And click on the particular dlw order
    When I select the following tests for order:
      | DLW_CMP - Comprehensive Metabolic Panel |
      | DLW_TSH - TSH                           |
      | DLW_CBCwDiff - CBC w Diff               |
      | DLW_Vitamin D - Vitamin D               |
    And select the diagnoses
    And click the order summary
    And click on the ordering provider
    And click on the primary ordering provider
    And click on send
    Then extracting the EMR from that page after placing the order

  @practicefusion @case
  Scenario: EMR create accession
    Given the user is on the login page for emr order
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully for creating case
        And the user selects the lab
    When click on the EMR order
    And validate whether the same EMR is reflected or not
    And click on the view button in the grid
    And I validate the first name
    And I validate the last name
    And I validate the date of birth
    And I validate the gender
    And I validate the mobile number
    And I validate the address
    And I validate the ZIP code
   # And validate whether I can able to get all the testnames or not
    And click on the edit button in EMR order
    And the user enters mobile number
    And the user enters the  collection date
    And the user enters the  received date
    And click on save accession in EMR
    And get the accession id after the order is converted into case in EMR
    
   Scenario: File generation of clinical chemistry
    When click on the view button in the grid
    
   

