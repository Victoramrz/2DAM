package PGV.Programacion_multihilo.LectoresEscritores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class MyBuffer {
    static String parrafo="El hotel del centro es el más antiguo del pueblo y también es aquel que tiene más comodidades; Este hotel fue construido en 1911, pero primero se utilizó como casa de familia; En 1975 un inversionista compró esta propiedad y la reformó para transformarla en el hotel que hoy conocemos; Es un hotel pequeño, pero cuenta con servicio a la habitación, con pileta climatizada, con un restaurante de categoría, entre otras cosas;La famosa banda de rock se separó, al menos por un tiempo; Los integrantes declararon en diversos medios que no hubo una pelea, sino que quieren trabajar un tiempo como solitas; Además, en una rueda de prensa, el representante dijo que es probable que el año próximo los músicos se vuelvan a juntar para hacer una gira;Muchas personas creen que los osos polares están en peligro de extinción, pero la denominación correcta sobre la situación de esta especie es que están en situación de conservación vulnerable; De todas formas, es necesario que se actúe rápidamente para evitar que esta especie desaparezca;";
    static String[] oraciones=parrafo.split(";");
    static File file= new File("src\\PGV\\Programacion_multihilo\\LectoresEscritores\\text.txt");;
    static int lineaEscrita=0;
    static int lineaLeida=0;
    static Semaphore mutex = new Semaphore(1);
    //He usado el faro binario llamado mutex
    MyBuffer(){
        if (!file.exists()) {
            System.out.println("No existe el documento text.txt");
        }
    }
    public static void writter() {
        try {
            mutex.acquire();
            System.out.println("El escritor va escribir algo del fichero");
            if (oraciones.length>=lineaEscrita) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
                bw.write(oraciones[lineaEscrita].trim());
                bw.newLine();
                bw.close();
            } else {
                System.out.println("Ya no se puede escribir mas");
            }
            if (lineaEscrita==oraciones.length-1) {
                lineaEscrita=0; 
            }else{
                lineaEscrita++;
            }
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } 
    }
    public static String reader() {
        String text=null;
        try {
            mutex.acquire();
            System.out.println("El lector va leer algo del fichero");
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (int j = 0; j <= lineaLeida; j++) {
                text=br.readLine();
            }
            br.close();
            if (lineaLeida==oraciones.length) {
                lineaLeida=0; 
            }else{
                lineaLeida++;
            }
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } 
        return text;
    }
}
