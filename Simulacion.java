public class Simulacion {
    public static void main(String[] args) {
        Puente puente = new Puente();
        
        while (true) { 
            Coche coche = new Coche(puente);
            coche.start(); 
            try {
                Thread.sleep(1000 + (int) (Math.random() * 4000)); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Simulación interrumpida.");
                break;
            }
        }
    }
}

