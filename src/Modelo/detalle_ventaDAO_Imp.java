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
*Esta clase contienen todos los metodos funcionales para realizar la clase detalle_venta
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 

public class detalle_ventaDAO_Imp implements detalle_ventaDAO{
   @Override
   
   public boolean create (DetalleVenta detalle_venta){
       boolean created = false;
       Connection con=null;
       Statement stm=null; 
       String sql="INSERT INTO detalle_venta VALUES ("+detalle_venta.getClaveProducto()+
               ","+detalle_venta.getClaveVenta()+")";
       ConexionDB cc= new ConexionDB();
       try{
           con=cc.conectarMySQL();
           stm=con.createStatement();
           stm.execute(sql);
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
    public List<DetalleVenta> readAll(){
        Connection con=null;
        Statement stm=null;
        ResultSet rs=null;
        String sql= "SELECT * FROM detalle_venta ORDER BY clave";
        
        List<DetalleVenta> listaDetalleVentas=new ArrayList<DetalleVenta>();
        try{
            con=new ConexionDB().conectarMySQL();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()){
                DetalleVenta c= new DetalleVenta(rs.getInt(1),rs.getInt(2));
                listaDetalleVentas.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo ReadAll");
            e.printStackTrace();
        }
        return listaDetalleVentas;
    }
    
   
}
