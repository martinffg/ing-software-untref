Feature: Como jugador quiero poder calcular el envido que tengo en mi mano

Scenario: Tengo trnumero cartas de diferente palo
Given "carta1" numero 1 tipo "copa"
And "carta2" numero 1 tipo "espada"
And "carta3" numero 1 tipo "oro"
When Calculo el envido de mi mano
Then El envido es 1.

Scenario: Tengo trnumero cartas del mismo palo
Given "carta1" numero 3 tipo "copa"
And "carta2" numero 1 tipo "copa"
And "carta3" numero 4 tipo "copa"
When Calculo el envido de mi mano
Then El envido es 27.

Scenario: Tengo dos cartas del mismo palo y la tercera no.
Given "carta1" numero 1 tipo "copa"
And "carta2" numero 7 tipo "copa"
And "carta3" numero 1 tipo "oro"
When Calculo el envido de mi mano
Then El envido es 28.
