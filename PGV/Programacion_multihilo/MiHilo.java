package PGV.Programacion_multihilo;

public class MiHilo implements Runnable{
    public static void main(String[] args) {
        Thread thread=null;
        for (int j = 1; j <= 4; j++) {
            thread = new Thread(new MiHilo(), "tarea " + j);
            thread.start();
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("¡Eso es to… eso es to… eeeesto es todo amigos!");        
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i==5) {
                switch(Thread.currentThread().getPriority()){
                    case 1:
                        Thread.currentThread().setPriority(10);
                    break;
                    case 10:
                        Thread.currentThread().setPriority(1);
                    break;
                    default:
                }
            }
            System.out.println(Thread.currentThread().getName()+" Prioridad: "+Thread.currentThread().getPriority()+" Repeticion: "+i);  
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
