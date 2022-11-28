package AED.Ficheros.Actividad1;

import java.io.File;

public class Propiedades_ficheros {
    public static void main(String[] args) {  
        String ruta=Menu_Act1.SolitoRuta();
        File doc = new File(ruta);
        Menu_Act1.Imprimir("Nombre del fichero/directorio");
        Menu_Act1.Imprimir(doc.getName());
        Menu_Act1.Imprimir("Ruta relativa");
        Menu_Act1.Imprimir(doc.getAbsolutePath());
        Menu_Act1.Imprimir("Ruta absoluta");
        System.out.println(doc.getParentFile());
        Menu_Act1.Imprimir("Atributo de lectura");
        System.out.println(doc.canRead());
        Menu_Act1.Imprimir("Atributo de escritua");
        System.out.println(doc.canWrite());
        Menu_Act1.Imprimir("Tamaño");
        System.out.println(doc.length());
        //Booleans
        Menu_Act1.Imprimir("Si es un directorio");
        System.out.println(doc.isDirectory());
        Menu_Act1.Imprimir("Si es un fichero");
        System.out.println(doc.isFile());
        return;
    }
}
