/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author ALDO
 */

public interface VentaDAO{
    public boolean create(Venta venta);
    public List<Venta> readAll();
}
