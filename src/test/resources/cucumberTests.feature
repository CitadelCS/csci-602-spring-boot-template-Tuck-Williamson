Feature: Test Status
  Scenario: client makes call to GET /info
    When the client calls /info
    Then the client receives status code of 200
    And the client receives server name, version, and description

  Scenario: client makes call to GET /health
    When the client calls /health
    Then the client receives status code of 200
    And the client receives a map with status equal to ok

  Scenario: client inspects the version
    When the client calls /info
    Then the client receives status code of 200
    And the client receives a map with version equal to 1.0.0
