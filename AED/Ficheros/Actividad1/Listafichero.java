package AED.Ficheros.Actividad1;

import java.io.File;

public class Listafichero {
    
    public static void main(String[] args) {
        //Parte A
        //Inicializamos el file con el nombre doc haciendo referencia a documento
        String ruta=Menu_Act1.SolitoRuta();
        try {
            File ruta_actual;
            ruta_actual= new File("./");
            //Solitamos el directorio absoluto del fichero para mostrarlo en la consola con el system.out.println
            Menu_Act1.Imprimir("Absoluta");
            Menu_Act1.Imprimir(ruta_actual.getAbsolutePath());
            //Solitamos el directorio relativo del fichero para mostrarlo en la consola (ES FILE, NO STRING)
            Menu_Act1.Imprimir("Relativa");
            System.out.println((ruta_actual.getParentFile()));
            //Solitamos la lista de ficheros en del directorio del usuario introducido previamente, pero primero necesito inicializarla
            File ruta_usuario= new File(ruta);
            //Posteriormente lo puedo mostrar
            String[] lista_ruta_usuario = new String[ruta_usuario.list().length];
            lista_ruta_usuario=ruta_usuario.list();
            for(int i=0; i<lista_ruta_usuario.length; i++){
                Menu_Act1.Imprimir(lista_ruta_usuario[i]);
            }
        } catch (Exception e) {
            if (e != null) {
                Menu_Act1.Imprimir("El archivo no existe o no tiene bien la ruta");
            }
        }
        return;
    }
}
