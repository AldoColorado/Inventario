package Modelo;

/**
*Esta clase contienen los atributos y metodos de un producto
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 
public class ProductoVO {
    private int clave;
    private String nombre;
    private String descripcion;
    private String unidad;
    private int cantidad;
    private double precio;
    
    
    /**
    * Metodo constructor por defecto
    */
    public ProductoVO() {
    }
    
    /*
    *Metodo constructor parametrizado
    *@param clave Clave del producto
    *@param nombre Nombre del producto
    *@param descripcion Descripcion del producto
    *@param unidad Unidad del producto
    *@param cantidad Cantidad del producto
    *@param precio Precio del producto
    */
    public ProductoVO(int clave, String nombre, String descripcion, String unidad, int cantidad, double precio) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    /**
    * Metodo para regresar la clave del producto
    * @return Regresa la clave del producto
    */
    public int getClave() {
        return clave;
    }
    
    /**
    * Metodo para regresar el nombre del producto
    * @return Regresa el nombre del producto
    */
    public String getNombre() {
        return nombre;
    }
    
    /**
    * Metodo para regresar la descripcion del producto
    * @return Regresa la descripcion del producto
    */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
    * Metodo para regresar la unidad del producto
    * @return Regresa la unidad del producto
    */
    public String getUnidad() {
        return unidad;
    }

    /**
    * Metodo para regresar la cantidad del producto
    * @return Regresa la cantidad del producto
    */
    public int getCantidad() {
        return cantidad;
    }

    /**
    * Metodo para regresar el precio del producto
    * @return Regresa el precio del producto
    */
    public double getPrecio() {
        return precio;
    }

    /**
    * Metodo para ingresar la clave al producto
    * @param clave Clave del producto
    */
    public void setClave(int clave) {
        this.clave = clave;
    }

    /**
    * Metodo para ingresar el nombre al producto
    * @param nombre nombre del producto
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    * Metodo para ingresar la descripcion del producto
    * @param descripcion Descripcion del producto
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
    * Metodo para ingresar la unidad del producto
    * @param unidad Unidad del producto
    */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
    * Metodo para ingresar la cantidad del producto
    * @param cantidad Cantidad del producto
    */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
    * Metodo para ingresar el precio del producto
    * @param precio Precio del producto
    */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
    @Override
    public String toString() {
        return "Producto{" + "clave=" + clave + ", nombre=" + nombre + ", descripcion=" + descripcion + ", unidad=" + unidad + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
}
