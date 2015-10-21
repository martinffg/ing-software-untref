Feature: Arriesgar Letra

  Scenario: Arriesgo al comienzo una letra minuscula y acierto
    Given la palabra secreta es "auto"
    And me quedan 7 vidas
    When arriesgo "a"
    Then estado es "a***"
    And me quedan 7 vidas

  Scenario: Arriesgo al comienzo una letra mayuscula y acierto
    Given la palabra secreta es "auto"
    And me quedan 7 vidas
    When arriesgo "A"
    Then estado es "a***"
    And me quedan 7 vidas

  Scenario: Arriesgo al comienzo una letra y no acierto
    Given la palabra secreta es "auto"
    And me quedan 7 vidas
    When arriesgo "x"
    Then estado es "****"
    And me quedan 6 vidas

  Scenario: Arriesgo no acierto y pierdo
    Given la palabra secreta es "auto"
    And me quedan 1 vidas
    When arriesgo "w"
    Then estado es "Ahorcado!"
    And me quedan 0 vidas

  Scenario: Arriesgo acierto y gano
    Given la palabra secreta es "auto"
    When estado_previo es "aut*"
    And arriesgo "o"
    Then estado es "auto"

  Scenario: Arriesgo una letra luego de haber perdido
    Given la palabra secreta es "auto"
    And me quedan 0 vidas
    When arriesgo "z"
    Then estado es "Ahorcado!"
    And me quedan 0 vidas
