package AED.Examenes.SimulacroUT1;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObj {
    public static void main(String[] args) {
        File docObj = new File("src\\AED\\Examenes\\SimulacroUT1\\dataEquipo.obj");
        try {
            FileInputStream fis = new  FileInputStream(docObj);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Teams team;
            while ((team=(Teams)ois.readObject())!=null){
                Simulacrout1.Print("Numero equipo: "+team.getNum_teams()+"\nNombre equipo:"+team.getName_teams().toString()+"\nNombre Presidente: "+team.getPresident_teams().toString()+"\nNumero de telefono: "+team.getTelefones()+"\nLocalidad del equipo: "+team.getLocality().toString()+"\n");
            }
            fis.close();
            ois.close();
        } catch(EOFException e){
            Simulacrout1.Print("Apruebame");
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       
    }
}
