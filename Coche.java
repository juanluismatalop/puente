import java.util.Random;

public class Coche extends Thread {
    private final Puente puente;
    private final int peso;
    private final int tiempoDeCruce;

    public Coche(Puente puente) {
        this.puente = puente;
        Random rand = new Random();
        this.peso = 800 + rand.nextInt(1201); 
        this.tiempoDeCruce = 10 + rand.nextInt(41);
    }

    @Override
    public void run() {
        Random rand = new Random();
        int tiempo = 1 + rand.nextInt(30); 

        try {
            Thread.sleep(tiempo * 1000);
            System.out.println("Coche de " + peso + " Kg intenta pasar después de " + tiempo + " segundos.");

            while (!puente.sePermitePaso(peso)) {
                System.out.println("Coche de " + peso + " Kg espera para cruzar.");
                Thread.sleep(1000);
            }

            System.out.println("Coche de " + peso + " Kg está cruzando por " + tiempoDeCruce + " segundos.");
            Thread.sleep(tiempoDeCruce * 1000);

            puente.finalizarPaso(peso);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

