package AED.Ficheros;

import java.io.*;

public class repaso_files {

    public static void main(String[] args) {
        File fichi= new File("src\\Ficheros\\texto.txt");
        if(fichi.exists()){
            System.out.println("Existo");
        }else{
            System.err.println("Error");
        }
    }
}
