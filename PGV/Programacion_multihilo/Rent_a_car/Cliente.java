package PGV.Programacion_multihilo.Rent_a_car;

public class Cliente extends Thread{
    Renting renting;
    Cliente(Renting renting){
        this.renting = renting;
    }
    public void run() {
        Coche coche;
        if ((coche=renting.Alquilar(this.getName()))!=null) {
            try {
                Thread.sleep((int)(Math.random()*1000));
                renting.Devolver(coche);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se le ha podido alquilar un coche");
        }
    }
}
