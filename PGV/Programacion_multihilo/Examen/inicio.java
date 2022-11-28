package PGV.Programacion_multihilo.Examen;


public class inicio {
    static int MaxClient=20;
    static int CantidadCajas=4;
    public static void main(String[] args) {
        
        //Como minimo solo hay que tener 4 cajas no me fio de que pongas menos a posta
        if (CantidadCajas<4) {
            CantidadCajas=4;
            System.out.println("El numero minimo de cajas son 4");
        }
        //Inicializo el buffer supermercado y le meto la cantidad de cajas que quiero
        SupermercadoBuff supermercadoBuffer = new SupermercadoBuff(CantidadCajas);
        //Como no me fio de que vallas a poner un numero mayor que 50 cree este if para si te pasas solo entren 50
        if (MaxClient>50) {
            MaxClient=50;
        }
        //Llegan los clientes a black thursday todo a un 10% mas caro
        int cliente=1;
        while (cliente<=MaxClient) {
            //Inicializo client y le pongo el nombre cliente mas el numero correspondiente Ej: cliente1,cliente2,cliente3
            cliente client = new cliente(supermercadoBuffer);
            client.setName("cliente"+cliente);
            //Compruebo si es multiplo de 7 si es le pongo prioridad 1
            if (cliente%7==0) {
                client.setPriority(1);
            }
            //Empieza el hilo a funcionar
            client.start();
            //Incremento el numero de clientes
            cliente++;
        }
    }
}
