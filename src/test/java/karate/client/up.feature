Feature: Up

  Background:
    * url baseUrl
    * def activeBase = "/up"

  Scenario Outline: Up client with status <statusCode>

    Given path activeBase
    And request <requestBody>
    When method PUT
    Then status <statusCode>
    And match response == <expected>

    Examples:
      | requestBody                                                                                                      | statusCode | expected                                                          |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": 1}    | 200        | { result: 0}                                                      |
      | {"address": null, "id": 1, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": 1}            | 400        | { errorMessage: "the address should not be null or empty"}        |
      | {"address": "", "id": 1, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": 1}              | 400        | { errorMessage: "the address should not be null or empty"}        |
      | {"address": "Olmedo 439", "id": null, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": 1} | 400        | { errorMessage: "the id should not be null"}                      |
      | {"address": "Olmedo 439", "id": 0, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": 1}    | 400        | { errorMessage: "the id should not be less o equals 0"}           |
      | {"address": "Olmedo 439", "id": -1, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": 1}   | 400        | { errorMessage: "the id should not be less o equals 0"}           |
      | {"address": "Olmedo 439", "id": 1, "name": null,"phone": "3518113800","surname": "Singer","typeClient": 1}       | 400        | { errorMessage: "the name should not be null or empty"}           |
      | {"address": "Olmedo 439", "id": 1, "name": "","phone": "3518113800","surname": "Singer","typeClient": 1}         | 400        | { errorMessage: "the name should not be null or empty"}           |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": null,"surname": "Singer","typeClient": 1}            | 400        | { errorMessage: "the phone should not be null or empty"}          |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": "","surname": "Singer","typeClient": 1}              | 400        | { errorMessage: "the phone should not be null or empty"}          |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": "3518113800","surname": null,"typeClient": 1}        | 400        | { errorMessage: "the surname should not be null or empty"}        |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": "3518113800","surname": "","typeClient": 1}          | 400        | { errorMessage: "the surname should not be null or empty"}        |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": null} | 400        | { errorMessage: "the type client should not be null"}             |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": 0}    | 400        | { errorMessage: "the type client should not be less or equals 0"} |
      | {"address": "Olmedo 439", "id": 1, "name": "Marla","phone": "3518113800","surname": "Singer","typeClient": -1}   | 400        | { errorMessage: "the type client should not be less or equals 0"} |