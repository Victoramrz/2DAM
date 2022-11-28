package AED.Manejo_conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexOracle21c {
    public static void main(String[] args) {
        //Cree la tabla de departamentos de las actividades anteriores
        String miquery="Select * From Departamentos";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "1234");
            Statement sentence=con.createStatement();
            ResultSet result= sentence.executeQuery(miquery);
            while(result.next()){
                System.out.println(result.getInt(1)+"-"+result.getString(2)+"-"+result.getString(3));
            }
        } catch (Exception e) {
           
        }

    }
}
