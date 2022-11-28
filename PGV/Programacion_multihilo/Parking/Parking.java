package PGV.Programacion_multihilo.Parking;

import java.util.concurrent.Semaphore;

public class Parking {
    int max;
    Semaphore mutex = new Semaphore(1);
    Parking(){
        max=0;    
    }
    protected int getMax() {
        return max;
    }
    protected void setMax(int max) {
        this.max = max;
    }
    //Synchronized
    /*protected synchronized boolean Aparcar(String nom){
        if (max<=0) {
            return false;
        } else {
            max--;
            return true;
        }
    }
    protected synchronized void salir(String nom) {
        max++;
        System.out.println("El vehiculo "+nom+" ha salido");
    }*/
    //Semaforo
    protected boolean Aparcar(String nom){
        boolean result=false;
        try {
            mutex.acquire();
            if (max<=0) {
                result= false;
            } else {
                max--;
                result = true;
            }
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }
        mutex.release();
        return result;
    }
    protected void salir(String nom) {
        max++;
        System.out.println("El vehiculo "+nom+" ha salido");
    }
    
}
