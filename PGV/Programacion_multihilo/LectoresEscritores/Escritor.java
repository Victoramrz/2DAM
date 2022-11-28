package PGV.Programacion_multihilo.LectoresEscritores;

public class Escritor extends Thread{
    String text="";
    MyBuffer myBuffer;
    Escritor(MyBuffer myBuffer){
        this.myBuffer=myBuffer;
    }
    public void escribir(){
        try {
            Thread.sleep(((int)(Math.random()*1000)));
            MyBuffer.writter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
