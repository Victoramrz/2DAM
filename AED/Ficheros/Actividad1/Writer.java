package AED.Ficheros.Actividad1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) {
        File doc = new File("src\\AED\\Ficheros\\Actividad1\\Writer.txt");
        try {
            if (doc.createNewFile()) {
                Menu_Act1.Imprimir("Documento creado "+doc.getName()+" con exito");
            } else {
                Menu_Act1.Imprimir("Documento ya existe");
            }
            if (doc.canWrite()) {
                FileWriter fw = new FileWriter(doc);
                String cadena= "Primera prueba con FileWriter";
                for (int i = 0; i < cadena.length(); i++) { 
                    fw.write(cadena.charAt(i));
                    Menu_Act1.Imprimir(""+cadena.charAt(i));
                }
                fw.write("\n"+"y esto es el final.");
                fw.close();
            }
        } catch (IOException e) {
            Menu_Act1.Imprimir("Error");
            e.printStackTrace();
        }
    }
}
