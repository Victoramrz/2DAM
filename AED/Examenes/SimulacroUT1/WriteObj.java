package AED.Examenes.SimulacroUT1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class WriteObj {
    public static void main(String[] args, File firan) {
        File docObj = new File("src\\AED\\Examenes\\SimulacroUT1\\dataEquipo.obj");
        try  {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(docObj));
            //read firan
            RandomAccessFile raf = new RandomAccessFile(firan, "r");
            int j=0;
            while (j<raf.length()) {
                Teams team = new Teams();
                int position_register=0;
                raf.seek(position_register+j);
                team.setNum_teams(raf.readInt());
                position_register=position_register+Simulacrout1.sizesRandom[0];
                raf.seek(position_register);
                team.setName_teams(ReadString(raf,position_register+j));
                position_register=position_register+Simulacrout1.sizesRandom[1];
                raf.seek(position_register+j);
                team.setPresident_teams(ReadString(raf,position_register+j));
                position_register=position_register+Simulacrout1.sizesRandom[2];
                raf.seek(position_register+j);
                team.setTelefones(raf.readInt());
                position_register=position_register+Simulacrout1.sizesRandom[3];
                raf.seek(position_register+j);
                team.setLocality(ReadString(raf,position_register+j));
                position_register=position_register+Simulacrout1.sizesRandom[4];
                j=j+Simulacrout1.sizesRandom[5];
                oos.writeObject(team);
            }
            Simulacrout1.Print(raf.readLine());
            raf.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String ReadString(RandomAccessFile raf, int localizador) {
        String nombre="";
        int final_position=0; 
        if (localizador>Simulacrout1.sizesRandom[5]) {
            for (int j = 0; j < (localizador/Simulacrout1.sizesRandom[5]); j++) {
                final_position = final_position+Simulacrout1.sizesRandom[5];
            }
        }
        for (int i=0; final_position<=localizador; i++) {
           final_position=final_position+Simulacrout1.sizesRandom[i];
        }
        try {
            raf.seek(localizador);
            for (int i=localizador; i <= final_position; i++) {
                char caracter=raf.readChar();
                if (caracter!=0) {
                    nombre+=caracter;
                }else{
                    i=final_position+1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombre;
    }
}
