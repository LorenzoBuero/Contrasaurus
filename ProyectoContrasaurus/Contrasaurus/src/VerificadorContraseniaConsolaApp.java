/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lorenzo Buero
 */

import java.util.Scanner;

public class VerificadorContraseniaConsolaApp {
    
    //ATRIBUTOS
    private String UbicacionContrasenia;
    
    
    //GET/SET
    private String getUbicacionContrasenia()
    {
        return UbicacionContrasenia;
    }
    private void setUbicacionContrasenia(String ubicacion)
    {
        this.UbicacionContrasenia = ubicacion;
    }
    
    
    //CONSTRUCTORES
    public VerificadorContraseniaConsolaApp(String ubicacionContrasenia)
    {
        this.setUbicacionContrasenia(ubicacionContrasenia);
    }
    
    //METODOS
    public String solicitarContrasenia()
    {
        Scanner escaner = new Scanner(System.in);
        
        System.out.println("Ingrese su contraseña");
        String contrasenia = escaner.nextLine();
        
        return contrasenia;
    }
    
    public boolean VerificarContrasenia(String contraseniaIngresada)
    {
        boolean retorno = false;
        
        String contraseniaHasheada = HashearContraseniaIngresada(contraseniaIngresada);
        String hashArchivo = ObtenerHashDeArchivo(adiwaodim);
        if(contraseniaHasheada.equals(hashArchivo))
        {
            retorno = true;
        }
        
        return retorno;
    }
    
    private String HashearContraseniaIngresada(String contraseniaIngresada)
    {
        String contraseniaHasheada = ;
        
        
        return contraseniaHasheada;
    }
    
    private String ObtenerHashDeArchivo(String ubicacionHash)
    {
        String hashEnElArchivo = ;
        
        
        
        return hashEnElArchivo;
    }
    
}
