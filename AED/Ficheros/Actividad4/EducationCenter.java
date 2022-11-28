package AED.Ficheros.Actividad4;

import java.io.Serializable;

public class EducationCenter implements Serializable{
    String Type;
    String Name;
    String Code;//This string is alphanumeric
    String Street;
    int PostCode;
    String Locality;
    String Island;
        EducationCenter(String Type, String Name, String Code, String Street, Integer PostCode, String Locality, String Island){
            this.Type=Type;
            this.Name=Name;
            this.Code=Code;
            this.Street=Street;
            this.PostCode=PostCode;
            this.Locality=Locality;
            this.Island=Island;
        }
        //GET
        public String getCode() {
            return Code;
        }
        public String getIsland() {
            return Island;
        }
        public String getLocality() {
            return Locality;
        }
        public String getName() {
            return Name;
        }
        public int getPostCode() {
            return PostCode;
        }
        public String getStreet() {
            return Street;
        }
        public String getType() {
            return Type;
        }
        //SET
        public void setCode(String code) {
            Code = code;
        }
        public void setIsland(String island) {
            Island = island;
        }
        public void setLocality(String locality) {
            Locality = locality;
        }
        public void setName(String name) {
            Name = name;
        }
        public void setPostCode(int postCode) {
            PostCode = postCode;
        }
        public void setStreet(String street) {
            Street = street;
        }
        public void setType(String type) {
            Type = type;
        }
}