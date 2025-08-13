package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {
    private WebDriver driver; // Used only for PageFactory

    // Login Elements
    @FindBy(xpath = "//input[@placeholder='Enter Username']")
    public WebElement username;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='el-button el-button--primary login-btn']")
    public WebElement login_btn;

    @FindBy(xpath = "//button[@class='el-button el-button--default nav-btn']")
    public WebElement newcase_button;

    @FindBy(xpath = "//a[text()=' PROCESSING ']")
    public WebElement process_filter;

    @FindBy(xpath = "//input[@placeholder='Select Search']")
    public WebElement filter_search;

    @FindBy(xpath = "//span[text()='Ordering Facility']")
    public WebElement ord_facil;

    @FindBy(xpath = "//input[@placeholder='Select Ordering Facility']")
    public WebElement ord_facility;

    @FindBy(xpath = "//span[text()='{ordering_facility}']")
    public WebElement ordering_selection;

    @FindBy(xpath = "//a[text()=' ACTIVE ']")
    public WebElement active_tab;

    @FindBy(xpath = "//div[contains(@class, 'el-loading-mask')]")
    public WebElement loading_mask;

    @FindBy(xpath = "//*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr")
    public WebElement table_row_count;

    @FindBy(xpath = "//*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr[1]/td[13]/div/ul/li[4]/button")
    public WebElement move_validation_button;

    @FindBy(xpath = "//span[@id='accession-id']")
    public WebElement accession_id;

    @FindBy(xpath = "//textarea[@placeholder='Enter reason']")
    public WebElement reason_textarea;

    @FindBy(xpath = "//button[@class='el-button el-button--default blue-save-button']")
    public WebElement save_button;
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement save_urinalysis;
    @FindBy(xpath = "//span[text()='Urinalysis reflex to UTI with STD']")
    public WebElement Urinalysis_reflex_to_UTI_with_STD;
    
    @FindBy(xpath = "//span[text()='Urinalysis']")
    public WebElement Urinalysis;
    @FindBy(xpath = "//span[text()='GENERATE REPORT']")
    public WebElement generate_report_urinalysis;

    @FindBy(xpath = "//input[@placeholder='Enter First Name']")
    public WebElement first_name_input;

    @FindBy(xpath = "//input[@placeholder='Enter Middle Name']")
    public WebElement middle_name_input;

    @FindBy(xpath = "//input[@placeholder='Enter Last Name']")
    public WebElement last_name_input;

    @FindBy(xpath = "//input[@placeholder='Gender']")
    public WebElement gender_dropdown;

    @FindBy(xpath = "//span[text()='MALE']")
    public WebElement gender_input;

    @FindBy(xpath = "//input[@placeholder='MM']")
    public WebElement dob_mm_input;

    @FindBy(xpath = "//input[@placeholder='DD']")
    public WebElement dob_dd_input;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
    public WebElement dob_yyyy_input;

    @FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
    public WebElement mobile_number_input;

    @FindBy(xpath = "//input[@placeholder='Enter Address Line 1s']")
    public WebElement address_line_1_input;
    @FindBy(xpath = "//input[@placeholder='Enter Address Line 1']")
    public WebElement address_line_1;

    @FindBy(xpath = "//input[@placeholder='Enter Zip']")
    public WebElement zip_code_input;

    @FindBy(xpath = "//input[@class='el-select__input']")
    public WebElement case_type;

    @FindBy(xpath = "//li[@class='el-select-dropdown__item' and span[text()='Covid']]")
    public WebElement particular_case_type;
    @FindBy(xpath = "//li[@class='el-select-dropdown__item' and span[text()='Clinical Chemistry']]")
    public WebElement particular_case_type_clinicalchemistry;

    @FindBy(xpath = "//li[@class='el-select-dropdown__item' and span[text()='Urinalysis']]")
    public WebElement particular_case_type_urinalysis;
   // Urinalysis reflex to UTI without STD
    @FindBy(xpath = "//li[@class='el-select-dropdown__item' and span[text()='UTI']]")
    public WebElement particular_case_type_UTI;
    @FindBy(xpath = "//span[text()='Urinalysis reflex to UTI without STD']")
    public WebElement Urinalysis_reflex_to_UTI_without_STD;
    @FindBy(xpath = "//li[@class='el-select-dropdown__item' and span[text()='Covid and Flu']]")
    public WebElement particular_case_type_Flu;
  //div[2]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/i[1]/*[name()='svg'][1]
    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/i[1]")
    public WebElement antibiotics_icon;
    @FindBy(xpath = "//body")
    public WebElement close_calender;

    @FindBy(xpath = "//div[@class='el-input']//input[@placeholder='Enter Address Line 1']")
    public WebElement address_line;

    @FindBy(xpath = "(//input[@class='el-input__inner' and contains(@placeholder, 'MM-DD-YYYY HH:MM AM')])[1]")
    public WebElement collection_date_input;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement received_date_input;

    @FindBy(xpath = "//body")
    public WebElement body_element;

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")//input[@class="el-input__inner" and contains(@placeholder, "MM-DD-YYYY HH:MM AM")][1]
    public WebElement order_date_input;

    @FindBy(xpath = "//ul[contains(@class,'el-select-dropdown__list')]/li/span[contains(text(),'${FACILITY_NAME}')]")
    public WebElement particular_facility;

    @FindBy(xpath = "//input[@placeholder='Select Ordering Physician']")
    public WebElement ordering_physician_dropdown;

    @FindBy(xpath = "//span[text()='${PHYSICIAN_NAME}']")
    public WebElement particular_physician;

    @FindBy(xpath = "//input[@placeholder='Select Bill To']")
    public WebElement billing;

    @FindBy(xpath = "//span[text()='INSURANCE']")
    public WebElement particular_billing;

    @FindBy(xpath = "//*[@id='app']/div/section/div/div/main/div/section/div/div[2]/div/div/div/div[2]/div/form/div/div[9]/div/div/div/div[2]/div[1]/div/div/input")
    public WebElement icd_code_input;
  //*[@id='app']/div/section/div/div/main/div/section/div/div[2]/div/div//div/div/div/div[2]/div[1]/div/div/input
    @FindBy(xpath = "//input[@placeholder='Select Result Type']")
    public WebElement ATILA_UTI_input;
    @FindBy(xpath = "//span[text()='ATILA UTI']")
    public WebElement ATILA_UTI_click;
  //input[@placeholder="ATILA UTI"]
    @FindBy(xpath = "//span[text()='GENEPATH UTI']")
    public WebElement Genepath_UTI_input;
    @FindBy(xpath = "//div[1]/div[2]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
    public WebElement icd_code_select;
    @FindBy(xpath = "//span[text()='COVID 19']")
    public WebElement covid_text;
    @FindBy(xpath = "//span[text()=' ADD TESTS ']")
    public WebElement add_test_button;
  //span[text()=' Add Test ']
    @FindBy(xpath = "//span[text()=' Add Test']")
    public WebElement add_test_button_new;
    @FindBy(xpath = "//button[@class='el-button el-button--text btn radius-button add-test-btn']")
    public WebElement add_test;

    @FindBy(xpath = "//label[@class='el-checkbox el-collapse-checkbox']")
    public WebElement add_test_checkbox;
    @FindBy(xpath = "//span[text()='Uti With Sti']")
    public WebElement utiWithStd;
    @FindBy(xpath = "//span[text()='Uti Without Sti']")
    public WebElement utiWithoutStd;
    @FindBy(xpath = "//span[text()='UTI Basic Panel']")
    public WebElement UTIBasicPanel;
    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/i[1]")
    public WebElement add_test_checkbox_allTest;
    @FindBy(xpath = "//div[1]/div[1]/section[1]/ul[1]/li[2]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]/span[1]/span[1]")
    public WebElement BMP_all;
    @FindBy(xpath = "//*[@id='app']/div/section/div/div/main/div/section/div/div[4]/div/div/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/button")
    public WebElement covid_checkbox;
  //ul[@class="selected-tests-list"]//li//span
    @FindBy(xpath = "//ul[@class='selected-tests-list']//li//span")
    public WebElement After_select_test_BMP;
  //*[@id="el-collapse-content-6235"]/div[1]/div[2]/div
    @FindBy(xpath = "//*[@id='el-collapse-content-189']/div[1]/div[2]")
    		
    public WebElement Before_select_test_BMP;
    @FindBy(xpath = "//*[text()='Add Patient Signature ']")
    public WebElement add_patient_signature;

    @FindBy(xpath = "//input[@placeholder='Enter Signature']")
    public WebElement enter_signature;

    @FindBy(xpath = "//div[@id='tab-type']")
    public WebElement tab_signature;

    @FindBy(xpath = "//input[@placeholder='Enter Insurance Name']")
    public WebElement insurance_name_input;

    @FindBy(xpath = "//input[@placeholder='Enter Policy No']")
    public WebElement policy_number_input;

    @FindBy(xpath = "//input[@placeholder='Select Relationship']")
    public WebElement relationship_select;

    @FindBy(xpath = "//span[text()='Self']")
    public WebElement self_text;

    @FindBy(xpath = "//input[@placeholder='Select Plan Type']")
    public WebElement select_plan;

    @FindBy(xpath = "//span[text()='INDIVIDUAL']")
    public WebElement particular_plan;

    @FindBy(xpath = "//button[@class='el-button el-button--button btn save-button']")
    public WebElement save;

    @FindBy(xpath = "//button[@class='el-button el-button--default blue-save-button success-button']")
    public WebElement success_next;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/span[2]")
    public WebElement order_id_element;

    @FindBy(xpath = "//span[text()='FAMILY']")
    public WebElement family_plan;

    @FindBy(xpath = "//button[@class='el-button el-button--default icon-btn']")
    public WebElement convert_case_button;

    @FindBy(xpath = "//textarea[@placeholder='Please enter reason to convert ']")
    public WebElement convert_reason_input;

    @FindBy(xpath = "//span[text()='Submit']")
    public WebElement submit_button;

    @FindBy(xpath = "//table[@class='el-table__body']//tbody//tr[1]//td[10]//span[@class='el-tag el-tag--success el-tag--light']")
    public WebElement success_finalize;

    @FindBy(xpath = "//a[text()='All Cases']")
    public WebElement all_cases;

    @FindBy(xpath = "//a[text()='Labsquire Orders']")
    public WebElement labsquire_order;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/span[2]")
    public WebElement order_id;

    @FindBy(xpath = "//button[@class='el-button el-button--button btn save-button']")
    public WebElement save_accession;
    @FindBy(xpath = "//span[text()=' Create Accession']")
    public WebElement save_accession_EMR;
    @FindBy(xpath = "//span[text()=' Create Accession ']")
    public WebElement save_accession_EMR_confirmation;
  
    @FindBy(xpath = "//tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/span[1]")
    public WebElement mark_finalize;

    @FindBy(xpath = "//span[text()=' Convert To Case']")
    public WebElement convert_to_case;

    @FindBy(xpath = "//textarea[@placeholder='Please enter reason to convert ']")
    public WebElement reason_for_convert;

    @FindBy(xpath = "//span[text()='Submit']")
    public WebElement submit;

    @FindBy(xpath = "//*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr[1]/td[13]/div/ul/li//button[@title='View Case']")
    public WebElement view_case;

    @FindBy(xpath = "//body[1]//div[4]//table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/span[1]")
    public WebElement accession_id_element;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/span[1]")
    public WebElement dashboard;
    
    @FindBy(xpath = "//a[text()=' Result Files']")
    public WebElement result_file;
    @FindBy(xpath = "//span[text()='UPLOAD FILES']")
    public WebElement upload_file;

    @FindBy(xpath = "//input[@placeholder='Select Case Type']")
    public WebElement select_case_type;
  //span[text()='UTI']
    @FindBy(xpath = "//span[text()='Covid']")
    public WebElement file_covid;
    @FindBy(xpath = "//span[text()='UTI']")
    public WebElement file_UTI;
    @FindBy(xpath = "//div[@class='el-upload-text-align']")
    public WebElement upload_click;

    @FindBy(xpath = "//button[@class='el-button el-button--default result-upload-btn']")
    public WebElement upload_button;

    @FindBy(xpath = "//div[3]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[1]/div[1]/button[1]/span[1]")
    public WebElement generate_report;
    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[1]/button[1]/span[1]")
    public WebElement view_processing;
    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[15]/div[1]/ul[1]/li[1]/button")
    public WebElement view_case_new;
    @FindBy(xpath = "//table[@class='el-table__body']//tbody//tr[1]//td[10]//span[@class='el-tag el-tag--warning el-tag--light']")
    public WebElement processing_text;
    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[14]/div[1]/div[1]/span[1]")
    public WebElement order_id_table;
  
    @FindBy(xpath = "//div[@id='tab-urinalysis']//span[@class='el-checkbox__inner']")
    public WebElement Urinalysis_tab;
  //span[text()='Uti Without Std - Atila']
    @FindBy(xpath = "//span[text()='Uti Without Std - Atila']")
    public WebElement uti_without_std_atila;
    @FindBy(xpath = "//span[text()='Covid and Flu']")
    public WebElement covidfFlu_file;
    @FindBy(xpath = "//div[@class='add-test-button']//button")
    public WebElement urinalysis_click;

    @FindBy(xpath = "//span[text()='Start Resulting']")
    public WebElement start_resulting;

    @FindBy(xpath = "//input[@placeholder='Enter value']")
    public List<WebElement> allInputs;

    @FindBy(xpath = "//span[@class='custom-select-capitalize']//div[@class='el-select__tags']")
    public WebElement specimen_types;

    @FindBy(xpath = "//span[text()='Urine']")
    public WebElement particular_specimen_type;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[2]/input[@placeholder='Select']")
    public WebElement select_panels;

    @FindBy(xpath = "//span[text()='UTI WITH STD']")
    public WebElement particular_select_panel;

    @FindBy(xpath = "//li[@class='el-select-dropdown__item' and span[text()='Toxicology']]")
    public WebElement particular_case_type_Toxicology;

    @FindBy(xpath = "(//input[@class='el-select__input'])[2]")
    public WebElement specimen_types_Toxicology;

    @FindBy(xpath = "//span[text()='Urine']")
    public WebElement particular_specimen_types_Tox;

    @FindBy(xpath = "//label[1]//span[1]//span[1]")
    public WebElement add_test_toxicology;

    @FindBy(xpath = "(//label[@class='el-checkbox position-relative-top-3'])[1]")
    public WebElement add_test_confirmation;

    @FindBy(xpath = "//span[text()=' Add Test ']")
    public WebElement add_test_save;

    @FindBy(xpath = "//input[@placeholder='Search Medication']")
    public WebElement search_medication;

    @FindBy(xpath = "//span[normalize-space()='${MEDICATION}']")
    public WebElement particular_medicine;

    @FindBy(xpath = "//span[text()='+ ADD']")
    public WebElement add_medicine;

    @FindBy(xpath = "//span[text()='Toxicology']")
    public WebElement file_Toxi;

    @FindBy(xpath = "//input[@placeholder='Select Result Type']")
    public WebElement result_type;

    @FindBy(xpath = "//span[text()='CONFIRMATION']")
    public WebElement particular_result_type;

    @FindBy(xpath = "//div[3]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[1]/button[1]/span[1]")
    public WebElement generate_report_Toxicology;

    @FindBy(xpath = "//span[@class='el-checkbox__inner']")
    public WebElement specific_ID;

    @FindBy(xpath = "(//span[text()='First Name is Required!'])[2]")
    public WebElement first_name_error;

    @FindBy(xpath = "(//span[text()='Last Name is Required!'])[2]")
    public WebElement Last_name_error;

    @FindBy(xpath = "(//p[text()='Date of Birth is Required!'])[2]")
    public WebElement DOB_Month_error;
    @FindBy(xpath = "//div[@class='el-notification__content']//p") public WebElement success_message;
    @FindBy(xpath = "(//p[text()='Date of Birth is Required!'])[2]")
    public WebElement DOB_Date_error;

    @FindBy(xpath = "(//p[text()='Date of Birth is Required!'])[2]")
    public WebElement DOB_Year_error;

    @FindBy(xpath = "(//span[text()='Gender is Required!'])[2]")
    public WebElement gender_error;

    @FindBy(xpath = "//span[text()='Mobile Number is Required!']")
    public WebElement Mobile_number_error;

    @FindBy(xpath = "//span[text()='Policy Number is Required!']")
    public WebElement Policy_number_error;
  
    @FindBy(xpath = "//span[text()='Address Line 1 is Required!']")
    public WebElement address_error;
    @FindBy(xpath = "//span[text()='Testing ordering facility']")
    public WebElement testing_ordering_facility;
  //span[text()='${ORDERING_FACILITY_INPUT}']
    @FindBy(xpath = "//span[normalize-space()='Secondary Insurance']")
    public WebElement secondary_insurance;
    @FindBy(xpath = "//span[normalize-space()='Tertiary Insurance']")
    public WebElement Tertiary_insurance;
    @FindBy(xpath = "//span[normalize-space()='Guarantor']")
    public WebElement guarantor_insurance;

    @FindBy(xpath = "//span[text()='Zip Code is Required!']")
    public WebElement zipcode_error;
    @FindBy(xpath = "//*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr")
    public List<WebElement> all_case_rows;
    
  
 //button[@id='loginButton']
    // First row in the case listing
    @FindBy(xpath = "//*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr[1]")
    public WebElement firstCaseRow;

    // Loading mask overlay
    @FindBy(xpath = "//*[@class='el-loading-mask']")
    public WebElement loadingOverlay;

    // "Move to Validation" button for the first row
    @FindBy(xpath = "//*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr[1]/td[13]/div/ul/li[3]/button")
    public WebElement moveToValidationBtnFirstRow;

    // Accession ID text (assuming it’s within name-accession class)
    @FindBy(xpath = "//div[@class='name-accession']")
    public WebElement accessionIdText;

    // Reason textarea
    @FindBy(xpath = "//textarea[@placeholder='Enter reason']")
    public WebElement reasonTextarea;

    // Save button
    @FindBy(xpath = "//button[@class='el-button el-button--default blue-save-button']")
    public WebElement saveButton;
    @FindBy(xpath = "//span[text()='Case Types is Required!']")
    public WebElement case_type_error;
    @FindBy(xpath = "//span[text()='Sample Types are Required!']")
    public WebElement specimen_type_error;
    
    @FindBy(xpath = "//span[text()='Invalid Ordering Date']")
    public WebElement Order_date_error;
    @FindBy(xpath = "//span[text()='Tests Info is Required!']")
    public WebElement Test_info_error;
    
    @FindBy(xpath = "//span[text()='Relationship is Required!']")
    public WebElement relationship_error;
    @FindBy(xpath = "//span[text()='Insurance Carrier Code is Required!']")
    public WebElement insurance_carrier_code_error;
    @FindBy(xpath = "//span[text()='Ordering Facility is Required!']")
    public WebElement Ordering_facility__error;

    @FindBy(xpath = "//span[text()='Ordering Physician is Required!']")
    public WebElement ordering_physician_error;

    @FindBy(xpath = "//span[text()='Billing Type is Required!']")
    public WebElement bill_to_error;

    @FindBy(xpath = "//span[text()='ICD 10 Codes is Required!']")
    public WebElement ICD_error;

    @FindBy(xpath = "//span[text()='Collection Date is Required!']")
    public WebElement collection_date_error;
  //*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr[1]
  //*[@id='all-cases-listings']/div/div[5]/div[2]/table/tbody/tr[1]/td[13]/div/ul/li[3]/button
    @FindBy(xpath = "(//button[@class='el-button el-button--default el-button--mini is-plain el-picker-panel__link-btn'])[1]") public WebElement collection_date_select;
    @FindBy(xpath = " //span[text()=' Confirm ']") public WebElement Confirm;
    @FindBy(xpath = "(//span[@class='el-select__tags-text'])[1]") public WebElement caseType;
  
    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/span[1]") public WebElement accession_id_table;
  //span[text()='Create Accession']
    @FindBy(xpath = "//span[text()='Create Accession']") public WebElement create_accession;
    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/span[1]") public WebElement accession_ID_DLW;
  //div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/span[1]
    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/span[1]") public WebElement accession_ID_DLW_2;

    
    //PractiseFusion Elements
    @FindBy(xpath = "//input[@id='inputUsername']")
    public WebElement practiceFusion_username;
   @FindBy(xpath = "//input[@id='inputPswd']")
   public WebElement practiceFusion_password;
   @FindBy(xpath = "//button[@id='loginButton']")
   public WebElement practiceFusion_loginButton;
 //a[@id='ember46']//div[@class='menu-icon']
   @FindBy(xpath = "//a[@id='ember46']//div[@class='menu-icon']")
   public WebElement practiceFusion_charts;
   
   @FindBy(xpath = "//button[normalize-space()='Add patient']")
   public WebElement practiceFusion_addpatient;
   
   @FindBy(xpath = "//input[@data-element='first-name']")
   public WebElement practiceFusion_first_name;
   
   @FindBy(xpath = "//input[@data-element='last-name']")
   public WebElement practiceFusion_Last_name;
   
   @FindBy(xpath = "//label[text()='Male'][1]")
   public WebElement practiceFusion_male;
   
   @FindBy(xpath = "//label[text()='Female'][1]")
   public WebElement practiceFusion_female;

   @FindBy(xpath = "//input[@data-element='birth-date-input']")
   public WebElement practiceFusion_dob;
   
   @FindBy(xpath = "//input[@data-element='email-address']")
   public WebElement practiceFusion_email;
  
   @FindBy(xpath = "//input[@data-element='address-1']")
   public WebElement practiceFusion_address;
   
   @FindBy(xpath = "//input[@data-element='zipcode']")
   public WebElement practiceFusion_zipcode;
   
   @FindBy(xpath = "//input[@data-element='mobile-phone']")
   public WebElement practiceFusion_mobile_number;
 
   @FindBy(xpath = "//button[@data-element='btn-save-profile']")
   public WebElement practiceFusion_save_button;
 
   @FindBy(xpath = "//span[text()='Actions']")
   public WebElement practiceFusion_Actions;
 
   @FindBy(xpath = "//div[normalize-space()='Add lab order']")
   public WebElement practiceFusion_add_lab_order;
   
   @FindBy(xpath = "//button[@data-element='lab-select-dropdown']")
   public WebElement practiceFusion_lab_select_dropdown;
   
   @FindBy(xpath = "//div[normalize-space()='Add lab order']")
   public WebElement practiceFusion_vendor_dlw;
   
   @FindBy(xpath = "//input[@aria-label='Search for a test']")
   public WebElement practiceFusion_tests;

   @FindBy(xpath = "//a[text()='EMR Orders']")
   public WebElement EMR_Orders;
 
   @FindBy(xpath = "//div[1]/div[1]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[14]/div[1]/ul[1]/li[1]/button[@title='View EMR']")
   public WebElement view_EMR;
 //div[1]/div[1]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[14]/div[1]/ul[1]/li[1]/button[@title='View EMR']
   @FindBy(xpath = "//a[@data-element='patient-header-tab-Profile']")
   public WebElement Profile;
   @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]")
   public WebElement EMR_ID;
   @FindBy(xpath = "//h4[normalize-space()='First Name']/following-sibling::p")
   public WebElement value_FIRST_NAME;

   @FindBy(xpath = "//h4[normalize-space()='Last Name']/following-sibling::p")
   public WebElement value_LAST_NAME;

   @FindBy(xpath = "//h4[normalize-space()='Date of Birth']/following-sibling::p")
   public WebElement value_DOB;

   @FindBy(xpath = "//h4[normalize-space()='Gender']/following-sibling::p")
   public WebElement value_GENDER;

   @FindBy(xpath = "//h4[normalize-space()='Mobile Number']/following-sibling::p")
   public WebElement value_MOBILE;

   @FindBy(xpath = "//h4[normalize-space()='Address Line 1']/following-sibling::p")
   public WebElement value_ADDRESS;

   @FindBy(xpath = "//h4[normalize-space()='Zip']/following-sibling::p")
   public WebElement value_ZIP;

 
   
   @FindBy(xpath = "//span[@class='edit-icon']")
   public WebElement Edit_EMR;
 
   
   @FindBy(xpath = "//input[@placeholder='Select Lab']")
   public WebElement select_lab_input;
 
   @FindBy(xpath = "//ul[@class='el-scrollbar__view el-select-dropdown__list']//li//span[text()='DLW - Irving'][1]")
   public WebElement particular_lab;
       @FindBy(xpath = "//a[text()='DLW_D-Dimer - D-Dimer']")
       public WebElement practiceFusion_DLW_DDimer;

       @FindBy(xpath = "//a[text()='DLW_DHEA-S - DHEA-S']")
       public WebElement practiceFusion_DLW_DHEAS;

       @FindBy(xpath = "//a[text()='DLW_Digoxin - Digoxin']")
       public WebElement practiceFusion_DLW_Digoxin;

       @FindBy(xpath = "//a[text()='DLW_Direct Renin - Direct Renin']")
       public WebElement practiceFusion_DLW_DirectRenin;

       @FindBy(xpath = "//a[text()='DLW_LDH - LDH']")
       public WebElement practiceFusion_DLW_LDH;

       @FindBy(xpath = "//a[text()='DLW_Aldosterone - Aldosterone']")
       public WebElement practiceFusion_DLW_Aldosterone;

       @FindBy(xpath = "//a[text()='DLW_Sodium - Sodium']")
       public WebElement practiceFusion_DLW_Sodium;

       @FindBy(xpath = "//a[text()='DLW_Cardiac Markers - Cardiac Markers']")
       public WebElement practiceFusion_DLW_CardiacMarkers;

       @FindBy(xpath = "//a[text()='DLW_Lipid Panel - Lipid Panel']")
       public WebElement practiceFusion_DLW_LipidPanel;

       @FindBy(xpath = "//a[text()='DLW_9017 Diabetes Profile - 9017 Diabetes Profile']")
       public WebElement practiceFusion_DLW_9017DiabetesProfile;

       @FindBy(xpath = "//a[text()='DLW_Estradiol - Estradiol']")
       public WebElement practiceFusion_DLW_Estradiol;

       @FindBy(xpath = "//a[text()='DLW_CBCwDiff - CBC w Diff']")
       public WebElement practiceFusion_DLW_CBCwDiff;

       @FindBy(xpath = "//a[text()='DLW_Chloride - Chloride']")
       public WebElement practiceFusion_DLW_Chloride;

       @FindBy(xpath = "//a[text()='DLW_C-Peptide - C-Peptide']")
       public WebElement practiceFusion_DLW_CPeptide;

       @FindBy(xpath = "//a[text()='dlw_Iron and TIBC - Iron and TIBC']")
       public WebElement practiceFusion_dlw_IronAndTIBC; // Corrected to dlw_

       @FindBy(xpath = "//a[text()='DLW_CAR - PGX- CARDIAC PANEL']")
       public WebElement practiceFusion_DLW_CAR_PGX_CARDIACPANEL;

       @FindBy(xpath = "//a[text()='DLW_TFPSA - Total and Free PSA']")
       public WebElement practiceFusion_DLW_TFPSA_TotalAndFreePSA;

       @FindBy(xpath = "//a[text()='DLW_Uric Acid - Uric Acid']")
       public WebElement practiceFusion_DLW_UricAcid;

       @FindBy(xpath = "//a[text()='DLW_Vitamin D - Vitamin D']")
       public WebElement practiceFusion_DLW_VitaminD;

       @FindBy(xpath = "//a[text()='DLW_Rheumatoid Factor - Rheumatoid Factor']")
       public WebElement practiceFusion_DLW_RheumatoidFactor;

       @FindBy(xpath = "//a[text()='DLSADP - Tox-Anti Depressants (TCAs)']")
       public WebElement practiceFusion_DLSADP_Tox_AntiDepressantsTCAs;

       @FindBy(xpath = "//a[text()='DLSBNZ - Tox-Benzodiazepine']")
       public WebElement practiceFusion_DLSBNZ_Tox_Benzodiazepine;

       @FindBy(xpath = "//a[text()='DLSMTD - Tox-Methadone']")
       public WebElement practiceFusion_DLSMTD_Tox_Methadone;

       @FindBy(xpath = "//a[text()='DLSOOA - Tox-Opioids and Opiate Analogs']")
       public WebElement practiceFusion_DLSOOA_Tox_OpioidsAndOpiateAnalogs;

       @FindBy(xpath = "//a[text()='DLSOXD - Tox-Oxycodone']")
       public WebElement practiceFusion_DLSOXD_Tox_Oxycodone;

       @FindBy(xpath = "//a[text()='DLSTRM - Tox-Tramadol']")
       public WebElement practiceFusion_DLSTRM_Tox_Tramadol;

       @FindBy(xpath = "//a[text()='DLW_WOUND - PCR - WOUND']")
       public WebElement practiceFusion_DLW_WOUND_PCR_WOUND;

       @FindBy(xpath = "//a[text()='DLSOTD - Tox-Other Drugs']")
       public WebElement practiceFusion_DLSOTD_Tox_OtherDrugs;

       @FindBy(xpath = "//a[text()='DLW_Triglycerides - Triglycerides']")
       public WebElement practiceFusion_DLW_Triglycerides;

       @FindBy(xpath = "//a[text()='DLW_Infectious Disease - Infectious Disease']")
       public WebElement practiceFusion_DLW_InfectiousDisease;

       @FindBy(xpath = "//a[text()='DLW_OBF - Occult Blood, Fecal, Immunoassay']")
       public WebElement practiceFusion_DLW_OBF_OccultBloodFecalImmunoassay;

       @FindBy(xpath = "//a[text()='DLSALK - Tox-Alkaloids']")
       public WebElement practiceFusion_DLSALK_Tox_Alkaloids;

       @FindBy(xpath = "//a[text()='DLSTPD - Tox-Tapentadol']")
       public WebElement practiceFusion_DLSTPD_Tox_Tapentadol;

       @FindBy(xpath = "//a[text()='DLW_Bilirubin - Direct - Bilirubin - Direct']")
       public WebElement practiceFusion_DLW_BilirubinDirect;

       @FindBy(xpath = "//a[text()='DLW_PAAP - PGX- PAIN AND ADDICTION PANEL']")
       public WebElement practiceFusion_DLW_PAAP_PGX_PAINANDADDICTIONPANEL;

       @FindBy(xpath = "//a[text()='DLW_Urine Protein - Protein, Random Urine']")
       public WebElement practiceFusion_DLW_UrineProteinRandomUrine;

       @FindBy(xpath = "//a[text()='DLW_VALPA - ValproicAcid']")
       public WebElement practiceFusion_DLW_VALPA_ValproicAcid;

       @FindBy(xpath = "//a[text()='DLW_UTISD - PCR- UTI w STD']")
       public WebElement practiceFusion_DLW_UTISD_PCR_UTIwSTD;

       @FindBy(xpath = "//a[text()='DLW_UTISTD - PCR- UTI w STD']")
       public WebElement practiceFusion_DLW_UTISTD_PCR_UTIwSTD;

       @FindBy(xpath = "//a[text()='DLSCNN - Tox-Cannabioids, Natural']")
       public WebElement practiceFusion_DLSCNN_Tox_CannabioidsNatural;

       @FindBy(xpath = "//a[text()='DLSMTA - Tox-Methylenedioxy-amphetamines']")
       public WebElement practiceFusion_DLSMTA_Tox_Methylenedioxy_amphetamines;

       @FindBy(xpath = "//a[text()='DLW_FOB - Fecal Occult Blood']")
       public WebElement practiceFusion_DLW_FOB_FecalOccultBlood;

       @FindBy(xpath = "//a[text()='DLW_MAL - Microalbumin, Random Urine']")
       public WebElement practiceFusion_DLW_MAL_MicroalbuminRandomUrine;

       @FindBy(xpath = "//a[text()='DLW_Quantiferon TB Gold - Quantiferon TB Gold']")
       public WebElement practiceFusion_DLW_QuantiferonTBGold;

       @FindBy(xpath = "//a[text()='DLSNOS - Tox-Not Otherwise specified']")
       public WebElement practiceFusion_DLSNOS_Tox_NotOtherwiseSpecified;

       @FindBy(xpath = "//a[text()='DLW_ACTH - ACTH']")
       public WebElement practiceFusion_DLW_ACTH;

       @FindBy(xpath = "//a[text()='DLW_AFP - AFP']")
       public WebElement practiceFusion_DLW_AFP;

       @FindBy(xpath = "//a[text()='DLW_Albumin - Albumin']")
       public WebElement practiceFusion_DLW_Albumin;

       @FindBy(xpath = "//a[text()='DLW_AlkPhos - AlkPhos']")
       public WebElement practiceFusion_DLW_AlkPhos;

       @FindBy(xpath = "//a[text()='DLW_ALT - ALT']")
       public WebElement practiceFusion_DLW_ALT;

       @FindBy(xpath = "//a[text()='DLW_AMH - AMH']")
       public WebElement practiceFusion_DLW_AMH;

       @FindBy(xpath = "//a[text()='DLW_Ammonia - Ammonia']")
       public WebElement practiceFusion_DLW_Ammonia;

       @FindBy(xpath = "//a[text()='DLW_ AT - Amylase- total']")
       public WebElement practiceFusion_DLW_AmylaseTotal;

       @FindBy(xpath = "//a[text()='DLW_Anti-CCP - Anti-CCP']")
       public WebElement practiceFusion_DLW_AntiCCP;

       @FindBy(xpath = "//a[text()='DLW_Anti-HAV - Anti-HAV']")
       public WebElement practiceFusion_DLW_AntiHAV;

       @FindBy(xpath = "//a[text()='DLW_ Anti-HAV IgM - Anti-HAV IgM']")
       public WebElement practiceFusion_DLW_AntiHAVIgM;

       @FindBy(xpath = "//a[text()='DLW_Anti-Hbc - Anti-Hbc']")
       public WebElement practiceFusion_DLW_AntiHbc;

       @FindBy(xpath = "//a[text()='DLW_Anti-HbcIgM - Anti-HbcIgM']")
       public WebElement practiceFusion_DLW_AntiHbcIgM;

       @FindBy(xpath = "//a[text()='DLW_Anti-HBs - Anti-HBs']")
       public WebElement practiceFusion_DLW_AntiHBs;

       @FindBy(xpath = "//a[text()='DLW_Anti-HCV - Anti-HCV']")
       public WebElement practiceFusion_DLW_AntiHCV;

       @FindBy(xpath = "//a[text()='DLW_COV - Anti-SARS-CoV-2']")
       public WebElement practiceFusion_DLW_COV_AntiSARSCoV2;

       @FindBy(xpath = "//a[text()='DLW_COVS - Anti-SARS-CoV-2 S']")
       public WebElement practiceFusion_DLW_COVS_AntiSARSCoV2S;

       @FindBy(xpath = "//a[text()='DLW_Antistreptolysin O - Antistreptolysin O']")
       public WebElement practiceFusion_DLW_AntistreptolysinO;

       @FindBy(xpath = "//a[text()='DLW_Anti-Tg - Anti-Tg']")
       public WebElement practiceFusion_DLW_AntiTg;

       @FindBy(xpath = "//a[text()='DLW_Anti-TPO - Anti-TPO']")
       public WebElement practiceFusion_DLW_AntiTPO;

       @FindBy(xpath = "//a[text()='DLW_Anti-TSHR - Anti-TSHR']")
       public WebElement practiceFusion_DLW_AntiTSHR;

       @FindBy(xpath = "//a[text()='DLW_APO B - APO B']")
       public WebElement practiceFusion_DLW_APOB;

       @FindBy(xpath = "//a[text()='DLW_APOA1 - APOA1']")
       public WebElement practiceFusion_DLW_APOA1;

       @FindBy(xpath = "//a[text()='DLW_PTT - APTT']")
       public WebElement practiceFusion_DLW_APTT;

       @FindBy(xpath = "//a[text()='DLW_AST - AST']")
       public WebElement practiceFusion_DLW_AST;

       @FindBy(xpath = "//a[text()='DLW_Basic Metabolic Panel - Basic Metabolic Panel']")
       public WebElement practiceFusion_DLW_BasicMetabolicPanel;

       @FindBy(xpath = "//a[text()='DLW_BUN - BUN']")
       public WebElement practiceFusion_DLW_BUN;

       @FindBy(xpath = "//a[text()='DLW_C3 - C3']")
       public WebElement practiceFusion_DLW_C3;

       @FindBy(xpath = "//a[text()='DLW_C4 - C4']")
       public WebElement practiceFusion_DLW_C4;

       @FindBy(xpath = "//a[text()='DLW_CA 125 - CA 125']")
       public WebElement practiceFusion_DLW_CA125;

       @FindBy(xpath = "//a[text()='DLW_CA 15-3 - CA 15-3']")
       public WebElement practiceFusion_DLW_CA153;

       @FindBy(xpath = "//a[text()='DLW_CA 19-9 - CA 19-9']")
       public WebElement practiceFusion_DLW_CA199;

       @FindBy(xpath = "//a[text()='DLW_Calcitonin - Calcitonin']")
       public WebElement practiceFusion_DLW_Calcitonin;

       @FindBy(xpath = "//a[text()='DLW_Calcium - Calcium']")
       public WebElement practiceFusion_DLW_Calcium;

       @FindBy(xpath = "//a[text()='DLW_Carcinoembryonic Antigen - Carcinoembryonic Antigen']")
       public WebElement practiceFusion_DLW_CarcinoembryonicAntigen;

       @FindBy(xpath = "//a[text()='DLW_Ceruloplasmin - Ceruloplasmin']")
       public WebElement practiceFusion_DLW_Ceruloplasmin;

       @FindBy(xpath = "//a[text()='DLW_Cholinesterase - Cholinesterase']")
       public WebElement practiceFusion_DLW_Cholinesterase;

       @FindBy(xpath = "//a[text()='DLW_CK - CK']")
       public WebElement practiceFusion_DLW_CK;

       @FindBy(xpath = "//a[text()='DLW_CK-MB - CK-MB']")
       public WebElement practiceFusion_DLW_CKMB;

       @FindBy(xpath = "//a[text()='DLW_CO2 - CO2']")
       public WebElement practiceFusion_DLW_CO2;

       @FindBy(xpath = "//a[text()='DLW_Coagulation Factor VII - Coagulation Factor VII']")
       public WebElement practiceFusion_DLW_CoagulationFactorVII;

       @FindBy(xpath = "//a[text()='DLW_Coagulation Factor VIII - Coagulation Factor VIII']")
       public WebElement practiceFusion_DLW_CoagulationFactorVIII;

       @FindBy(xpath = "//a[text()='DLW_CMP - Comprehensive Metabolic Panel']")
       public WebElement practiceFusion_DLW_CMP_ComprehensiveMetabolicPanel;

       @FindBy(xpath = "//a[text()='DLW_CortisolAM - Cortisol (AM)']")
       public WebElement practiceFusion_DLW_CortisolAM;

       @FindBy(xpath = "//a[text()='DLW_CortisolPM - Cortisol (PM)']")
       public WebElement practiceFusion_DLW_CortisolPM;

       @FindBy(xpath = "//a[text()='DLW_Creatinine - Creatinine']")
       public WebElement practiceFusion_DLW_Creatinine;

       @FindBy(xpath = "//a[text()='DLW_Cyfra21-1 - Cyfra21-1']")
       public WebElement practiceFusion_DLW_Cyfra211;

       @FindBy(xpath = "//a[text()='DLW_Cystatin C - Cystatin C']")
       public WebElement practiceFusion_DLW_CystatinC;

       @FindBy(xpath = "//a[text()='DLW_EA IgG - EA IgG']")
       public WebElement practiceFusion_DLW_EAIgG;

       @FindBy(xpath = "//a[text()='DLW_EBNA IgG - EBNA IgG']")
       public WebElement practiceFusion_DLW_EBNAIgG;

       @FindBy(xpath = "//a[text()='DLW_EBV IgM - EBV IgM']")
       public WebElement practiceFusion_DLW_EBVIgM;

       @FindBy(xpath = "//a[text()='DLW_Electrolyte Panel - Electrolyte Panel']")
       public WebElement practiceFusion_DLW_ElectrolytePanel;

       @FindBy(xpath = "//a[text()='DLW_ESR - ESR']")
       public WebElement practiceFusion_DLW_ESR;

       @FindBy(xpath = "//a[text()='DLW_Ferritin - Ferritin']")
       public WebElement practiceFusion_DLW_Ferritin;

       @FindBy(xpath = "//a[text()='DLW_Fibrinogen - Fibrinogen']")
       public WebElement practiceFusion_DLW_Fibrinogen;

       @FindBy(xpath = "//a[text()='DLW_Folate - Folate']")
       public WebElement practiceFusion_DLW_Folate;

       @FindBy(xpath = "//a[text()='DLW_Free PSA - Free PSA']")
       public WebElement practiceFusion_DLW_FreePSA;

       @FindBy(xpath = "//a[text()='DLW_Free T3 - Free T3']")
       public WebElement practiceFusion_DLW_FreeT3;

       @FindBy(xpath = "//a[text()='DLW_Free T4 - Free T4']")
       public WebElement practiceFusion_DLW_FreeT4;

       @FindBy(xpath = "//a[text()='DLW_Fructosamine - Fructosamine']")
       public WebElement practiceFusion_DLW_Fructosamine;

       @FindBy(xpath = "//a[text()='DLW_FSH - FSH']")
       public WebElement practiceFusion_DLW_FSH;

       @FindBy(xpath = "//a[text()='DLW_GC - General Chemistry']")
       public WebElement practiceFusion_DLW_GC_GeneralChemistry;

       @FindBy(xpath = "//a[text()='DLW_GGT - GGT']")
       public WebElement practiceFusion_DLW_GGT;

       @FindBy(xpath = "//a[text()='DLW_UAGLU - Glucose']")
       public WebElement practiceFusion_DLW_UAGLU_Glucose;

       @FindBy(xpath = "//a[text()='DLW_BreathTest - H. Pylori Breath Test']")
       public WebElement practiceFusion_DLW_BreathTest_HPyloriBreathTest;

       @FindBy(xpath = "//a[text()='DLW_Haptoglobin - Haptoglobin']")
       public WebElement practiceFusion_DLW_Haptoglobin;

       @FindBy(xpath = "//a[text()='DLW_HBsAg - HBsAg']")
       public WebElement practiceFusion_DLW_HBsAg;

       @FindBy(xpath = "//a[text()='DLW_HCG+B - HCG+B']")
       public WebElement practiceFusion_DLW_HCGPlusB;

       @FindBy(xpath = "//a[text()='DLW_Hepatic Panel - Hepatic Panel']")
       public WebElement practiceFusion_DLW_HepaticPanel;

       @FindBy(xpath = "//a[text()='DLW_Hgb A1C - Hgb A1C']")
       public WebElement practiceFusion_DLW_HgbA1C;

       @FindBy(xpath = "//a[text()='DLW_hGH - hGH']")
       public WebElement practiceFusion_DLW_hGH;

       @FindBy(xpath = "//a[text()='DLW_HIV Screen - HIV Screen']")
       public WebElement practiceFusion_DLW_HIVScreen;

       @FindBy(xpath = "//a[text()='DLW_Homocysteine - Homocysteine']")
       public WebElement practiceFusion_DLW_Homocysteine;

       @FindBy(xpath = "//a[text()='DLW_hsCRP - hsCRP']")
       public WebElement practiceFusion_DLW_hsCRP;

       @FindBy(xpath = "//a[text()='DLW_HSV1 - HSV 1 IgG']")
       public WebElement practiceFusion_DLW_HSV1IgG;

       @FindBy(xpath = "//a[text()='DLW_HSV2 - HSV-2 IgG']")
       public WebElement practiceFusion_DLW_HSV2IgG;

       @FindBy(xpath = "//a[text()='DLW_IgA - IgA']")
       public WebElement practiceFusion_DLW_IgA;

       @FindBy(xpath = "//a[text()='DLW_IgE II - IgE II']")
       public WebElement practiceFusion_DLW_IgEII;

       @FindBy(xpath = "//a[text()='DLW_IgG - IgG']")
       public WebElement practiceFusion_DLW_IgG;

       @FindBy(xpath = "//a[text()='DLW_IgM - IgM']")
       public WebElement practiceFusion_DLW_IgM;

       @FindBy(xpath = "//a[text()='DLW_Insulin - Insulin']")
       public WebElement practiceFusion_DLW_Insulin;

       @FindBy(xpath = "//a[text()='DLW_Lactate - Lactate']")
       public WebElement practiceFusion_DLW_Lactate;

       @FindBy(xpath = "//a[text()='DLW_Levetiracetam - Levetiracetam']")
       public WebElement practiceFusion_DLW_Levetiracetam;

       @FindBy(xpath = "//a[text()='DLW_LH - LH']")
       public WebElement practiceFusion_DLW_LH;

       @FindBy(xpath = "//a[text()='DLW_Lipase - Lipase']")
       public WebElement practiceFusion_DLW_Lipase;

       @FindBy(xpath = "//a[text()='DLW_Lipoprotein(a) - Lipoprotein(a)']")
       public WebElement practiceFusion_DLW_LipoproteinA;

       @FindBy(xpath = "//a[text()='DLW_LIT - Lithium']")
       public WebElement practiceFusion_DLW_LIT_Lithium;

       @FindBy(xpath = "//a[text()='DLW_Magnesium - Magnesium']")
       public WebElement practiceFusion_DLW_Magnesium;

       @FindBy(xpath = "//a[text()='DLW_Measles IgG - Measles IgG']")
       public WebElement practiceFusion_DLW_MeaslesIgG;

       @FindBy(xpath = "//a[text()='DLW_Mumps IgG - Mumps IgG']")
       public WebElement practiceFusion_DLW_MumpsIgG;

       @FindBy(xpath = "//a[text()='DLW_Myoglobin - Myoglobin']")
       public WebElement practiceFusion_DLW_Myoglobin;

       @FindBy(xpath = "//a[text()='DLW_Osteocalcin - Osteocalcin']")
       public WebElement practiceFusion_DLW_Osteocalcin;

       @FindBy(xpath = "//a[text()='DLW_PSMEAR - Pap Smear']")
       public WebElement practiceFusion_DLW_PSMEAR_PapSmear;

       @FindBy(xpath = "//a[text()='DLW_Pap Smear w/HPV - Pap Smear w/HPV']")
       public WebElement practiceFusion_DLW_PapSmearWHPV;

       @FindBy(xpath = "//a[text()='DLW_UTID - PCR- UTI PANEL']")
       public WebElement practiceFusion_DLW_UTID_PCR_UTIPANEL;

       @FindBy(xpath = "//a[text()='DLW_UTIwoSTI - PCR- UTIw/oSTI']")
       public WebElement practiceFusion_DLW_UTIwoSTI_PCR_UTIwoSTI;

       @FindBy(xpath = "//a[text()='DLW_ABR - PCR_ABR']")
       public WebElement practiceFusion_DLW_ABR_PCR_ABR;

       @FindBy(xpath = "//a[text()='DLW_COMP - PGX- COMPREHENSIVE PANEL']")
       public WebElement practiceFusion_DLW_COMP_PGX_COMPREHENSIVEPANEL;

       @FindBy(xpath = "//a[text()='DLW_OP - PGX- ONCOLOGY PANEL']")
       public WebElement practiceFusion_DLW_OP_PGX_ONCOLOGYPANEL;

       @FindBy(xpath = "//a[text()='DLW_PP - PGX- PSYCHIATRIC PANEL']")
       public WebElement practiceFusion_DLW_PP_PGX_PSYCHIATRICPANEL;

       @FindBy(xpath = "//a[text()='DLW_Phosphorus - Phosphorous']")
       public WebElement practiceFusion_DLW_Phosphorus;

       @FindBy(xpath = "//a[text()='DLW_Potassium - Potassium']")
       public WebElement practiceFusion_DLW_Potassium;

       @FindBy(xpath = "//a[text()='DLW_Prealbumin - Prealbumin']")
       public WebElement practiceFusion_DLW_Prealbumin;

       @FindBy(xpath = "//a[text()='DLW_Procalcitonin - Procalcitonin']")
       public WebElement practiceFusion_DLW_Procalcitonin;

       @FindBy(xpath = "//a[text()='DLW_Progesterone - Progesterone']")
       public WebElement practiceFusion_DLW_Progesterone;

       @FindBy(xpath = "//a[text()='DLW_Prolactin - Prolactin']")
       public WebElement practiceFusion_DLW_Prolactin;

       @FindBy(xpath = "//a[text()='DLW_Protein C - Protein C']")
       public WebElement practiceFusion_DLW_ProteinC;

       @FindBy(xpath = "//a[text()='DLW_PT - PT']")
       public WebElement practiceFusion_DLW_PT;

       @FindBy(xpath = "//a[text()='DLW_PTH - PTH']")
       public WebElement practiceFusion_DLW_PTH;

       @FindBy(xpath = "//a[text()='DLW_RP - Renal Panel']")
       public WebElement practiceFusion_DLW_RP_RenalPanel;

       @FindBy(xpath = "//a[text()='DLW_Retic - Retic']")
       public WebElement practiceFusion_DLW_Retic;

       @FindBy(xpath = "//a[text()='DLW_Ret - Reticulocyte Count']")
       public WebElement practiceFusion_DLW_Ret_ReticulocyteCount;

       @FindBy(xpath = "//a[text()='DLW_RubellaIgG - Rubella IgG']")
       public WebElement practiceFusion_DLW_RubellaIgG;

       @FindBy(xpath = "//a[text()='DLW_RubellaIgM - Rubella IgM']")
       public WebElement practiceFusion_DLW_RubellaIgM;

       @FindBy(xpath = "//a[text()='DLW_SPE - Serum Protein Electrophoresis']")
       public WebElement practiceFusion_DLW_SPE_SerumProteinElectrophoresis;

       @FindBy(xpath = "//a[text()='DLW_SHBG - SHBG']")
       public WebElement practiceFusion_DLW_SHBG;

       @FindBy(xpath = "//a[text()='DLW_Syphilis - Syphilis']")
       public WebElement practiceFusion_DLW_Syphilis;

       @FindBy(xpath = "//a[text()='DLW_Tacrolimus - Tacrolimus']")
       public WebElement practiceFusion_DLW_Tacrolimus;

       @FindBy(xpath = "//a[text()='DLW_Testosterone - Testosterone']")
       public WebElement practiceFusion_DLW_Testosterone;

       @FindBy(xpath = "//a[text()='DLW_Thrombin Time - Thrombin Time']")
       public WebElement practiceFusion_DLW_ThrombinTime;

       @FindBy(xpath = "//a[text()='DLW_ Total Protein - Total Protein']")
       public WebElement practiceFusion_DLW_TotalProtein;

       @FindBy(xpath = "//a[text()='DLW_Total PSA - Total PSA']")
       public WebElement practiceFusion_DLW_TotalPSA;

       @FindBy(xpath = "//a[text()='DLW_Total T3 - Total T3']")
       public WebElement practiceFusion_DLW_TotalT3;

       @FindBy(xpath = "//a[text()='DLW_Total T4 - Total T4']")
       public WebElement practiceFusion_DLW_TotalT4;

       @FindBy(xpath = "//a[text()='DLW_CNT - Tox- Confirmation Test']")
       public WebElement practiceFusion_DLW_CNT_Tox_ConfirmationTest;

       @FindBy(xpath = "//a[text()='DLW_SCR - Tox- Screening']")
       public WebElement practiceFusion_DLW_SCR_Tox_Screening;

       @FindBy(xpath = "//a[text()='DLSAMP - Tox-Amphetamines']")
       public WebElement practiceFusion_DLSAMP_Tox_Amphetamines;

       @FindBy(xpath = "//a[text()='DLSBUP - Tox-Buprenorphine']")
       public WebElement practiceFusion_DLSBUP_Tox_Buprenorphine;

       @FindBy(xpath = "//a[text()='DLSCOC - Tox-Cocaine']")
       public WebElement practiceFusion_DLSCOC_Tox_Cocaine;

       @FindBy(xpath = "//a[text()='DLSFNT - Tox-Fentanyl']")
       public WebElement practiceFusion_DLSFNT_Tox_Fentanyl;

       @FindBy(xpath = "//a[text()='DLSGBP - Tox-Gabapentin']")
       public WebElement practiceFusion_DLSGBP_Tox_Gabapentin;

       @FindBy(xpath = "//a[text()='DLSHMB - Tox-Heroin Metabolite']")
       public WebElement practiceFusion_DLSHMB_Tox_HeroinMetabolite;

       @FindBy(xpath = "//a[text()='DLSHPN - Tox-Hypnotics']")
       public WebElement practiceFusion_DLSHPN_Tox_Hypnotics;

       @FindBy(xpath = "//a[text()='DLW_ToxoIgG - Toxo IgG']")
       public WebElement practiceFusion_DLW_ToxoIgG;

       @FindBy(xpath = "//a[text()='DLW_ToxoIgM - Toxo IgM']")
       public WebElement practiceFusion_DLW_ToxoIgM;

       @FindBy(xpath = "//a[text()='DLSOPT - Tox-Opiates']")
       public WebElement practiceFusion_DLSOPT_Tox_Opiates;

       @FindBy(xpath = "//a[text()='DLSPCP - Tox-PCP']")
       public WebElement practiceFusion_DLSPCP_Tox_PCP;

       @FindBy(xpath = "//a[text()='DLSPGB - Tox-Pregabalin']")
       public WebElement practiceFusion_DLSPGB_Tox_Pregabalin;

       @FindBy(xpath = "//a[text()='DLSPPX - Tox-Propoxyphene']")
       public WebElement practiceFusion_DLSPPX_Tox_Propoxyphene;

       @FindBy(xpath = "//a[text()='DLSSMR - Tox-Skeletal Muscle Relaxants']")
       public WebElement practiceFusion_DLSSMR_Tox_SkeletalMuscleRelaxants;

       @FindBy(xpath = "//a[text()='DLSSTM - Tox-Stimulants']")
       public WebElement practiceFusion_DLSSTM_Tox_Stimulants;

       @FindBy(xpath = "//a[text()='DLW_Transferrin - Transferrin']")
       public WebElement practiceFusion_DLW_Transferrin;

       @FindBy(xpath = "//a[text()='DLW_Troponin T - Troponin T']")
       public WebElement practiceFusion_DLW_TroponinT;

       @FindBy(xpath = "//a[text()='DLW_TSH - TSH']")
       public WebElement practiceFusion_DLW_TSH;

       @FindBy(xpath = "//a[text()='DLW_Tumor Markers - Tumor Markers']")
       public WebElement practiceFusion_DLW_TumorMarkers;

       @FindBy(xpath = "//a[text()='DLW_T-Uptake - T-Uptake']")
       public WebElement practiceFusion_DLW_TUptake;

       @FindBy(xpath = "//a[text()='DLW_Urinalysis - Urinalysis']")
       public WebElement practiceFusion_DLW_Urinalysis;

       @FindBy(xpath = "//a[text()='DLW_VANP - Vancomycin (Peak)']")
       public WebElement practiceFusion_DLW_VANP_VancomycinPeak;

       @FindBy(xpath = "//a[text()='DLW_VANT - Vancomycin (Trough)']")
       public WebElement practiceFusion_DLW_VANT_VancomycinTrough;

       @FindBy(xpath = "//a[text()='DLW_VCA IgG - VCA IgG']")
       public WebElement practiceFusion_DLW_VCAIgG;

       @FindBy(xpath = "//a[text()='DLW_Vitamin B12 - Vitamin B12']")
       public WebElement practiceFusion_DLW_VitaminB12;

       @FindBy(xpath = "//a[text()='DLW_VZV IgG - VZV IgG']")
       public WebElement practiceFusion_DLW_VZV_IgG;
     @FindBy(xpath = "//input[@aria-label='Search to add diagnosis']")
     public WebElement practiceFusion_Diagnoses;
   
  
   @FindBy(xpath = "//p[text()='Prostatic intraepithelial neoplasia']")
   public WebElement practiceFusion_Diagnoses_particular;
   @FindBy(xpath = "//button[@data-element='next-btn']")
   public WebElement practiceFusion_Next;
   @FindBy(xpath = "//button[@data-element='show-item-button-3']")
   public WebElement practiceFusion_order_summary;
  
   @FindBy(xpath = "//button[@data-element='ordering-provider-select-dropdown']")
   public WebElement practiceFusion_ordering_provider;
   @FindBy(xpath = "//a[text()='RACHEL CASTRO']")
   public WebElement practiceFusion_particular_ordering_provider;
   @FindBy(xpath = "//button[@data-element='primary-provider-select-dropdown']")
   public WebElement practiceFusion_primary_ordering_provider;
   @FindBy(xpath = "//a[text()='RACHEL CASTRO']")
   public WebElement practiceFusion_particular_primary_ordering_provider;
   @FindBy(xpath = "//button[@data-element='next-btn']")
   public WebElement practiceFusion_send;
   @FindBy(xpath = "//button[@data-element='next-btn']")
   public WebElement practiceFusion_next_send;
   @FindBy(xpath = "//button[@data-element='print-btn']")
   public WebElement practiceFusion_print_button;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
//   @FindBy(xpath = "")
//   public WebElement practiceFusion_;
 //a[text()='Devansh Lab Werks - HILLSPC']
    // Constructor to initialize PageFactory
    public Locators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
//div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/span[1]