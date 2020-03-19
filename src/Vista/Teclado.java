package Vista;

import java.util.Scanner;

/**
*Esta clase contiene los metodos que permiten leer datos
* @autor Aldo Colorado Díaz
* @version 1.0
*/ 
public class Teclado {
    
    public int leerEntero(){
        int entero=0;
        Scanner sc= new Scanner (System.in);
        
        try{
            entero=sc.nextInt();
        }catch(Exception e){
            System.out.println("ERROR. No se pudo leer el dato.");
        }
        
        return entero;
    }
    
    public String leerCadena(){
        String cadena="";
        Scanner sc= new Scanner (System.in);
        try{
            cadena=sc.nextLine();
        }catch(Exception e){
            System.out.println("ERROR. No se pudo leer el dato.");
        }
        return cadena;
    }
    
    public double leerDoble(){
        double doble=0.0;
        Scanner sc= new Scanner (System.in);
        try{
            doble=sc.nextDouble();
        }catch(Exception e){
            System.out.println("ERROR. NO se pudo leer el dato.");
        }
        return doble;
    }
}
