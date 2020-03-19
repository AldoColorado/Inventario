package Vista;

import Modelo.ProductoVO;
import Modelo.Venta;
import Modelo.DetalleVenta;
import java.util.Iterator;
import java.util.List;

/**
*Esta clase contienen todos los mensajes que aparecen en pantalla
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 
public class Mensajes {
    Teclado teclado;

    public Mensajes() {
        this.teclado=new Teclado();
    }
    
    public int opcionEntero(){
        int opcion=0;
        System.out.print("Introduce un dato de tipo entero: ");
        opcion=teclado.leerEntero();
        return opcion;
    }
    
    public void menu(){
        System.out.println("Elige una opcion");
        System.out.println("1) Agregar");
        System.out.println("2) Modificar");
        System.out.println("3) Eliminar");
        System.out.println("4) Mostrar");
        System.out.println("5) Realizar venta");
        System.out.println("6) Consultar venta");
        System.out.println("7) Agregar cantidad a producto");
        System.out.println("8) Disminuir cantidad a producto");
        System.out.println("9) Salir");
    }
    
    public void menuModificar(){
        System.out.println("Elige que deseas modificar");
        System.out.println("1) Nombre");
        System.out.println("2) Descripcion");
        System.out.println("3) Unidad");
        System.out.println("4) Cantidad");
        System.out.println("5) Precio");
        System.out.println("6) Regresar al menu principal");
    }
    
    public void agregarMensajes(){
        System.out.println("Ingresando un producto :");
    }
    
    public void agregarMensajeDisminuirInventario(){
        System.out.println("Disminuyendo producto");
    }
    
    public void agregarMensajeEliminar(){
        System.out.println("Eliminando producto");
    }
    
    public void agregarMensajeVenta(){
        System.out.println("Realizando venta");
    }
    
    
    public void agregarMensajeConsultarVenta(){
        System.out.println("Consultando ventas");
    }
     
    public void agregarMensajeCantidadVenta(){
        System.out.println("Ingresa la cantidad de productos a vender");
    }
    
    public void agregarMensajeModificarInventario(){
        System.out.println("Modificando inventario");
    }
    
    public int leerClaveModificarInventario(){
        int claveModificarInventario=0;
        System.out.println("Ingresa la clave del producto del que deseas agregar mas existencia");
        claveModificarInventario=teclado.leerEntero();
        
        
        return claveModificarInventario;
    }
    
    public int leerClaveDisminuirInventario(){
        int claveDisminuirInventario=0;
        System.out.println("Ingresa la clave del producto del que deseas disminuirExistencia");
        claveDisminuirInventario=teclado.leerEntero();
        
        
        return claveDisminuirInventario;
    }
    
    public int leerClave(){
        int clave;
        System.out.print("Introduce la clave del producto: ");
        clave=teclado.leerEntero();
        return clave;
    }
    
    public String leerNuevoNombre(){
        String nombre;
        System.out.print("Introduce elnombre del producto: ");
        nombre=teclado.leerCadena();
        return nombre;
    }
    
     public String leerNuevaDescripcion(){
        String descripcion;
        System.out.print("Introduce la nueva descripcion del producto: ");
        descripcion=teclado.leerCadena();
        return descripcion;
    }
     
    public String leerNuevoUnidad(){
        String unidad;
        System.out.print("Introduce la nueva unidad del producto: ");
        unidad=teclado.leerCadena();
        return unidad;
    }
    
    public int leerNuevaCantidad(){
        int cantidad;
        System.out.print("Introduce la nueva cantidad del producto: ");
        cantidad=teclado.leerEntero();
        return cantidad;
    }
    
    
    public Double leerNuevoPrecio(){
        double precio;
        System.out.print("Introduce el nuevo precio del producto: ");
        precio=teclado.leerDoble();
        return precio;
    }
    
    public int leerCantidadVenta(){
        int cantidad=0;
        System.out.print("Introduce la cantidad del producto: ");
        cantidad=teclado.leerEntero();
        return cantidad;
    }
    
    public int leerContinuarVenta(){
        int cantidad=0;
        System.out.print("Introduce (1) para seguir vendiendo, (0) para no vender mas: ");
        cantidad=teclado.leerEntero();
        return cantidad;
    }
    
    public int leerClaveProductoVenta(){
        int clave;
        System.out.print("Introduce la clave del producto a vender: ");
        clave=teclado.leerEntero();
        return clave;
    }
    
    public void agregarMensajeModificar(){
        System.out.println("Modificando");
    }
    
    public int leerClaveEditar(){
        int clave=0;
        System.out.println("Introduce la clave del producto que deseas modificar");
        clave=teclado.leerEntero();
        return clave;
    }
    
    public String leerClaveVenta(){
        String clave="";
        System.out.print("Introduce la clave de la venta: ");
        clave=teclado.leerCadena();
        return clave;
    }
    
    public String leerNombre(){
        String nombre;
        System.out.print("Introduce el nombre del producto: ");
        nombre=teclado.leerCadena();
        return nombre;
    }
    
   public String leerDescripcion(){
        String descripcion;
        System.out.print("Introduce la descripcion del producto: ");
        descripcion=teclado.leerCadena();
        return descripcion;
   }

   public String leerUnidad(){
        String unidad;
        System.out.print("Introduce el tipo de unidad del producto: ");
        unidad=teclado.leerCadena();
        return unidad;
   }
   
   public int leerCantidad(){
       int cantidad=0;
       System.out.print("Introduce la cantidad de existencia del producto: ");
       cantidad=teclado.leerEntero();
       return cantidad;
   }
   
   public int leerCantidadADisminuir(){
       int cantidad=0;
       System.out.print("Introduce la cantidad a quitar del producto: ");
       cantidad=teclado.leerEntero();
       return cantidad;
   }
   
   public double leerPrecio(){
       double precio=0.0;
       System.out.print("Introduce el precio del producto: ");
       precio=teclado.leerDoble();
       return precio;
   }
   
   public void mostrarProdcutos (List<ProductoVO> lista){
        System.out.println("\t Los productos son:");
        Iterator<ProductoVO> iteradorE=lista.iterator();
        
        while (iteradorE.hasNext()){
            System.out.println("\t \t"+ iteradorE.next());
        }
    }
   
    public void mostrarVentas(List<Venta> lista){
        System.out.println("\t Los productos son:");
        Iterator<Venta> iteradorE=lista.iterator();
        
        while (iteradorE.hasNext()){
            System.out.println("\t \t"+ iteradorE.next());
        }
    }
    
     public void mostrarDetalleVenta(List<DetalleVenta> lista){
        System.out.println("\t Los productos son:");
        Iterator<DetalleVenta> iteradorE=lista.iterator();
        
        while (iteradorE.hasNext()){
            System.out.println("\t \t"+ iteradorE.next());
        }
    }
    
    public void resultadoOperacion(boolean resultado, String operacion){
        if (resultado){
            System.out.println("\n Resultado Exitoso al "+ operacion + "\n");
        }else{
            System.out.println("\n Resultado Fallido al "+ operacion + "\n");
        }
    }
}

