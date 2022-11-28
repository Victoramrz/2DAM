package PGV.Programacion_multihilo.Parking;

public class Vehiculos extends Thread{
    
    Parking parking;
    int intentos;
    Vehiculos(String nom, Parking parking){
        setName(nom);
        this.parking=parking;
        this.intentos=3;
    }

    public void run() {
        //Esto son los intentos
        for (int i = 0; i < intentos; i++) {
            if (parking.Aparcar(getName())) {
                System.out.println("El "+getName()+" a partado");
                try {
                    Vehiculos.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                parking.salir(getName());
                break;
            }else{
                System.err.println("No a podido aparcar el vehicuo "+getName());
            }
        }
    }
}
