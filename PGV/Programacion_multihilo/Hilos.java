package PGV.Programacion_multihilo;

public class Hilos extends Thread{
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(new MiHilo(), "tarea "+i);
            switch (i) {
                case 1:
                    thread.setPriority(MIN_PRIORITY);    
                break;
                case 2:
                    thread.setPriority(NORM_PRIORITY);   
                break;
                case 3:
                    thread.setPriority(MAX_PRIORITY);     
                break;
            }
            thread.start();
            try {
                Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
        }
        System.out.println("¡Eso es to… eso es to… eeeesto es todo amigos!");
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName()+" Repeticion: "+i);
        }
        System.out.println(Thread.currentThread().getName()+" Finish");
    }
}
