Feature: Delete

  Background:
    * url baseUrl

  Scenario Outline: Delete client by client id <client> with status <statusCode>

    Given path '/delete/<client>'
    When method DELETE
    Then status <statusCode>
    And match response == <expected>

    Examples:
      | client  | statusCode | expected                                                |
      | 1       | 200        | { result: 0}                                            |
      | 0       | 400        | { errorMessage: "the id should not be less o equals 0"} |
      | -1      | 400        | { errorMessage: "the id should not be less o equals 0"} |