package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*Clase que realiza la conexión entre el programa y el manejador de base de datos
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 

public class ConexionDB {
    public String driver="com.mysql.jdbc.Driver";
    public String database="ProductosV2";
    public String hostname="localhost";
    public String port="3306";
    public String url="jdbc:mysql://"+hostname+":"+port+"/"+database+
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDa"
            + "tetimeCode=false&serverTimezone=UTC";//(useSLL)Cancela el modo seguro para conectar a la base de datos
    public String username="root";
    public String password="LesCactus27";
    
    public Connection conectarMySQL(){
        Connection conn=null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("ERROR. No se pude conectar a la base de datos");
            e.printStackTrace();
        }
        return conn;
    }
}