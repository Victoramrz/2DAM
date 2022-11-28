package AED.Manejo_conectores;

import java.sql.*;
public class MiSQLite {
    public static void main(String[] args) {
        try {
            //Conector
            Class.forName("org.sqlite.JDBC"); //Cargamos el driver
            //Se establece conexión con BD
            //Cambiar ruta
            Connection conexion=DriverManager.getConnection ("jdbc:sqlite:C:\\Program Files\\sqlite-tools-win32-x86-3390400\\activy.db");
            Statement sentencia=conexion.createStatement(); //Se prepara una consulta
            //Cambiar tabla
            ResultSet resul = sentencia.executeQuery("SELECT * FROM Departamentos");
            while (resul.next()){
                System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getString(3));
            }
            System.out.println("/----------------------------------------------------------------------------------------------------------------------------------------/");
            resul = sentencia.executeQuery("SELECT * FROM Empleados");
            while (resul.next()){
                System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getString(3)+" "+resul.getString(4)+" "+resul.getString(5)+" "+resul.getString(6)+" "+resul.getString(7));
            }
            resul.close();
            sentencia.close();
            conexion.close();
        }
        catch (ClassNotFoundException ec) {ec.printStackTrace();}
        catch (SQLException es) {es.printStackTrace();}
    }
}

