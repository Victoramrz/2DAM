package PGV.Programacion_multihilo.Examen;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SupermercadoBuff {
    //Creamos una lista donde almacenar las cajas creadas
    protected ArrayList<caja> cajas = new ArrayList<caja>();
    Semaphore mutex = new Semaphore(1);
    SupermercadoBuff(int CantidadCajas){
        //Creo las cajas del supermecado
        for (int i = 0; i < CantidadCajas; i++) {
            //Inicio las cajas y le pongo el nombre con la misma estructura que la cliente Ej: caja1,caja2,caja3
            caja caja = new caja();
            caja.setName("Caja"+(i+1));
            //Y lo añado a una lista con todas las cajas
            cajas.add(caja);
        }
    }
    protected caja Pasarcompra(String string){
        try {
            //Cerramos el semaforo para que solo pase uno
            mutex.acquire();
            //Mirará si hay alguna caja libre si es que no salta la excepcion que dice que estan todas ocupadas
            caja Caja = cajas.get(0);
            //Si consiguio una la quitamos de la lista de cajas(que es una lista donde las cajas estan libres)
            cajas.remove(0);
            //Mostramos por pantalla que se ocupo la caja y que el usuario esta pasando la compra
            System.out.println("La "+Caja.getName()+" queda ocupada");
            System.out.println("El "+string+" esta pasando la compra por la "+Caja.getName());
            //Al terminar libreramos el metodo y retornamos la caja que esta usando
            mutex.release();
            return Caja;    
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e){
            System.out.println("Todas las cajas estan ocupadas. Hay que llamar a los refuerzos");
        }
        mutex.release();
        return null;
    }
    protected void Pagar(caja caja, String string){
        try {
            //Cerramos el semaforo para que solo pase uno
            mutex.acquire();
            //Mostramos que el cliente tiene que pagar una cierta cantidad y que queda libre la caja cuando la añadimos a la lista
            System.out.println("El "+string+" ha pagado "+((int)(Math.random()*500)+1)+"."+((int)(Math.random()*100))+"euros en la "+caja.getName());
            cajas.add(caja);
            System.out.println("La "+caja.getName()+" queda libre");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Al terminar libreramos el metodo
        mutex.release();
    }
}
