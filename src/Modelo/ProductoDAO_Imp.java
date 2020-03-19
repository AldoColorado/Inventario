package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
*Esta clase contienen los metodos funcionales de la clase producto
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 

public class ProductoDAO_Imp implements ProductoDAO {

    @Override
    public boolean create(ProductoVO producto) {
        boolean created = false;
        Connection con = null;
        Statement stm = null;
        String sql = "INSERT INTO producto VALUES ('" + producto.getClave() +
                "','" + producto.getNombre() + 
                "','" + producto.getDescripcion() + 
                "','" + producto.getUnidad() + 
                "'," + producto.getCantidad() + 
                "," + producto.getPrecio() + ")";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo agregar el producto, metodo "
 + "registrar");
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public List<ProductoVO> readAll() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM producto ORDER BY claveProducto";

        List<ProductoVO> listaProductos = new ArrayList<ProductoVO>();
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                ProductoVO c = new ProductoVO(rs.getInt(1), rs.getString(2), 
                rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
                listaProductos.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo ReadAll");
            e.printStackTrace();
        }
        return listaProductos;
    }

    public ProductoVO obtenerProducto(int clave) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean encontrado = false;
        String sql = "SELECT claveProducto, nombre, descripcion, unidad, "
        + "cantidad, precio "
                + " FROM producto "
                + " where claveProducto = '" + clave + "'  ";

        ProductoVO producto = null;
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                producto = new ProductoVO(rs.getInt("claveProducto"), rs.getString("nombre"),
                        rs.getString("descripcion"), rs.getString("unidad"), 
                        rs.getInt("cantidad"), rs.getDouble("precio"));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo ReadAll");
            e.printStackTrace();
        }
        return producto;
    }

    public boolean eliminar(int claveEliminar) {
        boolean eliminar = false;
        Connection con = null;
        Statement stm = null;
        String sqlEliminar = "DELETE FROM Producto WHERE claveProducto='" 
                            + claveEliminar + "';";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sqlEliminar);
            eliminar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo eliminar producto");
            e.printStackTrace();
        }
        return eliminar;
    }
    
    public boolean createVenta(ProductoVO producto) {
        boolean created = false;
        Connection con = null;
        Statement stm = null;
        String sql = "INSERT INTO producto VALUES ('" + producto.getClave() 
        + "','" + producto.getNombre() + "','" + producto.getDescripcion() + 
        "','" + producto.getUnidad() + "'," + producto.getCantidad() + "," + 
        producto.getPrecio() + ")";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo agregar el producto, "
            + "metodo registrar");
            e.printStackTrace();
        }
        return created;
    }
    
    public boolean agregarCantidadInventario(ProductoVO producto,int cantidad, double precio) {
        boolean modificarCantidad= false;
        Connection con = null;
        Statement stm = null;
        int cantidadNueva=cantidad+producto.getCantidad();        
        double precioNuevasExistencias=0;
        precioNuevasExistencias=(precio*cantidad);          //Suma de los precios de cada producto de entrada
        double precioCantidadActuales=0;           
        precioCantidadActuales=(producto.getPrecio()*producto.getCantidad());  //Suma de los precios de cada producto ya existentes                
        double precioUnitarioNuevo=(precioNuevasExistencias+precioCantidadActuales)/cantidadNueva;
        
        String sqlModificar = "UPDATE Producto SET cantidad='"+cantidadNueva+"',precio='"+precioUnitarioNuevo+"'WHERE claveProducto='" + producto.getClave()+ "';";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sqlModificar);
            modificarCantidad= true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo modificar el producto");
            e.printStackTrace();
        }
        return modificarCantidad;
    }
    
    public boolean disminuirCantidadInventario(ProductoVO producto,int cantidad) {
        boolean modificarCantidad= false;
        Connection con = null;
        Statement stm = null;
        if(cantidad>producto.getCantidad()){
            System.out.println("La cantidad sobrepasa la existencia");
        }else{
            
            int cantidadNueva=producto.getCantidad()-cantidad;        
        
            String sqlModificar = "UPDATE Producto SET cantidad='"+cantidadNueva+"'WHERE claveProducto='" + producto.getClave()+ "';";
            ConexionDB cc = new ConexionDB();
            try {
                con = cc.conectarMySQL();
                stm = con.createStatement();
                stm.execute(sqlModificar);
                modificarCantidad= true;
                stm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("ERROR. No se pudo modificar el producto");
                e.printStackTrace();
            }
            
        }
        return modificarCantidad;
    }
    
    public boolean modificarNombre(int claveModificar, String nuevoNombre) {
        boolean created = false;
        Connection con = null;
        Statement stm = null;
        String sql = "UPDATE Producto SET nombre='"+nuevoNombre+"' "
                + "WHERE claveProducto='"+claveModificar+"';";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo modificar el producto");
            e.printStackTrace();
        }
        return created;
    }
    
    public boolean modificarDescripcion(int claveModificar, String nuevaDescripcion) {
        boolean created = false;
        Connection con = null;
        Statement stm = null;
        String sql = "UPDATE Producto SET descripcion='"+nuevaDescripcion+"' "
                + "WHERE claveProducto='"+claveModificar+"';";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo modificar el producto");
            e.printStackTrace();
        }
        return created;
    }
    
    public boolean modificarUnidad(int claveModificar, String nuevaUnidad) {
        boolean created = false;
        Connection con = null;
        Statement stm = null;
        String sql = "UPDATE Producto SET unidad='"+nuevaUnidad+"' "
                + "WHERE claveProducto='"+claveModificar+"';";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo modificar el producto");
            e.printStackTrace();
        }
        return created;
    }
    
    public boolean modificarCantidad(int claveModificar, int cantidad) {
        boolean created = false;
        Connection con = null;
        Statement stm = null;
        String sql = "UPDATE Producto SET cantidad='"+cantidad+"' "
                + "WHERE claveProducto='"+claveModificar+"';";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo modificar el producto");
            e.printStackTrace();
        }
        return created;
    }
    
    public boolean modificarPrecio(int claveModificar, double precio) {
        boolean created = false;
        Connection con = null;
        Statement stm = null;
        String sql = "UPDATE Producto SET precio='"+precio+"' "
                + "WHERE claveProducto='"+claveModificar+"';";
        ConexionDB cc = new ConexionDB();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. No se pudo modificar el producto");
            e.printStackTrace();
        }
        return created;
    }
    
    
    /*@Override
     public boolean update (ProductoVO producto){
        
     }
     @Override
     public boolean delete (ProductoVO producto){
        
     }*/
}
