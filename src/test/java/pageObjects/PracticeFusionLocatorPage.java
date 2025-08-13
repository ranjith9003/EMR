package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PracticeFusionLocatorPage {
    private final Page page;

    public PracticeFusionLocatorPage(Page page) {
        this.page = page;
    }

    // --- Locators ---
    // Login Page Elements
    public Locator usernameInput() { return page.locator("input#inputUsername"); }
    public Locator passwordInput() { return page.locator("input#inputPswd"); }
    public Locator loginButton() { return page.locator("button#loginButton"); }

    // Dashboard Elements
    public Locator chartsLink() { return page.locator("a[data-tracking='Charts']"); }
    public Locator addPatientButton() { return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add patient")); }

    // Patient Profile Elements
    public Locator firstNameInput() { return page.locator("input[data-element='first-name']"); }
    public Locator lastNameInput() { return page.locator("input[data-element='last-name']"); }
    public Locator maleRadio() { return page.locator("div[data-element='radio-gender-male']"); }
    public Locator femaleRadio() { return page.getByLabel("Female", new Page.GetByLabelOptions().setExact(true)); }
    public Locator dobInput() { return page.locator("input[data-element='birth-date-input']"); }
    public Locator emailInput() { return page.locator("input[data-element='email-address']"); }
    public Locator addressInput() { return page.locator("input[data-element='address-1']"); }
    public Locator zipcodeInput() { return page.locator("input[data-element='zipcode']"); }
    public Locator mobileNumberInput() { return page.locator("input[data-element='mobile-phone']"); }
    public Locator saveButton() { return page.locator("button[data-element='btn-save-profile']"); }

    // Lab Order Elements
    public Locator actionsDropdown() { return page.getByText("Actions", new Page.GetByTextOptions().setExact(true)); }
    public Locator addLabOrderOption() { return page.getByText("Add lab order", new Page.GetByTextOptions().setExact(true)).first(); }
    public Locator labSelectDropdown() { return page.locator("button[data-element='lab-select-dropdown']"); }
    public Locator vendorDlwOption() { return page.getByText("Devansh Lab Werks - HILLSPC", new Page.GetByTextOptions().setExact(true)); } // Specific 'DLW' option within dropdown
    public Locator testsSearchInput() { return page.getByPlaceholder("Search for a test"); }

    // All specific lab test locators (from your js elements.txt)
    public Locator dlwDDimer() { return page.getByText("DLW_D-Dimer - D-Dimer", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCMP() { return page.getByText("DLW_CMP - Comprehensive Metabolic Panel", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwVitaminD() { return page.getByText("DLW_Vitamin D - Vitamin D", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwDHEAS() { return page.getByText("DLW_DHEA-S - DHEA-S", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwDigoxin() { return page.getByText("DLW_Digoxin - Digoxin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwDirectRenin() { return page.getByText("DLW_Direct Renin - Direct Renin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLDH() { return page.getByText("DLW_LDH - LDH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAldosterone() { return page.getByText("DLW_Aldosterone - Aldosterone", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwSodium() { return page.getByText("DLW_Sodium - Sodium", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCardiacMarkers() { return page.getByText("DLW_Cardiac Markers - Cardiac Markers", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLipidPanel() { return page.getByText("DLW_Lipid Panel - Lipid Panel", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlw9017DiabetesProfile() { return page.getByText("DLW_9017 Diabetes Profile - 9017 Diabetes Profile", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwEstradiol() { return page.getByText("DLW_Estradiol - Estradiol", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCBCwDiff() { return page.getByText("DLW_CBCwDiff - CBC w Diff", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwChloride() { return page.getByText("DLW_Chloride - Chloride", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCPeptide() { return page.getByText("DLW_C-Peptide - C-Peptide", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwIronAndTIBC() { return page.getByText("dlw_Iron and TIBC - Iron and TIBC", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCARPGXCARDIACPANEL() { return page.getByText("DLW_CAR - PGX- CARDIAC PANEL", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTFPSATotalAndFreePSA() { return page.getByText("DLW_TFPSA - Total and Free PSA", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUricAcid() { return page.getByText("DLW_Uric Acid - Uric Acid", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwRheumatoidFactor() { return page.getByText("DLW_Rheumatoid Factor - Rheumatoid Factor", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsADPToxAntiDepressantsTCAs() { return page.getByText("DLSADP - Tox-Anti Depressants (TCAs)", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsBNZToxBenzodiazepine() { return page.getByText("DLSBNZ - Tox-Benzodiazepine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsMTDToxMethadone() { return page.getByText("DLSMTD - Tox-Methadone", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsOOAToxOpioidsAndOpiateAnalogs() { return page.getByText("DLSOOA - Tox-Opioids and Opiate Analogs", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsOXDToxOxycodone() { return page.getByText("DLSOXD - Tox-Oxycodone", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsTRMToxTramadol() { return page.getByText("DLSTRM - Tox-Tramadol", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwWOUNDPCRWOUND() { return page.getByText("DLW_WOUND - PCR - WOUND", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsOTDToxOtherDrugs() { return page.getByText("DLSOTD - Tox-Other Drugs", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTriglycerides() { return page.getByText("DLW_Triglycerides - Triglycerides", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwInfectiousDisease() { return page.getByText("DLW_Infectious Disease - Infectious Disease", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwOBFOccultBloodFecalImmunoassay() { return page.getByText("DLW_OBF - Occult Blood, Fecal, Immunoassay", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsALKToxAlkaloids() { return page.getByText("DLSALK - Tox-Alkaloids", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsTPDToxTapentadol() { return page.getByText("DLSTPD - Tox-Tapentadol", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwBilirubinDirect() { return page.getByText("DLW_Bilirubin - Direct - Bilirubin - Direct", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPAAPPGXPAINANDADDICTIONPANEL() { return page.getByText("DLW_PAAP - PGX- PAIN AND ADDICTION PANEL", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUrineProteinRandomUrine() { return page.getByText("DLW_Urine Protein - Protein, Random Urine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwVALPAValproicAcid() { return page.getByText("DLW_VALPA - ValproicAcid", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUTISDPCRUTIwSTD() { return page.getByText("DLW_UTISD - PCR- UTI w STD", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUTISTDPCRUTIwSTD() { return page.getByText("DLW_UTISTD - PCR- UTI w STD", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsCNNToxCannabioidsNatural() { return page.getByText("DLSCNN - Tox-Cannabioids, Natural", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsMTAToxMethylenedioxyAmphetamines() { return page.getByText("DLSMTA - Tox-Methylenedioxy-amphetamines", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFOBFecalOccultBlood() { return page.getByText("DLW_FOB - Fecal Occult Blood", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwMALMicroalbuminRandomUrine() { return page.getByText("DLW_MAL - Microalbumin, Random Urine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwQuantiferonTBGold() { return page.getByText("DLW_Quantiferon TB Gold - Quantiferon TB Gold", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsNOS_ToxNotOtherwiseSpecified() { return page.getByText("DLSNOS - Tox-Not Otherwise specified", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwACTH() { return page.getByText("DLW_ACTH - ACTH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAFP() { return page.getByText("DLW_AFP - AFP", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAlbumin() { return page.getByText("DLW_Albumin - Albumin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAlkPhos() { return page.getByText("DLW_AlkPhos - AlkPhos", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwALT() { return page.getByText("DLW_ALT - ALT", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAMH() { return page.getByText("DLW_AMH - AMH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAmmonia() { return page.getByText("DLW_Ammonia - Ammonia", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAmylaseTotal() { return page.getByText("DLW_ AT - Amylase- total", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiCCP() { return page.getByText("DLW_Anti-CCP - Anti-CCP", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiHAV() { return page.getByText("DLW_Anti-HAV - Anti-HAV", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiHAVIgM() { return page.getByText("DLW_ Anti-HAV IgM - Anti-HAV IgM", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiHbc() { return page.getByText("DLW_Anti-Hbc - Anti-Hbc", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiHbcIgM() { return page.getByText("DLW_Anti-HbcIgM - Anti-HbcIgM", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiHBs() { return page.getByText("DLW_Anti-HBs - Anti-HBs", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiHCV() { return page.getByText("DLW_Anti-HCV - Anti-HCV", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCOVAntiSARSCoV2() { return page.getByText("DLW_COV - Anti-SARS-CoV-2", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCOVS_AntiSARSCoV2S() { return page.getByText("DLW_COVS - Anti-SARS-CoV-2 S", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntistreptolysinO() { return page.getByText("DLW_Antistreptolysin O - Antistreptolysin O", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiTg() { return page.getByText("DLW_Anti-Tg - Anti-Tg", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiTPO() { return page.getByText("DLW_Anti-TPO - Anti-TPO", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAntiTSHR() { return page.getByText("DLW_Anti-TSHR - Anti-TSHR", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAPOB() { return page.getByText("DLW_APO B - APO B", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAPOA1() { return page.getByText("DLW_APOA1 - APOA1", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAPTT() { return page.getByText("DLW_PTT - APTT", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwAST() { return page.getByText("DLW_AST - AST", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwBasicMetabolicPanel() { return page.getByText("DLW_Basic Metabolic Panel - Basic Metabolic Panel", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwBUN() { return page.getByText("DLW_BUN - BUN", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwC3() { return page.getByText("DLW_C3 - C3", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwC4() { return page.getByText("DLW_C4 - C4", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCA125() { return page.getByText("DLW_CA 125 - CA 125", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCA153() { return page.getByText("DLW_CA 15-3 - CA 15-3", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCA199() { return page.getByText("DLW_CA 19-9 - CA 19-9", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCalcitonin() { return page.getByText("DLW_Calcitonin - Calcitonin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCalcium() { return page.getByText("DLW_Calcium - Calcium", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCarcinoembryonicAntigen() { return page.getByText("DLW_Carcinoembryonic Antigen - Carcinoembryonic Antigen", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCeruloplasmin() { return page.getByText("DLW_Ceruloplasmin - Ceruloplasmin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCholinesterase() { return page.getByText("DLW_Cholinesterase - Cholinesterase", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCK() { return page.getByText("DLW_CK - CK", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCKMB() { return page.getByText("DLW_CK-MB - CK-MB", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCO2() { return page.getByText("DLW_CO2 - CO2", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCoagulationFactorVII() { return page.getByText("DLW_Coagulation Factor VII - Coagulation Factor VII", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCoagulationFactorVIII() { return page.getByText("DLW_Coagulation Factor VIII - Coagulation Factor VIII", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCMPComprehensiveMetabolicPanel() { return page.getByText("DLW_CMP - Comprehensive Metabolic Panel", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCortisolAM() { return page.getByText("DLW_CortisolAM - Cortisol (AM)", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCortisolPM() { return page.getByText("DLW_CortisolPM - Cortisol (PM)", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCreatinine() { return page.getByText("DLW_Creatinine - Creatinine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCyfra211() { return page.getByText("DLW_Cyfra21-1 - Cyfra21-1", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCystatinC() { return page.getByText("DLW_Cystatin C - Cystatin C", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwEAIgG() { return page.getByText("DLW_EA IgG - EA IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwEBNAIgG() { return page.getByText("DLW_EBNA IgG - EBNA IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwEBVIgM() { return page.getByText("DLW_EBV IgM - EBV IgM", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwElectrolytePanel() { return page.getByText("DLW_Electrolyte Panel - Electrolyte Panel", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwESR() { return page.getByText("DLW_ESR - ESR", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFerritin() { return page.getByText("DLW_Ferritin - Ferritin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFibrinogen() { return page.getByText("DLW_Fibrinogen - Fibrinogen", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFolate() { return page.getByText("DLW_Folate - Folate", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFreePSA() { return page.getByText("DLW_Free PSA - Free PSA", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFreeT3() { return page.getByText("DLW_Free T3 - Free T3", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFreeT4() { return page.getByText("DLW_Free T4 - Free T4", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFructosamine() { return page.getByText("DLW_Fructosamine - Fructosamine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwFSH() { return page.getByText("DLW_FSH - FSH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwGCGeneralChemistry() { return page.getByText("DLW_GC - General Chemistry", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwGGT() { return page.getByText("DLW_GGT - GGT", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUAGLUGlucose() { return page.getByText("DLW_UAGLU - Glucose", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwBreathTestHPyloriBreathTest() { return page.getByText("DLW_BreathTest - H. Pylori Breath Test", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHaptoglobin() { return page.getByText("DLW_Haptoglobin - Haptoglobin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHBsAg() { return page.getByText("DLW_HBsAg - HBsAg", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHCGPlusB() { return page.getByText("DLW_HCG+B - HCG+B", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHepaticPanel() { return page.getByText("DLW_Hepatic Panel - Hepatic Panel", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHgbA1C() { return page.getByText("DLW_Hgb A1C - Hgb A1C", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwhGH() { return page.getByText("DLW_hGH - hGH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHIVScreen() { return page.getByText("DLW_HIV Screen - HIV Screen", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHomocysteine() { return page.getByText("DLW_Homocysteine - Homocysteine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHsCRP() { return page.getByText("DLW_hsCRP - hsCRP", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHSV1IgG() { return page.getByText("DLW_HSV1 - HSV 1 IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwHSV2IgG() { return page.getByText("DLW_HSV2 - HSV-2 IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwIgA() { return page.getByText("DLW_IgA - IgA", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwIgEII() { return page.getByText("DLW_IgE II - IgE II", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwIgG() { return page.getByText("DLW_IgG - IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwIgM() { return page.getByText("DLW_IgM - IgM", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwInsulin() { return page.getByText("DLW_Insulin - Insulin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLactate() { return page.getByText("DLW_Lactate - Lactate", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLevetiracetam() { return page.getByText("DLW_Levetiracetam - Levetiracetam", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLH() { return page.getByText("DLW_LH - LH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLipase() { return page.getByText("DLW_Lipase - Lipase", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLipoproteinA() { return page.getByText("DLW_Lipoprotein(a) - Lipoprotein(a)", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwLITLithium() { return page.getByText("DLW_LIT - Lithium", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwMagnesium() { return page.getByText("DLW_Magnesium - Magnesium", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwMeaslesIgG() { return page.getByText("DLW_Measles IgG - Measles IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwMumpsIgG() { return page.getByText("DLW_Mumps IgG - Mumps IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwMyoglobin() { return page.getByText("DLW_Myoglobin - Myoglobin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwOsteocalcin() { return page.getByText("DLW_Osteocalcin - Osteocalcin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPSMEARPapSmear() { return page.getByText("DLW_PSMEAR - Pap Smear", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPapSmearWHPV() { return page.getByText("DLW_Pap Smear w/HPV - Pap Smear w/HPV", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUTIDPCRUTIPANEL() { return page.getByText("DLW_UTID - PCR- UTI PANEL", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUTIwoSTIPCRUTIwoSTI() { return page.getByText("DLW_UTIwoSTI - PCR- UTIw/oSTI", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwABRPCRABR() { return page.getByText("DLW_ABR - PCR_ABR", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCOMPPGXCOMPREHENSIVEPANEL() { return page.getByText("DLW_COMP - PGX- COMPREHENSIVE PANEL", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwOPPGXONCOLOGYPANEL() { return page.getByText("DLW_OP - PGX- ONCOLOGY PANEL", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPPPGXPSYCHIATRICPANEL() { return page.getByText("DLW_PP - PGX- PSYCHIATRIC PANEL", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPhosphorus() { return page.getByText("DLW_Phosphorus - Phosphorous", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPotassium() { return page.getByText("DLW_Potassium - Potassium", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPrealbumin() { return page.getByText("DLW_Prealbumin - Prealbumin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwProcalcitonin() { return page.getByText("DLW_Procalcitonin - Procalcitonin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwProgesterone() { return page.getByText("DLW_Progesterone - Progesterone", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwProlactin() { return page.getByText("DLW_Prolactin - Prolactin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwProteinC() { return page.getByText("DLW_Protein C - Protein C", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPT() { return page.getByText("DLW_PT - PT", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwPTH() { return page.getByText("DLW_PTH - PTH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwRPRenalPanel() { return page.getByText("DLW_RP - Renal Panel", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwRetic() { return page.getByText("DLW_Retic - Retic", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwRetReticulocyteCount() { return page.getByText("DLW_Ret - Reticulocyte Count", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwRubellaIgG() { return page.getByText("DLW_RubellaIgG - Rubella IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwRubellaIgM() { return page.getByText("DLW_RubellaIgM - Rubella IgM", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwSPESerumProteinElectrophoresis() { return page.getByText("DLW_SPE - Serum Protein Electrophoresis", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwSHBG() { return page.getByText("DLW_SHBG - SHBG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwSyphilis() { return page.getByText("DLW_Syphilis - Syphilis", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTacrolimus() { return page.getByText("DLW_Tacrolimus - Tacrolimus", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTestosterone() { return page.getByText("DLW_Testosterone - Testosterone", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwThrombinTime() { return page.getByText("DLW_Thrombin Time - Thrombin Time", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTotalProtein() { return page.getByText("DLW_ Total Protein - Total Protein", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTotalPSA() { return page.getByText("DLW_Total PSA - Total PSA", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTotalT3() { return page.getByText("DLW_Total T3 - Total T3", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTotalT4() { return page.getByText("DLW_Total T4 - Total T4", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwCNT_ToxConfirmationTest() { return page.getByText("DLW_CNT - Tox- Confirmation Test", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwSCR_ToxScreening() { return page.getByText("DLW_SCR - Tox- Screening", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsAMPToxAmphetamines() { return page.getByText("DLSAMP - Tox-Amphetamines", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsBUPToxBuprenorphine() { return page.getByText("DLSBUP - Tox-Buprenorphine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsCOCToxCocaine() { return page.getByText("DLSCOC - Tox-Cocaine", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsFNTToxFentanyl() { return page.getByText("DLSFNT - Tox-Fentanyl", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsGBPToxGabapentin() { return page.getByText("DLSGBP - Tox-Gabapentin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlw_HeroinMetabolite() { return page.getByText("DLSHMB - Tox-Heroin Metabolite", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsHPNToxHypnotics() { return page.getByText("DLSHPN - Tox-Hypnotics", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwToxoIgG() { return page.getByText("DLW_ToxoIgG - Toxo IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwToxoIgM() { return page.getByText("DLW_ToxoIgM - Toxo IgM", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsOPToxOpiates() { return page.getByText("DLSOPT - Tox-Opiates", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsPCPToxPCP() { return page.getByText("DLSPCP - Tox-PCP", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsPGBToxPregabalin() { return page.getByText("DLSPGB - Tox-Pregabalin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsPPXToxPropoxyphene() { return page.getByText("DLSPPX - Tox-Propoxyphene", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsSMRToxSkeletalMuscleRelaxants() { return page.getByText("DLSSMR - Tox-Skeletal Muscle Relaxants", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlsSTMToxStimulants() { return page.getByText("DLSSTM - Tox-Stimulants", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTransferrin() { return page.getByText("DLW_Transferrin - Transferrin", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTroponinT() { return page.getByText("DLW_Troponin T - Troponin T", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTSH() { return page.getByText("DLW_TSH - TSH", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTumorMarkers() { return page.getByText("DLW_Tumor Markers - Tumor Markers", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwTUptake() { return page.getByText("DLW_T-Uptake - T-Uptake", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwUrinalysis() { return page.getByText("DLW_Urinalysis - Urinalysis", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwVANP_VancomycinPeak() { return page.getByText("DLW_VANP - Vancomycin (Peak)", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwVANT_VancomycinTrough() { return page.getByText("DLW_VANT - Vancomycin (Trough)", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwVCAIgG() { return page.getByText("DLW_VCA IgG - VCA IgG", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwVitaminB12() { return page.getByText("DLW_Vitamin B12 - Vitamin B12", new Page.GetByTextOptions().setExact(true)); }
    public Locator dlwVZV_IgG() { return page.getByText("DLW_VZV IgG - VZV IgG", new Page.GetByTextOptions().setExact(true)); }

    // Diagnosis Elements
    public Locator diagnosesInput() { return page.getByLabel("Search to add diagnosis"); }
    public Locator diagnosesParticular() { return page.getByText("Chronic viral hepatitis C", new Page.GetByTextOptions().setExact(true)); }

    // Order Summary/Provider Elements
    public Locator orderSummaryButton() { return page.getByText("Order summary", new Page.GetByTextOptions().setExact(true)); }
    public Locator orderingProviderDropdown() { return page.locator("button[data-element='ordering-provider-select-dropdown']"); }
    public Locator particularOrderingProvider() { return page.getByText("RACHEL CASTRO", new Page.GetByTextOptions().setExact(true)).first(); }
    public Locator primaryOrderingProviderDropdown() { return page.locator("button[data-element='primary-provider-select-dropdown']"); }
    public Locator particularPrimaryOrderingProvider() { return page.getByText("RACHEL CASTRO", new Page.GetByTextOptions().setExact(true)).nth(1); }
    public Locator sendButton() { return page.locator("button[data-element='next-btn']"); } // This locator is used for multiple clicks
    public Locator nextSendButton() { return page.locator("button[data-element='next-btn']"); } // This is for the second instance if it's different
    public Locator printButton() { return page.locator("button[data-element='print-btn']"); }
    public Locator profile() { return page.locator("a[data-element='patient-header-tab-Profile']"); }
  //p[@data-element="prn-text"]
    public Locator recordId() { return page.locator("p[data-element='prn-text']"); }

}