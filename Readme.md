# Enunciado #
1. El puente sólo acepta un máximo de 3 coches.
2. El puente soporta un peso máximo de 5000 Kg.
3. Cada coche pesa entre 800 y 2000 Kg.
4. Cada coche llega al puente entre 1 y 30 segundos.
5. Cada coche, tarda entre 10 y 50 segundos en pasar.
6. Para hacer la simulación, modelamos coches como hilos.
7. El objeto Puente, es recurso compartido que controla el paso de los coches.
8. Dentro de puente, deberá haber un método  sePermitePaso, que devuelva true/false dependiendo si acepta el paso de un coche.
9. Cuando un coche salga, deberá modificar el estado del puente mediante un método llamado finalizarPaso.
10. Implementar la clase Puente, Coche y SimulacionPuente.
11. Deberéis utilizar el método sleep de Thread.

En clase, expliqué mediante pseudocódigo, cómo debería hacerse