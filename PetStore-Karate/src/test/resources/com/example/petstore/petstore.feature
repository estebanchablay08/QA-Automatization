Feature: Pruebas E2E de la API de PetStore

  Background:
    * url 'https://petstore.swagger.io/v2'
    * def petId = 987654321

  Scenario: 1. Crear una nueva mascota en la tienda
    Given path 'pet'
    And request { "id": #(petId), "name": "Taco", "status": "available" }
    When method post
    Then status 200
    And match response.name == 'Taco'
    And match response.status == 'available'

  Scenario: 2. Consultar la mascota creada por ID
    Given path 'pet', petId
    When method get
    Then status 200
    And match response.id == petId
    And match response.name == 'Taco'

  Scenario: 3. Actualizar el estado de la mascota a 'sold'
    Given path 'pet'
    And request { "id": #(petId), "name": "Taco", "status": "sold" }
    When method put
    Then status 200
    And match response.status == 'sold'

  Scenario: 4. Eliminar la mascota
    Given path 'pet', petId
    When method delete
    Then status 200