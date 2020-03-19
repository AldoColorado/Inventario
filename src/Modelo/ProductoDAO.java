package Modelo;

import java.util.List;

/**
*Esta clase hecha a andar los metodos de la clase producto
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 

public interface ProductoDAO{
    public boolean create (ProductoVO producto);
    public List<ProductoVO> readAll();
    //public boolean update (ProductoVO producto);
    //public boolean delete (ProductoVO producto);
}
