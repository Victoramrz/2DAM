package PGV.Programacion_multihilo.Rent_a_car;

public class Coche {
    final static String alfabeto="ABCDEFGHIJKLMNPQRSTUVWXYZ";
    String Matricula;
    boolean alquilado;
    Coche(){
        this.Matricula=(Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10))+alfabeto.charAt((int)(Math.random()*alfabeto.length()))+alfabeto.charAt((int)(Math.random()*alfabeto.length())));
        alquilado=false;
    }
    protected void setMatricula(String matricula) {
        Matricula = matricula;
    }
    protected String getMatricula() {
        return Matricula;
    }
    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }
    public boolean isAlquilado() {
        return alquilado;
    }
}
