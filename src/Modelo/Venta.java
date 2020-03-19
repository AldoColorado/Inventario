/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
*Esta clase contienen todas los atributos y metodos de una venta
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 
public class Venta {
    private int claveVenta; 
    private String fecha_hora;
    private List<DetalleVenta> listaLineasVenta = new ArrayList<>();
    private double importe;

    public Venta(int claveVenta, String fecha_hora, double importe) {
        this.claveVenta = claveVenta;
        this.fecha_hora = fecha_hora;
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }
    
    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Venta() {
    
    }

    public int getClaveVenta() {
        return claveVenta;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setClaveVenta(int claveVenta) {
        this.claveVenta = claveVenta;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
    
    public List<DetalleVenta> getListaLineasVenta() {
        return listaLineasVenta;
    }

    public void setListaLineasVenta(List<DetalleVenta> listaLineasVenta) {
        this.listaLineasVenta = listaLineasVenta;
    }

    
}
