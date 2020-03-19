/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
*Esta clase contienen los metodos funcionales para realizar la venta
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 
public class VentaDAO_Imp implements VentaDAO{
   @Override
   public boolean create (Venta venta){
       boolean created = false;
       Connection con=null;
       Statement stm=null; 
       String sql="INSERT INTO venta VALUES ("+venta.getClaveVenta()+
               ",'"+venta.getFecha_hora()+"',"+venta.getImporte()+")";
       ConexionDB cc= new ConexionDB();
       try{
           con=cc.conectarMySQL();
           stm=con.createStatement();
           stm.execute(sql);
           
           
//           while
           
           
           
           created=true;
           stm.close();
           con.close();
       }catch (SQLException e){
           System.out.println("ERROR. No se pudo agregar la venta");
           e.printStackTrace();
       }
       return created;
   }
   
   @Override
    public List<Venta> readAll(){
        Connection con=null;
        Statement stm=null;
        ResultSet rs=null;
        String sql= "SELECT * FROM producto ORDER BY clave";
        
        List<Venta> listaVentas=new ArrayList<Venta>();
        try{
            con=new ConexionDB().conectarMySQL();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()){
                Venta c= new Venta(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                listaVentas.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo ReadAll");
            e.printStackTrace();
        }
        return listaVentas;
    }
    
   
}
