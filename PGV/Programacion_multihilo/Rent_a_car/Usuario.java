package PGV.Programacion_multihilo.Rent_a_car;

public class Usuario {
    public static void main(String[] args) {
        Renting renting = new Renting();
        for (int i = 0; i <= 30 /*((int)(Math.random()*50)+11)*/; i++) {
            Cliente cliente = new Cliente(renting);
            cliente.setName("Cliente"+i);
            cliente.start();
        }
    }
    
}
