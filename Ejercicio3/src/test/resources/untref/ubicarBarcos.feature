Feature: Como usuario quiero ubicar mis barcos

  Scenario: Ubico mi barco exitosamente
    Given tengo un tablero de 10*10
    And no hay barco en posicion 3,3
    And no hay barco en posicion 3,4
    When jugador elige un "acorazado" 
    And la posicion es 3,3
	And la orientacion es "horizontal"
    Then barco posicionado exitosamente

  Scenario: No se puede ubicar un barco en una posición ya ocupada
    Given tengo un tablero de 10*10 
    And hay barco en posicion 7,7
    When jugador elige un "destructor"
    And la posicion es 7,7
    And la orientacion es "horizontal"
    Then error al posicionar barco

  Scenario: No se puede ubicar un barco si alguna de sus posiciones intermedias esta siendo ocupada por otro
    Given tengo un tablero de 10*10 
    And hay barco en posicion 2,1
    When jugador elige un "destructor"
    And la posicion es 1,1
    And la orientacion es "vertical"
    Then error al posicionar barco

  Scenario: No puedo ubicar mi barco en una posición fuera del tablero
    Given tengo un tablero de 10*10 
    When jugador elige un "lancha"
    And la posicion es 11,1
    And la orientacion es "vertical"
    Then posicion fuera de tablero
