package AED.Examenes.SimulacroUT1;

import java.io.Serializable;

public class Teams implements Serializable{
    int Num_teams; 
    String Name_teams;
    String President_teams;
    int Telefones ;
    String Locality ;
    Teams() {
        
    }
    //Get
    public String getLocality() {
        return Locality;
    }
    public String getName_teams() {
        return Name_teams;
    }
    public int getNum_teams() {
        return Num_teams;
    }
    public String getPresident_teams() {
        return President_teams;
    }
    public int getTelefones() {
        return Telefones;
    }
    //Set
    public void setLocality(String locality) {
        Locality = locality;
    }
    public void setName_teams(String name_teams) {
        Name_teams = name_teams;
    }
    public void setNum_teams(int num_teams) {
        Num_teams = num_teams;
    }
    public void setPresident_teams(String president_teams) {
        President_teams = president_teams;
    }
    public void setTelefones(int telefones) {
        Telefones = telefones;
    }
}
