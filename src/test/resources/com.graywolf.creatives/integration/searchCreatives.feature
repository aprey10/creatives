Feature: Search creatives

  Scenario: Simple search for one creative
    Given have creative with url "http://testUrl" and description "description"
    And creative has set of os:
      | linux   |
      | android |
      | osx     |
    And creative has set of countries:
      | UA  |
      | US  |
    And creative has set of excluded countries:
      | LV |
      | LB |
      | LS |
    And creative stored in database
    When Search for creative with os "linux" and country "UA" and limit 2
    Then Creative with url "http://testUrl" should be found
    And 1 creatives should be found
    
  Scenario: Simple search for two creatives
    Given have creative with url "http://testUrl" and description "description"
    And creative has set of os:
      | linux   |
      | android |
      | osx     |
    And creative has set of countries:
      | UA  |
      | US  |
    And creative has set of excluded countries:
      | LV |
      | LB |
      | LS |
    And creative stored in database
    Given have creative with url "http://test2Url" and description "description2"
    And creative has set of os:
      | windows |
      | android |
      | osx     |
    And creative has set of countries:
      | UA  |
      | KG  |
    And creative has set of excluded countries:
      | LV |
      | LB |
      | LS |
    And creative stored in database
    When Search for creative with os "osx" and country "UA" and limit 5
    Then Creative with url "http://testUrl" should be found
    And Creative with url "http://test2Url" should be found
    And 2 creatives should be found

  Scenario: Search for two creatives
    Given have creative with url "http://testUrl" and description "description"
    And creative has set of os:
      | linux   |
      | android |
      | osx     |
    And creative has set of countries:
      | UA  |
      | US  |
    And creative has set of excluded countries:
      | LV |
      | LB |
      | LS |
    And creative stored in database
    Given have creative with url "http://test2Url" and description "description2"
    And creative has set of os:
      | windows |
      | android |
      | osx     |
    And creative has set of countries:
      | UA  |
      | KG  |
    And creative has set of excluded countries:
      | LV |
      | LB |
      | LS |
    And creative stored in database
    Given have creative with url "http://test3Url" and description "description2"
    And creative has set of os:
      | windows |
      | android |
      | osx     |
    And creative has set of countries:
      | UA  |
      | KG  |
    And creative has set of excluded countries:
      | UA |
      | LB |
      | LS |
    And creative stored in database
    Given have creative with url "http://test4Url" and description "description2"
    And creative has set of os:
      | windows |
      | linux   |
      | android |
    And creative has set of countries:
      | UA  |
      | KG  |
    And creative has set of excluded countries:
      | UA |
      | LB |
      | LS |
    And creative stored in database
    When Search for creative with os "osx" and country "UA" and limit 5
    Then Creative with url "http://testUrl" should be found
    And Creative with url "http://test2Url" should be found
    And 2 creatives should be found