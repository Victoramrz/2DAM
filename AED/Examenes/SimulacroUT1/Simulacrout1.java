package AED.Examenes.SimulacroUT1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Simulacrout1 {

    final static Integer[] sizesRandom={4,40,40,4,40,128};
    public static void main(String[] args) {
        /*Estructura:
            Tip no se puede hacer la estructura sin saber el length de todo si no lo se lo creo
            Num_teams int 1*32 bytes= 32/8=4
            Name_teams string 20 caracter * 16 bytes = 208/8 =40
            President_teams string 20 caracter * 16 bytes = 176/8=40
            Telefones int 1 * 32 bytes = 32/8= 4
            Locality string 20 caracteres * 16 bytes = 256/8= 40
            total 128
        */
       
        File fiby = new File("src\\AED\\Examenes\\SimulacroUT1\\datosEquipo.txt");//El nombre fiby viene de juntar file y bytes
        try {
            if (!fiby.exists()) {
                if (fiby.createNewFile()) {
                    Print("Documento creado "+fiby.getName()+" con exito");
                } else {
                    Print("Documento ya existe");
                }
            }
            WriteFiBy.main(args,fiby);
            Print("The writerfiby has successfully finished ");
            File firan = new File("src\\AED\\Examenes\\SimulacroUT1\\datosEquipos.dat");//El nombre firan viene de juntar file y random
            if (!firan.exists()) {
                if (firan.createNewFile()) {
                    Print("Documento creado "+firan.getName()+" con exito");
                } else {
                    Print("Documento ya existe");
                } 
            } 
            ReadFibyAndWriteFiRan.main(args,fiby,firan);
            Print("The readFiby and writefiran has successfully finished");
            Modifiran.main(args,firan);
            Print("The modifiran and writefiran has successfully finished");
            WriteObj.main(args,firan);
            ReadObj.main(args);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    protected static void Print(String Text) {
        System.out.println(Text);
    }
}
