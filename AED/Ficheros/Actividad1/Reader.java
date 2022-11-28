package AED.Ficheros.Actividad1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Reader {
    public static void main(String[] args) {
        //No puedo inicializar el Scanner porque si no me rompe el menu principal
        File doc = new File("src\\AED\\Ficheros\\Actividad1\\Text.txt");
        if (!doc.exists()) {
            JOptionPane.showMessageDialog(null, "No existe el fichero, por favor cree el fichero");
            //No se puede usar system.exit(0) porque sales de todo el programa
            return;
        }else{
        FileReader fr;
        try {
            fr = new FileReader(doc);
            int caracter;
            int i=0;
            char[] letras = new char[10];
            String sentencia="";
            do {
                caracter=fr.read(letras);
                for (i=0; i < caracter; i++) {
                    sentencia+=letras[i];
                    Menu_Act1.Imprimir(""+letras[i]);
                }
                Menu_Act1.Imprimir(sentencia);
                sentencia="";
            } while (caracter>=0);
            Menu_Act1.Imprimir(sentencia);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //String DNI = JOptionPane.showInputDialog(null, "Inserte el DNI a validar:");
        }
    }
}
