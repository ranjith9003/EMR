@smoke
Feature: Order creation functionality with mandatory fields

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without First name
    Given the user is on the login page of DLW
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully
    When the user click the add new order
    And the user enters the patient's last name
    And the user selects gender
    And the user enters date of birth
    And the user enters mobile number
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without last name
    Given the user is on the login page of DLW
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully
    When the user click the add new order
    When the user enters the patient's first name
    And the user selects gender
    And the user enters date of birth
    And the user enters mobile number
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for last name

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without gender
    Given the user is on the login page of DLW
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully
    When the user click the add new order
    When the user enters the patient's first name
    And the user enters the patient's last name
    And the user enters date of birth
    And the user enters mobile number
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for gender

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without DOB
    Given the user is on the login page of DLW
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully
    When the user click the add new order
    When the user enters the patient's first name
    And the user enters the patient's last name
    And the user selects gender
    And the user enters mobile number
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for date of birth

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without mobile number
    Given the user is on the login page of DLW
    When the user enters username
    And the user enters password
    And clicks the login button
    Then the user should be logged in successfully
    When the user click the add new order
    When the user enters the patient's first name
    And the user enters the patient's last name
    And the user selects gender
    And the user enters date of birth
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for mobile number

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without address
    Given the user is on the login page of DLW
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
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for address

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without zip code
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    Then the patient should be registered successfully
    When the user searches and selects the required test
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for zip code

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without case type
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for case type

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without order date
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for order date

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without ordering facillity
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for ordering facility

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without ordering physcician
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user searches and selects the required test
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for ordering pysician

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without bill to
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered
    When the user searches and selects the required test
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for billing method

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without ICD
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user searches and selects the required test
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the collection date and time
    Then the case information should be saved successfully
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for ICD-10

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without specimen type
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user searches and selects the required test
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    And the user clicks the add test button for covidflu
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for specimen types

  # @covidflu @CovidFluvalidations
  #Scenario: Order Creation
  #Given the user is on the login page of DLW
  #When the user enters username
  #And the user enters password
  #And clicks the login button
  #Then the user should be logged in successfully
  #When the user click the add new order
  #When the user enters the patient's first name
  #And the user enters the patient's last name
  #And the user selects gender
  #And the user enters date of birth
  #And the user enters mobile number
  #And the user enters address line 1 in order creation
  #And the user enters zip code
  #Then the patient should be registered successfully
  #When the user selects the UTI case type for cases
  #And the user enters the order date
  #And the user selects the ordering facility
  #And the user selects the ordering physician
  #And the user selects the billing method
  #And the user enters the ICD-10 code in case
  #And the user selects the specimen types
  #Then the case information should be saved successfully
  #When the user searches and selects the UTI test Without Std
  #And the user clicks the add test button to add
  #When the user opens the patient signature section
  #And the user uploads or draws the patient signature
  #And the user confirms and saves the signature
  #When the user selects the relationship
  #And the user enters insurance name
  #And the user enters policy number
  #And the new case information should be saved successfully
  #Then verify whether we are receiving error message or not for collection date and time
  @covidflu @CovidFluvalidations
  Scenario: Order Creation without test info
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for panel

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without Add test
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user searches and selects the required test
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    And the new case information should be saved successfully
    Then verify whether we are receiving error message or not for add test

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without relationship
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    And the user enters insurance name
    And the user enters policy number
    And the new case information should be saved successfully
    And verify whether user receiving error message or not for relationship

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without insurance name
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters policy number
    And the new case information should be saved successfully
    And verify whether user receiving error message or not for insurance name

  @covidflu @CovidFluvalidations
  Scenario: Order Creation without policynumber
    Given the user is on the login page of DLW
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
    And the user enters address line 1 in order creation
    And the user enters zip code
    Then the patient should be registered successfully
    When the user selects the case type as covidflu
    And the user enters the order date
    And the user selects the ordering facility
    And the user selects the ordering physician
    And the user selects the billing method
    And the user enters the ICD-10 code
    And the user enters the collection date and time
    Then the case information should be saved successfully
    When the user searches and selects the required test
    And the user clicks the add test button for covidflu
    When the user opens the patient signature section
    And the user uploads or draws the patient signature
    And the user confirms and saves the signature
    When the user selects the relationship
    And the user enters insurance name
    And the new case information should be saved successfully
    And verify whether user receiving error message or not for policy number
