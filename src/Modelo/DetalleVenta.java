/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
*Esta clase contiene los atributos y metodos de la clase detalle_venta
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 
public class DetalleVenta {
    
    private int claveProducto;
    private int claveVenta;

    public DetalleVenta() {}
    
    public DetalleVenta(int claveProducto, int claveVenta) {
        this.claveProducto = claveProducto;
        this.claveVenta = claveVenta;
    }

    public int getClaveProducto() {
        return claveProducto;
    }

    public int getClaveVenta() {
        return claveVenta;
    }

    public void setClaveProducto(int claveProducto) {
        this.claveProducto = claveProducto;
    }

    public void setClaveVenta(int claveVenta) {
        this.claveVenta = claveVenta;
    }
    
}
