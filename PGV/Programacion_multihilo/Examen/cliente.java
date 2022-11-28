package PGV.Programacion_multihilo.Examen;

public class cliente extends Thread{
    SupermercadoBuff supermercadoBuffer;
    int intentos=(int)(Math.random()*3)+1;
    //Al inicializar me paso el supermercadobuff para que todos los clientes usen el mismo supermercado Lidl
    cliente(SupermercadoBuff supermercadoBuffer){
        this.supermercadoBuffer = supermercadoBuffer;
    }
    @Override
    public void run() {
        //Inicializo Caja
        caja Caja;
        for (int i = 0; i < intentos; i++) {
            //Le digo que prueba a ver si hay alguna caja libre si es null que siga intentandolo
            Caja=supermercadoBuffer.Pasarcompra(this.getName());
            if (Caja != null) {
                try {
                    //Si es distinto de null que pase por la cinta los productos
                    Thread.sleep((int)(Math.random()*1000));
                    //Tras pasar todos los productos tenemos que pagarloss :_C
                    supermercadoBuffer.Pagar(Caja,this.getName());
                    //Y como ya termino se va del super satifeco 
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
