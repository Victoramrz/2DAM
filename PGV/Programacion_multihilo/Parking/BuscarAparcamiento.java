package PGV.Programacion_multihilo.Parking;

public class BuscarAparcamiento {
    public static void main(String[] args) {
        Parking parking = new Parking();
        //Este for son la cantidad de vehiculos
        parking.setMax(2);
        for (int i = 0; i <15; i++) {
            Vehiculos vehiculo = new Vehiculos("Vehiculo "+(i+1),parking);
            vehiculo.start();
        }
    }
}
