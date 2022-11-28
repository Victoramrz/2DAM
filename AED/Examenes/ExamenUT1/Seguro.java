package AED.Examenes.ExamenUT1;

import java.io.Serializable;

public class Seguro implements Serializable{
    int Poliza;
    String Cliente;
    String Matricula;
    Double Cuota;
    public Seguro() {
        
    }
    public int getPoliza() {
        return Poliza;
    }
    public void setPoliza(int poliza) {
        Poliza = poliza;
    }
    public String getCliente() {
        return Cliente;
    }
    public void setCliente(String cliente) {
        Cliente = cliente;
    }
    public String getMatricula() {
        return Matricula;
    }
    public void setMatricula(String matricula) {
        Matricula = matricula;
    }
    public Double getCuota() {
        return Cuota;
    }
    public void setCuota(Double cuota) {
        Cuota = cuota;
    }
    
}
