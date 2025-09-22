@smoke
Feature: Clinical Chemistry casetype End to End flow

   @order
  Scenario: Order Creation
    Given the user is on the login page
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully
    When the user click the add new order
    When the user enters the patient's first name
    And the user enters the patient's last name
    And the user selects gender
    And the user enters date of birth
    And the user enters mobile number
    And the user enters address line 1
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the Clinical chemistry case type for cases
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user selects the specimen types
    And the user enters the collection date and time
    And the user selects the fasting
    Then the case information should be saved successfully
    When the user searches and selects the required test
    Then I select the following panels
      | Food Allergens-30      |
      | Inhalenat Allergens-36 |
    Then the following panels should have correct tests
      | Panel Name             |
      | Food Allergens-30      |
      | Inhalenat Allergens-36 |
    #| Basic Metabolic Panel                  |
    #| Comp Metabolic Panel                   |
    #| Hepatic Profile                        |
    #| Hepatitis                              |
    #| Lipid Panel                            |
    #| Renal Panel                            |
    #| Food Allergens-30                      |
    #| Inhalenat Allergens-36                 |
    When the user clicks the add test button in clinical chemistry
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the billing case information should be saved successfully
    And check if the patient is already enrolled and proceed
    And get the orderID for the corresponding order
