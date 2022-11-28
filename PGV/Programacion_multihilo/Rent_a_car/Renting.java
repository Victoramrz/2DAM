package PGV.Programacion_multihilo.Rent_a_car;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Renting {
    ArrayList<Coche> CochesList = new ArrayList<Coche>();
    Semaphore mutex = new Semaphore(1);
    
    Renting(){
        for (int i = 0; i <= 20; i++) {
            Coche coche = new Coche();
            CochesList.add(coche);
        }
    }
    protected Coche Alquilar(String nombre){
        try {
            mutex.acquire();
            if (!CochesList.isEmpty()) {
                Coche coche=CochesList.get(0);
                System.out.println("Se le alquilo el coche con Matricula "+coche.getMatricula()+" al usuario "+nombre);
                CochesList.remove(0);
                mutex.release();
                return coche;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex.release();
        return null;
    }

    protected void Devolver(Coche coche){
        //Añadir el objeto Coche que habias sacado, a la lista.
        try {
            mutex.acquire();
            CochesList.add(coche);
            System.out.println("Se ha devuelto el coche con la Matricula "+coche.getMatricula());
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
