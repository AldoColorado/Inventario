/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
*Esta clase hecha a andar los metodos de la calse detalle_venta
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 
public interface detalle_ventaDAO {
    public boolean create(DetalleVenta venta);
    public List<DetalleVenta> readAll(); 
}
