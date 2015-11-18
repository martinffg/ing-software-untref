Feature: Como jugador quiero poder calcular el envido que tengo en mi mano

Scenario: Tengo tres cartas de diferente palo
Given Verifico mi mano
And carta1 es 1 copa
And carta2 es 1 espada
And carta3 es 1 oro.
When Calculo el envido de mi mano.
Then El envido es 1.

Scenario: Tengo tres cartas del mismo palo
Given Verifico mi mano
And carta1 es 3 copa
And carta2 es 1 copa
And carta3 es 4 copa.
When Calculo el envido de mi mano
Then El envido es 27.

Scenario: Tengo dos cartas del mismo palo y la tercera no.
Given Verifico mi mano
And carta1 es 1 copa
And carta2 es 7 copa
And carta3 es 1 oro.
When Calculo el envido de mi mano
Then El envido es 28.
