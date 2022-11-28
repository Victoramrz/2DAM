package AED.Examenes.SimulacroUT1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFiBy {
    public static void main(String[] args, File fiby) {
        Integer[] Num_teams = {100,101,202} ; 
        String[] Name_teams = {"Playa hombre","Estrella Rojo","Siete Palmas"};
        String[] President_teams={"Messi","Pepito Rojo","Manuel Feo"};
        Integer[] Telefones = {555666777,666888999,123123123};
        String[] Locality = {"Telde","Santa Brigida","Las Palmas de GC"};
        try  {
            FileOutputStream fos = new FileOutputStream(fiby);
            for (int i = 0; i < Locality.length; i++) {
                String register = Num_teams[i]+"##"+Name_teams[i]+"##"+President_teams[i]+"##"+Telefones[i]+"##"+Locality[i]+"\n";
                fos.write(register.getBytes());
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
