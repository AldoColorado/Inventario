package Controlador;


import Modelo.ProductoDAO_Imp;
import Modelo.ProductoVO;
import Modelo.Venta;
import Modelo.VentaDAO_Imp;
import Modelo.DetalleVenta;
import Modelo.detalle_ventaDAO_Imp;
import Vista.Mensajes;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



/**
*Esta clase contienen todas las operaciones de las diferentes clases del proyecto
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 

public class Operaciones {

    
    Mensajes ms;
    ProductoDAO_Imp productoDAOImp;
    VentaDAO_Imp ventaDAOImp;
    detalle_ventaDAO_Imp detalle_ventaDAO_Imp;

    public Operaciones() {
        this.ms = new Mensajes();
        this.productoDAOImp = new ProductoDAO_Imp();
        this.ventaDAOImp = new VentaDAO_Imp();
        this.detalle_ventaDAO_Imp = new detalle_ventaDAO_Imp();
    }

    public void guardar(int clave, String nombre, String descripcion, String unidad, int cantidad, double precio) {
        ProductoVO pp = new ProductoVO(clave, nombre, descripcion, unidad, cantidad, precio);
        ProductoDAO_Imp pi = new ProductoDAO_Imp();
        pi.create(pp);
    }
        
    public void guardarVenta(int claveVenta, String fecha_hora,Double importe) {
        Venta pp = new Venta(claveVenta, fecha_hora,importe);
        VentaDAO_Imp pi = new VentaDAO_Imp();
        pi.create(pp);
    }

    public void guardarDetalleVenta(int claveProducto, int claveVenta) {
        DetalleVenta pp = new DetalleVenta(claveProducto, claveVenta);
        detalle_ventaDAO_Imp pi = new detalle_ventaDAO_Imp();
        pi.create(pp);
    }

    public void mostrar() {
        List<ProductoVO> lista = productoDAOImp.readAll();
        ms.mostrarProdcutos(lista);
    }

    public void mostrarVenta() {
        List<Venta> lista = ventaDAOImp.readAll();
        ms.mostrarVentas(lista);
    }

    public void mostrarDetalleCompra() {
        List<DetalleVenta> lista = detalle_ventaDAO_Imp.readAll();
        ms.mostrarDetalleVenta(lista);
    }

    public void ejecutarAplicacion() {
        
       

        int opcion = 0;
        do {
            ms.menu();
            opcion = ms.opcionEntero();
            switch (opcion) {
                case 1:
                    ms.agregarMensajes();
                    int clave=0;
                    String nombre = ms.leerNombre();
                    String descripcion = ms.leerDescripcion();
                    String unidad = ms.leerUnidad();
                    int cantidad = ms.leerCantidad();
                    double precio = ms.leerPrecio();
                    ProductoVO producto = new ProductoVO(clave, nombre, descripcion, unidad, cantidad, precio);
                    boolean creado = this.productoDAOImp.create(producto);
                    ms.resultadoOperacion(creado, "Crear");
                    
                    
                    
                    break;
                case 2:
                    ms.agregarMensajeModificar();
                    int claveModificar=ms.leerClaveEditar();
                    int opcionModificar=0;
                    
                    while(opcionModificar!=6){
                        ms.menuModificar();
                 
                        opcionModificar=ms.opcionEntero();
                    
                        switch(opcionModificar){
                            case 1:
                                String nuevoNombre;
                                nuevoNombre=ms.leerNuevoNombre();
                                
                                boolean modificarNombre=this.productoDAOImp.modificarNombre(claveModificar, nuevoNombre);
                                ms.resultadoOperacion(modificarNombre, "Modificar");
                                
                           
                                
                                break;
                                
                            case 2:
                                String nuevaDescripcion;
                                nuevaDescripcion=ms.leerNuevaDescripcion();
                                
                                boolean modificarDescripcion=this.productoDAOImp.modificarDescripcion(claveModificar, nuevaDescripcion);
                                ms.resultadoOperacion(modificarDescripcion, "Modificar");
                                
                                
                                
                                break;
                            
                            case 3:
                                
                                String nuevaUnidad;
                                nuevaUnidad=ms.leerNuevoUnidad();
                                
                                boolean modificarUnidad=this.productoDAOImp.modificarUnidad(claveModificar, nuevaUnidad);
                                ms.resultadoOperacion(modificarUnidad, "Modificar");
                                
                                
                                break;
                                
                            case 4:
                                int nuevaCantidad;
                                nuevaCantidad=ms.leerNuevaCantidad();
                                
                                boolean modificarCantidad=this.productoDAOImp.modificarCantidad(claveModificar, nuevaCantidad);
                                ms.resultadoOperacion(modificarCantidad, "Modificar");
                                
                                
                                break;
                                
                            case 5:
                                double nuevoPrecio;
                                nuevoPrecio=ms.leerNuevoPrecio();
                                
                                boolean modificarPrecio=this.productoDAOImp.modificarPrecio(claveModificar, nuevoPrecio);
                                ms.resultadoOperacion(modificarPrecio, "Modificar");
                                
                                
                                break;
                                
                            case 6:
                                
                                
                                break;
                            
                                
                                
                             
                        }
                    }
                  
                    break;
                case 3:
                    ms.agregarMensajeEliminar();
                    int claveEliminar = ms.leerClave();
                    boolean eliminado = this.productoDAOImp.eliminar(claveEliminar);
                    ms.resultadoOperacion(eliminado, "eliminar");

                    break;
                case 4:
                    List<ProductoVO> lista = this.productoDAOImp.readAll();
                    ms.mostrarProdcutos(lista);
                    break;
                    
                case 5:
                    
//Realizar venta     
                    int claveVenta=0;
                    int claveDetalleVenta=0;
                    double importe=0;
                    List<DetalleVenta> listaLineasVenta = new ArrayList<>();
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    String fecha = dateFormat.format(date);
                    
                    int opcionVender=1;
                    
                    Venta venta = new Venta();
                    venta.setClaveVenta(claveVenta);
                    
                    
                    while(opcionVender!=0){
                        
                        ms.agregarMensajeVenta();
                        ProductoVO p = new ProductoVO();
                      
                        
                        
                        int claveVender = ms.leerClaveProductoVenta();
                        p = this.productoDAOImp.obtenerProducto(claveVender);
                        System.out.println(p.getClave());
                        
                        if (p == null) {
                            System.out.println("No existe el producto ... ");
                        } else {

                            ms.agregarMensajeCantidadVenta();
                            int cant  = ms.leerCantidadVenta();
                            
                            double importeUnitario = cant  * p.getPrecio();
                            
                           
                            
                           
                            boolean disminuido=this.productoDAOImp.disminuirCantidadInventario(p,cant);
                            ms.resultadoOperacion(disminuido, "Producto Disminuido");
                            
                            
                            DetalleVenta detalleVenta = new DetalleVenta(p.getClave(),venta.getClaveVenta());
                            boolean detalleVentaCreado=this.detalle_ventaDAO_Imp.create(detalleVenta);
                            ms.resultadoOperacion(detalleVentaCreado,"DetalleVenta creado");
                            
                            listaLineasVenta.add(detalleVenta);

       //                   venta.getListaLineasVenta().add(detalleVenta);
                            importe+=importeUnitario;
                        }
                        
                        opcionVender=ms.leerContinuarVenta();
                        
                    } //fin while
                   
                    
                    
                    venta.setFecha_hora(fecha);
                    venta.setImporte(importe);
                    venta.setListaLineasVenta(listaLineasVenta);
                    
                    break;
                case 6:
                    //Consultar venta

                    break;
                case 7:
                    ms.agregarMensajeModificarInventario();
                    ProductoVO productoModificarCantidad=new ProductoVO();
                    int claveModificarInventario=ms.leerClaveModificarInventario();
                    int cantidadNuevoIngreso=ms.leerCantidad();
                    double precioNuevoIngreso=ms.leerPrecio();
                    productoModificarCantidad=this.productoDAOImp.obtenerProducto(claveModificarInventario);
                    boolean modificado=this.productoDAOImp.agregarCantidadInventario(productoModificarCantidad,cantidadNuevoIngreso, precioNuevoIngreso);
                    ms.resultadoOperacion(modificado, "modificar");
                    
                    break;
                case 8:
                    
                    ms.agregarMensajeDisminuirInventario();
                    ProductoVO productoDisminuirCantidad=new ProductoVO();
                    int claveDisminuirInventario=ms.leerClaveDisminuirInventario();
                    int cantidadDisminuir=ms.leerCantidadADisminuir();
                    productoDisminuirCantidad=this.productoDAOImp.obtenerProducto(claveDisminuirInventario);
                    boolean disminuido=this.productoDAOImp.disminuirCantidadInventario(productoDisminuirCantidad,cantidadDisminuir);
                    ms.resultadoOperacion(disminuido,"Producto Disminuido exitosamente");
                    
                    
                    break;
                case 9:
                    System.out.println("Saliendo...");
                   
                default:
                    System.out.println("ERROR. Opcion invalida.");
                    break;
            }
        } while (opcion !=9);
    }
}
