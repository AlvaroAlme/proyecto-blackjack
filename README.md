# Proyecto Blackjack

Juego de Blackjack en Java jugable por consola, desarrollado como ejercicio de diseño orientado a objetos (incluye diagrama de clases UML).

## Estructura

- `Carta.java`: representa una carta de la baraja y calcula su valor (las figuras valen 10, el As vale 11 salvo que la mano se pase de 21).
- `Mano.java`: representa la mano de cartas de un jugador; suma los puntos aplicando la regla del As (11 o 1) y controla los estados de blackjack y mano pasada.
- `main.java`: punto de entrada del juego; monta la baraja, reparte cartas al jugador y a la banca, y gestiona una ronda completa por consola.
- `diagrama-clases.puml` / `diagrama-clases.drawio`: diagrama de clases UML del diseño.

## Cómo jugar

Compila y ejecuta con el JDK:

```bash
javac *.java
java Main
```

El juego reparte dos cartas a cada jugador, te pregunta si quieres pedir carta y, cuando te plantas, juega el turno de la banca (pide hasta llegar a 17) y muestra el resultado de la ronda.

## Posibles mejoras

- Soportar varias rondas seguidas sin reiniciar el programa.
- Añadir apuestas y gestión de saldo.
- Implementar el resto de clases previstas en el diagrama UML (Jugador, Banca, Baraja, Ronda).
