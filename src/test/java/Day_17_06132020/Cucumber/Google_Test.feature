Feature: Google Test Scenarios

  Scenario Outline: TC01: Allow user to capture google search number on search result

    #following use case covers google test scenario
    Given I Navigate to google home page
    When I Enter a keywork <Cars> on the search field
    When I click the search icon
    When I capture search result
    Then I can extract the search number and print it



    Examples:
    | Cars |
    | Lexus |
    | BMW   |


#each scenario/scenario outline are individual test cases. No relation between
    Scenario: TC02: Allow user to go to google sign in page