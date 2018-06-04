Feature: This is a home Page feature

background:
    Given Launch chrome driver
    And Launch application url

Scenario: submit a grant application
    Given Start the chrome browser
    And launch the Url
    When credentials are provided
    Then User should be able to log in
    And Navigate to Home Page and provide required information
    And Navigate to Proposal Page and provide Input
