Feature: Check if title of main page is correct

  Scenario: Addition
    Given I open website misskathy.ru
    When getting page title
    Then asserting page title