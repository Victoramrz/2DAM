package PGV.Programacion_multihilo.LectoresEscritores;

public class Inicio {
    public static void main(String[] args) {
        MyBuffer myBuffer = new MyBuffer();
        for (int i = 0; i <((int)Math.random()*20)+10; i++) {
            Escritor writter = new Escritor(myBuffer);
            Lector reader = new Lector(myBuffer);
            writter.setName("escritor");
            reader.setName("lector");
            writter.escribir();
            reader.leer();
        }
    }
}
