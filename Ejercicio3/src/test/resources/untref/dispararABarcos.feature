Feature: Como usuario quiero disparar a los barcos enemigos

  Scenario: Disparo y toco agua
    Given tengo un tablero de 10*10
	And no hay barco en posicion 2,7
    When disparo a la posicion 2,7
    Then el resultado fue agua

  Scenario: Disparo y toco un barco pero no lo hundo
    Given tengo un tablero de 10*10
    And hay barco en posicion 3,4
    When disparo a la posicion 3,4
    Then el resultado fue tocado

  Scenario: Disparo toco un barco y lo hundo
    Given tengo un tablero de 10*10
    And hay barco en posicion 6,2
    And el resto del barco fue tocado
    When disparo a la posicion 6,2 
    Then el resultado fue hundido

  Scenario: No se puede disparar fuera del tablero
    Given tengo un tablero de 10*10
    When disparo a la posicion 11,1
    Then el resultado fue posicion_invalida
