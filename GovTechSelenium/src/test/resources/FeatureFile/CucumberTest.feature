Feature: This feature file is for all scenarios for BGP portal

Background:
    Given Launch chrome driver

    Scenario: Submit a grant application successfully
        When Launch application url
        Then Submit a grant and Validate the grant is submitted successfully on Summary Page

    @Regression
    Scenario Outline: Submit Grant Application with valid Eligibility
        Given Sign In the user with valid credentials to launch the application
        And Login with  a predefined User
        When Apply for Grant
        And Provide confirmation on Eligibility and validate all tabs get enabled
        And Provide Contact Details on the Contact & Details page
        |   testcase_ID    |
        |   <test_id>      |
        And Provide type of solution, date , vendor list, location type and upload the testfile
        Then Provide the Purchase details on Purchase page and Validate the total fees
        And Provide tasks, reason and percentage Efficiency on the Business Impacts Page
        And Provide answers for the questionnaire and acknowledge on Declare and Review Page
        And Provide the aggrement and submit the application on the company Profile Page and Validate all the fields matches the input provided at each page
        And Validate that application is submitted successfuly
        Examples:
        |   <test_id>  |
        |   test1      |
        |   test2      |

    @Regression
    Scenario Outline: Submit Grant Application with invalid Eligibility
        Given Sign In the user with valid credentials to launch the application
        And Login with  a predefined User
        When Apply for Grant
        And Provide confirmation on the In- eligibility on Eligibility Page
        And Validate all the tabs are disabled and SME Matters link is displayed


