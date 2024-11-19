import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Puente {
    private int cochesEnPuente = 0;
    private int pesoActual = 0;
    private final int MAX_COCHES = 3;
    private final int MAX_PESO = 5000;
    private final Lock lock = new ReentrantLock();
    private final Condition condicionPaso = lock.newCondition();

    public boolean sePermitePaso(int pesoCoche) {
        lock.lock();
        try {
            if (cochesEnPuente < MAX_COCHES && pesoActual + pesoCoche <= MAX_PESO) {
                cochesEnPuente++;
                pesoActual += pesoCoche;
                System.out.println("Coche con " + pesoCoche + " Kg entra al puente. Total coches en puente: " 
                                   + cochesEnPuente + ", Peso total: " + pesoActual + " Kg");
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void finalizarPaso(int pesoCoche) {
        lock.lock();
        try {
            cochesEnPuente--;
            pesoActual -= pesoCoche;
            System.out.println("Coche con " + pesoCoche + " Kg sale del puente. Total coches en puente: " 
                               + cochesEnPuente + ", Peso total: " + pesoActual + " Kg");
            condicionPaso.signalAll(); // Despierta a otros coches que esperan para intentar cruzar
        } finally {
            lock.unlock();
        }
    }
}
