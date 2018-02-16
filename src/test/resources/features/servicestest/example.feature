@Example
Feature: example feature file

  Scenario: example feature file
    When the service is called with HTTP method "GET" on "www.testautomationschool.nl/test/test.xml"
    Then the status code is "200"
    And the response message has an element "name" with value "Jantje"